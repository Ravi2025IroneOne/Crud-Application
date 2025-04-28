package org.studentTestApp.repo;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.studentTestApp.entity.Module;

@ApplicationScoped
public class ModuleRepo implements PanacheRepository<Module> {
}
