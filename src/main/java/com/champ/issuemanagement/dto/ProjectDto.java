package com.champ.issuemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {

    private Long id;
    @NotNull //proje adının clientten(fronend) boş gönderilmesini engelliyoruz.
    private String projectName;
    @NotNull
    private String projectCode;

}
