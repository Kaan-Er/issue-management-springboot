package com.champ.issuemanagement.api;
import com.champ.issuemanagement.dto.ProjectDto;
import com.champ.issuemanagement.service.impl.ProjectServiceImpl;
import com.champ.issuemanagement.util.ApiPaths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.ProjectCtrl.Ctrl)
public class ProjectController {

    private ProjectServiceImpl projectServiceImpl;
    @Autowired
    public ProjectController(ProjectServiceImpl projectServiceImpl){
        this.projectServiceImpl=projectServiceImpl;
    }

    @GetMapping("/{id}") //localhost:8080/project/id    required=true -> null bi değer gelmesini engelledik.
    public ResponseEntity<ProjectDto> getById(@PathVariable(value = "id",required = true) Long id){
        ProjectDto projectDto = projectServiceImpl.getById(id);
        return ResponseEntity.ok(projectDto); //ok->status:200
    }

    @PostMapping
    public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto project){ //@Valid->kısıtlama yaptıklarımızı kontrol eder.(@NotNull demiştik)
        return ResponseEntity.ok(projectServiceImpl.save(project));
    }
    @PutMapping
    public ResponseEntity<ProjectDto> updateProject(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody ProjectDto project) {
        return ResponseEntity.ok(projectServiceImpl.update(id, project));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProject(@PathVariable(value = "id",required = true) Long id){
        return ResponseEntity.ok(projectServiceImpl.delete(id));
    }
}
