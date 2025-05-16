package test;


import Page.PageInitHome;
import io.appium.java_client.android.AndroidDriver;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static base.AppFactory.Android_LaunchApp;
import static base.AppFactory.driver;


public class WdioLoginWithOutPass {
    @Test()
    void loginWdio() throws Exception {
        // Validate error without add password
        Android_LaunchApp(); // Primero se lanza la app



    }
}
