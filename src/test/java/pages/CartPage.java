package pages;

import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

public class CartPage extends BasePage {
    private final SelenideElement navCart =
            $(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Корзина\"]"));
    private final SelenideElement oneProductInCartBadge =
            $(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"ru.beru.android:id/badge\" and @text=\"1\"]"));
    private final SelenideElement firstProductNameInCart =
            $(AppiumBy.xpath("//android.widget.GridView[@resource-id=\"ru.beru.android:id/flexsdk_recycler_view_id\"]" +
                    "/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup" +
                    "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView"));

    private final SelenideElement deleteProduct =
            $(AppiumBy.xpath("//android.widget.GridView[@resource-id=\"ru.beru.android:id/flexsdk_recycler_view_id\"]" +
                    "/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup" +
                    "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.ImageView[2]"));

    private final SelenideElement emptyCart =
            $(AppiumBy.xpath("//android.widget.TextView[@text=\"Корзина пустая\"]"));

    @Step("Проверка отображения значка количества добавленных товаров в корзину")
    public CartPage goToCart() {
        clickElement(navCart);
        return this;
    }

    @Step("Проверка отображения значка количества добавленных товаров в корзину")
    public void checkBadgeAfterAddingProductToCart() {
        shouldBeVisible(oneProductInCartBadge, 10);
    }

    @Step("Проверка, что кнопка меню 'Корзина' выделена")
    public void isNavCartSelected() {
        navCart.shouldBe(selected);
    }

    @Step("Проверка, что выбранный товар отображается в корзине")
    public CartPage isProductNameVisibleAndEqualToChosenProductName() {
        shouldBeVisible(firstProductNameInCart, 10);
        firstProductNameInCart.getText().equals(ListingPage.firstSuggestedProductName);
        return this;
    }

    @Step("Удаление товара из корзины")
    public CartPage deleteProduct() {
        clickElement(deleteProduct);
        return this;
    }

    @Step("Проверка, что корзина пуста")
    public CartPage isCartEmpty() {
        shouldBeVisible(emptyCart, 10);
        return this;
    }
}
