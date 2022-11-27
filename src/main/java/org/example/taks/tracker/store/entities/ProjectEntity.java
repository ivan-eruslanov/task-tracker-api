package org.example.taks.tracker.store.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "project")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(unique = true)
    String name;

    @Builder.Default
    Instant createdAt = Instant.now();

    @Builder.Default
    Instant updatedAt = Instant.now();

    @Builder.Default
    @OneToMany
    @JoinColumn(name = "project_id")
    List<TaskStateEntity> taskStates = new ArrayList<>();
}
