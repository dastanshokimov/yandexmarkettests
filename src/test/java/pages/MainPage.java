package pages;

import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

public class MainPage extends SearchPage {
    private final SelenideElement freeDeliveryPromo =
            $(AppiumBy.xpath("//android.view.ViewGroup[@resource-id='ru.beru.android:id/content']"));
    private final SelenideElement freeDeliveryPromoCloseButton =
            $(AppiumBy.xpath("//android.widget.ImageButton[@resource-id='ru.beru.android:id/closeButton']"));
    private final SelenideElement freeDeliveryPromoAnotherCity =
            $(AppiumBy.xpath("//android.widget.Button[@resource-id='ru.beru.android:id/bottomButton']"));
    private final SelenideElement regionChooseInput =
            $(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"ru.beru.android:id/modernInputInputEditText\"]"));
    private final SelenideElement firstCitySuggestion =
            $(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"ru.beru.android:id/region_name\" and @text=\"Moscow\"]"));
    private final SelenideElement remindLaterButton =
            $(AppiumBy.xpath("//android.widget.Button[@resource-id=\"ru.beru.android:id/bottomButton\"]"));
    private final SelenideElement skipCookieButton =
            $(AppiumBy.xpath("//android.widget.Button[@resource-id=\"ru.beru.android:id/negativeButton\"]"));
    private final SelenideElement navMain =
            $(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Главная\"]"));

    @Step("Проверка отображения всех промо, их закрытие и внесение начальных данных")
    public void checkPromosAndInitialSetup() {
        shouldBeVisible(freeDeliveryPromo, 10);
        clickElement(freeDeliveryPromoAnotherCity);
        typeText(regionChooseInput, "Moscow");
        clickElement(firstCitySuggestion);
        clickElement(remindLaterButton);
        clickElement(skipCookieButton);
    }

    @Step("Проверка, что кнопка меню 'Главная' выделена")
    public void isNavMainSelected() {
        navMain.shouldBe(selected);
    }
}
