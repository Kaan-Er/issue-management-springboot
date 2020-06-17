package com.champ.issuemanagement.service.impl;

import com.champ.issuemanagement.entity.Project;
import com.champ.issuemanagement.repository.ProjectRepository;
import com.champ.issuemanagement.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository)
    {
        this.projectRepository=projectRepository;
    }

    @Override
    public Project save(Project project) {

        if(project.getProjectCode()==null)
        {
            throw new IllegalArgumentException("Project code can not be null.");
        }
        project= this.projectRepository.save(project);
        return project;
    }

    @Override
    public Project getById(Long id) {
        return projectRepository.getOne(id);
    }

    @Override
    public Page<Project> getAllPageable(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    @Override
    public List<Project> getByProjectCode(String projectCode) {
        return null;
    }

    @Override
    public List<Project> getByProjectCodeContains(String projectCode) {
        return null;
    }

    @Override
    public Boolean delete(Project project) {
        return null;
    }
}