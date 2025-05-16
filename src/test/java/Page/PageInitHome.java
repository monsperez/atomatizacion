package Page;

import base.Common;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;

import java.time.Duration;

public class PageInitHome extends Common {
    private AppiumDriver driver;
    private static final Logger log = LoggerFactory.getLogger(PageInitHome.class);


    @AndroidFindBy(accessibility = "wdio demo app")
    public WebElement open_app;
    @AndroidFindBy(accessibility = "Login")
    public WebElement loginApp;
    @AndroidFindBy(accessibility = "input-email")
    public WebElement areaTextEmail;
    @AndroidFindBy(accessibility = "input-password")
    public WebElement areaTextPass;

    public PageInitHome(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(20)), this);
    }

    public void openApp() throws InterruptedException {
        tapElement(open_app);
    }

    public void tapInLogin(String message) throws InterruptedException {
        if (returnIfElementIsDisplayed(loginApp,5)) {
            tapElement(loginApp);
            Reporter.log(message + ": SUCCESS", true);
            staticWait(5);
        } else {
            Reporter.log("Button Login not available", true);
        }
    }
    public void addTextEmail(String email, String message) throws InterruptedException {
        if(returnIfElementIsDisplayed(areaTextEmail,5)){
            areaTextEmail.click();
            areaTextEmail.sendKeys(email); // Example
            Reporter.log(message, true);
            staticWait(5);
        }else{
            Reporter.log("Area for text Email not available", true);
        }
    }
    public void addTextPass(String pass, String message) throws InterruptedException {
        if(returnIfElementIsDisplayed(areaTextPass,5)){
            areaTextPass.click();
            areaTextPass.sendKeys(pass); // Example
            Reporter.log(message, true);
            staticWait(5);
        }
    }
}
