package configs;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CapabilitiesClass {
    public AndroidDriver getLocalDriver() throws MalformedURLException {
        DesiredCapabilities capabilites = new DesiredCapabilities();

        capabilites.setCapability("deviceName", "Galaxy Tab S2");
        capabilites.setCapability("udid", "3300f235f1aaa271");
        capabilites.setCapability("app", "C:\\Trainings\\Testing\\appium\\2019\\com.google.android.gmail.apk");
        capabilites.setCapability("appPackage", "com.google.android.gm");
        capabilites.setCapability("appActivity", "com.google.android.gm.ConversationListActivityGmail");
        capabilites.setCapability("platformName", "Android");
        capabilites.setCapability("automationName", "Appium");

        URL url = new URL("http://0.0.0.0:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(url, capabilites);

        return driver;
    }
}