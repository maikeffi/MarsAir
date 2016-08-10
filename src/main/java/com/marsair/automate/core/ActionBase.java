package com.marsair.automate.core;

import com.marsair.automate.utils.GetItem;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Ganga Hawa on 09-08-2016.
 */
public class ActionBase {
    protected Manager manager;
    protected WebDriver webDriver;

    public ActionBase(Manager manager) {
        this.manager = manager;
        webDriver = manager.getCrDriver().getDriver();
    }


    public WebElement findElement(String elementName) throws Exception {
        String xpath = manager.getProItem().getItemFromProp(elementName);
        return  webDriver.findElement(By.xpath(xpath));
    }

    public void clickElement(String elementName) throws Exception {
        findElement(elementName).click();
    }

    public void setDropDownValue(String elementName, String value) throws Exception {
        WebElement selecBox = findElement(elementName);
        Select selectDropDown = new Select(selecBox);
        selectDropDown.selectByVisibleText(value);

    }

    public boolean IsElementAvailable(String elementName){
        try {
            return findElement(elementName).isDisplayed();
        }catch (ElementNotVisibleException e){
            return false;
        }catch (Exception e1){
            return false;
        }
    }
}
