package com.example.android2lesson1.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android2lesson1.ItemListener;
import com.example.android2lesson1.R;
import com.example.android2lesson1.adapters.TaskAdapter;
import com.example.android2lesson1.databinding.FragmentTaskBinding;
import com.example.android2lesson1.models.TaskModel;

import java.util.ArrayList;

public class TaskFragment extends Fragment implements ItemListener {

    private FragmentTaskBinding binding;
    private ArrayList<TaskModel> modelList = new ArrayList<>();
    private TaskAdapter taskAdapter = new TaskAdapter(modelList, this);

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
    }

    private void setData() {
        getParentFragmentManager().setFragmentResultListener("requestKey", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                String titleFromCreateTask = bundle.getString("title");
                String regularFromCreateTask = bundle.getString("regular");
                String dateFromCreateTask = bundle.getString("date");
                modelList.add(new TaskModel(titleFromCreateTask, regularFromCreateTask, dateFromCreateTask));
                taskAdapter.notifyItemInserted(modelList.size() - 1);
            }
        });
    }

    private void initAdapter() {
        binding.recycler.setAdapter(taskAdapter);
    }

    private void listener() {
        binding.btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(requireView()).navigate(R.id.createTaskFragment);
            }
        });
    }

    @Override
    public void itemClick() {
    }


}

