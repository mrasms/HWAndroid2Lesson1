package com.example.android2lesson1.ui.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.android2lesson1.SetTaskData;
import com.example.android2lesson1.databinding.FragmentCreateTaskBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class CreateTaskFragment extends BottomSheetDialogFragment {

    private FragmentCreateTaskBinding binding;;

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
//        setListener();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("TAG", "onStart: start");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        setListener();
        Log.d("TAG", "onDestroyView: destroy");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("TAG", "onStop: stop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("TAG", "onDestroy: fulll destroy");
//        setListener();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("TAG", "onResume: resume");
//        setListener();
    }

    private void setListener() {
        binding.btnSendToTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Bundle result = new Bundle();
                    result.putString("title",binding.etTitle.getText().toString().trim() );
                    result.putString("regular",binding.tvRegular.getText().toString() );
                    result.putString("date",binding.tvDate.getText().toString() );
                    getParentFragmentManager().setFragmentResult("requestKey", result);
                    /*TaskFragment taskFragment = new TaskFragment();
                    taskFragment.onStart();*/

                /*Bundle bundle = new Bundle();
                bundle.putString("title", binding.etTitle.getText().toString().trim());
                bundle.putString("regular", binding.tvRegular.getText().toString());
                bundle.putString("date", binding.tvDate.getText().toString());
                FragmentManager fm = getParentFragmentManager();
                FragmentTransaction ft;
                TaskFragment taskFragment = new TaskFragment();
                ft = fm.beginTransaction();
                taskFragment.setArguments(bundle);
                ft = fm.beginTransaction();
                ft.addToBackStack("key");
//                taskData.setNewData();
                ft.commit();*/


                //ft.detach(getParentFragment()).attach(getParentFragment());
                //ft.replace(R.id.createTaskFragment,taskFragment).commit();
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