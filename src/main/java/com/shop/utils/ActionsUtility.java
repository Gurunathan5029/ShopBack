package com.shop.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtility {
    Actions action = null;

    public ActionsUtility(WebDriver driver) {
        action = new Actions(driver);
    }

    public void moveElementToTheRight(WebElement ele, int numberOfTimes) {
        while (numberOfTimes > 0) {
            action.dragAndDropBy(ele, 100, 0).build().perform();
            numberOfTimes--;
        }

    }
}
