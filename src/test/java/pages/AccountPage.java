package pages;

import org.openqa.selenium.By;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class AccountPage extends BasePage
{
    private By settingsIcon = By.id("com.ebay.kijiji.ca:id/action_settings");
    private By logOutButton = By.id("com.ebay.kijiji.ca:id/logoutButton");

    public AccountPage(AppiumDriver<MobileElement> appiumDriver)
    {
        super(appiumDriver);
    }

    public void clickAccountSettingsIcon()
    {
        waitAndClick(settingsIcon);
    }

    public void clickLogOutButton()
    {
        scrollDown();
        waitAndClick(logOutButton);
    }
}
