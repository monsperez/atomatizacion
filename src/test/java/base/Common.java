package base;

import org.junit.platform.commons.logging.LoggerFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Common {
    private static final Logger log = (Logger) LoggerFactory.getLogger(Common.class);
    public void tapElement(WebElement element) {
        try {
            if (element.isDisplayed()) {
                Reporter.log("Element is displayed");
                element.click();
            } else {
                Reporter.log("Element not displayed");
            }
        } catch (Exception error) {
            Reporter.log("Click not found");
        }
    }

    public boolean validateText(WebElement element, String text) {
        try {
            String compare = element.getText();
            if (compare.equals(text)) {
                Reporter.log("Element is equal: ");
            } else {
                Reporter.log("Element in not equal: ");
            }
        } catch (Exception error) {
            Reporter.log("Text was not found");
            return true;
        }
        return false;
    }
    public WebDriverWait createWait(int timeToWait){
        Duration duration = Duration.ofSeconds((long) timeToWait);;
        return new WebDriverWait(AppDriver.getDriver(), duration);
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
}
