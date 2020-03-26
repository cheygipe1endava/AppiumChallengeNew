package pages;

import org.openqa.selenium.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class HomePage extends BasePage {

    private By menuIcon = By.id("com.ebay.kijiji.ca:id/home_search_icon");
    private By welcomeTextContainer = By.id("com.ebay.kijiji.ca:id/welcome_text");
    private By signInButtonMenu = By.id("com.ebay.kijiji.ca:id/signInButtonInDrawer");
    private By userProfileEmail = By.id("com.ebay.kijiji.ca:id/user_profile_email");
    private By userLoggedInContainer = By.id("com.ebay.kijiji.ca:id/userProfileContainer");
    private By homePageIcon = By.xpath("//android.widget.RelativeLayout/android.widget.TextView[@text='Home']");
    private By favouritesIcon = By.xpath("//android.widget.RelativeLayout/android.widget.TextView[@text='Favourites']");
    private By carsAndVehiclesIcon = By.xpath("//android.widget.LinearLayout/android.widget.TextView[@text='Cars & Vehicles']");

    public HomePage(AppiumDriver<MobileElement> appiumDriver)
    {
        super(appiumDriver);
    }

    public void clickMenuIcon() {
        waitAndClick(menuIcon);
    }

    public void clickSignInButtonFromMenu() {
        waitAndClick(signInButtonMenu);
    }

    public void clickUserLoggedInContainer()
    {
        waitAndClick(userLoggedInContainer);
    }

    public void clickHomePageOption()
    {
        waitAndClick(homePageIcon);
    }

    public void clickFavouritesOption()
    {
        waitAndClick(menuIcon);
        waitAndClick(favouritesIcon);
    }

    public void clickCarsAndVehiclesIcon()
    {
        waitAndClick(carsAndVehiclesIcon);
    }

    public boolean logInSession(String email)
    {
        clickMenuIcon();
        return equalsTextValidations(userProfileEmail, email);
    }

    public boolean logOutSession()
    {
        clickMenuIcon();
        return lowerCaseValidations(welcomeTextContainer, "welcome");
    }

}
