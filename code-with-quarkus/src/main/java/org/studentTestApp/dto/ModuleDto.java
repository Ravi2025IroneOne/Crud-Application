package org.studentTestApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ModuleDto {
    private long moduleID;
    private int moduleLevel;
    private String moduleName;
}
