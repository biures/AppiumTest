package tests;

import configs.BaseClass;
import fragments.WelcomeFragment;
import org.junit.Assert;
import org.junit.Test;

public class WelcomePageTests extends BaseClass {

    @Test
    public void checkElements() {
        WelcomeFragment welcomeFragment = new WelcomeFragment(driver);
        welcomeFragment.initElements();

        Assert.assertTrue(welcomeFragment.logo.isDisplayed());
        Assert.assertEquals("Nou în Gmail", welcomeFragment.welcomeTitle.getText());
        Assert.assertEquals("Toate funcțiile pe care le știi deja într-o interfață nou-nouță", welcomeFragment.welcomeText.getText());
        Assert.assertEquals("AM ÎNȚELES", welcomeFragment.gotItButton.getText());
    }
}
