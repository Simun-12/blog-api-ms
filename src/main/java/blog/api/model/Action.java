package blog.api.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Actions")
@Getter
@Setter
public class Action {
    @Id
    private String actionId;
    private String postId;
    private String userId;
    private String actionType;
}
