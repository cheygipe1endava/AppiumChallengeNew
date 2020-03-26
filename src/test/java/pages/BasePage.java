package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.touch.WaitOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage {

    private AppiumDriver<MobileElement> appiumDriver;
    private WebDriverWait wait;
    private boolean verifyStatus;

    public BasePage(AppiumDriver<MobileElement> appiumDriver)
    {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(appiumDriver,this);
        wait = new WebDriverWait(appiumDriver, Long.parseLong("15"));
    }

    public void clickAndSendData(By by, String data)
    {
        WebElement element = appiumDriver.findElement(by);
        element.click();
        element.sendKeys(data);
    }

    public void waitAndClick(By by)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        appiumDriver.findElement(by).click();
    }

    public boolean lowerCaseValidations(By by, String text)
    {
        verifyStatus = false;
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        String verificationText = appiumDriver.findElement(by).getText().toLowerCase();
        if(verificationText.contains(text))
        {
            verifyStatus = true;
        }
        return verifyStatus;
    }

    public boolean equalsTextValidations(By by, String text)
    {
        verifyStatus = false;
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        if (appiumDriver.findElement(by).getText().equals(text))
        {
            verifyStatus = true;
        }
        return verifyStatus;
    }

    public void scrollDown()
    {
        Dimension dimension = appiumDriver.manage().window().getSize();
        double scrollHeightStart = dimension.getHeight() * 0.5;
        double scrollHeightEnd = dimension.getHeight() * 0.2;
        int scrollStart = (int) scrollHeightStart;
        int scrollEnds = (int) scrollHeightEnd;

        new TouchAction<>(appiumDriver)
                .press(PointOption.point(0,scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(0,scrollEnds))
                .release().perform();
    }
}
