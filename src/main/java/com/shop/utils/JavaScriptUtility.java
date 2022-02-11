package com.shop.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtility {
    JavascriptExecutor executor=null;

    public JavaScriptUtility(WebDriver driver) {
        executor =  (JavascriptExecutor)driver;
    }


    public void clickOnTheElement(WebElement element)
    {
        executor.executeScript("arguments[0].click();", element);
    }

    public void scrollToTheElement(WebElement element)
    {
        executor.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
