package ApiTests;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;
    @JsonProperty("real_name")
    private String realName;
    @JsonProperty("email")
    private String email;
    @JsonProperty("access_level")
    private UserAccessLevel accessLevelName;
    @JsonProperty("enabled")
    private boolean enabled;
    @JsonProperty("protected")
    private boolean userProtected;
}
