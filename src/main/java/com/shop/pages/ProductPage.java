package com.shop.pages;

import com.shop.constants.Constants;
import com.shop.utils.JavaScriptUtility;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;

public class ProductPage extends PageObject {
    JavaScriptUtility javaScriptUtility = new JavaScriptUtility(getDriver());
    @FindBy(css = "h1.text-lg")
    WebElementFacade productListingLabel;

    @FindBy(css = "div.brand-filter label")
    List<WebElementFacade> brandFilterLabel;

    @FindBy(xpath = "//input[@placeholder='$ max']")
    WebElementFacade maxFilterTbx;

    @FindBy(css = "button.submit-filter-button")
    WebElementFacade submitFilterBtn;

    @FindBy(css = "span.product-listing-tags-filter-item span:nth-child(1)")
    List<WebElementFacade> listOfFiltersAdded;

    @FindBy(css = "div.sort-list div.cursor-pointer")
    WebElementFacade sortListIcon;

    @FindBy(css = "div.sort-list ul.dropdown-list-block li")
    List<WebElementFacade> sortTypesList;

    @FindBy(css = "div.sale-price")
    List<WebElementFacade> productsPriceList;

    @FindBy(css = "div.product-listing-content a h3")
    List<WebElementFacade> productsTitleList;

    @FindBy(css = "div.pagination-list div.btn-default:nth-of-type(2)")
    WebElementFacade nextBtn;

    private String filterLabelsInput = "//preceding-sibling::input";


    public String getProductPageHeader() {
        return this.productListingLabel.getText();
    }

    /**
     * Apply Filter In Product Listing Page
     * @param filterType - Type of filters like "Brands" or "Shops"
     * @param value - Value for the filter like "Samsung" or "Sony"
     */
    public void chooseFilter(Constants.FILTER_TYPE filterType, String value) {
        switch (filterType) {
            case CASHBACK_STORE:
            case BRANDS:
                WebElementFacade element = this.findAll(By.cssSelector(filterType.getPath())).stream().filter(label -> label.getText().equals(value)).findFirst().get();
                javaScriptUtility.clickOnTheElement(element.findElement(By.xpath(filterLabelsInput)));
                break;
            case PRICE_MIN:
            case PRICE_MAX:
                this.find(By.xpath(filterType.getPath())).type(value);
                break;
            case AVAILABILITY:
                if (value.equals("yes"))
                    this.find(By.cssSelector(filterType.getPath())).click();
                break;
        }
        javaScriptUtility.clickOnTheElement(this.submitFilterBtn);
    }

    /**
     * Apply Sort product Listing Page
     * @param sortType - Type of Sort like "Price High To Low" and etc
     */
    public void sortProductListing(Constants.SORT_TYPE sortType) {
        this.sortListIcon.click();
        javaScriptUtility.clickOnTheElement(this.sortTypesList.stream().filter(sort -> sort.getText().equals(sortType.getText())).findFirst().get());
    }

    public List<String> getProductListingLabel() {
        return this.productsTitleList.stream().map(product -> product.getText()).toList();
    }

    public List<Double> getProductListingPriceList() {
        List<Double> priceList = this.productsPriceList.stream().map(price -> Double.parseDouble(price.getText().replaceAll("[^a-zA-Z0-9\\. ]", "").split(" ")[0])).toList();
        return priceList;
    }

    public void moveToNextPage() {
        javaScriptUtility.scrollToTheElement(this.nextBtn);
        javaScriptUtility.clickOnTheElement(this.nextBtn);
    }
}
