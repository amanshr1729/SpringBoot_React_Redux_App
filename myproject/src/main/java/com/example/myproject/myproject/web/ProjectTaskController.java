package com.example.myproject.myproject.web;

import com.example.myproject.myproject.domain.ProjectTask;
import com.example.myproject.myproject.service.ProjectTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/board")
@CrossOrigin
public class ProjectTaskController {
@Autowired
    private ProjectTaskService projectTaskService;
@PostMapping("")
 public ResponseEntity<?> addBoard(@Valid @RequestBody ProjectTask projectTask, BindingResult bindingResult)
{
    if(bindingResult.hasErrors())
    {
        Map<String,String> err = new HashMap<>();
        bindingResult.getFieldError();
        for(FieldError error: bindingResult.getFieldErrors())
        {
            err.put(error.getField(),error.getDefaultMessage());
        }
        return  new ResponseEntity<Map<String,String>>(err, HttpStatus.BAD_REQUEST);
    }
    ProjectTask newP = projectTaskService.savedProject(projectTask);
    return  new ResponseEntity<ProjectTask>(newP, HttpStatus.CREATED);
}
@GetMapping("/all")
    public  Iterable<ProjectTask> getAllp(){

    return projectTaskService.readAll();
}
@GetMapping("/{pt_id}")
    public  ResponseEntity<?> getPTById(@PathVariable Long pt_id)
{

    ProjectTask projectTask = projectTaskService.findById(pt_id);
    return  new ResponseEntity<ProjectTask>(projectTask,HttpStatus.OK);
}
@DeleteMapping("/{pt_id}")
    public ResponseEntity<?> deleTask(@PathVariable Long pt_id)
{

    projectTaskService.delete(pt_id);
    return new ResponseEntity<String>("Task Deleted",HttpStatus.OK);
}
}
