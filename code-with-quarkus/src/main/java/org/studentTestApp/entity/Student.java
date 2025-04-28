package org.studentTestApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    private long studentId;
    private String studentName;
    private int studentAge;

    @ManyToOne
    @JoinColumn(name = "module_id")
    Module module;

    public Student(long studentId, String studentName, int studentAge) {
    }

}
