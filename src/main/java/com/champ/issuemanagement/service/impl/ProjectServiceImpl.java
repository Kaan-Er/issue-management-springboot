package com.champ.issuemanagement.service.impl;

import com.champ.issuemanagement.dto.ProjectDto;
import com.champ.issuemanagement.entity.Project;
import com.champ.issuemanagement.repository.ProjectRepository;
import com.champ.issuemanagement.service.ProjectService;
import com.champ.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository,ModelMapper modelMapper)
    {
        this.projectRepository=projectRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public ProjectDto save(ProjectDto project) {
        //aynı proje code olmasının önüne geçiyoruz.
        Project projectCheck = projectRepository.getByProjectCode(project.getProjectCode());
        if(projectCheck!=null){
            throw new IllegalArgumentException("Project code is already!");
        }
        Project p = modelMapper.map(project,Project.class); //gelen parametreyi db entitye göre dönüştürdük.
        p = projectRepository.save(p); //dönüştürdükten sonra db'ye kaydettik.
        project.setId(p.getId()); //db'de oluşan id bilgisini aldık.
        return project; //proje bilgilerini dto şeklinde dönderdik.
    }

    @Override
    public ProjectDto getById(Long id) {
        Project p = projectRepository.getOne(id); //verilen id'ye göre db de kayıtlı proje bilgilerini aldık.
        return modelMapper.map(p,ProjectDto.class); //bu bilgileri dto'ya göre map edip return ettik.
    }

    @Override
    public TPage<ProjectDto> getAllPageable(Pageable pageable) {
        Page<Project> data = projectRepository.findAll(pageable);
        TPage<ProjectDto> response = new TPage<ProjectDto>();
        response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(),ProjectDto[].class)));
        return response;
    }

    @Override
    public ProjectDto getByProjectCode(String projectCode) {
        return null;
    }

    @Override
    public List<ProjectDto> getByProjectCodeContains(String projectCode) {
        return null;
    }

    @Override
    public Boolean delete(ProjectDto project) {
        return null;
    }

    public Boolean delete(Long id) {
        projectRepository.deleteById(id);
        return true;
    }

    @Override
    public ProjectDto update(Long id, ProjectDto project) {
        Project projectDb = projectRepository.getOne(id); //id ye göre projeyi db den aldık.
        if(projectDb==null) // eger bu id li bir projemiz yoksa hata fırlatıyoruz.
        {
            throw new IllegalArgumentException("Project Does Not Exist ID :"+id);
        }
        //aynı proje code olmasının önüne geçiyoruz.
        Project projectCheck = projectRepository.getByProjectCodeAndIdNot(project.getProjectCode(),id);
        if(projectCheck!=null){
            throw new IllegalArgumentException("Project code is already!");
        }

        projectDb.setProjectCode(project.getProjectCode());
        projectDb.setProjectName(project.getProjectName());

        projectRepository.save(projectDb);
        return modelMapper.map(projectDb,ProjectDto.class);
    }
}
