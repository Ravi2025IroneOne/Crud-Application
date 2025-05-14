package org.studentTestApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.studentTestApp.entity.Module;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentModuleDto {
    private long studentId;
    private String studentName;
    private int nic;
    private String email;

    private Module module;
}
