package com.example.day8application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class CourseDetailActivity extends AppCompatActivity
{
    TextView tvCourseCode, tvCourseName, tvStartD, tvCourseLength;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        tvCourseCode = findViewById(R.id.tvCourseCode);
        tvCourseName = findViewById(R.id.tvCourseName);
        tvStartD = findViewById(R.id.tvStartD);
        tvCourseLength = findViewById(R.id.tvLength);

        Intent intent = getIntent();
        Course c = (Course) intent.getSerializableExtra("course");
        tvCourseCode.setText(c.getCourseCode());
        tvCourseName.setText(c.getCourseName());
        tvStartD.setText(c.getStartDate());
        tvCourseLength.setText(c.getCourseLength() + "");
    }
}
