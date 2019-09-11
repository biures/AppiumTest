package fragments.afterLogin;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class PopupsFragment {
    AndroidDriver<MobileElement> driver;
    public MobileElement firstNextButton;
    public MobileElement secondNextButton;

    public PopupsFragment(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public boolean initFirstElements() {
        try {
            firstNextButton = driver.findElement(By.id("com.google.android.gm:id/gm_dismiss_button"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean initSecondElements() {
        try {
            secondNextButton = driver.findElement(By.id("com.google.android.gm:id/gm_dismiss_button"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
