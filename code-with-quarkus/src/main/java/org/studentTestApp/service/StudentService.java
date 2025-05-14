package org.studentTestApp.service;

import org.studentTestApp.dto.StudentDto;
import org.studentTestApp.dto.StudentModuleDto;
import org.studentTestApp.dto.StudentRequest;
import org.studentTestApp.entity.Student;

import java.util.List;

public interface StudentService{
    List<StudentDto> getAllStudents();

    StudentDto deleteStudentById(long id);

    StudentDto createStudent(StudentDto studentDto);

    StudentDto getStudentById(long id);


    StudentRequest studentRegModules(StudentRequest studentRequest);
}
