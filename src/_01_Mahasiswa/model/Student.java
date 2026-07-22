package _01_Mahasiswa.model;

import _01_Mahasiswa.exception.InvalidDataException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public abstract class Student {
    private static int counter = 125111000;
    private final int studentId;
    private final String name;
    private IsPaid isPaid;
    private final Major major;
    private Map<Semester, List<Course>> studyPlan = new EnumMap<>(Semester.class);
    private StudentStatus studentStatus;
    private final LocalDateTime createdDate;

    public Student(String name, IsPaid isPaid, Major major) {
        this.studentId = addStudentId();
        this.name = name;
        this.isPaid = isPaid;
        this.major = major;
        this.studentStatus = StudentStatus.ACTIVE;
        this.createdDate = LocalDateTime.now();
    }

    private static synchronized int addStudentId(){
        counter++;
        return counter;
    }

    public abstract StudentStatus graduationCheck();

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public IsPaid getIsPaid() {
        return isPaid;
    }

    public Major getMajor() {
        return major;
    }

    public StudentStatus getStudentStatus() {
        return studentStatus;
    }

    public Map<Semester, List<Course>> getStudyPlan() {
        return studyPlan;
    }

    public abstract String getStudentInfo();

    public void addCourse(Semester semester, Course course){
        studyPlan.computeIfAbsent(semester, c -> new ArrayList<>()).add(course);
    }
}