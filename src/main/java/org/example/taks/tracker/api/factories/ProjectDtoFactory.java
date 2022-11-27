package org.example.taks.tracker.api.factories;

import org.example.taks.tracker.api.dto.ProjectDto;
import org.example.taks.tracker.store.entities.ProjectEntity;
import org.springframework.stereotype.Component;

@Component
public class ProjectDtoFactory {

    public ProjectDto makeProjectDto(ProjectEntity entity) {
        return ProjectDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .updatedAt(entity.getUpdatedAt())
                .createdAt(entity.getCreatedAt())
                .build();
    }

}
