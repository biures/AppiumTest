package fragments.beforeLogin;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.List;

public class ConfigureEmailAccountFragment {
    AndroidDriver<MobileElement> driver;
    public List<MobileElement> accountOptions;

    public ConfigureEmailAccountFragment(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void initElements() {
        accountOptions = driver.findElements(By.id("com.google.android.gm:id/account_setup_item"));
    }
}
