package com.example.day8application;

import java.io.Serializable;

class Course implements Serializable
{
    private String courseCode;
    private String courseName;
    private String startDate;
    private Integer courseLength;

    public Course(String courseCode, String courseName, String startDate, Integer courseLength)
    {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.startDate = startDate;
        this.courseLength = courseLength;
    }

    public String getCourseCode()
    {
        return courseCode;
    }

    public void setCourseCode(String courseCode)
    {
        this.courseCode = courseCode;
    }

    public String getCourseName()
    {
        return courseName;
    }

    public void setCourseName(String courseName)
    {
        this.courseName = courseName;
    }

    public String getStartDate()
    {
        return startDate;
    }

    public void setStartDate(String startDate)
    {
        this.startDate = startDate;
    }

    public Integer getCourseLength()
    {
        return courseLength;
    }

    public void setCourseLength(Integer courseLength)
    {
        this.courseLength = courseLength;
    }

    @Override
    public String toString()
    {
        return "Course{" +
                "courseCode='" + courseCode + '\'' +
                ", courseName='" + courseName + '\'' +
                ", startDate='" + startDate + '\'' +
                ", courseLength=" + courseLength +
                '}';
    }
}
