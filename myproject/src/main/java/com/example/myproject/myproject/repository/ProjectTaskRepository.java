package com.example.myproject.myproject.repository;

import com.example.myproject.myproject.domain.ProjectTask;
import org.springframework.data.repository.CrudRepository;

public interface ProjectTaskRepository extends CrudRepository<ProjectTask,Long> {
ProjectTask getByid(Long id);
}
