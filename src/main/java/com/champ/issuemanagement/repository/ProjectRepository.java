package com.champ.issuemanagement.repository;

import com.champ.issuemanagement.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Long> {

    //otomatik olarak bize sorguları dönderiyor.

    Project getByProjectCode (String projectCode);

    List<Project> getByProjectCodeContains(String projectCode);

    Page<Project> findAll(Pageable pageable);

    List<Project> findAll(Sort sort);

    Project getByProjectCodeAndIdNot(String projectCode, Long id);
}
