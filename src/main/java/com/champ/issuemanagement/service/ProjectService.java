package com.champ.issuemanagement.service;

import com.champ.issuemanagement.dto.ProjectDto;
import com.champ.issuemanagement.entity.Project;
import com.champ.issuemanagement.entity.User;
import com.champ.issuemanagement.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {

    ProjectDto save(ProjectDto project); // Project kaydı için parametre aldı.kaydettiği Project geri dönderiyor.

    ProjectDto getById(Long id); // verdiğimiz id ye göre Project dönderecek.

    TPage<ProjectDto> getAllPageable(Pageable pageable); // sayfalama yapıyoruz.

    ProjectDto getByProjectCode(String projectCode);

    List<ProjectDto> getByProjectCodeContains(String projectCode);

    Boolean delete(ProjectDto project);
}
