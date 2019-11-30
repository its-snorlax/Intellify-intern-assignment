package com.assignment.intellify.presenter;

import com.assignment.intellify.network.response.StudentInfo;
import com.assignment.intellify.network.service.StudentInfoService;
import com.assignment.intellify.view.MainActivityView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityPresenter {
    private MainActivityView mainActivityView;
    private StudentInfoService studentInfoService;

    public MainActivityPresenter(MainActivityView mainActivityView, StudentInfoService studentInfoService) {
        this.mainActivityView = mainActivityView;
        this.studentInfoService = studentInfoService;
    }

    public void makeRequest(long studentId) {
        Call<StudentInfo> call = studentInfoService.getStudentInfoById("AllClassAttendance", studentId);
        mainActivityView.showProgressBar();
        call.enqueue(new Callback<StudentInfo>() {
            @Override
            public void onResponse(Call<StudentInfo> call, Response<StudentInfo> response) {
                mainActivityView.hideProgressBar();
                mainActivityView.onSucess(response);
            }

            @Override
            public void onFailure(Call<StudentInfo> call, Throwable t) {
                mainActivityView.hideProgressBar();
                mainActivityView.onFail();
            }
        });
    }
}
