package Backend.Steps;

import Backend.Models.ResponseModel.GetAllBooksResponse;
import Backend.Models.ResponseModel.GetBookResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static Backend.Data.TestData.BASE_URL;
public class GetBookWithIsbnStep {
    public GetBookResponse getBookDetails(String isbn){
        Response response = RestAssured
                .given()
                .queryParam("ISBN", isbn)
                .when()
                .get(BASE_URL + "/Book")
                .then()
                .extract()
                .response();
        return response.as(GetBookResponse.class);
    }

}
