package com.example.day8application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity
{
    // reference variables
    EditText txtCourseCode, txtCourseName, txtStartDate, txtLength;
    Button btnAdd, btnThemeChange, btnChangeBack;
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
        // theme change button
        btnThemeChange = findViewById(R.id.btnThemeChange);
        btnChangeBack = findViewById(R.id.btnChangeBack);

        // create hash map
        data = new ArrayList<>();

        // set scroll to true for list
        lvCourses.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        lvCourses.setStackFromBottom(true);

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
            }
        });

        btnThemeChange.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                View currentLayout = findViewById(R.id.home_constrained_layout);
                View root = currentLayout.getRootView();
                root.setBackgroundColor(Color.parseColor("#c0ffb3"));
                //setTheme(R.style.ThemeChange);
            }
        });

        btnChangeBack.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                View currentLayout = findViewById(R.id.home_constrained_layout);
                View root = currentLayout.getRootView();
                root.setBackgroundColor(Color.parseColor("#ffffff"));
                //setTheme(R.style.ThemeChange);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        Toast toast;
        switch (item.getItemId())
        {
            case R.id.menu_home:
                toast = Toast.makeText(this, "The home button", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            case R.id.menu_settings:
                toast = Toast.makeText(this, "The settings button", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            case R.id.menu_about:
                toast = Toast.makeText(this, "About JayG Cool App \n" +
                        "Author: Jay Gervais \n" +
                        "Purpose: To make the world a better place \n" +
                        "Android version: 10 \n" +
                        "Date written: September, 2019", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
        }
        return super.onOptionsItemSelected(item);
    }
}
