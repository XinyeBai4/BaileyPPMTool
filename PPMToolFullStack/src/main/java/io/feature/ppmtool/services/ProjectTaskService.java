package io.feature.ppmtool.services;

import io.feature.ppmtool.domain.Backlog;
import io.feature.ppmtool.domain.ProjectTask;
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

    public ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask) {
        // Exception : Project not found

        // PTs to be a specific project, project != null => BL exists
        Backlog backlog = backlogRepository.findByProjectIdentifier(projectIdentifier);
        // set the BL to PT
        projectTask.setBacklog(backlog);

        // we want our project sequence like this: IDPRO-1 IDPRO-2
        Integer BacklogSequence = backlog.getPTSequence();
        // Update the BL sequence
        BacklogSequence++;

        // Add sequence to project task
        projectTask.setProjectSequence(projectIdentifier + "-" + BacklogSequence);
        projectTask.setProjectIdentifier(projectIdentifier);

        // Initial priority when priority is null
        if (projectTask.getPriority() == null) {
            projectTask.setPriority(3);
            // In the future we need projectTask.getPriority() == 0 to handle the form
        }
        // Initial status when status is null
        if (projectTask.getStatus() == "" || projectTask.getStatus() == null) {
            projectTask.setStatus("TO_DO");
        }

        return projectTaskRepository.save(projectTask);
    }
}
