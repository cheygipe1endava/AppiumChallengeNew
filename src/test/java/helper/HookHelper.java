package helper;

import java.net.URL;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import java.net.MalformedURLException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.Scenario;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HookHelper {

    private AppiumDriver<MobileElement> appiumDriver;
    private static final String SL_username = System.getenv("SAUCE_USERNAME");
    private static final String SL_accessKey = System.getenv("SAUCE_ACCESS_KEY");

    @Before
    public void setUp(Scenario scenario) throws MalformedURLException
    {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appiumVersion", "1.15.0");
        desiredCapabilities.setCapability("deviceName","Samsung Galaxy S9 WQHD GoogleAPI Emulator");
        desiredCapabilities.setCapability("deviceOrientation", "portrait");
        desiredCapabilities.setCapability("browserName", "");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "9.0");
        desiredCapabilities.setCapability("username", SL_username);
        desiredCapabilities.setCapability("accesskey", SL_accessKey);
        desiredCapabilities.setCapability("build", "Trainline Suite");
        desiredCapabilities.setCapability("name", scenario.getName());
        desiredCapabilities.setCapability("autoGrantPermissions", true);
        desiredCapabilities.setCapability("app","sauce-storage:com.ebay.kijiji.ca_apkmirror.com.apk");

        URL url = new URL("http://ondemand.saucelabs.com:80/wd/hub");
        appiumDriver = new AppiumDriver<>(url, desiredCapabilities);
    }

    public AppiumDriver<MobileElement> getAppiumDriver()
    {
        return appiumDriver;
    }

    @After
    public void tearDown(Scenario scenario)
    {
        if (scenario.isFailed()){
            appiumDriver.executeScript("sauce:job-result=failed");
        }
        else {
            appiumDriver.executeScript("sauce:job-result=passed");
        }
        appiumDriver.closeApp();
    }
}

