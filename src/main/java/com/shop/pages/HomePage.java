package com.shop.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import java.util.List;

@DefaultUrl("https://www.shopback.sg/")
public class HomePage extends PageObject {
    @FindBy(css = "div.header__auth-btn")
    WebElementFacade authBtn;

    @FindBy(css = "div.justify-center div.header__user-menu-item")
    WebElementFacade userIcon;

    @FindBy(css = "div.ext-popup-content svg")
    WebElementFacade notificationCloseBtn;

    @FindBy(css = "div.capitalize")
    WebElementFacade greetingsLabel;

    @FindBy(css = "nav.header__nav--categories")
    WebElementFacade categoryDropDownList;

    @FindBy(css = "dt.header__nav-category-title--is-level-1 a")
    List<WebElementFacade> primaryCategoryList;

    private String secondCategoryList = "//dt[contains(@class,'header__nav-category-title--is-level-2')]//a";

    private String prodCategoryList = "//a[contains(@class,'header__nav-category-title--is-level-3')]";

    private String findParentCategories = "//ancestor::dt";

    public void clickOnUserLoginIcon() {
        this.authBtn.click();
    }

    public void moveToUserIconAndClick() {
        withAction().moveToElement(userIcon).click().perform();
    }

    public String getUserGreetingsLabel() {
        return greetingsLabel.getText();
    }

    public void checkAndCloseNotification() {
        if (this.notificationCloseBtn.isClickable())
            this.notificationCloseBtn.click();
    }
    /**
     * Click on Main Category->Sub Category->Product
     * @param category - Main category type - like "Mobile & Tablets"
     * @param subCategory - Sub category type - Like "MobilePhones"
     * @param product - Product type - Like "Mobile"
     */
    public void selectProduct(String category, String subCategory, String product) {
        withAction().moveToElement(this.categoryDropDownList).perform();
        WebElementFacade categoryElement =this.primaryCategoryList.stream().filter(cat -> cat.getText().equals(category)).findFirst().get();
        withAction().moveToElement(categoryElement).perform();
        categoryElement.findElement(By.xpath(findParentCategories)).findElements(By.xpath(secondCategoryList)).stream().filter(sub->sub.getText().equals(subCategory)).findFirst().get().
                findElement(By.xpath(findParentCategories)).findElements(By.xpath(prodCategoryList)).stream().filter(prod->prod.getText().equals(product)).findFirst().get().click();

    }

}
