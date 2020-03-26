package steps;

import pages.*;
import helper.HookHelper;
import org.junit.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.datatable.DataTable;

public class PostPageSteps
{
    private AppiumDriver<MobileElement> appiumDriver;
    private HomePage homePage;
    private AccountPage accountPage;
    private CarsPage carsPage;
    private ProductPage productPage;
    private FavouritesPage favouritesPage;
    private ProfilePage profilePage;
    private String productText, sellerName;

    public PostPageSteps(HookHelper hookHelper)
    {
        appiumDriver = hookHelper.getAppiumDriver();
    }

    @Given("the user logs in Kijiji's web page")
    public void theUserLogsInKijijiSWebPage(DataTable fields)
    {
        LoginPage loginPage = new LoginPage(appiumDriver);
        homePage = new HomePage(appiumDriver);
        carsPage = new CarsPage(appiumDriver);
        homePage.clickMenuIcon();
        homePage.clickSignInButtonFromMenu();
        loginPage.clickSignInOptionButton();
        loginPage.processDataInsert(fields);
        String email = loginPage.inputEmailAndPassword();
        loginPage.clickSignInButton();
        Assert.assertTrue("Successfully logged in", homePage.logInSession(email));
    }

    @And("the user searches for cars and vehicle's first match in Canada")
    public void theUserSearchesForCarsAndVehicleSFirstMatchInCanada()
    {
        homePage.clickHomePageOption();
        homePage.clickCarsAndVehiclesIcon();
        productText = carsPage.selectFirstMatch();
    }

    @Given("the user is in first pick of Kijiji's cars post page")
    public void theUserIsInFirstPickOfKijijiSCarsPostPage()
    {
        productPage = new ProductPage(appiumDriver);
        favouritesPage = new FavouritesPage(appiumDriver);
        accountPage = new AccountPage(appiumDriver);
        profilePage = new ProfilePage(appiumDriver);
        Assert.assertTrue("Successfully selected first car post", productPage.postPageVerification(productText));
    }

    @When("the user clicks on heart icon at top right corner")
    public void theUserClicksOnHeartIconAtTopRightCorner()
    {
        productPage.clickHeartIcon();
    }

    @And("the user goes to favourites section in home menu")
    public void theUserGoesToFavouritesSectionInHomeMenu()
    {
        productPage.goBackToHomePage();
        carsPage.goBackToHomePage();
        homePage.clickFavouritesOption();
    }

    @Then("the user should have successfully saved post as its favourite")
    public void theUserShouldHaveSuccessfullySavedPostAsItsFavourite()
    {
        Assert.assertTrue("Successfully added post in Favourites", favouritesPage.verifyFavouritesPostAdded(productText));
    }

    @And("the user deletes post from favourites")
    public void theUserDeletesPostFromFavourites()
    {
        favouritesPage.clickFavouritesPostAdded();
        productPage.postPageVerification(productText);
        productPage.clickHeartIcon();
        productPage.goBackToHomePage();
        favouritesPage.openMenu();
        Assert.assertTrue("Successfully deleted post from Favourites", favouritesPage.noAdsAddedAsFavourites());
    }

    @And("the user closes the session")
    public void theUserClosesTheSession()
    {
        homePage.clickUserLoggedInContainer();
        accountPage.clickAccountSettingsIcon();
        accountPage.clickLogOutButton();
        Assert.assertTrue("Successfully logged out", homePage.logOutSession());
    }

    @When("the user clicks on seller's name")
    public void theUserClicksOnSellerSName()
    {
        sellerName = productPage.getAndClickSellerName();
    }

    @Then("the user should have been redirected to the seller's profile page")
    public void theUserShouldHaveBeenRedirectedToTheSellerSProfilePage()
    {
        Assert.assertTrue("Successfully logged out", profilePage.profilePageVerification(sellerName));
    }

    @And("the user goes back to home page")
    public void theUserGoesBackToHomePage()
    {
        profilePage.goBackToHomePage();
        productPage.goBackToHomePage();
        carsPage.goBackToHomePage();
        homePage.clickMenuIcon();
    }
}
