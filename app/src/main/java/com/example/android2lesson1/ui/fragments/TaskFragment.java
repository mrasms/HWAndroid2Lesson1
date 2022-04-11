package com.example.android2lesson1.ui.fragments;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.android2lesson1.ItemListener;
import com.example.android2lesson1.R;
import com.example.android2lesson1.adapters.TaskAdapter;
import com.example.android2lesson1.databinding.FragmentTaskBinding;
import com.example.android2lesson1.models.TaskModel;
import com.example.android2lesson1.SetTaskData;

import java.util.ArrayList;
import java.util.Objects;


public class TaskFragment extends Fragment implements ItemListener {

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
        //setData();
        initAdapter();
        getParentFragmentManager().setFragmentResultListener("requestKey", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                Log.e("tag", bundle.getString("title"));
                String titleFromCreateTask = bundle.getString("title");
                String regularFromCreateTask = bundle.getString("regular");
                String dateFromCreateTask = bundle.getString("date");
                modelList.add(new TaskModel(titleFromCreateTask, regularFromCreateTask, dateFromCreateTask));
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

    //setFragmentResultListener
    /*private void setData() {
        if (getArguments() != null) {

            //bundle = Objects.requireNonNull(Navigation.findNavController(requireView()).getCurrentBackStackEntry()).getSavedStateHandle().get("bun");
            String titleFromCreateTask = getArguments().getString("title");
            String regularFromCreateTask = getArguments().getString("regular");
            String dateFromCreateTask = getArguments().getString("date");
            Toast.makeText(requireActivity(), titleFromCreateTask, Toast.LENGTH_SHORT).show();
            modelList.add(new TaskModel(titleFromCreateTask, regularFromCreateTask, dateFromCreateTask));
        }

    }*/


//    @Override
//    public void setNewData() {
//        setData();
//        initAdapter();
//    }
}

