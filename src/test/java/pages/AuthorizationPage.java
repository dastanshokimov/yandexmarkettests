package pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

public class AuthorizationPage extends BasePage {
//    private final SelenideElement loginOrEmailInput = $(AppiumBy.id(""));
//    private final SelenideElement signInButton = $(AppiumBy.id(""));
//    private final SelenideElement createIdButton = $(AppiumBy.id(""));
    private final SelenideElement exitButton = $(AppiumBy.xpath("//android.view.View[@content-desc='Назад']"));

    @Step("Закрыть окно авторизации для выбора Яндекс аккаунта")
    public void exitAuthorizationPage() {
        clickElement(exitButton);
    }

    @Step("Заполнить логин или email")
    public AuthorizationPage typeLogin() {
        /*
        Логика для логина
         */
        return this;
    }
}
