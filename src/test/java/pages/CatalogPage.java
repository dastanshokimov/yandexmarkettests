package pages;

import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

import static driver.EmulatorHelper.androidScrollToAnElementByText;
import static driver.EmulatorHelper.customScroll;

import com.codeborne.selenide.SelenideElement;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

public class CatalogPage extends SearchPage {
    private final SelenideElement navCatalog =
            $(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Каталог\"]"));
    public SelenideElement getCategoryByName(String category) {
        return $(AppiumBy.xpath("//android.widget.TextView[@text=\""+category+"\"]"));
    }

    @Step("Перейти в каталог")
    public CatalogPage goToCatalog() {
        clickElement(navCatalog);
        return this;
    }

    @Step("Проверка, что кнопка меню 'Каталог' выделена")
    public void isNavCatalogSelected() {
        navCatalog.shouldBe(selected);
    }

    @Step("Перейти в раздел 'Книги'")
    public void goToBooksSection() {
        androidScrollToAnElementByText("Книги");
    }
}
