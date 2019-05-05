package ApiTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;

public abstract class Data {

    public User user;
    public Project project;
    public Issue issue;
    public SubProject subProject;
    public Issue updatedIssue;

    @BeforeClass(alwaysRun = true)
    protected void InitializeData() {

        ObjectMapper mapper = new ObjectMapper();
        try {
             user = mapper.readValue(new File("src/test/resources/ApiTests/users.json"), User.class);
             project = mapper.readValue(new File("src/test/resources/ApiTests/projects.json"), Project.class);
             issue = mapper.readValue(new File("src/test/resources/ApiTests/issues.json"), Issue.class);
             subProject = mapper.readValue(new File("src/test/resources/ApiTests/subproject.json"), SubProject.class);
             updatedIssue = mapper.readValue(new File("src/test/resources/ApiTests/updatedissues.json"), Issue.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}



