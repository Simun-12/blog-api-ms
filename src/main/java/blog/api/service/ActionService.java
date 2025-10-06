package blog.api.service;

import blog.api.model.Action;
import blog.api.repository.ActionRepository;
import org.springframework.stereotype.Service;

@Service
public class ActionService {

    private final ActionRepository actionRepository;

    public ActionService(ActionRepository actionRepository) {
        this.actionRepository = actionRepository;
    }

    public Action setAction(Action action) {
        return actionRepository.save(action);
    }
}
