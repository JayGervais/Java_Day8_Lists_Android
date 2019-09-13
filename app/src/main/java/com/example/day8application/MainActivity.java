package com.example.day8application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity
{
    // reference variables
    EditText txtCourseCode, txtCourseName, txtStartDate, txtLength;
    Button btnAdd;
    ListView lvCourses;
    ArrayList<Course> courseList = new ArrayList<>();
    ArrayList<HashMap<String, String>> data;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // assign variables by id
        btnAdd = findViewById(R.id.btnAdd);
        txtCourseCode = findViewById(R.id.txtCourseCode);
        txtCourseName = findViewById(R.id.txtCourseName);
        txtStartDate = findViewById(R.id.txtStartD);
        txtLength = findViewById(R.id.txtLength);
        lvCourses = findViewById(R.id.lvCourses);

        // create hash map
        data = new ArrayList<>();

//        HashMap<String, String> map = new HashMap<>();
//        map.put("code", "CMPP264");
//        map.put("name", "Java Programming");
//        data.add(map);

        // course item
        String[] from = { "code", "name" };
        int[] to = { R.id.tvCode, R.id.tvName };
        final SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.course_item, from, to);
        lvCourses.setAdapter(adapter);
        lvCourses.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Course c = courseList.get(position);
                Intent intent = new Intent(getApplicationContext(), CourseDetailActivity.class);
                intent.putExtra("course", c);
                startActivity(intent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                HashMap<String, String> map = new HashMap<>();
                map.put("code", txtCourseCode.getText().toString());
                map.put("name", txtCourseName.getText().toString());
                data.add(map);
                adapter.notifyDataSetChanged();
                courseList.add(new Course(txtCourseCode.getText().toString(),
                        txtCourseName.getText().toString(),
                        txtStartDate.getText().toString(),
                        Integer.parseInt(txtLength.getText().toString())));


//                Log.d("Jay", "Add button was clicked");
//
//                courseList.add(new Course(txtCourseCode.getText().toString(),
//                        txtCourseName.getText().toString(),
//                        txtStartDate.getText().toString(),
//                        Integer.parseInt(txtLength.getText().toString())));
            }
        });

    }
}
