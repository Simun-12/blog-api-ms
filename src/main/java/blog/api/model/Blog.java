package blog.api.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "Blogs")
@Getter
@Setter
public class Blog {
    @Id
    private int postId;
    private String Title;
    private String content;
    private int userId;
    private LocalDateTime timestamp;
    private int totalUpvote;
    private int totalDownvote;
}
