package org.studentTestApp.dto;

import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class StudentRequest {
    private long studentId;
    private String studentName;
    private int nic;
    private String email;

    private Set<Long> moduleIDs;
}
