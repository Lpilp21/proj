package Frontend.Pages;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class BooksPage {
    ArrayList<SelenideElement> books = new ArrayList<>();
    public SelenideElement firstBook = $(".rt-tbody div:first-child .action-buttons");
    public ElementsCollection allBooks = $$(".rt-tbody .rt-tr-group");


}
