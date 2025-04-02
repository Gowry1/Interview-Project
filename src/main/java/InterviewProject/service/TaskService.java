package InterviewProject.service;

import InterviewProject.entities.Task;
import InterviewProject.entities.TaskDto;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public interface TaskService {


    final RestTemplate restTemplate = new RestTemplate();
    final String API_URL = "https://jsonplaceholder.typicode.com/todos";


    List<Task> getAllTodos();


//    Task createTodo(TaskDto taskDto);
//
//
//    Task updateTodo(Long id, TaskDto taskDto);

    Task addTaskById(Long id);

    Task updateTodo(Long id,TaskDto taksDto);

    void deleteTodo(Long id);
}
