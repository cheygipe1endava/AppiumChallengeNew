package pages;

import org.openqa.selenium.By;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ProductPage extends BasePage
{
    private AppiumDriver<MobileElement> appiumDriver;
    private String goBackArrow = "Navigate up";
    private By adTitle = By.id("com.ebay.kijiji.ca:id/adTitle");
    private By heartIcon = By.id("com.ebay.kijiji.ca:id/action_favorite");
    private By sellerNameContainer = By.id("com.ebay.kijiji.ca:id/user_profile_name_view");

    public ProductPage(AppiumDriver<MobileElement> appiumDriver)
    {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
    }

    public boolean postPageVerification(String productText)
    {
        return lowerCaseValidations(adTitle, productText);
    }

    public void clickHeartIcon()
    {
        waitAndClick(heartIcon);
    }

    public void goBackToHomePage()
    {
        appiumDriver.findElementByAccessibilityId(goBackArrow).click();
    }

    public String getAndClickSellerName()
    {
        String sellerName = appiumDriver.findElement(sellerNameContainer).getText().toLowerCase();
        appiumDriver.findElement(sellerNameContainer).click();
        return sellerName;
    }
}
