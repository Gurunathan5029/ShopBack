package com.shop.steps;

import com.shop.constants.Constants;
import com.shop.constants.StoryContextKeys;
import com.shop.pages.HomePage;
import com.shop.pages.LoginPage;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class LoginSteps {
    HomePage homePage;
    LoginPage loginPage;
    @Step
    public void launchShopBackUrl() {
        this.homePage.open();
        this.homePage.getDriver().manage().window().maximize();
    }
    @Step
    public void openLoginWindow()
    {
        this.homePage.clickOnUserLoginIcon();
    }
    @Step
    public void clickOnLoginBtnAndChooseEmail()
    {
        this.loginPage.clickOnLoginBtn();
        this.loginPage.clickUserEmailAddressBtn();
    }

    @Step
    public void enterEmailAddress(String email)
    {
        this.loginPage.enterEmailAddress(email);
        this.loginPage.clickOnNextBtn();
    }
    @Step
    public void enterPassword(String password)
    {
        this.loginPage.enterPassword(password);
        this.loginPage.clickOnNextBtn();
    }

    @Step
    public void closeNotificationIfExist()
    {
       this.homePage.checkAndCloseNotification();
    }

    @Step
    public void validateGreetingMessage()
    {
        String expGreeting = ((Constants.CREDENTIAL) Serenity.getCurrentSession().get(StoryContextKeys.credentials)).getMessage();
        this.homePage.moveToUserIconAndClick();
        String actGreeting = this.homePage.getUserGreetingsLabel();
        Assert.assertEquals("Verify Greeting Message is Displayed as: "+expGreeting,expGreeting,actGreeting);
    }

}
