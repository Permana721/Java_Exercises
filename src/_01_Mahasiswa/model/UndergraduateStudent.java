package _01_Mahasiswa.model;

import java.util.List;
import java.util.Map;

public class UndergraduateStudent extends Student{
    public UndergraduateStudent(String name, IsPaid isPaid, Major major) {
        super(name, isPaid, major);
    }

    public int getTotalCredits() {
        int totalCredits = 0;
        if (getStudyPlan() != null) {
            for (List<Course> courseList : getStudyPlan().values()) {
                for (Course course : courseList) {
                    totalCredits += course.getCourseSks();
                }
            }
        }
        return totalCredits;
    }

    @Override
    public StudentStatus graduationCheck() {
        int total = getTotalCredits();

        if (total >= 144) {
            return StudentStatus.GRADUATED;
        } else {
            return StudentStatus.ACTIVE;
        }
    }

    @Override
    public String getStudentInfo() {
        StringBuilder info = new StringBuilder();
        info.append("===========Undergraduate Student Info=============\n");
        info.append(String.format("Student ID: %d\n", getStudentId()));
        info.append(String.format("Name: %s\n", getName()));
        info.append(String.format("Payment Status: %s\n", getIsPaid().getDisplayName()));
        info.append(String.format("Major: %s\n", getMajor().getDisplayName()));
        if (getTotalCredits() >= 144){
            info.append(String.format("Student status: %s\n", StudentStatus.GRADUATED.getDisplayName()));
        } else {
            info.append(String.format("Student status: %s\n", getStudentStatus().getDisplayName()));
        }
        if (getIsPaid().equals(IsPaid.UNPAID)){
            info.append(String.format("Study plan: Please complete payment first!\n"));
        } else if (getStudyPlan().isEmpty()) {
            info.append(String.format("Study plan: Please input study plan first!\n"));
        } else {
            info.append(String.format("Study plan: "));
            for (Map.Entry<Semester, List<Course>> entry : getStudyPlan().entrySet()) {
                Semester sem = entry.getKey();
                List<Course> listCourse = entry.getValue();

                info.append(String.format("\n[ " + sem.getDisplayName() + " ]"));
                for (Course course : listCourse) {
                    info.append(String.format("\n" + course.getCourseCode() + " - " + course.getCourseName() + " (" + course.getCourseSks() + " Credits)"));
                }
            }
        }
        info.append(("\n=====================================\n"));

        return info.toString();
    }
}
