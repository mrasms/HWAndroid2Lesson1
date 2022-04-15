package com.example.android2lesson1.ui.fragments;

import static com.example.android2lesson1.keys.Keys.FILE_NAME;
import static com.example.android2lesson1.keys.Keys.IS_SHOW_KEY;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android2lesson1.interfaces.ItemListener;
import com.example.android2lesson1.R;
import com.example.android2lesson1.adapters.BoardAdapter;
import com.example.android2lesson1.databinding.FragmentOnBoardBinding;
import com.example.android2lesson1.models.BoardModel;
import com.example.android2lesson1.models.TaskModel;

import java.util.ArrayList;


public class OnBoardFragment extends Fragment implements ItemListener {
    private FragmentOnBoardBinding binding;
    private ArrayList<BoardModel> list = new ArrayList<>();
    private SharedPreferences preferences;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOnBoardBinding.inflate(getLayoutInflater());
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        checkOnShowBoard();
        initAdapter();
        setupListeners();
        setupScrollContent();

    }

    private void checkOnShowBoard() {
        preferences = requireActivity().getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);

        if (preferences != null) {
            boolean isShow = preferences.getBoolean(IS_SHOW_KEY, false);
            if (isShow) {
                Navigation.findNavController(requireView()).navigate(R.id.taskFragment);
            }
        }
    }


    private void initAdapter() {
        BoardAdapter adapter = new BoardAdapter(getBoardList(), this);
        binding.pager.setAdapter(adapter);
    }


    private void setupListeners() {

        // dotsListeners
        binding.imDot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.pager.getCurrentItem() != 0) {
                    binding.pager.setCurrentItem(0);
                }
            }
        });
        binding.imDot2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.pager.getCurrentItem() != 1) {
                    binding.pager.setCurrentItem(1);
                }
            }
        });
        binding.imDot3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.pager.getCurrentItem() != 2) {
                    binding.pager.setCurrentItem(2);
                }
            }
        });
    }

    private void setupScrollContent() {
        //Не пришло в голову нужное слово, которое описывает действия метода
        // Метод заставляет работать самодельный "Dot's indicator" , а также
        // меняет текст кнопки при попадании на последний элемент
        binding.pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);

                if (binding.pager.getCurrentItem() == position) {
                    for (int i = 0; i <= list.size(); i++) {
                        if (i == position && position == 0) {
                            binding.imDot1.setImageResource(R.drawable.selected_dot);
                            binding.imDot2.setImageResource(R.drawable.default_dot);
                            binding.imDot3.setImageResource(R.drawable.default_dot);
                        } else if (i == position && position == 1) {
                            binding.imDot1.setImageResource(R.drawable.default_dot);
                            binding.imDot2.setImageResource(R.drawable.selected_dot);
                            binding.imDot3.setImageResource(R.drawable.default_dot);
                        } else if (i == position && position == 2) {
                            binding.imDot1.setImageResource(R.drawable.default_dot);
                            binding.imDot2.setImageResource(R.drawable.default_dot);
                            binding.imDot3.setImageResource(R.drawable.selected_dot);
                        }
                    }
                }

            }
        });
    }

    private ArrayList<BoardModel> getBoardList() {
        list.add(new BoardModel("time.json", "Экономь время", "Дальше"));
        list.add(new BoardModel("tasks.json", "Достигай целей", "Дальше"));
        list.add(new BoardModel("improvement.json", "Развивайся", "Начинаем"));
        return list;
    }

    @Override
    public void onStop() {
        super.onStop();
        list.clear();
    }

    @Override
    public void itemClick() {
        if (binding.pager.getCurrentItem() ==list.size()-1) {
            preferences = requireActivity().getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
            preferences.edit().putBoolean(IS_SHOW_KEY, true).apply();
            Navigation.findNavController(requireView()).navigate(R.id.taskFragment);
        }else binding.pager.setCurrentItem(binding.pager.getCurrentItem()+1);
    }


}