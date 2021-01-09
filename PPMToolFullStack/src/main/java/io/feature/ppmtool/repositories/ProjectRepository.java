package io.feature.ppmtool.repositories;

import io.feature.ppmtool.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    Project findByProjectIdentifer(String projectId);

    @Override
    Iterable<Project> findAll();

}
