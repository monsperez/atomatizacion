package base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Common {
    private static final Logger log = LoggerFactory.getLogger(Common.class);
    public void tapElement(WebElement element) {
        try {
            if (element.isDisplayed()) {
                Reporter.log("Element is displayed", true);
                element.click();
            } else {
                Reporter.log("Element not displayed", true);
            }
        } catch (Exception error) {
            Reporter.log("Click not found: " + error.getMessage(), true);
            log.error("Error while clicking element", error);
        }
    }

    public boolean validateText(WebElement element, String text) {
        try {
            String compare = element.getText();
            if (compare.equals(text)) {
                Reporter.log("Text matched: " + compare, true);
                return true;
            } else {
                Reporter.log("Text not matched. Found: " + compare + " | Expected: " + text, true);
            }
        } catch (Exception error) {
            Reporter.log("Text was not found: " + error.getMessage(), true);
            log.error("Error validating text", error);
        }
        return false;
    }

    public WebDriverWait createWait(int timeToWait) {
        return new WebDriverWait(AppDriver.getDriver(), Duration.ofSeconds(timeToWait));
    }

    public void staticWait (long secund){
        try{
            TimeUnit.SECONDS.sleep(secund);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }
    public boolean returnIfElementIsDisplayed(WebElement element, int time){
        boolean visible = false;
        try{
            this.createWait(time).until(ExpectedConditions.visibilityOf(element));
            visible = true;
            log.info("Element displayed: "+ element);
        } catch (Exception error) {
            log.info("Element not displayed: "+ element);
        }
        return visible;
    }
    public void closeApp(AppiumDriver driver, String appPackage){
        staticWait(5);
        ((InteractsWithApps)driver).terminateApp(appPackage);
        Reporter.log("Close App SUCCESS",true);
    }
}
