package com.shop.glue;

import com.shop.constants.Constants;
import com.shop.steps.FilterSortSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class FilterSortGlue {
    @Steps
    FilterSortSteps filterSortSteps;

    @When("apply (.+) filter with value (.+)$")
    public void apply_brands_filter_with_value_samsung(Constants.FILTER_TYPE filter, String value) {
        filterSortSteps.filterProductListing(filter, value);
    }

    @When("sort the listing with (.+)$")
    public void sort_the_listing_with_price_high_to_low(Constants.SORT_TYPE sortType) {
        filterSortSteps.sortProductListing(sortType);
    }

    @Then("product listing should be listed based on filter")
    public void product_listing_should_be_listed_based_on_filter() {
        filterSortSteps.verifyProductListingByFilter();
    }

    @Then("product listing should be listed based on sortType")
    public void product_listing_should_be_listed_based_on_sort_type() {
       filterSortSteps.verifyItemsAreSortedBasedOnPrice();
    }

    @And("verify next page is also listed based on (.+) applied$")
    public void verifyNextPageIsAlsoListedBasedOnFilterOrSortApplied(Constants.OPERATION_TYPE operation) {
        filterSortSteps.verifyNextPageIsListedBasedOnAppliedFilterOrSort(operation);
    }
}
