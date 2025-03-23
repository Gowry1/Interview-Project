package InterviewProject.service;

import InterviewProject.entities.Task;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public interface TaskService {


    final RestTemplate restTemplate = new RestTemplate();
    final String API_URL = "https://jsonplaceholder.typicode.com/todos";

    public default List<Task> getAllTodos() {
        Task[] todos = restTemplate.getForObject(API_URL, Task[].class);
        return Arrays.asList(todos);
    }
}
