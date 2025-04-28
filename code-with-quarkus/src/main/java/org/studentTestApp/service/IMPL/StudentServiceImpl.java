package org.studentTestApp.service.IMPL;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import org.studentTestApp.dto.StudentDto;

import org.studentTestApp.entity.Student;
import org.studentTestApp.repo.StudentRepo;
import org.studentTestApp.service.StudentService;

import java.util.ArrayList;
import java.util.List;


@ApplicationScoped
public class StudentServiceImpl implements StudentService {

    @Inject
    StudentRepo studentRepo;

    @Override
public List<StudentDto> getAllStudents() {
        List<Student> getAllStudents = studentRepo.listAll();
        if (!getAllStudents.isEmpty()) {
            List<StudentDto> studentDtos = new ArrayList<>();

            for (Student student : getAllStudents) {
                StudentDto studentDto = new StudentDto(
                        student.getStudentId(),
                        student.getStudentName(),
                        student.getStudentAge()
                );
                studentDtos.add(studentDto);
            }
            return studentDtos;
        } else {
            throw new NotFoundException("No student found");
        }
    }


    public StudentDto getStudentById(long id) {
        Student student = studentRepo.findById(id);
       StudentDto studentDto = new StudentDto(
               student.getStudentId(),
               student.getStudentName(),
               student.getStudentAge()
       );
       return studentDto;
    }

    @Transactional
    public void createStudent(Student student) {
        studentRepo.persist(student);
        //return student;
    }

    @Transactional
    public StudentDto deleteStudentById(long id) {
    Student student = studentRepo.findById(id);
    studentRepo.deleteById(id);
    StudentDto studentDto = new StudentDto(
            student.getStudentId(),
            student.getStudentName(),
            student.getStudentAge()
    );
    return studentDto;
    }

    @Transactional
    @Override
    public void createStudent(StudentDto studentDto) {
    Student student = new Student(
            studentDto.getStudentId(),
            studentDto.getStudentName(),
            studentDto.getStudentAge()
    );
        studentRepo.persist(student);


    }
}
