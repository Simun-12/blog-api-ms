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
    private int actionId;
    private int postId;
    private int userId;
    private String actionType;
}
