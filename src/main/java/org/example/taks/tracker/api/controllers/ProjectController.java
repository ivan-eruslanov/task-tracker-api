package org.example.taks.tracker.api.controllers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.taks.tracker.api.dto.ProjectDto;
import org.example.taks.tracker.api.exceptions.BadRequestException;
import org.example.taks.tracker.api.factories.ProjectDtoFactory;
import org.example.taks.tracker.store.entities.ProjectEntity;
import org.example.taks.tracker.store.repositories.ProjectRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional
@RestController
public class ProjectController {

    ProjectDtoFactory projectDtoFactory;
    ProjectRepository projectRepository;

    public static final String CREATE_PROJECT = "/api/projects";

    @PostMapping(CREATE_PROJECT)
    public ProjectDto createProject(@RequestParam String name) {
        projectRepository
                .findByName(name)
                .ifPresent(project -> {
                    throw new BadRequestException(String.format("Project \"%s\" already exists.", name));
                });

        ProjectEntity project = projectRepository.saveAndFlush(
                ProjectEntity.builder()
                        .name(name)
                        .build()
        );

        return projectDtoFactory.makeProjectDto(project);
    }
}
