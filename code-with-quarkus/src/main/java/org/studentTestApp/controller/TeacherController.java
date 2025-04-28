package org.studentTestApp.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.studentTestApp.entity.Teacher;
import org.studentTestApp.service.IMPL.TeacherServiceImpl;

@Path("/api/v1/teacher")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class TeacherController {
    @Inject
    private TeacherServiceImpl teacherService;

    @POST
    @Path("/save")
    public Response saveTeacher(Teacher teacher){
        teacherService.saveTeacher(teacher);
        return Response.status(Response.Status.CREATED).build();
    }
}
