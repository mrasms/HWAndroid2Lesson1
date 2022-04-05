package com.example.android2lesson1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android2lesson1.databinding.ItemBoardBinding;
import com.example.android2lesson1.model.BoardModel;

import java.util.ArrayList;


public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.BoardViewHolder> {
    private ArrayList<BoardModel> list;

    public BoardAdapter(ArrayList<BoardModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public BoardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBoardBinding binding = ItemBoardBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new BoardViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BoardViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class BoardViewHolder extends RecyclerView.ViewHolder {
        private ItemBoardBinding binding;

        public BoardViewHolder(ItemBoardBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(BoardModel model) {
            binding.imBoard.setImageResource(model.getImage());
            binding.tvDescription.setText(model.getDescription());
            //binding.btnNext.setText(model.getButtonText());
        }
    }
}
