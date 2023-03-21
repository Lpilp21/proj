package Backend.Steps;

import Backend.Models.ResponseModel.GetAllBooksResponse;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static Backend.Data.TestData.BASE_URL;

public class GetAllBooksSteps {
    public GetAllBooksResponse getBookList(){
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .filter(new AllureRestAssured())
                .when()
                .get(BASE_URL + "Books")
                .then()
                .extract()
                .response();

        return response.as(GetAllBooksResponse.class);
    }


}
