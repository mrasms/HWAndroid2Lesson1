package com.example.android2lesson1.ui.fragments;

import static com.example.android2lesson1.keys.Keys.FILE_NAME;
import static com.example.android2lesson1.keys.Keys.IS_SHOW_KEY;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android2lesson1.ItemListener;
import com.example.android2lesson1.R;
import com.example.android2lesson1.SetTaskData;
import com.example.android2lesson1.databinding.FragmentCreateTaskBinding;
import com.example.android2lesson1.models.TaskModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

public class CreateTaskFragment extends BottomSheetDialogFragment {
    private FragmentCreateTaskBinding binding;

    public CreateTaskFragment(SetTaskData taskData) {
        this.taskData = taskData;
    }

    //private SharedPreferences preferences;
    //private ArrayList<TaskModel> list = new ArrayList<>();
    private SetTaskData taskData;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCreateTaskBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //onTaskClick();
        setListener();
    }

    private void setListener() {
        binding.btnSendToTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("title", binding.etTitle.getText().toString().trim());
                bundle.putString("regular", binding.tvRegular.getText().toString());
                bundle.putString("date", binding.tvDate.getText().toString());
                FragmentManager fm = getParentFragmentManager();
                FragmentTransaction ft;
                ft = fm.beginTransaction();
                setArguments(bundle);
                ft.commit();

                taskData.setNewData();

                //ft.detach(getParentFragment()).attach(getParentFragment());
                //ft.replace(R.id.createTaskFragment,taskFragment).commit();
                //ft.addToBackStack(null);
                dismiss();
            }
        });
    }
    /*private void onTaskClick() {

        preferences = requireActivity().getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);

        if (preferences != null) {
            boolean onTaskClick = preferences.getBoolean(IS_SHOW_KEY, false);
            if (onTaskClick) {
                Navigation.findNavController(requireView()).navigate(R.id.taskFragment);
            }
        }
    }*/
}