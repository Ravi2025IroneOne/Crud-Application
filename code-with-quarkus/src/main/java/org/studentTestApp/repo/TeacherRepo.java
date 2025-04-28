package org.studentTestApp.repo;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.studentTestApp.entity.Teacher;
@ApplicationScoped
public class TeacherRepo implements PanacheRepository<Teacher> {
}
