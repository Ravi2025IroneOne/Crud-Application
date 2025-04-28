package org.studentTestApp.entity;

import jakarta.persistence.*;
import jakarta.ws.rs.GET;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Module {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private long moduleID;
    private int moduleLevel;
    private String moduleName;

    @OneToMany(mappedBy = "module",cascade = CascadeType.ALL)
    Set<Student> students;


    public Module(long moduleID, int moduleLevel, String moduleName) {
    }
}
