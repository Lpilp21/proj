package Frontend.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;


public class MainPage {
    public SelenideElement bookStore = $(".category-cards div:nth-child(5)");


}