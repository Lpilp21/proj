package Frontend.Steps;

import Frontend.Data.BookData;
import Frontend.Pages.BooksPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;

public class GetAllBooksStep {
    private BooksPage booksPage;
    public BookData bookData = new BookData();
    public ElementsCollection books;
    public int bookCount;


    public GetAllBooksStep(WebDriver driver) {
        booksPage = new BooksPage();

    }

    @Step("get collection of book divs")
    public GetAllBooksStep getAllBooks() {
        books = booksPage.allBooks;
        return this;
    }

    @Step("filter divs to eliminate empty ones")
    public GetAllBooksStep filterEmptyOnes() {
        books = books.filterBy(Condition.cssClass("rt-tr-even"))
                .filterBy(Condition.cssClass("rt-td"))
                .filterBy(Condition.text("expectedText"));
        return this;
    }

    @Step("launch book store")
    public GetAllBooksStep getBookCount() {
        bookCount = books.size();
        return this;
    }



}

