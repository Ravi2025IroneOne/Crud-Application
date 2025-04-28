package org.studentTestApp.service.IMPL;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import org.studentTestApp.dto.ModuleDto;
import org.studentTestApp.dto.StudentDto;
import org.studentTestApp.entity.Module;
import org.studentTestApp.repo.ModuleRepo;
import org.studentTestApp.service.ModuleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class ModuleServiceImpl implements ModuleService {

    private ModuleRepo moduleRepo;

    public ModuleServiceImpl(ModuleRepo moduleRepo) {
        this.moduleRepo = moduleRepo;
    }


    @Override
    public void addModule(ModuleDto moduleDto) {
        Module module = new Module(
                moduleDto.getModuleID(),
                moduleDto.getModuleLevel(),
                moduleDto.getModuleName()
        );
       moduleRepo.persist(module);
    }

    public List<ModuleDto> getAllModule() {
        List<Module> getAllModules=  moduleRepo.listAll();
        if(!getAllModules.isEmpty()){
            List<ModuleDto> moduleDtoList = new ArrayList<>();

            for(Module module : getAllModules){
                ModuleDto moduleDto = new ModuleDto(
                        module.getModuleID(),
                        module.getModuleLevel(),
                        module.getModuleName()
                );
                moduleDtoList.add(moduleDto);
            }
            return moduleDtoList;
        }else {
            throw new NotFoundException("No Customer Found");

    }
    }

    @Transactional
    public Set<StudentDto> getStudentsByModuleId(Long moduleId) {
        Module module = moduleRepo.findById(moduleId);
        if (module == null) {
            throw new IllegalArgumentException("Module with ID " + moduleId + " not found");
        }
        
        return module.getStudents().stream()
                .map(student -> new StudentDto(
                        student.getStudentId(),
                        student.getStudentName(),
                        student.getStudentAge()))
                .collect(Collectors.toSet());
    }

    @Transactional
    @Override
    public ModuleDto deleteModuleByID(long id) {
        Module module = moduleRepo.findById(id);
        moduleRepo.deleteById(id);
        ModuleDto moduleDto = new ModuleDto(
                module.getModuleID(),
                module.getModuleLevel(),
                module.getModuleName()
        );
        return moduleDto;
    }
}
