package com.assignment.intellify.view;

import com.assignment.intellify.network.response.StudentInfo;

import retrofit2.Response;

public interface MainActivityView {
    void hideProgressBar();

    void showProgressBar();

    void onSucess(Response<StudentInfo> response);

    void onFail();
}
