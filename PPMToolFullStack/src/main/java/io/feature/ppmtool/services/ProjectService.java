package io.feature.ppmtool.services;

import io.feature.ppmtool.domain.Project;
import io.feature.ppmtool.exceptions.ProjectIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.feature.ppmtool.repositories.ProjectRepository;

import java.util.Locale;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project) {

        // Logic
        try {
            project.setProjectIdentifer(project.getProjectIdentifer().toUpperCase());
            return projectRepository.save(project);
        } catch (Exception e) {
            throw new ProjectIdException("Project ID ‘" + project.getProjectIdentifer().toUpperCase() + "' already exists");
        }


    }
}
