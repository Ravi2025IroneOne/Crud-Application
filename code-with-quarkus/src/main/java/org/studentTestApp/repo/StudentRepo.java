package org.studentTestApp.repo;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.studentTestApp.entity.Student;

@ApplicationScoped
public class StudentRepo implements PanacheRepository<Student> {

}
