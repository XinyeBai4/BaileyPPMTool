package io.feature.ppmtool.services;

import io.feature.ppmtool.repositories.BacklogRepository;
import io.feature.ppmtool.repositories.ProjectRepository;
import io.feature.ppmtool.repositories.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskService {

    @Autowired
    private BacklogRepository backlogRepository;

    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    public ProjectTask addProjectTask() {
        // PTs to be a specific project, project != null => BL exists
        // set the BL to PT

        // we want our project sequence like this: IDPRO-1 IDPRO-2
        // Update the BL sequence

        // Initial priority when priority is null
        // Initial status when status is null
    }
}
