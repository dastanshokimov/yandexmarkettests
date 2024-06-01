package pages;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

import org.openqa.selenium.JavascriptExecutor;

import java.io.File;
import java.time.Duration;

import io.appium.java_client.AppiumBy;

public class BasePage {

    public File fullPageScreenshot() {
        return $(AppiumBy.id("")).screenshot();
    }

    public void clickElement(SelenideElement element) {
        element.shouldBe(visible, Duration.ofSeconds(10)).scrollTo().click();
    }

    public void shouldBeVisible(SelenideElement element, int seconds) {
        element.shouldBe(visible, Duration.ofSeconds(seconds));
    }

    public void typeText(SelenideElement element, String text) {
        element.press(text);
    }
}
