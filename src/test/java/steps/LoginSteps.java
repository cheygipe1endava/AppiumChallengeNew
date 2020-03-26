package steps;

import pages.HomePage;
import pages.LoginPage;
import org.junit.Assert;
import helper.HookHelper;
import pages.AccountPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.datatable.DataTable;

public class LoginSteps {

    private AppiumDriver<MobileElement> appiumDriver;
    private HomePage homePage;
    private LoginPage loginPage;
    private AccountPage accountPage;
    private String email;

    public LoginSteps(HookHelper hookHelper)
    {
        appiumDriver = hookHelper.getAppiumDriver();
    }

    @Given("the user is in Kijiji's home page")
    public void theUserIsInKijijiSHomePage()
    {
        homePage = new HomePage(appiumDriver);
        loginPage = new LoginPage(appiumDriver);
        accountPage = new AccountPage(appiumDriver);
    }

    @And("the user clicks on menu icon")
    public void theUserClicksOnMenuIcon()
    {
        homePage.clickMenuIcon();
    }

    @When("the user clicks on sign in button and selects sign in option button")
    public void theUserClicksOnSignInButtonAndSelectsSignInOptionButton()
    {
        homePage.clickSignInButtonFromMenu();
        loginPage.clickSignInOptionButton();
    }

    @And("types in its credentials for email and password and enters them by clicking sign in button")
    public void typesInItsCredentialsForEmailAndPasswordAndEntersThemByClickingSignInButton(DataTable fields)
    {
        loginPage.processDataInsert(fields);
        email = loginPage.inputEmailAndPassword();
        loginPage.clickSignInButton();
    }

    @Then("the user should be signed in")
    public void theUserShouldBeSignedIn()
    {
        Assert.assertTrue("Successfully logged in", homePage.logInSession(email));
    }

    @And("the user logs out from session")
    public void theUserLogsOutFromSession()
    {
        homePage.clickUserLoggedInContainer();
        accountPage.clickAccountSettingsIcon();
        accountPage.clickLogOutButton();
        Assert.assertTrue("Successfully logged out", homePage.logOutSession());
    }

    @Then("the user cannot login because app shows error with credentials")
    public void theUserCannotLoginBecauseAppShowsErrorWithCredentials()
    {
        Assert.assertTrue("Error: Invalid credentials, unable to login", loginPage.failedLogIn());
    }
}