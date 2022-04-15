package com.example.android2lesson1.ui.fragments;

import static com.example.android2lesson1.App.getApp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.Observer;
import androidx.navigation.Navigation;

import com.example.android2lesson1.App;
import com.example.android2lesson1.R;
import com.example.android2lesson1.adapters.TaskAdapter;
import com.example.android2lesson1.databinding.FragmentTaskBinding;
import com.example.android2lesson1.interfaces.OnItemListener;
import com.example.android2lesson1.models.TaskModel;

import java.util.ArrayList;
import java.util.List;

public class TaskFragment extends Fragment {

    private FragmentTaskBinding binding;
    private TaskModel taskModel;
    //private ArrayList<TaskModel> modelList = new ArrayList<>();
    private TaskAdapter taskAdapter = new TaskAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTaskBinding.inflate(getLayoutInflater());
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listener();
        initAdapter();
        setData();
        onItemClick();

    }

    private void listener() {
        binding.btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(requireView()).navigate(R.id.createTaskFragment);
            }
        });
    }

    private void initAdapter() {
        binding.recycler.setAdapter(taskAdapter);
        App.getApp().getDataBase().taskDao().getListData().observe(getViewLifecycleOwner(), new Observer<List<TaskModel>>() {
            @Override
            public void onChanged(List<TaskModel> taskModels) {
                taskAdapter.setList(taskModels);
            }
        });
    }

    private void setData() {
        getParentFragmentManager().setFragmentResultListener("requestKey", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                String titleFromCreateTask = bundle.getString("title");
                String regularFromCreateTask = bundle.getString("regular");
                String dateFromCreateTask = bundle.getString("date");
                taskModel = new TaskModel(titleFromCreateTask, regularFromCreateTask, dateFromCreateTask);
                App.getApp().getDataBase().taskDao().insert(taskModel);


            }
        });
    }

    public void onItemClick() {
        taskAdapter.setListener(new OnItemListener() {
            @Override
            public void onItemClick(TaskModel model) {
                Toast.makeText(requireContext(), "Kol", Toast.LENGTH_SHORT).show();
                String setMessage = "Вы уверены, что хотите удалить?";
                String setTitle = "Удалить";
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                builder.setTitle(setTitle);
                builder.setMessage(setMessage);
                builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        getApp().getDataBase().taskDao().delete(model);
                    }
                })
                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert).show();
            }
        });

    }

}





