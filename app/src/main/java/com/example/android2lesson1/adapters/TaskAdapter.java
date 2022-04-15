package com.example.android2lesson1.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android2lesson1.interfaces.ItemListener;
import com.example.android2lesson1.databinding.TaskHolderBinding;
import com.example.android2lesson1.interfaces.OnItemListener;
import com.example.android2lesson1.models.TaskModel;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskHolder> {

    private List<TaskModel> modelList = new ArrayList<>();
    private OnItemListener listener;

    public void setListener(OnItemListener listener) {
        this.listener = listener;
    }

    public void setList(List<TaskModel> modelList) {
        this.modelList = modelList;
        notifyDataSetChanged();
    }

//    @SuppressLint("NotifyDataSetChanged")
//    public void delete(TaskModel model) {
//        modelList.remove(model);
//        notifyDataSetChanged();
//    }

//    public TaskAdapter(ArrayList<TaskModel> modelList, OnItemListener listener) {
//        this.modelList = modelList;
//        this.listener = listener;
//    }

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
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(taskModel);
                }
            });
//            binding.cardView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    listener.onItemClick(taskModel);
//                }
//            });
        }
    }
}
