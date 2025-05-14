package org.studentTestApp.controller;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.studentTestApp.dto.StudentDto;
import org.studentTestApp.dto.StudentModuleDto;
import org.studentTestApp.dto.StudentRequest;
import org.studentTestApp.entity.Student;
import org.studentTestApp.service.StudentService;

import java.util.List;


@Path("/api/v1/student")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentController {

    @Inject
    StudentService studentService;


@GET
@Path("/getAll")
public List<StudentDto> getAllStudents() {
    return studentService.getAllStudents();
}

    @GET
    @Path("/{id}")
    public Response getStudentById(@PathParam("id") long id) {
        StudentDto studentDto = studentService.getStudentById(id);
        if (studentDto != null) {
            return Response.ok(studentDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Path("/save")
    public Response createStudent(StudentDto studentDto) {
        studentService.createStudent(studentDto);
        return Response.status(Response.Status.OK).entity(studentDto).build();

    }

    @DELETE
    @Path("{id}")
    public Response deleteStudent(@PathParam("id") long id){
    StudentDto studentDto = studentService.deleteStudentById(id);
        return Response.status(Response.Status.OK).entity(studentDto).build();

    }
    @POST
    @Path("/studentRegModules")
    public Response saveRequest(StudentRequest studentRequest){
    StudentRequest studentRequest1=studentService.studentRegModules(studentRequest);
        return Response.ok(studentRequest1).status(Response.Status.OK).entity(studentRequest).build();
    }
}
