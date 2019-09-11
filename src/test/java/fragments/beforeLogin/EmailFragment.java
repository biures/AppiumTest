package fragments.beforeLogin;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class EmailFragment {
    AndroidDriver<MobileElement> driver;
    public MobileElement emailField;
    public MobileElement forgotEmailLabel;
    public MobileElement createAccountLabel;
    public MobileElement nextButton;

    public EmailFragment(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void initElements() {
        long startTime = System.nanoTime();
        long endTime;
        boolean shouldContinue = true;

        while (shouldContinue) {
            try {
                emailField = driver.findElement(By.className("android.widget.EditText"));
                nextButton = driver.findElement(By.id("identifierNext"));
                shouldContinue = false;
            } catch (Exception e) {
                endTime = System.nanoTime();
                if (endTime - startTime >= 7000000000L) shouldContinue = false;
            }
        }
    }

    public void submitEmail(String email) {
        this.emailField.sendKeys(email);
        this.nextButton.click();
    }
}
