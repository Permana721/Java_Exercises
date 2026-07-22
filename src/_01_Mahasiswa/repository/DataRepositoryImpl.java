package _01_Mahasiswa.repository;

import _01_Mahasiswa.model.Student;

import java.util.ArrayList;
import java.util.List;

public class DataRepositoryImpl implements DataRepository {
    private final List<Student> students;

    public DataRepositoryImpl() {
        this.students = new ArrayList<>();
    }

    @Override
    public Student save(Student student) {
        students.add(student);
        return student;
    }

    @Override
    public Student findById(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        return null;
    }
}