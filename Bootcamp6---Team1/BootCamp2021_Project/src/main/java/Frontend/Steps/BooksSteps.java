package Frontend.Steps;

import Frontend.Pages.BooksPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import org.testng.Assert;

public class BooksSteps {
    private BooksPage booksPage;
    public ElementsCollection books;
    public int bookCount;
    private int UIBooksSize;



    public BooksSteps() {
        booksPage = new BooksPage();

    }
    @Step("choose first book and go to details")
    public BooksSteps clickFirstBook(){
        booksPage.firstBook.shouldBe(Condition.visible).click();
        return this;
    }

    @Step("get collection of book divs")
    public BooksSteps getAllBooks() {
        books = booksPage.allBooks;
        return this;
    }

    @Step("get book count in store")
    public BooksSteps getBookCount() {
        bookCount = books.size();
        return this;
    }
    @Step("compare book sizes")
    public BooksSteps ValidateSizes(int ApiBooksSize) {
        UIBooksSize = booksPage.allBooks.size();
        Assert.assertEquals(UIBooksSize, ApiBooksSize);
        return this;
    }



}

