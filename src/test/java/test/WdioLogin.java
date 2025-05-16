package test;


import Page.PageInitHome;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Test;
import static base.AppFactory.Android_LaunchApp;
import static base.AppFactory.driver;


public class WdioLogin {
    @Test()
    void loginWdio() throws Exception {
        Android_LaunchApp(); // Primero se lanza la app
        PageInitHome pageInitHome = new PageInitHome((AndroidDriver) driver);
        pageInitHome.tapInLogin("Click on button login");


    }
}
