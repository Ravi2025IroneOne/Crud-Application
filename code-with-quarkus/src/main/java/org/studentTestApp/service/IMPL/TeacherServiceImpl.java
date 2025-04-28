package org.studentTestApp.service.IMPL;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.studentTestApp.entity.Teacher;
import org.studentTestApp.repo.TeacherRepo;
@ApplicationScoped
public class TeacherServiceImpl {
    @Inject
    private TeacherRepo teacherRepo;
    public void saveTeacher(Teacher teacher) {
        teacherRepo.persist(teacher);
    }
}
