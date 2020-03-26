package pages;

import org.openqa.selenium.By;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePage extends BasePage
{
    private WebDriverWait wait;
    private AppiumDriver<MobileElement> appiumDriver;
    private String goBackArrow = "Navigate up";
    private By sellerNameProfile = By.id("com.ebay.kijiji.ca:id/user_profile_name_view");

    public ProfilePage(AppiumDriver<MobileElement> appiumDriver)
    {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
        wait = new WebDriverWait(appiumDriver, Long.parseLong("15"));
    }

    public void goBackToHomePage()
    {
        appiumDriver.findElementByAccessibilityId(goBackArrow).click();
    }

    public boolean profilePageVerification(String sellerName)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(sellerNameProfile));
        return lowerCaseValidations(sellerNameProfile, sellerName);
    }
}
