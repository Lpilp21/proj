package test;

import Backend.Models.ResponseModel.GetBookResponse;
import Backend.Steps.GetAllBooksSteps;
import Backend.Steps.GetBookSteps;
import Frontend.Data.BookData;
import Frontend.Steps.BookDetailsSteps;
import Frontend.Steps.BooksSteps;
import io.qameta.allure.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static Frontend.Data.BookData.WEB_URL;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.open;


@Epic("Bookstore Application")
@Feature("Main Page")

public class BookStoreApiTest {
    public BookDetailsSteps bookDetailsSteps = new BookDetailsSteps();
    public BooksSteps booksSteps = new BooksSteps();
    public GetBookSteps getBookSteps = new GetBookSteps();
    public GetAllBooksSteps getAllBooksSteps = new GetAllBooksSteps();

    @BeforeClass
    public void setUp() {
        browser="chrome";
        holdBrowserOpen = false;
        timeout = 50000;
        screenshots = true;
        browserSize = "1920x1080";
        getBookSteps = new GetBookSteps();
        getAllBooksSteps = new GetAllBooksSteps();

    }
    @BeforeMethod
    public void start(){
        open(WEB_URL);
    }

    @Test()
    @Story("Validate UI and API retrived data for first book of the book store")
    @Description("Launch bookstore website and get first book details, send request to API and get details for first book, validate results")
    @Step("Validate UI and API retrived data for first book of the book store")
    public void validateBookDetails() {
        booksSteps.clickFirstBook();
        bookDetailsSteps
                .getBookIsbn()
                .getBookTitle()
                .getBookSubtitle()
                .getBookAuthor()
                .getBookPublisher()
                .getBookPages()
                .getBookDescription()
                .getBookWebsite();

        GetBookResponse apiResponse = getBookSteps.getBookDetails(BookData.isbn);
        bookDetailsSteps.validateIsbn(apiResponse.getIsbn())
                .validateTitle(apiResponse.getTitle())
                .validateSubtitle(apiResponse.getSubTitle())
                .validateAuthor(apiResponse.getAuthor())
                .validatePublisher(apiResponse.getPublisher())
                .validatePages(apiResponse.getPages())
                .validateDescription(apiResponse.getDescription())
                .validateWebsite(apiResponse.getWebsite());
    }
    @Test()
    @Story("Validate UI and API retrived book count of the book store")
    @Description("Launch bookstore website and get number of books, send request to API and get all books, validate is count matches")
    @Step("Validate UI and API retrived book count of the book store")
    public void ValidateBookCount() {
        int countOfApiBooks = getAllBooksSteps.getBookList().getBooks().size(); // TODO: ana api countis sworad wamogeba
        booksSteps
                .ValidateSizes(countOfApiBooks);




    }



    @Attachment(value = "Screenshot on failure", type = "image/png")
    public byte[] takeScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}

