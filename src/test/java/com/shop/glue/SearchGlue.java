package com.shop.glue;

import com.shop.steps.SearchSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class SearchGlue {
    @Steps
    SearchSteps searchSteps;

    @And("select product (.+) under (.+) sub category under the (.+) main category$")
    public void selectProductProductUnderSub_CategoryCategory(String product, String subCategory, String category) {
        searchSteps.selectProductList(category, subCategory, product);
    }

    @Then("verify product page is displayed")
    public void verifyProductPageIsDisplayed() {
        searchSteps.verifyProductPageIsDisplayed();
    }


}
