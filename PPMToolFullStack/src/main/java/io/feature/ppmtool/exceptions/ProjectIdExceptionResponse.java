package io.feature.ppmtool.exceptions;

import io.feature.ppmtool.domain.Project;

public class ProjectIdExceptionResponse {

    private String projectIdentifier;

    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }

    public ProjectIdExceptionResponse(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;

    }
}
