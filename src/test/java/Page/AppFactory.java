package Page;

import base.AppDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class AppFactory {
    public static AndroidDriver driver;

    @BeforeTest
    public static void Android_LaunchApp() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("deviceName", "ZY22J8LTK5");
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("appPackage", "org.telegram.messenger");
        cap.setCapability("appActivity", "org.telegram.ui.LaunchActivity");
        cap.setCapability("noReset", true); // 👉 Esto evita reinstalar la app

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), cap);
        System.out.println("Android driver is set");

    }

}


