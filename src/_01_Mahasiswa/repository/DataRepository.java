package _01_Mahasiswa.repository;

import _01_Mahasiswa.model.Student;

public interface DataRepository {
    Student save(Student student);
    Student findById(int studentId);
}
