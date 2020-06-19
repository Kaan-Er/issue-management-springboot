package com.champ.issuemanagement.api;

import com.champ.issuemanagement.dto.ProjectDto;
import com.champ.issuemanagement.service.impl.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/project")
public class ProjectController {

    private ProjectServiceImpl projectServiceImpl;
    @Autowired
    public ProjectController(ProjectServiceImpl projectServiceImpl){
        this.projectServiceImpl=projectServiceImpl;
    }

    @GetMapping("/{id}") //localhost:8080/project/id
    public ResponseEntity<ProjectDto> getById(@PathVariable("id") Long id){

        ProjectDto projectDto = projectServiceImpl.getById(id);
        return ResponseEntity.ok(projectDto); //ok->status:200
    }

    @PostMapping
    public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto project){ //@Valid->kısıtlama yaptıklarımızı kontrol eder.(@NotNull demiştik)

        return ResponseEntity.ok(projectServiceImpl.save(project));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable("id") Long id,@Valid @RequestBody ProjectDto project){

       return ResponseEntity.ok(projectServiceImpl.update(id,project));
    }
}
