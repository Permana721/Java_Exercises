package _01_Mahasiswa.service;

import _01_Mahasiswa.exception.StudentNotFoundException;
import _01_Mahasiswa.model.*;
import _01_Mahasiswa.repository.DataRepository;

public class StudentServiceImpl implements StudentService {
    private DataRepository repository;

    public StudentServiceImpl(DataRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student createStudent(Student student) {
        Student savedStudent = repository.save(student);

        System.out.println("Account created!: ");
        System.out.println(savedStudent.getStudentInfo());
        return savedStudent;
    }

    @Override
    public Student selectStudent(int studentId) {
        Student student = repository.findById(studentId);
        if (student == null) {
            throw new StudentNotFoundException("Student with ID '" + studentId + "' not found!");
        }

        System.out.println(student.getStudentInfo());

        return student;
    }

    public void addCourseToStudent(int studentId, Semester semester, Course... courses) {
        Student student = selectStudent(studentId);
        for (Course course : courses){
            student.addCourse(semester, course);
        }
    }

    @Override
    public int getStudentTotalCreditsById(int studentId) {
        Student student = selectStudent(studentId);

        if (student instanceof UndergraduateStudent) {
            return ((UndergraduateStudent) student).getTotalCredits();
        } else if (student instanceof GraduateStudent) {
            return ((GraduateStudent) student).getTotalCredits();
        }

        return 0;
    }
}