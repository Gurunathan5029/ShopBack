package com.shop.glue;

import com.shop.constants.Constants;
import com.shop.constants.StoryContextKeys;
import com.shop.steps.SearchSteps;
import com.shop.steps.LoginSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class LoginGlue {
    @Steps
    LoginSteps loginSteps;
    @Steps
    SearchSteps searchSteps;
    @Given("shopback page is launched")
    public void shopback_page_is_launched() {
        loginSteps.launchShopBackUrl();
    }
    @When("user click on user Icon")
    public void user_click_on_user_icon() {
        loginSteps.openLoginWindow();
    }

    @When("login with (BLANK|INVALID_PASSWORD|INVALID_EMAIL|VALID) credentials$")
    public void login_with_valid_details(Constants.CREDENTIAL credentials) {
        loginSteps.clickOnLoginBtnAndChooseEmail();
        loginSteps.enterEmailAddress(credentials.getEmail());
        loginSteps.enterPassword(credentials.getPassword());
        Serenity.getCurrentSession().put(StoryContextKeys.credentials,credentials);
    }

    @Then("user should be successfully logged in")
    public void user_should_be_successfully_logged_in() {
        loginSteps.closeNotificationIfExist();
        loginSteps.validateGreetingMessage();
    }

}
