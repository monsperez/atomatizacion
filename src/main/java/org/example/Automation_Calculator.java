package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ThreadLocalRandom;

import static java.time.Duration.ofSeconds;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Automation_Calculator {
    public static AppiumDriver driver;
    public static DesiredCapabilities cap;
    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("deviceName", "Moto Edge");
        cap.setCapability("udid", "ZY22J8LTK5");
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("appPackage", "com.google.android.calculator");
        cap.setCapability("appActivity", "com.android.calculator2.Calculator");
        cap.setCapability("noReset", true);


        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), cap);

        Thread.sleep(5000);

        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_9")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_mul")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_1")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_0")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/eq")).click();
        Thread.sleep(3000);
        String result = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
        System.out.println("Result: " + result); //MUESTRA EN CONSOLA


        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"5\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"más\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"4\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"9\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"igual a\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"borrar\"]")).click();

        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"9\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"división\"]")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_2")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"igual a\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"borrar\"]")).click();

        driver.findElement(AppiumBy.id("com.google.android.calculator:id/formula")).sendKeys("H ");//MUESTRA MENSAJE
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/formula")).sendKeys("O ");
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/formula")).sendKeys("L ");
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/formula")).sendKeys("A ");

        String num1 = String.valueOf(ThreadLocalRandom.current().nextInt(100, 301)); // permite colocar numeros aleatorios desde el 100 al 301
        int num2 = ThreadLocalRandom.current().nextInt(100, 301);


        // Ingresar el primer número
        for (char c : String.valueOf(num1).toCharArray()) {
            driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_" + c)).click();
        }

        // Presionar +
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_add")).click();

        // Ingresar el segundo número
        for (char c : String.valueOf(num2).toCharArray()) {
            driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_" + c)).click();



        }

        // Presionar =
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/eq")).click();

        //driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"borrar\"]")).click();// BORRA EL RESULTADO

        // Presionar =





       // driver.findElement(AppiumBy.id("com.google.android.calculator:id/formula")).sendKeys("Texto que quieres escribir");
        /*driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Contacts tab.']")).click();
        Thread.sleep(500);
        List<MobileElement> contacts = driver.findElements(By.id("com.google.android.dialer:id/contact_name"));
        contacts.get(0).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.EditText[@text='First name']")).sendKeys("Welcome");
        driver.findElement(By.id("com.android.contacts:id/editor_menu_save_button")).click();*/

        Thread.sleep(2000);

        //Util.scrollTo("$7.99");

        Thread.sleep(2000);

        driver.quit();
    }
  }