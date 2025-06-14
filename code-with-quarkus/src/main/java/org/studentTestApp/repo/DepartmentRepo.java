package org.studentTestApp.repo;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.studentTestApp.entity.Department;

@ApplicationScoped
public class DepartmentRepo implements PanacheRepository<Department> {
}
