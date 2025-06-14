package org.studentTestApp.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class StudentDto {
    private long studentId;
    private String studentName;
    private int nic;
    private String email;
}
