package test;

import Backend.Models.ResponseModel.GetBookResponse;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Step;
import io.qameta.allure.Attachment;
import Frontend.Steps.*;
import Frontend.Data.*;
import Backend.Steps.*;

import static Frontend.Data.BookData.WEB_URL;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Configuration.*;


@Epic("Bookstore Application")
@Feature("Main Page")

public class BookStoreApiTest {
    private GetFirstBookStep navigate;
    public BookData uiBookData;
    public GetBookWithIsbnStep getBookWithIsbnStep;
    public GetAllBooksFromApiStep getAllBooksFromApiStep;
    public GetAllBooksStep getAllBooksStep;

    @BeforeClass
    public void setUp() {
        open(WEB_URL);
        browser="chrome";
        holdBrowserOpen = true;
        timeout = 90000;
        screenshots = true;
        savePageSource = false;
        browserSize = "1920x1080";
//        ChromeOptions option = new ChromeOptions();
//        option.addArguments("--remote-allow-origins=*");
        //Configuration.browserCapabilities = new ChromeOptions().addArguments("start-maximized");
        navigate = new GetFirstBookStep();
        getBookWithIsbnStep = new GetBookWithIsbnStep();
        getAllBooksFromApiStep = new GetAllBooksFromApiStep();

    }

    @Test()
    @Story("Validate UI and API retrived data for first book of the book store")
    @Description("Launch bookstore website and get first book details, send request to API and get details for first book, validate results")
    @Step("Validate UI and API retrived data for first book of the book store")
    public void validateBookDetails() {
        navigate.clickBookStore()
                .clickFirstBook()
                .getBookIsbn()
                .getBookTitle()
                .getBookSubtitle()
                .getBookAuthor()
                .getBookPublisher()
                .getBookPages()
                .getBookDescription()
                .getBookWebsite();
        uiBookData = navigate.bookData;
        GetBookResponse apiResponse = getBookWithIsbnStep.getBookDetails(uiBookData.isbn);
        navigate.validateIsbn(apiResponse.getIsbn())
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
        int countOfApiBooks = getAllBooksFromApiStep.getBookList().getBooks().size();
        int countOfUiBooks = getAllBooksStep.getAllBooks().filterEmptyOnes().getBookCount().bookCount;
        Assert.assertEquals(countOfApiBooks, countOfUiBooks);

    }


//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

    @Attachment(value = "Screenshot on failure", type = "image/png")
    public byte[] takeScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}

