package fragments;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class WelcomeFragment {
    AndroidDriver<MobileElement> driver;

    public MobileElement logo;
    public MobileElement welcomeTitle;
    public MobileElement welcomeText;
    public MobileElement gotItButton;

    public WelcomeFragment(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void initElements() {
        logo = driver.findElement(By.id("com.google.android.gm:id/gmail_logo"));
        welcomeTitle = driver.findElement(By.id("com.google.android.gm:id/welcome_tour_title"));
        welcomeText = driver.findElement(By.id("com.google.android.gm:id/welcome_tour_text"));
        gotItButton = driver.findElement(By.id("com.google.android.gm:id/welcome_tour_got_it"));
    }

}
