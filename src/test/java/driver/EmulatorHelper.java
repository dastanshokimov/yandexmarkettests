package driver;

import com.codeborne.selenide.SelenideElement;

import org.openqa.selenium.Dimension;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class EmulatorHelper extends EmulatorDriver {
    /**
     * Нажимает кнопку назад
     */
    public static void goBack(){
        driver.navigate().back();
    }

    /**
     * Листает к элементу по его тексту
     * @param text текст на элементе
     */
    public static void androidScrollToAnElementByText(String text){
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)" +
                        ".instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))"))
                .click();
    }

    public static void androidScrollTo(String text){
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)" +
                        ".instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))"));
    }

    public static void scrollDown() {
        // Perform a scroll action
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))"
                        + ".scrollForward();"));
    }

    public static void customScroll(int divideHeightTo) {
        // Get the size of the scrollable view
        Dimension size = driver.manage().window().getSize();
        int height = size.getHeight();

        // Calculate the scroll distance (approximately half the height)
        int scrollDistance = height / divideHeightTo;

        // Perform the scroll action
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))"
                        + ".scrollForward("+scrollDistance+");"));
    }

    /**
     * Закрывает клавиатуру если она есть
     */
    public static void closeKeyBoard(){
        if(driver.isKeyboardShown()){
            driver.hideKeyboard();
        }
    }

    /**
     * Вводит текст и нажимает Enter
     * @param element поле для ввода
     * @param text текст
     */
    public static void sendKeysAndFind(SelenideElement element, String text){
        element.sendKeys(text);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
}
