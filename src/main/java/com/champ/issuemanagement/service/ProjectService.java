package com.champ.issuemanagement.service;

import com.champ.issuemanagement.entity.Project;
import com.champ.issuemanagement.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {

    Project save(Project project); // Project kaydı için parametre aldı.kaydettiği Project geri dönderiyor.

    Project getById(Long id); // verdiğimiz id ye göre Project dönderecek.

    Page<Project> getAllPageable(Pageable pageable); // sayfalama yapıyoruz.

    List<Project> getByProjectCode(String projectCode);

    List<Project> getByProjectCodeContains(String projectCode);

    Boolean delete(Project project);
}
