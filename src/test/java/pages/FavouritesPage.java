package pages;

import org.openqa.selenium.By;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FavouritesPage extends BasePage
{
    private AppiumDriver<MobileElement> appiumDriver;
    private WebDriverWait wait;
    private String menu = "Navigate up";
    private By adTitle = By.id("com.ebay.kijiji.ca:id/ad_title");
    private By noAdsAddedText = By.id("com.ebay.kijiji.ca:id/noAdsTitle");

    public FavouritesPage(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
        wait = new WebDriverWait(appiumDriver, Long.parseLong("15"));
    }

    public boolean verifyFavouritesPostAdded(String productText)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(adTitle));
        return lowerCaseValidations(adTitle, productText);
    }

    public void clickFavouritesPostAdded()
    {
        appiumDriver.findElement(adTitle).click();
    }

    public void openMenu()
    {
        appiumDriver.findElementByAccessibilityId(menu).click();
    }

    public boolean noAdsAddedAsFavourites()
    {
        return equalsTextValidations(noAdsAddedText, "You do not have any favourites");
    }
}
