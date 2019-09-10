package fragments;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LoginFragment {
    AndroidDriver<MobileElement> driver;
    public MobileElement emailField;
    public MobileElement forgotEmailLabel;
    public MobileElement createAccountLabel;
    public MobileElement nextButton;

    public LoginFragment(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void initElements() {
        emailField = driver.findElement(By.className("android.widget.EditText"));
        forgotEmailLabel = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[2]/android.view.View[3]/android.view.View/android.view.View[2]/android.widget.Button"));
        createAccountLabel = driver.findElement(By.id("ow248"));
        nextButton = driver.findElement(By.id("identifierNext"));
    }
}
