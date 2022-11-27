package org.example.taks.tracker.api.factories;

import org.example.taks.tracker.api.dto.TaskStateDto;
import org.example.taks.tracker.store.entities.TaskStateEntity;
import org.springframework.stereotype.Component;

@Component
public class TaskStateDtoFactory {

    public TaskStateDto makeTaskStateDto(TaskStateEntity entity) {
        return TaskStateDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .ordinal(entity.getOrdinal())
                .createdAt(entity.getCreatedAt())
                .build();
    }
}
