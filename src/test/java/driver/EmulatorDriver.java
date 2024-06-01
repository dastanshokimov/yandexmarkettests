package driver;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.codeborne.selenide.WebDriverProvider;
import com.codeborne.selenide.WebDriverRunner;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nonnull;

import config.ConfigReader;
import helper.ApkInfoHelper;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class EmulatorDriver implements WebDriverProvider {

    protected static AndroidDriver driver;
    private static final String DEVICE_NAME = ConfigReader.emulatorConfig.deviceName();
    private static final String PLATFORM_NAME = ConfigReader.emulatorConfig.platformName();
    private static final String AUTOMATION_NAME = ConfigReader.emulatorConfig.automationName();

    private static String APP_PACKAGE = ConfigReader.emulatorConfig.appPackage();
    private static String APP_ACTIVITY = ConfigReader.emulatorConfig.appActivity();
    private static final String APP = ConfigReader.emulatorConfig.app();
    private static final String URL = ConfigReader.emulatorConfig.remoteUrl();

    public static URL getUrl() {
        try {
            return new URL(URL);
        } catch (MalformedURLException e) {
            throw new RuntimeException();
        }
    }

    private void initPackageActivity() {
        ApkInfoHelper helper = new ApkInfoHelper();
        APP_PACKAGE = APP_PACKAGE.isEmpty() ? helper.getAppPackageFromApk() : APP_PACKAGE;
        APP_ACTIVITY = APP_ACTIVITY.isEmpty() ? helper.getAppMainActivity() : APP_ACTIVITY;
    }

    private String getAbsolutePath(String filepath) {
        File file = new File(filepath);
        assertTrue(file.exists(), filepath + " not found");
        return file.getAbsolutePath();
    }

    /**
     * Создает appium сессию AndroidDriver
     * @param capabilities настройки для создания сесии
     * @return сессия AndroidDriver
     */

    @Nonnull
    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        initPackageActivity();
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities(capabilities);

        desiredCapabilities.setCapability("appium:autoGrantPermissions",true);
        desiredCapabilities.setCapability("appium:deviceName", DEVICE_NAME);
        desiredCapabilities.setCapability("platformName", PLATFORM_NAME);
        desiredCapabilities.setCapability("appium:appPackage", APP_PACKAGE);
        desiredCapabilities.setCapability("appActivity", APP_ACTIVITY);
        desiredCapabilities.setCapability("appium:app", getAbsolutePath(APP));
        desiredCapabilities.setCapability("appium:automationName", AUTOMATION_NAME);
        desiredCapabilities.merge(new DesiredCapabilities(capabilities));

//        System.out.println("Appium URL: " + getUrl()); // Log the URL to verify
//        System.out.println("Capabilities: " + desiredCapabilities); // Log capabilities

        driver = new AndroidDriver(getUrl(), desiredCapabilities);
//        WebDriverRunner.setWebDriver(driver);
        return driver;
    }
}
