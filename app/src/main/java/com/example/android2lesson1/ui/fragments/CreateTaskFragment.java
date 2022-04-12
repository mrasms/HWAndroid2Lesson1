package com.example.android2lesson1.ui.fragments;


import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.example.android2lesson1.databinding.FragmentCreateTaskBinding;

import java.util.Calendar;


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

    public DatePickerDialog showDateDialog() {
        final Calendar newCalendar = Calendar.getInstance();
        final DatePickerDialog StartTime = new DatePickerDialog(requireContext(), new DatePickerDialog.OnDateSetListener() {
            @SuppressLint("SetTextI18n")
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                binding.tvDate.setText(dayOfMonth + "." + monthOfYear+ "."+year);
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        return StartTime;
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
        binding.tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog().show();
            }
        });
    }
}
