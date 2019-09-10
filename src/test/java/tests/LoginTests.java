package tests;

import configs.BaseClass;
import fragments.AddEmailInitialFragment;
import fragments.ConfigureEmailAccountFragment;
import fragments.LoginFragment;
import fragments.WelcomeFragment;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginTests extends BaseClass {

    WelcomeFragment welcomeFragment;

    @Before
    public void bypassWelcomePage() {
        welcomeFragment = new WelcomeFragment(driver);
        welcomeFragment.initElements();
        welcomeFragment.gotItButton.click();
    }

    @Test
    public void addEmailTest() throws InterruptedException {
        AddEmailInitialFragment addEmailInitialFragment = new AddEmailInitialFragment(driver);
        addEmailInitialFragment.initElements();

        addEmailInitialFragment.addEmailAddressButton.click();

        ConfigureEmailAccountFragment configureEmailAccountFragment = new ConfigureEmailAccountFragment(driver);
        configureEmailAccountFragment.initElements();

        configureEmailAccountFragment.accountOptions.get(0).click();

        LoginFragment loginFragment = new LoginFragment(driver);
        loginFragment.initElements();

        Assert.assertTrue(loginFragment.nextButton.isDisplayed());
        Assert.assertEquals("Creați un cont", loginFragment.createAccountLabel.getText());
        Assert.assertEquals("Ați uitat adresa de e-mail?", loginFragment.forgotEmailLabel.getText());
    }
}
