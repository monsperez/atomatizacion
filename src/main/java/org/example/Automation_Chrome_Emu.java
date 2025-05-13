package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Automation_Chrome_Emu {
    public static AppiumDriver driver;
    public static DesiredCapabilities cap;
    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("deviceName", "emulator-5554");
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("appPackage", "com.android.chrome");
        cap.setCapability("appActivity", "com.google.android.apps.chrome.IntentDispatcher");
        cap.setCapability("noReset", true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), cap);

        Thread.sleep(3000);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Chrome\"]")).click();
        Thread.sleep(5000);
        driver.findElement(AppiumBy.id("com.android.chrome:id/search_box_text")).click();
        Thread.sleep(3000);
        driver.findElement(AppiumBy.id("com.android.chrome:id/url_bar")).sendKeys("Carros deportivos");
        Thread.sleep(3000);
        driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"com.android.chrome:id/omnibox_results_container\"]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.LinearLayout")).click();
        Thread.sleep(15000);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Mostrar más\"]")).click();
        Thread.sleep(3000);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Imágenes\"]")).click();
        Thread.sleep(3000);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Estos son los 10 coches deportivos más rápidos del mundo | GQ\"]")).click();
        Thread.sleep(15000);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Estos son los 10 coches deportivos más rápidos del mundo | GQ\"]")).click();

    }
  }
