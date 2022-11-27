package org.example.taks.tracker.store.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "task_state")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskStateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(unique = true)
    String name;

    Long ordinal;

    @Builder.Default
    Instant createdAt = Instant.now();

    @Builder.Default
    @OneToMany
    @JoinColumn(name = "task_state_id")
    List<TaskEntity> tasks = new ArrayList<>();
}
