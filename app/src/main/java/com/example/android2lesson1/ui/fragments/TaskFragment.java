package com.example.android2lesson1.ui.fragments;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android2lesson1.ItemListener;
import com.example.android2lesson1.adapters.TaskAdapter;
import com.example.android2lesson1.databinding.FragmentTaskBinding;
import com.example.android2lesson1.models.TaskModel;
import com.example.android2lesson1.SetTaskData;

import java.util.ArrayList;


public class TaskFragment extends Fragment implements ItemListener, SetTaskData {
    private FragmentTaskBinding binding;
    private ArrayList<TaskModel> modelList = new ArrayList<>();
    TaskAdapter taskAdapter = new TaskAdapter(modelList, this);


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
        setData();
        initAdapter();

    }

    private void initAdapter() {
        binding.recycler.setAdapter(taskAdapter);
    }

    private void listener() {
        binding.btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new CreateTaskFragment(TaskFragment.this).show(requireActivity().getSupportFragmentManager(), "newTask");
            }
        });

    }

    @Override
    public void itemClick() {
    }

    private void setData() {
        if (getArguments() != null) {
            String titleFromCreateTask = getArguments().getString("title");
            String regularFromCreateTask = getArguments().getString("regular");
            String dateFromCreateTask = getArguments().getString("date");
            modelList.add(new TaskModel(titleFromCreateTask, regularFromCreateTask, dateFromCreateTask));
        }

    }


    @Override
    public void setNewData() {
        setData();
        initAdapter();
    }
}

