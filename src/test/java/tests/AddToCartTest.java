package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.qameta.allure.Description;
import pages.AuthorizationPage;
import pages.CartPage;
import pages.CatalogPage;
import pages.ListingPage;
import pages.MainPage;

public class AddToCartTest extends BaseTest {
    private static AuthorizationPage authorizationPage;
    private static MainPage mainPage;
    private static CatalogPage catalogPage;
    private static ListingPage listingPage;
    private static CartPage cartPage;

    @BeforeAll
    public static void init() {
        authorizationPage = new AuthorizationPage();
        mainPage = new MainPage();
        catalogPage = new CatalogPage();
        listingPage = new ListingPage();
        cartPage = new CartPage();
    }

    @Description("Добавление в корзину любого товара из раздела “Книги")
    @Test
    public void addProductToCartTest() {
        authorizationPage.exitAuthorizationPage();
        mainPage.checkPromosAndInitialSetup();
        mainPage.isNavMainSelected();
        catalogPage.goToCatalog();
        catalogPage.isNavCatalogSelected();
        catalogPage.goToBooksSection();
        listingPage.getFirstSuggestedProductName();
        listingPage.addFirstProductToCart();
        cartPage.checkBadgeAfterAddingProductToCart();
        cartPage.goToCart();
        cartPage.isNavCartSelected();
        cartPage.isProductNameVisibleAndEqualToChosenProductName();
    }

    @Description("Добавление и удаление товара из раздела “Книги")
    @Test
    public void deleteProductFromCartTest() {
        authorizationPage.exitAuthorizationPage();
        mainPage.checkPromosAndInitialSetup();
        mainPage.isNavMainSelected();
        catalogPage.goToCatalog();
        catalogPage.isNavCatalogSelected();
        catalogPage.goToBooksSection();
        listingPage.getFirstSuggestedProductName();
        listingPage.addFirstProductToCart();
        cartPage.checkBadgeAfterAddingProductToCart();
        cartPage.goToCart();
        cartPage.isNavCartSelected();
        cartPage.isProductNameVisibleAndEqualToChosenProductName();
        cartPage.deleteProduct();
        cartPage.isCartEmpty();
    }
}


