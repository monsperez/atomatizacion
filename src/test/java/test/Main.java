package test;

import base.AppDriver;
import base.AppFactory;
import Page.PageInitHome;
import base.Common;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Main extends AppFactory{

    public static void main(String[] args) throws Exception {
        Android_LaunchApp(); // Primero se lanza la app
        PageInitHome pageInitHome = new PageInitHome((AndroidDriver) driver);

        pageInitHome.tapInLogin("Click on button login");




    }
}
