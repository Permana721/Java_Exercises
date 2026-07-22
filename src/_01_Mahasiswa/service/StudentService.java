package _01_Mahasiswa.service;

import _01_Mahasiswa.model.Course;
import _01_Mahasiswa.model.Semester;
import _01_Mahasiswa.model.Student;

public interface StudentService {
    Student createStudent(Student student);
    Student selectStudent(int studentId);
    void addCourseToStudent(int studentId, Semester semester, Course... courses);
    public int getStudentTotalCreditsById(int studentId);
}
