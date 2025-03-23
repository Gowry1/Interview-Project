package InterviewProject.controller;


import InterviewProject.EndpointUri;
import InterviewProject.common.response.ContentResponse;
import InterviewProject.dto.GetDto;
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
}
