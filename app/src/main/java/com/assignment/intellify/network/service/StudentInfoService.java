package com.assignment.intellify.network.service;

import com.assignment.intellify.network.response.StudentInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface StudentInfoService {

    @GET("/api/attendance")
    Call<StudentInfo> getStudentInfoById(@Query("for") String intendedFor, @Query("student_id") long studentId);
}
