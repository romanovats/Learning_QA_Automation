package ApiTests;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Project {
    private int id;
    private String name;
    private ProjectStatus status;
    private String description;
    private boolean enabled;
    @JsonProperty("file_path")
    private String filepath;
    @JsonProperty("view_state")
    private ProjectViewState viewState;
}
