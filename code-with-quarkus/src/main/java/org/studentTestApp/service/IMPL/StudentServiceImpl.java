package org.studentTestApp.service.IMPL;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.studentTestApp.dto.StudentDto;
import org.studentTestApp.dto.StudentModuleDto;
import org.studentTestApp.dto.StudentRequest;
import org.studentTestApp.entity.Module;
import org.studentTestApp.entity.Student;
import org.studentTestApp.repo.ModuleRepo;
import org.studentTestApp.repo.StudentRepo;
import org.studentTestApp.service.StudentService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@ApplicationScoped
public class StudentServiceImpl implements StudentService {
    @Inject
    StudentRepo studentRepo;

    @Inject
    ModuleRepo moduleRepo;

    @Override
public List<StudentDto> getAllStudents() {
        List<Student> getAllStudents = studentRepo.listAll();
        if (!getAllStudents.isEmpty()) {
            List<StudentDto> studentDtos = new ArrayList<>();

            for (Student student : getAllStudents) {
                StudentDto studentDto = new StudentDto(
                        student.getStudentId(),
                        student.getStudentName(),
                        student.getNic(),
                        student.getEmail()
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
               student.getNic(),
               student.getEmail()
       );
       return studentDto;
    }

@Transactional
public StudentRequest studentRegModules(StudentRequest studentRequest) {
    // 1. Create new Student entity
    Student student = new Student();
    student.setStudentId(studentRequest.getStudentId());
    student.setStudentName(studentRequest.getStudentName());
    student.setNic(studentRequest.getNic());
    student.setEmail(studentRequest.getEmail());


    if (studentRequest.getModuleIDs() != null && !studentRequest.getModuleIDs().isEmpty()) {

        List<Module> modules = moduleRepo.list("id IN ?1", studentRequest.getModuleIDs());


        if (modules.size() != studentRequest.getModuleIDs().size()) {
            throw new WebApplicationException("One or more Module IDs are invalid", Response.Status.BAD_REQUEST);
        }

        student.setModules(new HashSet<>(modules));
        modules.forEach(module -> module.getStudents().add(student));
    }


    studentRepo.persist(student);

    return studentRequest;
}


    @Transactional
    public StudentDto deleteStudentById(long id) {
    Student student = studentRepo.findById(id);
    studentRepo.deleteById(id);
    return  new StudentDto(
            student.getStudentId(),
            student.getStudentName(),
            student.getNic(),
            student.getEmail()
    );

    }

    @Transactional
    public StudentDto createStudent(StudentDto studentDto) {
    Student student = new Student(
            studentDto.getStudentId(),
            studentDto.getStudentName(),
            studentDto.getNic(),
            studentDto.getEmail()
    );
        studentRepo.persist(student);
        return studentDto;


    }
}
