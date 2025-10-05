package blog.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
@Getter
@Setter
@JsonIgnoreProperties
public class User {
    @Id
    private String userId;
    private String userName;
    private String fullName;
    private String email;
    private String password;
    private String dob;
    private String bio;
}
