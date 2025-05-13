package test;

import Page.AppFactory;
import Page.PageInitHome;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

public class Main {

    public static void main(String[] args) throws Exception {
        AppFactory appFactory = new AppFactory();
        appFactory.Android_LaunchApp();

        PageInitHome openAppHome = new PageInitHome(AppFactory.driver);
        openAppHome.tapOnElement();
    }
}
