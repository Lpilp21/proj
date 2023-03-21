package Backend.Steps;

import Backend.Models.ResponseModel.GetBookResponse;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static Backend.Data.TestData.BASE_URL;
public class GetBookSteps {
    public GetBookResponse getBookDetails(String isbn){
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when()
                .get(BASE_URL + "Book?ISBN=" + isbn)
                .then()
                .extract()
                .response();
        return response.as(GetBookResponse.class);
    }

}
