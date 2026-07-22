package _01_Mahasiswa.model;

import java.util.List;

public class GraduateStudent extends Student {
    public GraduateStudent(String name, IsPaid isPaid, Major major) {
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

        if (total >= 36) {
            return StudentStatus.GRADUATED;
        } else {
            return StudentStatus.ACTIVE;
        }
    }

    @Override
    public String getStudentInfo() {
        StringBuilder info = new StringBuilder();
        info.append("===========Graduate Student Info=============\n");
        info.append(String.format("Student ID: %d\n", getStudentId()));
        info.append(String.format("Name: %s\n", getName()));
        info.append(String.format("Payment Status: %s\n", getIsPaid().getDisplayName()));
        info.append(String.format("Major: %s\n", getMajor().getDisplayName()));
        info.append(String.format("Student status: %s\n", getStudentStatus().getDisplayName()));
        if (getIsPaid().equals(IsPaid.UNPAID)){
            info.append(String.format("Study plan: Please complete payment first!\n"));
        } else if (getStudyPlan().isEmpty()) {
            info.append(String.format("Study plan: Please input study plan first!\n"));
        } else {
            info.append(String.format("Study plan: %s\n", getStudyPlan()));
        }
        info.append(("\n=====================================\n"));

        return info.toString();
    }


}