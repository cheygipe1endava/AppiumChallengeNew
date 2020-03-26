package helper;

import java.net.URL;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import java.net.MalformedURLException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HookHelper {

    private AppiumDriver<MobileElement> appiumDriver;

    @Before
    public void setUp() throws MalformedURLException
    {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "SM-A205G");
        desiredCapabilities.setCapability("udid", "R58M92BSEXD");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "9");
        desiredCapabilities.setCapability("autoGrantPermissions", true);
        desiredCapabilities.setCapability("appPackage", "com.ebay.kijiji.ca");
        desiredCapabilities.setCapability("appActivity", "com.ebay.app.common.startup.SplashScreenActivity");
        desiredCapabilities.setCapability("automationName", "UiAutomator1");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        appiumDriver = new AppiumDriver<>(url, desiredCapabilities);
    }

    public AppiumDriver<MobileElement> getAppiumDriver()
    {
        return appiumDriver;
    }

    @After
    public void tearDown()
    {
        appiumDriver.closeApp();
    }
}

