# yandexmarkettests
Test Assignment for dats.team. Position: Automation QA Specialist

E2E tests that implement the folowing scenarios: 
 - Adding a product from "Books" section of the catalog
 - Adding then deleting the same product from the cart

## What do you need to run tests in this project:
 - **appium** installed (if not, see: https://appium.io/docs/en/latest/quickstart/install/)
 - **appium-uiautomator2-driver** installed (if not, see: https://github.com/appium/appium-uiautomator2-driver)
 - make sure that **ANDROID_HOME**, **tools**, **platform-tools**, and **build-tools** are exported
 - **Android Studio** installed (if not, see: https://developer.android.com/studio)
 - before running the tests:
     - make sure that appium is started (check URL, usually it is http://127.0.0.1:4723/ if not, update emulator.properties)
     - make sure that Android device is started (usually it is Pixel 3a API 34, if not update emulator.properties)
- **./gradlew** test to run the tests using terminal, or manually using Android Studio
