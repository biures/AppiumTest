package fragments.afterLogin;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.List;

public class InboxFragment {
    AndroidDriver<MobileElement> driver;
    private MobileElement composeButton;
    private MobileElement sentSnackBar;
    private List<MobileElement> emailList;

    public InboxFragment(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void initElements() {
        long startTime = System.nanoTime();
        long endTime;
        boolean shouldContinue = true;

        while (shouldContinue) {
            try {
                composeButton = driver.findElement(By.id("com.google.android.gm:id/compose_button"));
                emailList = driver.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.view.View"));
                shouldContinue = false;
            } catch (Exception e) {
                endTime = System.nanoTime();
                if (endTime - startTime >= 5000000000L) shouldContinue = false;
            }
        }
    }

    public boolean initSnackBar() {
        try {
            sentSnackBar = driver.findElement(By.id("com.google.android.gm:id/toast_bar"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnCompose() {
        composeButton.click();
    }

    public boolean isComposeButtonDisplayed() {
        return composeButton.isDisplayed();
    }

    public boolean isEmailFound(String query) {
        for (MobileElement mail : emailList) {
            if (mail.getText().toLowerCase().contains(query.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public boolean isSentSnackBarDisplayed() {
        return sentSnackBar.isDisplayed();
    }
}
