package com.example.android2lesson1.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android2lesson1.ItemListener;
import com.example.android2lesson1.databinding.ItemBoardBinding;
import com.example.android2lesson1.databinding.TaskHolderBinding;
import com.example.android2lesson1.models.TaskModel;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskHolder> {
    private ArrayList<TaskModel> modelList;
    private ItemListener listener;

    public TaskAdapter(ArrayList<TaskModel> modelList, ItemListener listener) {
        this.modelList = modelList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TaskHolderBinding binding = TaskHolderBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new TaskAdapter.TaskHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskHolder holder, int position) {
        holder.onBind(modelList.get(position));

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class TaskHolder extends RecyclerView.ViewHolder {
        private TaskHolderBinding binding;

        public TaskHolder(@NonNull TaskHolderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(TaskModel taskModel) {
            binding.tvCardTitle.setText(taskModel.getTitle());
            binding.tvCardRegular.setText(taskModel.getRegular());
            binding.tvCardDate.setText(taskModel.getDate());
            binding.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.itemClick();
                }
            });
        }
    }
}
