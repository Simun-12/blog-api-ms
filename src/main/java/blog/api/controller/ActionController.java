package blog.api.controller;

import blog.api.model.Action;
import blog.api.repository.ActionRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Action API", description = "Operations related to upvote/downvote")
@RestController
@RequestMapping("/api/actions")
public class ActionController {
    private final ActionRepository actionRepository;

    public ActionController(ActionRepository actionRepository){
        this.actionRepository = actionRepository;
    }

    @Operation(summary = "set Action")
    @PostMapping("/setAction")
    public Action setAction(@RequestBody Action action){
        return actionRepository.save(action);
    }
}
