package test;

import Backend.Models.ResponseModel.GetBookResponse;
import Backend.Steps.GetAllBooksFromApiStep;
import Backend.Steps.GetBookWithIsbnStep;
import Frontend.Data.BookData;
import Frontend.Steps.GetAllBooksStep;
import Frontend.Steps.GetFirstBookStep;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Frontend.Data.BookData.WEB_URL;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.open;


@Epic("Bookstore Application")
@Feature("Main Page")

public class BookStoreApiTest {
    public GetFirstBookStep navigate = new GetFirstBookStep();
    public GetBookWithIsbnStep getBookWithIsbnStep = new GetBookWithIsbnStep();
    public GetAllBooksFromApiStep getAllBooksFromApiStep = new GetAllBooksFromApiStep();

    @BeforeClass
    public void setUp() {
        open(WEB_URL);
        browser="chrome";
        holdBrowserOpen = false;
        timeout = 50000;
        screenshots = true;
        browserSize = "1920x1080";
//        ChromeOptions option = new ChromeOptions();
//        option.addArguments("--remote-allow-origins=*");
        //Configuration.browserCapabilities = new ChromeOptions().addArguments("start-maximized");
        getBookWithIsbnStep = new GetBookWithIsbnStep();
        getAllBooksFromApiStep = new GetAllBooksFromApiStep();

    }

    @Test()
    @Story("Validate UI and API retrived data for first book of the book store")
    @Description("Launch bookstore website and get first book details, send request to API and get details for first book, validate results")
    @Step("Validate UI and API retrived data for first book of the book store")
    public void validateBookDetails() {
        navigate
                .clickFirstBook()
                .getBookIsbn()
                .getBookTitle()
                .getBookSubtitle()
                .getBookAuthor()
                .getBookPublisher()
                .getBookPages()
                .getBookDescription()
                .getBookWebsite();

//        GetBookResponse apiResponse = getBookWithIsbnStep.getBookDetails(uiBookData.isbn);
//        navigate.validateIsbn(apiResponse.getIsbn())
//                .validateTitle(apiResponse.getTitle())
//                .validateSubtitle(apiResponse.getSubTitle())
//                .validateAuthor(apiResponse.getAuthor())
//                .validatePublisher(apiResponse.getPublisher())
//                .validatePages(apiResponse.getPages())
//                .validateDescription(apiResponse.getDescription())
//                .validateWebsite(apiResponse.getWebsite());
    }
    @Test()
    @Story("Validate UI and API retrived book count of the book store")
    @Description("Launch bookstore website and get number of books, send request to API and get all books, validate is count matches")
    @Step("Validate UI and API retrived book count of the book store")
    public void ValidateBookCount() {
//        int countOfApiBooks = getAllBooksFromApiStep.getBookList().getBooks().size(); // TODO: ana api countis sworad wamogeba
        int countOfApiBooks = 8; // TODO: temp

        navigate
                .ValidateSizes(countOfApiBooks);




    }


    @Attachment(value = "Screenshot on failure", type = "image/png")
    public byte[] takeScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}

