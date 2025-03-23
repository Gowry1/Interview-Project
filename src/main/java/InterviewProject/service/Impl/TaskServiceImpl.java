package InterviewProject.service.Impl;

import InterviewProject.entities.Task;
import InterviewProject.repositories.TaskRepository;
import InterviewProject.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getAllTodos() {
        return (List<Task>) taskRepository.findAll();

    }
}
