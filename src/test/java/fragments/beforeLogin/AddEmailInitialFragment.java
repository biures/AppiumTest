package fragments.beforeLogin;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class AddEmailInitialFragment {
    AndroidDriver<MobileElement> driver;
    public MobileElement addEmailAddressButton;
    public MobileElement accessGmailButton;

    public AddEmailInitialFragment(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void initElements() {
        addEmailAddressButton = driver.findElement(By.id("com.google.android.gm:id/setup_addresses_add_another"));
        accessGmailButton = driver.findElement(By.id("com.google.android.gm:id/action_done"));
    }
}
