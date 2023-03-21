package Frontend.Steps;

import Frontend.Data.BookData;
import Frontend.Pages.BookDetailsPage;
import io.qameta.allure.Step;
import org.testng.Assert;

public class BookDetailsSteps {
    private BookDetailsPage bookPage;


    public BookDetailsSteps() {
        bookPage = new BookDetailsPage();
    }

    @Step("get ISBN of first book")
    public BookDetailsSteps getBookIsbn(){
        BookData.isbn = bookPage.isbn.getText();
        return this;
    }
    @Step("get title of first book")
    public BookDetailsSteps getBookTitle(){
        BookData.title = bookPage.title.getText();
        return this;
    }
    @Step("get subtitle of first book")
    public BookDetailsSteps getBookSubtitle(){
        BookData.subtitle = bookPage.subtitle.getText();
        return this;
    }
    @Step("get author of first book")
    public BookDetailsSteps getBookAuthor(){
        BookData.author = bookPage.author.getText();
        return this;
    }
    @Step("get publisher of first book")
    public BookDetailsSteps getBookPublisher(){
        BookData.publisher = bookPage.publisher.getText();
        return this;
    }
    @Step("get page number of first book")
    public BookDetailsSteps getBookPages(){
        BookData.pages = Integer.parseInt(bookPage.pages.getText());
        return this;
    }
    @Step("get description of first book")
    public BookDetailsSteps getBookDescription(){
        BookData.description = bookPage.description.getText();
        return this;
    }
    @Step("get website of first book")
    public BookDetailsSteps getBookWebsite(){
        BookData.website = bookPage.website.getText();
        return this;
    }
    @Step("Validate ISBN value")
    public BookDetailsSteps validateIsbn(String apiIsbn) {
        Assert.assertEquals(apiIsbn, BookData.isbn);
        return this;
    }

    @Step("Validate Title value")
    public BookDetailsSteps validateTitle(String apiTitle) {
        Assert.assertEquals(apiTitle, BookData.title);
        return this;
    }

    @Step("Validate Subtitle value")
    public BookDetailsSteps validateSubtitle(String apiSubtitle) {
        Assert.assertEquals(apiSubtitle, BookData.subtitle);
        return this;
    }

    @Step("Validate Author value")
    public BookDetailsSteps validateAuthor(String apiAuthor) {
        Assert.assertEquals(apiAuthor, BookData.author);
        return this;
    }

    @Step("Validate Publisher value")
    public BookDetailsSteps validatePublisher(String apiPublisher) {
        Assert.assertEquals(apiPublisher, BookData.publisher);
        return this;
    }

    @Step("Validate Pages value")
    public BookDetailsSteps validatePages(int apiPages) {
        Assert.assertEquals(apiPages, BookData.pages);
        return this;
    }

    @Step("Validate Description value")
    public BookDetailsSteps validateDescription(String apiDescription) {
        Assert.assertEquals(apiDescription, BookData.description);
        return this;
    }

    @Step("Validate Website value")
    public BookDetailsSteps validateWebsite(String apiWebsite) {
        Assert.assertEquals(apiWebsite, BookData.website);
        return this;
    }


}
