package fragments.afterLogin;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ComposeEmailFragment {
    AndroidDriver<MobileElement> driver;
    private MobileElement smartComposeGotItButton;
    private MobileElement toField;
    private MobileElement subjectField;
    private MobileElement emailBody;
    private MobileElement sendEmailButton;

    public ComposeEmailFragment(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public boolean isSmartComposeButtonInitialized() {
        try {
            smartComposeGotItButton = driver.findElement(By.id("android:id/button1"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void initElements() {
        long startTime = System.nanoTime();
        long endTime;
        boolean shouldContinue = true;

        while (shouldContinue) {
            try {
                toField = driver.findElement(By.id("com.google.android.gm:id/to"));
                subjectField = driver.findElement(By.id("com.google.android.gm:id/subject"));
                emailBody = driver.findElement(By.id("com.google.android.gm:id/composearea_tap_trap_bottom"));
                sendEmailButton = driver.findElement(By.id("com.google.android.gm:id/send"));
                shouldContinue = false;
            } catch (Exception e) {
                endTime = System.nanoTime();
                if (endTime - startTime >= 7000000000L) {
                    shouldContinue = false;
                }
            }
        }
    }

    public void clickOnGotIt() {
        smartComposeGotItButton.click();
    }

    public void sendEmail(String to, String subject, String body) {
        subjectField.sendKeys(subject);
        emailBody.sendKeys(body);
        toField.sendKeys(to);
        sendEmailButton.click();
    }
}
