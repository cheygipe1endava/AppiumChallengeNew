package pages;

import java.util.List;
import org.openqa.selenium.By;
import io.cucumber.datatable.DataTable;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage
{
    private WebDriverWait wait;
    private List<List<String>> credentialsData;
    private By signInOptionButton = By.id("com.ebay.kijiji.ca:id/new_login_choice_sign_in");
    private By emailInputBox = By.id("com.ebay.kijiji.ca:id/new_login_fragment_email");
    private By passwordInputBox = By.id("com.ebay.kijiji.ca:id/new_login_fragment_password");
    private By signInButton = By.id("com.ebay.kijiji.ca:id/new_login_fragment_continue");
    private By failedLogInText = By.id("com.ebay.kijiji.ca:id/title");

    public LoginPage(AppiumDriver<MobileElement> appiumDriver)
    {
        super(appiumDriver);
        wait = new WebDriverWait(appiumDriver, Long.parseLong("15"));
    }

    public void processDataInsert(DataTable fields)
    {
        credentialsData = fields.cells();
    }

    public void clickSignInOptionButton()
    {
        waitAndClick(signInOptionButton);
    }

    public String inputEmailAndPassword()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputBox));
        clickAndSendData(emailInputBox, credentialsData.get(0).get(1));
        clickAndSendData(passwordInputBox, credentialsData.get(1).get(1));
        return credentialsData.get(0).get(1);
    }

    public void clickSignInButton()
    {
        waitAndClick(signInButton);
    }

    public boolean failedLogIn()
    {
        return lowerCaseValidations(failedLogInText, "failure");
    }
}
