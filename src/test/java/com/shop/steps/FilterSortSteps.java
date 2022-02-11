package com.shop.steps;

import com.shop.constants.Constants;
import com.shop.constants.StoryContextKeys;
import com.shop.model.ProductFilterSort;
import com.shop.pages.ProductPage;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class FilterSortSteps {
    ProductPage productPage;

    @Step
    public void filterProductListing(Constants.FILTER_TYPE filter, String value) {
        //Store Filter details for validation purpose
        com.shop.model.ProductFilterSort filterSort;
        if ((ProductFilterSort) Serenity.getCurrentSession().get(StoryContextKeys.productFilterSort) == null)
            filterSort = new ProductFilterSort(filter, value, null);
        else {
            filterSort = (ProductFilterSort) Serenity.getCurrentSession().get(StoryContextKeys.productFilterSort);
            filterSort.setFilterType(filter);
            filterSort.setValue(value);
        }
        Serenity.getCurrentSession().put(StoryContextKeys.productFilterSort, filterSort);
        productPage.chooseFilter(filter, value);
    }

    @Step
    public void sortProductListing(Constants.SORT_TYPE sortType) {
        //Store sort details for validation purpose
        com.shop.model.ProductFilterSort filterSort;
        if ((ProductFilterSort) Serenity.getCurrentSession().get(StoryContextKeys.productFilterSort) == null)
            filterSort = new ProductFilterSort(null, null, sortType);
        else {
            filterSort = (ProductFilterSort) Serenity.getCurrentSession().get(StoryContextKeys.productFilterSort);
            filterSort.setSortType(sortType);
        }
        Serenity.getCurrentSession().put(StoryContextKeys.productFilterSort, filterSort);
        productPage.sortProductListing(sortType);
    }

    @Step
    public void verifyProductListingByFilter() {
        String expVal = ((ProductFilterSort) Serenity.getCurrentSession().get(StoryContextKeys.productFilterSort)).getValue();
        Assert.assertEquals("All the items displayed should match the filter applied:" + expVal, 0, productPage.getProductListingLabel().stream().filter(prod -> !Pattern.compile(Pattern.quote(expVal), Pattern.CASE_INSENSITIVE).matcher(prod).find()).toList().stream().count());
    }

    //Following method can be extended to support other SortTypes
    @Step
    public void verifyItemsAreSortedBasedOnPrice() {
        Constants.SORT_TYPE sortType = ((ProductFilterSort) Serenity.getCurrentSession().get(StoryContextKeys.productFilterSort)).getSortType();
        List<Double> expList = new ArrayList<Double>(productPage.getProductListingPriceList());
        if (sortType.equals(Constants.SORT_TYPE.PRICE_LOW_TO_HIGH))
            Collections.sort(expList);
        else if (sortType.equals(Constants.SORT_TYPE.PRICE_HIGH_TO_LOW))
            Collections.sort(expList, Collections.reverseOrder());
        Assert.assertEquals("Verify items are sorted based on: " + sortType.getText(), expList, productPage.getProductListingPriceList());
    }

    @Step
    public void verifyNextPageIsListedBasedOnAppliedFilterOrSort(Constants.OPERATION_TYPE operation) {
        productPage.moveToNextPage();
        int page = (int)Serenity.getCurrentSession().get(StoryContextKeys.page);
        if (operation.equals(Constants.OPERATION_TYPE.FILTER))
            verifyProductListingByFilter();
        else if (operation.equals(Constants.OPERATION_TYPE.SORT))
            //This can be improved by validating the sort order based on previous page list
            verifyItemsAreSortedBasedOnPrice();
        Assert.assertEquals("Verify page display",page+1,productPage.returnPageDisplayed());
    }


}
