package com.shop.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.shopback.sg/")
public class LoginPage extends PageObject {

    //Login button in Flyout
    @FindBy(xpath = "//span[contains(text(),'Login')]/parent::div")
    WebElementFacade loginBtn;

    //Use email address in the Flyout
    @FindBy(xpath = "//span[contains(text(),'Use Email Address')]/parent::div")
    WebElementFacade useEmailAddressBtn;

    @FindBy(xpath = "//input[@type='email']")
    WebElementFacade emailAddressTbx;

    @FindBy(xpath = "//input[@type='password']")
    WebElementFacade passwordTbx;

    //Next button in the Flyout
    @FindBy(xpath = "//span[contains(text(),'Next')]/parent::button")
    WebElementFacade nextBtn;

    public void clickOnLoginBtn() {
        this.loginBtn.click();
    }

    public void clickUserEmailAddressBtn() {
        this.useEmailAddressBtn.click();
    }

    public void enterEmailAddress(String email) {
        this.emailAddressTbx.type(email);
    }

    public void enterPassword(String password) {
        this.passwordTbx.type(password);
    }

    public void clickOnNextBtn()
    {
        this.nextBtn.click();
    }

}
