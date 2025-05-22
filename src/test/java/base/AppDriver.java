package base;

import io.appium.java_client.AppiumDriver;

public class AppDriver {
    private static AppiumDriver driver;

    public static AppiumDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("AppiumDriver not initialized. Call setDriver() first.");
        }
        return driver;
    }

    public static void setDriver(AppiumDriver driver){
        AppDriver.driver = driver;
        System.out.println("Driver is set");
    }
}
