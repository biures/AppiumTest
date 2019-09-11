package tests;

import configs.BaseClass;
import fragments.afterLogin.ComposeEmailFragment;
import fragments.afterLogin.InboxFragment;
import fragments.afterLogin.PopupsFragment;
import fragments.beforeLogin.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginTests extends BaseClass {

    @Before
    public void bypassWelcomePage() {
        WelcomeFragment welcomeFragment = new WelcomeFragment(driver);
        welcomeFragment.initElements();
        welcomeFragment.gotItButton.click();
    }

    @Test
    public void addEmailTest() {
        AddEmailInitialFragment addEmailInitialFragment = new AddEmailInitialFragment(driver);
        addEmailInitialFragment.initElements();
        addEmailInitialFragment.addEmailAddressButton.click();

        ConfigureEmailAccountFragment configureEmailAccountFragment = new ConfigureEmailAccountFragment(driver);
        configureEmailAccountFragment.initElements();
        configureEmailAccountFragment.accountOptions.get(0).click();

        EmailFragment emailFragment = new EmailFragment(driver);
        emailFragment.initElements();
        Assert.assertTrue(emailFragment.emailField.isDisplayed());
        Assert.assertTrue(emailFragment.nextButton.isDisplayed());
        emailFragment.submitEmail("appiumtest18@gmail.com");

        PasswordFragment passwordFragment = new PasswordFragment(driver);
        passwordFragment.initElements();
        Assert.assertTrue(passwordFragment.passwordField.isDisplayed());
        Assert.assertTrue(passwordFragment.nextButton.isDisplayed());
        passwordFragment.submitPassword("Appium123");
    }

    @Test
    public void loginTest() {
        AddEmailInitialFragment addEmailInitialFragment = new AddEmailInitialFragment(driver);
        addEmailInitialFragment.initElements();
        addEmailInitialFragment.accessGmailButton.click();

        PopupsFragment popupsFragment = new PopupsFragment(driver);
        if (popupsFragment.initFirstElements()) {
            popupsFragment.firstNextButton.click();
        }
        if (popupsFragment.initSecondElements()) {
            popupsFragment.secondNextButton.click();
        }

        InboxFragment inboxFragment = new InboxFragment(driver);
        inboxFragment.initElements();
        Assert.assertTrue(inboxFragment.isComposeButtonDisplayed());
    }

    @Test
    public void composeAndReadTest() throws InterruptedException {
        AddEmailInitialFragment addEmailInitialFragment = new AddEmailInitialFragment(driver);
        addEmailInitialFragment.initElements();
        addEmailInitialFragment.accessGmailButton.click();

        PopupsFragment popupsFragment = new PopupsFragment(driver);
        if (popupsFragment.initFirstElements()) {
            popupsFragment.firstNextButton.click();
        }
        if (popupsFragment.initSecondElements()) {
            popupsFragment.secondNextButton.click();
        }

        InboxFragment inboxFragment = new InboxFragment(driver);
        inboxFragment.initElements();
        inboxFragment.clickOnCompose();

        ComposeEmailFragment composeEmailFragment = new ComposeEmailFragment(driver);
        if (composeEmailFragment.isSmartComposeButtonInitialized()) {
            composeEmailFragment.clickOnGotIt();
        }

        composeEmailFragment.initElements();
        composeEmailFragment.sendEmail("appiumtest18@gmail.com", "test", "blabla");

        inboxFragment.initElements();
        inboxFragment.initSnackBar();
        Assert.assertTrue(inboxFragment.isSentSnackBarDisplayed());
    }
}
