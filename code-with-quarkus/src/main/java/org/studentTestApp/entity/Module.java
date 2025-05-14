package org.studentTestApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Module {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private long moduleID;
    private int moduleLevel;
    private String moduleName;


    @ManyToMany
    @JoinTable(
            name = "student_enrollment",
            joinColumns = @JoinColumn(name = "moduleId"),
            inverseJoinColumns = @JoinColumn(name = "studentId")
    )
    private Set<Student> students = new HashSet<>();

    public Module(long moduleID, String moduleName, int moduleLevel) {
        this.moduleID = moduleID;
        this.moduleName = moduleName;
        this.moduleLevel = moduleLevel;
    }
}
