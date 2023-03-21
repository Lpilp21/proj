package Frontend.Pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;


public class BookPage {
    public SelenideElement isbn = $("#ISBN-wrapper div:nth-child(2) label");
    public SelenideElement title = $("#title-wrapper div:nth-child(2) label");
    public SelenideElement subtitle = $("#subtitle-wrapper div:nth-child(2) label");
    public SelenideElement author = $("#author-wrapper div:nth-child(2) label");
    public SelenideElement publisher = $("#publisher-wrapper div:nth-child(2) label");
    public SelenideElement pages = $("#pages-wrapper div:nth-child(2) label");
    public SelenideElement description = $("#description-wrapper div:nth-child(2) label");
    public SelenideElement website = $("#website-wrapper div:nth-child(2) label");




}