package Frontend.Steps;

import Frontend.Data.BookData;
import Frontend.Pages.BookPage;
import Frontend.Pages.BooksPage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import Frontend.Pages.MainPage;
import org.testng.Assert;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class GetFirstBookStep {
    private MainPage mainPage;
    private BooksPage booksPage;
    private BookPage bookPage;
    public BookData bookData = new BookData();

    private int UIBooksSize;


    public GetFirstBookStep() {
        mainPage = new MainPage();
        booksPage = new BooksPage();
        bookPage = new BookPage();


    }
    @Step("choose first book and go to details")

    public GetFirstBookStep clickFirstBook(){
        booksPage.firstBook.shouldBe(Condition.visible).click();
        return this;
    }
    @Step("get ISBN of first book")
    public GetFirstBookStep getBookIsbn(){
        bookData.isbn = bookPage.isbn.getText();
        System.out.println(bookPage.isbn.getText());
        return this;
    }
    @Step("get title of first book")
    public GetFirstBookStep getBookTitle(){
        bookData.title = bookPage.title.getText();
        System.out.println(bookPage.title.getText());
        return this;
    }
    @Step("get subtitle of first book")
    public GetFirstBookStep getBookSubtitle(){
        bookData.subtitle = bookPage.subtitle.getText();
        System.out.println(bookPage.subtitle.getText());
        return this;
    }
    @Step("get author of first book")
    public GetFirstBookStep getBookAuthor(){
        bookData.author = bookPage.author.getText();
        System.out.println(bookPage.author.getText());
        return this;
    }
    @Step("get publisher of first book")
    public GetFirstBookStep getBookPublisher(){
        bookData.publisher = bookPage.publisher.getText();
        System.out.println(bookPage.publisher.getText());
        return this;
    }
    @Step("get page number of first book")
    public GetFirstBookStep getBookPages(){
        bookData.pages = Integer.parseInt(bookPage.pages.getText());
        System.out.println(bookPage.pages.getText());
        return this;
    }
    @Step("get description of first book")
    public GetFirstBookStep getBookDescription(){
        bookData.description = bookPage.description.getText();
        System.out.println(bookPage.description.getText());
        return this;
    }
    @Step("get website of first book")
    public GetFirstBookStep getBookWebsite(){
        bookData.website = bookPage.website.getText();
        System.out.println(bookPage.website.getText());
        return this;
    }
    @Step("Validate ISBN value: {0}")
    public GetFirstBookStep validateIsbn(String apiIsbn) {
        Assert.assertEquals(apiIsbn, BookData.isbn);
        return this;
    }

    @Step("Validate Title value: {0}")
    public GetFirstBookStep validateTitle(String apiTitle) {
        Assert.assertEquals(apiTitle, BookData.title);
        return this;
    }

    @Step("Validate Subtitle value: {0}")
    public GetFirstBookStep validateSubtitle(String apiSubtitle) {
        Assert.assertEquals(apiSubtitle, BookData.subtitle);
        return this;
    }

    @Step("Validate Author value: {0}")
    public GetFirstBookStep validateAuthor(String apiAuthor) {
        Assert.assertEquals(apiAuthor, BookData.author);
        return this;
    }

    @Step("Validate Publisher value: {0}")
    public GetFirstBookStep validatePublisher(String apiPublisher) {
        Assert.assertEquals(apiPublisher, BookData.publisher);
        return this;
    }

    @Step("Validate Pages value: {0}")
    public GetFirstBookStep validatePages(int apiPages) {
        Assert.assertEquals(apiPages, BookData.pages);
        return this;
    }

    @Step("Validate Description value: {0}")
    public GetFirstBookStep validateDescription(String apiDescription) {
        Assert.assertEquals(apiDescription, BookData.description);
        return this;
    }

    @Step("Validate Website value: {0}")
    public GetFirstBookStep validateWebsite(String apiWebsite) {
        Assert.assertEquals(apiWebsite, BookData.website);
        return this;
    }

    @Step("compare book sizes")
    public GetFirstBookStep ValidateSizes(int ApiBooksSize) {
        UIBooksSize = booksPage.allBooks.size();
        Assert.assertEquals(UIBooksSize, ApiBooksSize);
        return this;
    }
}
