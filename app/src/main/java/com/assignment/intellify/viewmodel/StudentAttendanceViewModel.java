package com.assignment.intellify.viewmodel;

import androidx.lifecycle.ViewModel;

import com.assignment.intellify.model.Attendance;

import java.util.ArrayList;
import java.util.List;

public class StudentAttendanceViewModel extends ViewModel {

    private List<Attendance> attendances = new ArrayList<>();

    public List<Attendance> getAtendances() {
        return attendances;
    }

    public void setAttendances(List<Attendance> items) {
        attendances = items;
    }
}
