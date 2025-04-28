package org.studentTestApp.service;

import org.studentTestApp.dto.StudentDto;
import org.studentTestApp.entity.Student;

import java.util.List;

public interface StudentService{
    List<StudentDto> getAllStudents();

    StudentDto deleteStudentById(long id);

    void createStudent(StudentDto studentDto);

    StudentDto getStudentById(long id);
}
