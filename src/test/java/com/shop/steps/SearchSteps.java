package com.shop.steps;

import com.shop.constants.StoryContextKeys;
import com.shop.model.Product;
import com.shop.pages.HomePage;
import com.shop.pages.ProductPage;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class SearchSteps {
    HomePage homePage;
    ProductPage productPage;
    @Step
    public void selectProductList(String category, String subCategory, String Product)
    {
        com.shop.model.Product prod = new Product(category,subCategory,Product);
        Serenity.getCurrentSession().put(StoryContextKeys.product,prod);
        homePage.selectProduct(category,subCategory,Product);
        //Store active page number for future validation
        Serenity.getCurrentSession().put(StoryContextKeys.page,productPage.returnPageDisplayed());
    }

    @Step
    public void verifyProductPageIsDisplayed()
    {
      String expVal = String.format("Compare %s Prices in Singapore",((Product)Serenity.getCurrentSession().get(StoryContextKeys.product)).getProductName());
      String actVal = productPage.getProductPageHeader();
      Assert.assertEquals("Product title should be displayed as:"+expVal,expVal,actVal);
    }
}
