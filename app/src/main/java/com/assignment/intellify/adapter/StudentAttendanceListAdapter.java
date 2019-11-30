package com.assignment.intellify.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.assignment.intellify.R;
import com.assignment.intellify.model.Attendance;

import java.text.MessageFormat;
import java.util.List;

public class StudentAttendanceListAdapter extends RecyclerView.Adapter<StudentAttendanceListAdapter.ViewHolder> {

    private List<Attendance> attendances;

    public StudentAttendanceListAdapter(List<Attendance> attendances) {
        this.attendances = attendances;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.student_attendance_list_item, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Attendance currentItem = attendances.get(position);
        holder.late.setText(MessageFormat.format("{0}", currentItem.getLate()));
        holder.absent.setText(MessageFormat.format("{0}", currentItem.getAbsent()));
        holder.present.setText(MessageFormat.format("{0}", currentItem.getPresent()));
        holder.className.setText(MessageFormat.format("{0}", currentItem.getClassName()));
        holder.totalNumberOfLectures.setText(MessageFormat.format("{0}", currentItem.getTotalLectures()));
        holder.sick.setText(MessageFormat.format("{0}", currentItem.getSick()));
    }

    @Override
    public int getItemCount() {
        return attendances.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView className;
        private TextView totalNumberOfLectures;
        private TextView present;
        private TextView sick;
        private TextView absent;
        private TextView late;


        ViewHolder(@NonNull View itemView) {
            super(itemView);
            className = itemView.findViewById(R.id.class_name);
            totalNumberOfLectures = itemView.findViewById(R.id.total_lectures);
            present = itemView.findViewById(R.id.present);
            sick = itemView.findViewById(R.id.sick);
            absent = itemView.findViewById(R.id.absent);
            late = itemView.findViewById(R.id.late);
        }
    }
}
