package blog.api.repository;

import blog.api.model.Action;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActionRepository extends MongoRepository<Action,String> {
}
