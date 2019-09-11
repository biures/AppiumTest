package fragments.beforeLogin;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class PasswordFragment {
    AndroidDriver<MobileElement> driver;
    public MobileElement passwordField;
    public MobileElement nextButton;

    public PasswordFragment(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void initElements() {
        passwordField = driver.findElement(By.id("password"));
        nextButton = driver.findElement(By.id("passwordNext"));
    }

    public void submitPassword(String password) {
        this.passwordField.sendKeys(password);
        this.nextButton.click();
    }
}
