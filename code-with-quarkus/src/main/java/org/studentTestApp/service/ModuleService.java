package org.studentTestApp.service;

import org.studentTestApp.dto.ModuleDto;
import org.studentTestApp.dto.StudentDto;
import org.studentTestApp.entity.Module;

import java.util.List;
import java.util.Set;

public interface ModuleService {
    void addModule(ModuleDto moduleDto);

    List<ModuleDto> getAllModule();

    Set<StudentDto> getStudentsByModuleId(Long moduleId);

    ModuleDto deleteModuleByID(long id);
}
