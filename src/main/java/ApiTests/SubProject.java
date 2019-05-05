package ApiTests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SubProject {
    private Project project;
    @JsonProperty("inherit_parent")
    private String inheritParent;
}
