package org.studentTestApp.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.studentTestApp.dto.ModuleDto;
import org.studentTestApp.dto.StudentDto;
import org.studentTestApp.entity.Module;
import org.studentTestApp.service.IMPL.ModuleServiceImpl;
import org.studentTestApp.service.ModuleService;

import java.util.List;
import java.util.Set;

@Path("/api/v1/module")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ModuleController {
    @Inject
    public ModuleService moduleService;

    @POST
    @Path("/addModule")
    public Response addModule(ModuleDto moduleDto){
        moduleService.addModule(moduleDto);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/get_all_module")
    public List<ModuleDto> getAllModule(){
        return moduleService.getAllModule();
    }
//    @GET
//    @Path("/getStudentsByModule{moduleId}")
//    public Response getStudentsByModule(@PathParam("moduleId") Long moduleId) {
//        try {
//            Set<StudentDto> students = moduleService.getStudentsByModuleId(moduleId);
//            return Response.ok(students).build();
//        } catch (IllegalArgumentException e) {
//            return Response.status(Response.Status.NOT_FOUND)
//                    .entity(e.getMessage())
//                    .build();
//        }
//    }

    @DELETE
    @Path("{id}")
    public Response deleteModuleByID(@PathParam("id") long id){
       ModuleDto moduleDto= moduleService.deleteModuleByID(id);
        return  Response.status(Response.Status.OK).entity(moduleDto).build();
    }
}
