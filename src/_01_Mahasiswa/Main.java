package _01_Mahasiswa;

import _01_Mahasiswa.exception.InvalidDataException;
import _01_Mahasiswa.model.*;
import _01_Mahasiswa.repository.DataRepository;
import _01_Mahasiswa.repository.DataRepositoryImpl;
import _01_Mahasiswa.service.StudentService;
import _01_Mahasiswa.service.StudentServiceImpl;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataRepository dataRepository = new DataRepositoryImpl();
        StudentService studentService = new StudentServiceImpl(dataRepository);

        boolean loop = true;
        while (loop) {
            System.out.println("============Menu=============");
            System.out.println("1. Create new student account");
            System.out.println("2. Search & view account student information");
            System.out.println("3. Add course");
            System.out.println("4. Check student graduation");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int chose = 0;
            try {
                chose = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e){
                throw new InvalidDataException("An error occurred: " + e.getMessage());
            }

            try {
                switch (chose) {
                    case 1 -> {
                        System.out.print("\nEnter student name: ");
                        String name = scanner.nextLine();

                        System.out.print("Payment status (1. Paid, 2. Partial, 3. Unpaid): ");
                        int paymentStatus = scanner.nextInt();
                        IsPaid isPaid = null;
                        switch (paymentStatus) {
                            case 1 -> isPaid = IsPaid.PAID;
                            case 2 -> isPaid = IsPaid.PARTIAL;
                            case 3 -> isPaid = IsPaid.UNPAID;
                            default -> throw new InvalidDataException("Please input a valid number!");
                        }

                        System.out.print("Input major (1. Informatika, 2. Manajemen, 3. Psikologi): ");
                        int major = scanner.nextInt();
                        Major majors = null;
                        switch (major) {
                            case 1 -> majors = Major.INFORMATIKA;
                            case 2 -> majors = Major.MANAJEMEN;
                            case 3 -> majors = Major.PSIKOLOGI;
                            default -> throw new InvalidDataException("Please input a valid number!");
                        }

                        System.out.print("Select an educational level: (1. Undergraduate, 2. Graduate): ");
                        int eduLevel = scanner.nextInt();
                        switch (eduLevel) {
                            case 1 -> {
                                UndergraduateStudent undergraduateStudent = new UndergraduateStudent(name, isPaid, majors);
                                studentService.createStudent(undergraduateStudent);
                            }
                            case 2 -> {
                                GraduateStudent graduateStudent = new GraduateStudent(name, isPaid, majors);
                                studentService.createStudent(graduateStudent);
                            }
                            default -> throw new InvalidDataException("Please input a valid number!");
                        }
                    }
                    case 2 -> {
                        System.out.print("Input student Id: ");
                        int studentId = scanner.nextInt();

                        studentService.selectStudent(studentId);

                    }
                    case 3 -> {
                        System.out.print("Input student ID: ");
                        int studentId = scanner.nextInt();
                        scanner.nextLine();
                        Student student = studentService.selectStudent(studentId);

                        System.out.print("Input Semester in number in range 1-8, like 1 for semester 1: ");
                        int semesterInput = scanner.nextInt();

                        Semester semester = null;

                        switch (semesterInput){
                            case 1 -> semester = Semester.SEMESTER1;
                            case 2 -> semester = Semester.SEMESTER2;
                            case 3 -> semester = Semester.SEMESTER3;
                            case 4 -> semester = Semester.SEMESTER4;
                            case 5 -> semester = Semester.SEMESTER5;
                            case 6 -> semester = Semester.SEMESTER6;
                            case 7 -> semester = Semester.SEMESTER7;
                            case 8 -> semester = Semester.SEMESTER8;
                            default -> System.out.println("Please input a right number!");
                        }

                        scanner.nextLine();

                        System.out.print("Input course code: ");
                        String courseCode = scanner.nextLine();

                        System.out.print("Input course name: ");
                        String courseName = scanner.nextLine();

                        System.out.print("Input lecturer name: ");
                        String courseLecturer = scanner.nextLine();

                        System.out.print("Input course credit: ");
                        int courseCredit = scanner.nextInt();
                        scanner.nextLine();

                        Course course = new Course(courseCode, courseName, courseLecturer, courseCredit);

                        studentService.addCourseToStudent(studentId, semester, course);

                        System.out.println("Success: Course added to " + student.getName() + "'s study plan!");
                    }
                    case 4 -> {
                        System.out.print("Enter student id: ");
                        int studentId = scanner.nextInt();
                        scanner.nextLine();

                        int totalCourse = studentService.getStudentTotalCreditsById(studentId);

                    }
                    case 0 -> loop = false;
                }
            } catch (Exception e){
                throw new InvalidDataException("An error occurred: " + e.getMessage());
            }
        }
    }
}