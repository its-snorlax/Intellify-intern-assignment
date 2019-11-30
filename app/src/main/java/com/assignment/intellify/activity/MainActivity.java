package com.assignment.intellify.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.assignment.intellify.R;
import com.assignment.intellify.adapter.StudentAttendanceListAdapter;
import com.assignment.intellify.model.Attendance;
import com.assignment.intellify.network.ServiceBuilder;
import com.assignment.intellify.network.response.StudentInfo;
import com.assignment.intellify.network.service.StudentInfoService;
import com.assignment.intellify.presenter.MainActivityPresenter;
import com.assignment.intellify.view.MainActivityView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText studentIdEdittext = findViewById(R.id.student_id);
        Button submitButton = findViewById(R.id.submit_button);
        progressBar = findViewById(R.id.progress_bar);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String studentId = studentIdEdittext.getText().toString();
                if (studentId.isEmpty()) {
                    showErrorToast();
                } else {
                    onSubmitButtonClick(studentId);
                }
            }
        });
    }

    private void onSubmitButtonClick(String studentId) {
        MainActivityPresenter mainActivityPresenter =
                new MainActivityPresenter(this,
                        ServiceBuilder.build(StudentInfoService.class));
        mainActivityPresenter.makeRequest(Long.parseLong(studentId));
    }

    private void showErrorToast() {
        Toast.makeText(MainActivity.this, R.string.empty_student_id, Toast.LENGTH_LONG).show();
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onSucess(Response<StudentInfo> response) {
        List<Attendance> attendance = response.body().getAttendance();

        RecyclerView recyclerView = findViewById(R.id.list_section);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(new StudentAttendanceListAdapter(attendance));
        Toast.makeText(MainActivity.this, "on Sucess", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFail() {
        Toast.makeText(MainActivity.this, "No student exists in Database", Toast.LENGTH_LONG).show();
    }
}
