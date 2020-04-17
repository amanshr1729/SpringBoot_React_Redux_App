package com.example.myproject.myproject.service;

import com.example.myproject.myproject.domain.ProjectTask;
import com.example.myproject.myproject.repository.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskService {
    @Autowired
    private ProjectTaskRepository projectTaskRepository;
    public ProjectTask savedProject(ProjectTask projectTask)
    {

        if(projectTask.getStatus()==null||projectTask.getStatus()=="")
        {
            projectTask.setStatus("TODO");
        }
        return  projectTaskRepository.save(projectTask);
    }
    public Iterable<ProjectTask> readAll(){

        return projectTaskRepository.findAll();
    }
    public ProjectTask findById(Long Id)
    {
        return  projectTaskRepository.getByid(Id);
    }
    public  void delete(Long id)
    {
        ProjectTask projectTask = findById(id);
        projectTaskRepository.delete(projectTask);
    }
}
