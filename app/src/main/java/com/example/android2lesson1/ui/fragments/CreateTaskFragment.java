package com.example.android2lesson1.ui.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android2lesson1.databinding.FragmentCreateTaskBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class CreateTaskFragment extends BottomSheetDialogFragment {

    private FragmentCreateTaskBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCreateTaskBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       setListener();
    }


    private void setListener() {
        binding.btnSendToTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle result = new Bundle();
                result.putString("title", binding.etTitle.getText().toString().trim());
                result.putString("regular", binding.tvRegular.getText().toString());
                result.putString("date", binding.tvDate.getText().toString());
                getParentFragmentManager().setFragmentResult("requestKey", result);
                dismiss();
            }
        });
    }
}