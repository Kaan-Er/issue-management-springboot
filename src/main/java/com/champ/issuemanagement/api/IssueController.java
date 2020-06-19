package com.champ.issuemanagement.api;

import com.champ.issuemanagement.dto.IssueDto;
import com.champ.issuemanagement.service.impl.IssueServiceImpl;
import com.champ.issuemanagement.util.ApiPaths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.IssueCtrl.Ctrl)
public class IssueController {

    private IssueServiceImpl issueServiceImpl;
    @Autowired
    public IssueController(IssueServiceImpl issueServiceImpl){
        this.issueServiceImpl=issueServiceImpl;
    }

    @GetMapping("/{id}") //localhost:8080/project/id    required=true -> null bi değer gelmesini engelledik.
    public ResponseEntity<IssueDto> getById(@PathVariable(value = "id",required = true) Long id){

        IssueDto issueDto = issueServiceImpl.getById(id);
        return ResponseEntity.ok(issueDto); //ok->status:200
    }

    @PostMapping
    public ResponseEntity<IssueDto> createProject(@Valid @RequestBody IssueDto issueDto){ //@Valid->kısıtlama yaptıklarımızı kontrol eder.(@NotNull demiştik)

        return ResponseEntity.ok(issueServiceImpl.save(issueDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<IssueDto> updateProject(@PathVariable(value = "id" ,required = true) Long id,@Valid @RequestBody IssueDto issueDto){

       return ResponseEntity.ok(issueServiceImpl.update(id,issueDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProject(@PathVariable(value = "id",required = true) Long id){
        return ResponseEntity.ok(issueServiceImpl.delete(id));
    }
}
