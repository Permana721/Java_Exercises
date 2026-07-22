package _01_Mahasiswa.model;

import _01_Mahasiswa.exception.InvalidDataException;

public class Course {
    private String courseCode;
    private String courseName;
    private String courseLecturer;
    private int courseSks;

    public Course(String courseCode, String courseName, String courseLecturer, int courseSks) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseLecturer = courseLecturer;
        this.courseSks = courseSks;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCourseSks() {
        return courseSks;
    }

}
