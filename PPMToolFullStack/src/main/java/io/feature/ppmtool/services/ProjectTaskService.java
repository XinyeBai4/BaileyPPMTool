package io.feature.ppmtool.services;

import io.feature.ppmtool.domain.Backlog;
import io.feature.ppmtool.domain.Project;
import io.feature.ppmtool.domain.ProjectTask;
import io.feature.ppmtool.exceptions.ProjectNotFoundException;
import io.feature.ppmtool.repositories.BacklogRepository;
import io.feature.ppmtool.repositories.ProjectRepository;
import io.feature.ppmtool.repositories.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectTaskService {

    @Autowired
    private BacklogRepository backlogRepository;

    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    public ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask) {
        // Exception : Project not found
    	try {
    		 // PTs to be a specific project, project != null => BL exists
            Backlog backlog = backlogRepository.findByProjectIdentifier(projectIdentifier);
            // set the BL to PT
            projectTask.setBacklog(backlog);

            // we want our project sequence like this: IDPRO-1 IDPRO-2
            Integer BacklogSequence = backlog.getPTSequence();
            // Update the BL sequence
            BacklogSequence++;
            backlog.setPTSequence(BacklogSequence);

            // Add sequence to project task
            projectTask.setProjectSequence(projectIdentifier + "-" + BacklogSequence);
            projectTask.setProjectIdentifier(projectIdentifier);

            // Initial priority when priority is null
            if (projectTask.getPriority() == 0 || projectTask.getPriority() == null) {
                projectTask.setPriority(3);
                // In the future we need projectTask.getPriority() == 0 to handle the form
            }
            // Initial status when status is null
            if (projectTask.getStatus() == "" || projectTask.getStatus() == null) {
                projectTask.setStatus("TO_DO");
            }

            return projectTaskRepository.save(projectTask);
    	} catch (Exception e) {
    		throw new ProjectNotFoundException("Project not Found");
    	}
    	

       
    }
    
    @Autowired
    private ProjectRepository projectRepository;

    public Iterable<ProjectTask>findBacklogById(String id) {
        
    	Project project = projectRepository.findByProjectIdentifier(id);
    			
    	if (project==null) {
    		throw new ProjectNotFoundException("Project with ID: '"+id+"' does not exist");
    	}
    	
    	return projectTaskRepository.findByProjectIdentifierOrderByPriority(id);
    }
    
    public ProjectTask findByProjectSequence(String backlog_id, String pt_id) {
    	
    	// make sure we are searching on the right backlog
    	Backlog backlog = backlogRepository.findByProjectIdentifier(backlog_id);
    	if (backlog_id == null) {
    		throw new ProjectNotFoundException("Project with ID: '"+backlog_id+"' does not exist");
    	}
    	
    	// make sure that our task exists
    	ProjectTask projectTask = projectTaskRepository.findByProjectSequence(pt_id);
    	if (projectTask == null) {
    		throw new ProjectNotFoundException("Project Task '"+pt_id+"' not found");
    	}
    	// make sure that the backlog/project id in the path corresponds to the right project
    	if (!projectTask.getProjectIdentifier().equals(backlog_id)) {
    		throw new ProjectNotFoundException("Project Task '"+pt_id+"' does not exist in project: '"+backlog_id+"'");
    	}
    	return projectTask;
    }
    
    public ProjectTask updateByProjectSequence(ProjectTask updatedTask, String backlog_id, String pt_id) {
    	// Update project task
    	//    	ProjectTask projectTask = projectTaskRepository.findByProjectSequence(updatedTask.getProjectSequence());
//    	ProjectTask projectTask = projectTaskRepository.findByProjectSequence(pt_id);
    	ProjectTask projectTask = findByProjectSequence(backlog_id, pt_id);
    	projectTask = updatedTask;
    	return projectTaskRepository.save(projectTask);
   
    
	    //find existing project task
	    
	    //replace it with updated task
	    
	    //save update
    }
    
    public void deletePTByProjectSequence(String backlog_id, String pt_id) {
    	ProjectTask projectTask = findByProjectSequence(backlog_id, pt_id);
    	
//    	Backlog backlog = projectTask.getBacklog();
//    	List<ProjectTask> pts = backlog.getProjectTasks();
//    	pts.remove(projectTask);
    	
    	
    	projectTaskRepository.delete(projectTask);
    }
}
