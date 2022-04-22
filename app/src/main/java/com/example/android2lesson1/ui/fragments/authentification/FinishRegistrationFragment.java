package com.example.android2lesson1.ui.fragments.authentification;

import static com.example.android2lesson1.keys.Keys.FILE_NAME;
import static com.example.android2lesson1.keys.Keys.IS_SHOW_KEY;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android2lesson1.R;
import com.example.android2lesson1.databinding.FragmentFinishRegistrationBinding;
import com.example.android2lesson1.keys.Keys;


public class FinishRegistrationFragment extends Fragment {
    private FragmentFinishRegistrationBinding binding;
    private SharedPreferences preferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFinishRegistrationBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initClickers();
    }

    private void initClickers() {
        binding.btnBegin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preferences = requireActivity().getSharedPreferences(Keys.REG_NAME, Context.MODE_PRIVATE);
                preferences.edit().putBoolean(Keys.USER_REGISTERED, true).apply();
                Navigation.findNavController(requireView()).navigate(R.id.taskFragment);
            }
        });
    }
}