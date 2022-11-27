package org.example.taks.tracker.store.repositories;

import org.example.taks.tracker.store.entities.TaskStateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskStateRepository extends JpaRepository<TaskStateEntity, Long> {
}
