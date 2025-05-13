package Page;

import base.AppDriver;
import base.Common;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class PageInitHome {
    final Common common = new Common();
    final AppDriver driver = new AppDriver();
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Telegram\"]")
    public WebElement open_app;

    public PageInitHome(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver,Duration.ofSeconds(20)), this);
    }

    public void tapOnElement() throws InterruptedException {
        common.tapElement(open_app);
    }
    public Boolean validateInitSession() throws InterruptedException {
        Assert.assertTrue(common.validateText(open_app,"Page Principal"));

        return true;
    }


}
