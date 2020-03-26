package pages;

import java.util.List;
import org.openqa.selenium.By;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarsPage extends BasePage
{
    private AppiumDriver<MobileElement> appiumDriver;
    private WebDriverWait wait;
    private String goBackArrow = "Navigate up";
    private By toolBar = By.id("com.ebay.kijiji.ca:id/toolbar_actionbar");
    private By availableInCanadaList = By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.ebay.kijiji.ca:id/card_recycler_view']" +
                                                "/android.widget.LinearLayout/android.widget.TextView");



    public CarsPage(AppiumDriver<MobileElement> appiumDriver)
    {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
        wait = new WebDriverWait(appiumDriver, Long.parseLong("15"));
    }

    public String selectFirstMatch()
    {
        scrollDown();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(availableInCanadaList));
        List<MobileElement> carsProductList = appiumDriver.findElements(availableInCanadaList);
        String productText = carsProductList.get(0).getText().toLowerCase();
        carsProductList.get(0).click();
        return productText;
    }

    public void goBackToHomePage()
    {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(toolBar));
        appiumDriver.findElementByAccessibilityId(goBackArrow).click();
    }
}
