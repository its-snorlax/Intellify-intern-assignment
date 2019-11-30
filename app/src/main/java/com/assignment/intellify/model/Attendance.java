package com.assignment.intellify.model;

public class Attendance {
    private String className;
    private int totalLectures;
    private int present;
    private int sick;
    private int absent;
    private int late;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getTotalLectures() {
        return totalLectures;
    }

    public void setTotalLectures(int totalLectures) {
        this.totalLectures = totalLectures;
    }

    public int getPresent() {
        return present;
    }

    public void setPresent(int present) {
        this.present = present;
    }

    public int getSick() {
        return sick;
    }

    public void setSick(int sick) {
        this.sick = sick;
    }

    public int getAbsent() {
        return absent;
    }

    public void setAbsent(int absent) {
        this.absent = absent;
    }

    public int getLate() {
        return late;
    }

    public void setLate(int late) {
        this.late = late;
    }
}
