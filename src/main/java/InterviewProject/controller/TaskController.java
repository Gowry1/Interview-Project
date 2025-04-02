package InterviewProject.controller;


import InterviewProject.EndpointUri;
import InterviewProject.common.response.ContentResponse;
import InterviewProject.dto.GetDto;
import InterviewProject.entities.Task;
import InterviewProject.entities.TaskDto;
import InterviewProject.rest.enums.RequestStatus;
import InterviewProject.service.TaskService;
import InterviewProject.util.Constants;
import InterviewProject.util.StatusCodeBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class TaskController {

    @Autowired
    private StatusCodeBundle statusCodeBundle;

    @Autowired TaskService taskService;

    @GetMapping(value = EndpointUri.GETTASK)
    public ResponseEntity<Object> getTask() {
        return ResponseEntity.ok(
                new ContentResponse<>(
                        Constants.TASK,
                        taskService.getAllTodos(),
                        RequestStatus.SUCCESS.getStatus(),
                        statusCodeBundle.getCommonSuccessCode(),
                        statusCodeBundle.getCommonSuccessCode()
                )
        );
    }

    @PostMapping(value = EndpointUri.CREATETASK)
    public ResponseEntity<Task> createTodo(@RequestBody TaskDto taskDto) {
        return ResponseEntity.ok(taskService.addTaskById(taskDto.getId()));
    }

    @PutMapping(value = EndpointUri.UPDATETASK)
    public ResponseEntity<Task> updateTodo(@PathVariable Long id,@RequestBody TaskDto taskDto) {
        return ResponseEntity.ok(taskService.updateTodo(id,taskDto));
    }

    @DeleteMapping(value = EndpointUri.DELETETASK)
    public ResponseEntity<Void> deleteTodo(@PathVariable("id") Long id) {
        taskService.deleteTodo(id);
        return ResponseEntity.noContent().build(); // Returns 204 No Content after successful deletion
    }
}
