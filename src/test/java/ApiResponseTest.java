import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ApiResponseTest {

    @Test
    public void testGetRequestWoops() {
        Response response = given()
                .when()
                .get("https://postman-echo.com/get?foo1=bar1&foo2=bar2")
                .then().log().body()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", equalTo("close"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.user-agent", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                .extract()
                .response();
    }
    @Test
    public void testPostRawText() {
        String requestBody = "{ \"test\": \"value\" }";
        Response response = given()
                .header("Content-Type", "text/plain")
                .body(requestBody)
                .when()
                .post("https://postman-echo.com/post")
                .then().log().body()
                .statusCode(200)
                .extract()
                .response();
        response.then()
                .body("args", notNullValue())
                .body("data", notNullValue())
                .body("files", notNullValue())
                .body("form", notNullValue())
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", equalTo("close"))
                .body("headers.content-length", notNullValue())
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/23.0.2)"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.postman-token", equalTo(null))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.cookie", equalTo(null))
                .body("json", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/post"));
    }
    @Test
    public void testPostFormData() {
        String requestBody = "foo1=bar1&foo2=bar2";
        Response response = given()
                .header("Content-Type", "text/plain")
                .body(requestBody)
                .when()
                .post("https://postman-echo.com/post")
                .then().log().body()
                .statusCode(200)
                .extract()
                .response();
        response.then()
                .body("args", notNullValue())
                .body("data", notNullValue())
                .body("files", notNullValue())
                .body("form.foo1", equalTo(null))
                .body("form.foo2", equalTo(null))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", equalTo("close"))
                .body("headers.content-length", equalTo("19"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/23.0.2)"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.postman-token", equalTo(null))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers.cookie", equalTo(null))
                .body("json.foo1", equalTo(null))
                .body("json.foo2", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/post"));
    }
    @Test
    public void testPutRequest() {
        String requestBody = "{ \"test\": \"value\", \"foo1\": \"bar1\", \"foo2\": \"bar2\" }";
        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put("https://postman-echo.com/put")
                .then().log().body()
                .statusCode(200)
                .extract()
                .response();
        response.then()
                .body("args", notNullValue())
                .body("data.test", equalTo("value"))
                .body("data.foo1", equalTo("bar1"))
                .body("data.foo2", equalTo("bar2"))
                .body("files", notNullValue())
                .body("form", notNullValue())
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", equalTo("close"))
                .body("headers.content-length", notNullValue())
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.user-agent", notNullValue())
                .body("headers.accept", equalTo("*/*"));
    }
    @Test
    public void testPatchRequest() {
        String requestBody = "{ \"test\": \"value\", \"foo1\": \"bar1\", \"foo2\": \"bar2\" }";
        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .patch("https://postman-echo.com/patch")
                .then().log().body()
                .statusCode(200)
                .extract()
                .response();
        response.then()
                .body("args", notNullValue())
                .body("data", notNullValue())
                .body("files", notNullValue())
                .body("form", notNullValue())
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", equalTo("close"))
                .body("headers.content-length", notNullValue())
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.user-agent", notNullValue())
                .body("headers.accept", equalTo("*/*"));
    }
    @Test
    public void testDeleteRequest() {
        String requestBody = "";
        Response response = given()
                .header("Content-Type", "text/plain")
                .body(requestBody)
                .when()
                .delete("https://postman-echo.com/delete")
                .then().log().body()
                .statusCode(200)
                .extract()
                .response();
        response.then()
                .body("args", notNullValue())
                .body("data", notNullValue())
                .body("files", notNullValue())
                .body("form", notNullValue())
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", equalTo("close"))
                .body("headers.content-length", equalTo("0"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/23.0.2)"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.postman-token", equalTo(null))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.cookie", equalTo(null))
                .body("json", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/delete"));
    }
}

