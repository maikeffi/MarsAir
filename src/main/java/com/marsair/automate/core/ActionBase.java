package com.marsair.automate.core;

import com.google.common.base.Predicate;
import com.marsair.automate.utils.GetItem;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


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


    public WebElement findElementByXpath(String elementName) throws Exception {
        String xpath = manager.getProItem().getItemFromProp(elementName);
        return  webDriver.findElement(By.xpath(xpath));
    }

    public WebElement findElementByLinkText(String linkText){
        return webDriver.findElement(By.linkText(linkText));
    }

    public List<WebElement> findElementsByTagName(String tagName){

        return webDriver.findElements(By.tagName(tagName));
    }

    public void clickElement(String elementName) throws Exception {
        findElementByXpath(elementName).click();
    }



    public void setDropDownValue(String elementName, String value) throws Exception {
        WebElement selecBox = findElementByXpath(elementName);
        Select selectDropDown = new Select(selecBox);
        selectDropDown.selectByVisibleText(value);

    }

    public void setTextBoxValue(String elementName, String value) throws Exception {
        findElementByXpath(elementName).sendKeys(value);
    }

    public void clickLinkByText(String linkText){
        webDriver.findElement(By.linkText(linkText));
    }




    public boolean IsElementAvailable(String elementName){
        try {
            return findElementByXpath(elementName).isDisplayed();
        }catch (ElementNotVisibleException e){
            return false;
        }catch (Exception e1){
            return false;
        }
    }


    public void waitForElement(String elementName){
        new WebDriverWait(webDriver , 10).until(ElementIsAvailableByXpath(elementName));
    }

    public void waitForLink(String elementName){
        new WebDriverWait(webDriver , 10).until(ElementIsAvailableByLinkText(elementName));
    }




    public Predicate<WebDriver> ElementIsAvailableByXpath(final String item){
        return new Predicate<WebDriver>(){
            public boolean apply(WebDriver driver){

                try {
                    return findElementByXpath(item).isDisplayed();
                } catch (Exception e){

                    return false;
                }

            }
        };

    }

    public Predicate<WebDriver> ElementIsAvailableByLinkText(final String item){
        return new Predicate<WebDriver>(){
            public boolean apply(WebDriver driver){

                try {
                    return findElementByLinkText(item).isDisplayed();
                } catch (Exception e){

                    return false;
                }

            }
        };

    }


}
