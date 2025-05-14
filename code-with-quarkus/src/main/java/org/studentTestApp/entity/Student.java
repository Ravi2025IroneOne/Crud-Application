package org.studentTestApp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Student {
    @Id
    private long studentId;
    private String studentName;

    @Column(name = "studentNic")
    private int nic;

    @Column(name = "studentEmail")
    private String email;


    @ManyToMany
//    @JoinTable(
//            name = "student_enrollment",
//            joinColumns = @JoinColumn(name = "studentId"),
//            inverseJoinColumns = @JoinColumn(name = "moduleId")
//    )
    private Set<Module> modules = new HashSet<>();

    public Student(long studentId, String studentName, int nic, String email) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.nic = nic;
        this.email = email;
    }

/*    public Student(long studentId, String studentName, int nic, String email, long moduleID) {
        this.studentId=studentId;
        this.studentName=studentName;
        this.nic=nic;
        this.email=email;
        this.
    }*/
}
