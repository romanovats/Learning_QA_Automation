package ApiTests;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Issue {

    private String summary;
    private String description;
    private Project project;
    private IssueCategory category;
    private List<File> files;
    private IssuePriority priority;
    private IssueStatus status;
}
