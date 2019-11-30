package com.assignment.intellify.network.response;

import com.assignment.intellify.model.Attendance;

import java.util.List;

public class StudentInfo {
    private String message;
    private List<Attendance> attendance;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Attendance> getAttendance() {
        return attendance;
    }

    public void setAttendance(List<Attendance> attendance) {
        this.attendance = attendance;
    }
}
