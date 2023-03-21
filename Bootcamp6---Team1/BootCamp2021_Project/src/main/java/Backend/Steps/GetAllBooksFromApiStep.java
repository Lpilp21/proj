package Backend.Steps;

import Backend.Models.ResponseModel.GetAllBooksResponse;
import Backend.Models.ResponseModel.GetBookResponse;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static Backend.Data.TestData.BASE_URL;

public class GetAllBooksFromApiStep {
    public GetAllBooksResponse getBookList(){
        Response response = RestAssured
                .given()
                .filter(new AllureRestAssured())
                .when()
                .get(BASE_URL + "/Books")
                .then()
                .extract()
                .response();

        return response.as(GetAllBooksResponse.class);
    }


}
