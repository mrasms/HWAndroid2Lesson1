package com.example.android2lesson1.ui.fragments;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.RadioButton;

import com.example.android2lesson1.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.example.android2lesson1.databinding.FragmentCreateTaskBinding;

import java.util.Calendar;


public class CreateTaskFragment extends BottomSheetDialogFragment {
    private ViewDialog viewDialog = new ViewDialog();
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
        binding.tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog().show();
            }
        });
        binding.tvRegular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewDialog.showDialog();
            }
        });
    }

    public DatePickerDialog showDateDialog() {
        final Calendar newCalendar = Calendar.getInstance();
        final DatePickerDialog StartTime = new DatePickerDialog(requireContext(), new DatePickerDialog.OnDateSetListener() {
            @SuppressLint("SetTextI18n")
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear +1, dayOfMonth);
                if (monthOfYear < 10) {
                    int month = monthOfYear + 1;
                    binding.tvDate.setText(dayOfMonth + ".0" + month + "." + year);

                }
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        return StartTime;
    }

    public class ViewDialog {

        public void showDialog() {
            final Dialog dialog = new Dialog(requireActivity());
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(true);
            dialog.setContentView(R.layout.dialog);
            RadioButton day = (RadioButton) dialog.findViewById(R.id.every_day_btn);
            RadioButton week = (RadioButton) dialog.findViewById(R.id.every_week_btn);
            RadioButton month = (RadioButton) dialog.findViewById(R.id.every_month_btn);
            RadioButton year = (RadioButton) dialog.findViewById(R.id.every_year_btn);
            day.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    binding.tvRegular.setText(day.getText().toString());
                }
            });
            week.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    binding.tvRegular.setText(week.getText().toString());
                }
            });
            month.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    binding.tvRegular.setText(month.getText().toString());
                }
            });
            year.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    binding.tvRegular.setText(year.getText().toString());
                }
            });


            dialog.show();
        }
    }
}
