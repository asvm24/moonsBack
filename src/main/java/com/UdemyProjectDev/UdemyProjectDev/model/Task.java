package com.UdemyProjectDev.UdemyProjectDev.model;

import com.UdemyProjectDev.UdemyProjectDev.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @ManyToOne
    @JoinColumn(name = "user_id") // Define the column name for the foreign key
    private User user;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
}