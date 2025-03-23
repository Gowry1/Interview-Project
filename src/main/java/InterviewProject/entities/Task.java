package InterviewProject.entities;

import InterviewProject.enums.TaskStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    private String assignedTo;

    private LocalDateTime dueDate;
}
