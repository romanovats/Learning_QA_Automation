package ApiTests;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

public class ApiTests extends Data {

    String userId;
    String projectId;
    String issueId;

    //Создание пользователя
    @Test
    public void CreateUserTest(){
        RequestSpecification request =
            given()
                .baseUri("http://khda91.fvds.ru/mantisbt/api/rest")
                .header(new Header("Authorization", "XNd5tIXXB7U8FV4C8w0nao0WYr5S0nN7"))
                .contentType(ContentType.JSON)
                .body(user);

        Response response = request
            .when()
                .post("/users");

        String statusLine = response
            .then()
                .statusCode(201)
                .statusLine(containsString("User created with id"))
                .extract()
                .statusLine();

        String[] splitStatusLine = statusLine.split(" ");
        userId = splitStatusLine[splitStatusLine.length - 1];
        System.out.println("created user id -> " + userId);
    }

    //Создание проекта
    @Test
    public void CreateProjectTest(){
        RequestSpecification request =
                given()
                        .baseUri("http://khda91.fvds.ru/mantisbt/api/rest")
                        .header(new Header("Authorization", "XNd5tIXXB7U8FV4C8w0nao0WYr5S0nN7"))
                        .contentType(ContentType.JSON)
                        .body(project);

        Response response = request
                .when()
                .post("/projects/");

        String statusLine = response
                .then()
                .statusCode(201)
                .statusLine(containsString("Project created with id"))
                .extract()
                .statusLine();

        String[] splitStatusLine = statusLine.split(" ");
        projectId = splitStatusLine[splitStatusLine.length - 1];
        System.out.println("created project id -> " + projectId);
    }

    //Создание issue с attachments
    @Test
    public void CreateIssueWithAttachmentsTest(){
        RequestSpecification request =
                given()
                        .baseUri("http://khda91.fvds.ru/mantisbt/api/rest")
                        .header(new Header("Authorization", "XNd5tIXXB7U8FV4C8w0nao0WYr5S0nN7"))
                        .contentType(ContentType.JSON)
                        .body(issue);

        Response response = request
                .when()
                .post("/issues/");

        String statusLine = response
                .then()
                .statusCode(201)
                .extract()
                .statusLine();

        String[] splitStatusLine = statusLine.split(" ");
        issueId = splitStatusLine[splitStatusLine.length - 1];
        System.out.println("created issue id -> " + issueId);
    }

    //удаление созданного пользователя
    @Test
    public void DeleteUserTest(){
        RequestSpecification request =
                given()
                        .baseUri("http://khda91.fvds.ru/mantisbt/api/rest")
                        .header(new Header("Authorization", "XNd5tIXXB7U8FV4C8w0nao0WYr5S0nN7"));

        Response response = request
                .when()
                .delete("/users/"+userId);

        response
                .then()
                .statusCode(204);
    }

    //добавление подпроекта к проекту
    @Test
    public void CreateSubProjectTest(){

        System.out.println(subProject);
        RequestSpecification request =
                given()
                        .baseUri("http://khda91.fvds.ru/mantisbt/api/rest")
                        .header(new Header("Authorization", "XNd5tIXXB7U8FV4C8w0nao0WYr5S0nN7"))
                        .contentType(ContentType.JSON)
                        .body(subProject);

        Response response = request
                .when()
                .post("/projects/"+projectId+"/subprojects");
        System.out.println(response.statusLine());
        String statusLine =  response
                .then()
                .statusCode(204)
                .statusLine(containsString("Subproject added to project"))
                .extract()
                .statusLine();

        String[] splitStatusLine = statusLine.split(" ");
        String id = splitStatusLine[1];
        System.out.println("id -> " + id);
    }

    //обновление issue
    @Test
    public void UpdateIssueTest(){
        RequestSpecification request =
                given()
                        .baseUri("http://khda91.fvds.ru/mantisbt/api/rest")
                        .header(new Header("Authorization", "XNd5tIXXB7U8FV4C8w0nao0WYr5S0nN7"))
                        .contentType(ContentType.JSON)
                        .body(updatedIssue);

        Response response = request
                .when()
                .patch("/issues/"+issueId);

        String statusLine = response
                .then()
                .statusCode(200)
                .extract()
                .statusLine();

        String[] splitStatusLine = statusLine.split(" ");
        String updatedIssueId = splitStatusLine[splitStatusLine.length - 1];
        System.out.println("updated issue id -> " + updatedIssueId);
    }

    //обновление несуществующего issue
    @Test
    public void UpdateNonexistentIssueTest(){
        RequestSpecification request =
                given()
                        .baseUri("http://khda91.fvds.ru/mantisbt/api/rest")
                        .header(new Header("Authorization", "XNd5tIXXB7U8FV4C8w0nao0WYr5S0nN7"))
                        .contentType(ContentType.JSON)
                        .body(issue);

        Response response = request
                .when()
                .patch("/issues/"+9999);

        String statusLine = response
                .then()
                .statusCode(404)
                .extract()
                .statusLine();

        System.out.println(statusLine);
    }

    //удаление несуществующего проекта
    @Test
    public void DeleteNonexistentProjectTest(){
        RequestSpecification request =
                given()
                        .baseUri("http://khda91.fvds.ru/mantisbt/api/rest")
                        .header(new Header("Authorization", "XNd5tIXXB7U8FV4C8w0nao0WYr5S0nN7"))
                        .contentType(ContentType.JSON);

        Response response = request
                .when()
                .delete("/projects/"+9999);

        String statusLine = response
                .then()
                .statusCode(403)
                .extract()
                .statusLine();

        System.out.println(statusLine);
    }

    //Удаление несуществующего пользователя
    @Test
    public void DeleteNonexistentUserTest(){
        RequestSpecification request =
                given()
                        .baseUri("http://khda91.fvds.ru/mantisbt/api/rest")
                        .header(new Header("Authorization", "XNd5tIXXB7U8FV4C8w0nao0WYr5S0nN7"));

        Response response = request
                .when()
                .delete("/users/"+9999);

        String statusLine = response
                .then()
                .statusCode(404)
                .extract()
                .statusLine();

        System.out.println(statusLine);
    }
}
