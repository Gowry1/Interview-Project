package InterviewProject.service.Impl;

import InterviewProject.entities.Task;
import InterviewProject.entities.TaskDto;
import InterviewProject.repositories.TaskRepository;
import InterviewProject.service.TaskService;
import jakarta.transaction.Transactional;
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
        return taskRepository.findAll();
    }

    @Override
    @Transactional
    public Task addTaskById(Long id) {
        // Check if task exists in DB
        Optional<Task> existingTask = taskRepository.findById(id);
        if (existingTask.isPresent()) {
            return existingTask.get();
        }

        // Fetch from API if not in DB
        String url = API_URL + "/" + id;
        Task taskFromApi = restTemplate.getForObject(url, Task.class);

        if (taskFromApi == null) {
            throw new RuntimeException("Task not found in API");
        }

        // Ensure a new entity is created instead of using the detached one
        Task newTask = new Task();
        newTask.setTitle(taskFromApi.getTitle());
        newTask.setCompleted(taskFromApi.isCompleted());

        // Save to the database
        return taskRepository.save(newTask);
    }


    @Override
    public Task updateTodo(Long id, TaskDto taskDto) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setTitle(taskDto.getTitle());
        task.setCompleted(taskDto.isCompleted());
        return taskRepository.save(task);
    }

    @Override
    public void deleteTodo(Long id) {
        taskRepository.deleteById(id);
    }


}
