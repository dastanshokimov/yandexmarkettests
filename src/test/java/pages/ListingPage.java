package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static driver.EmulatorHelper.customScroll;

import com.codeborne.selenide.SelenideElement;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

public class ListingPage extends SearchPage {
    private static final SelenideElement addFirstProductToCartButton =
            $(AppiumBy.xpath("(//androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"ru.beru.android:id/cartButtonProgressButtonLayout\"])[1]"));
    private static final String firstProductNameText =
            "(//android.widget.LinearLayout[@resource-id=\"ru.beru.android:id/descriptionBlock\"])[1]//android.widget.Button";
    public static String firstSuggestedProductName;

    @Step("Добавить первый предложенный товар в корзину по кнопке 'В корзину'")
    public ListingPage addFirstProductToCart() {
        clickElement(addFirstProductToCartButton);
//        androidScrollTo(xp);
        return this;
    }

    @Step("Получить название первого товара")
    public void getFirstSuggestedProductName() {
        sleep(3000);
        customScroll(10);
        firstSuggestedProductName = $(AppiumBy.xpath(firstProductNameText)).getText();
        System.out.println("Первый товар в листинге: " + firstSuggestedProductName);
    }
}
