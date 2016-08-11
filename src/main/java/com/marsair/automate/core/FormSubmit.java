package com.marsair.automate.core;

import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Ganga Hawa on 09-08-2016.
 */
public class FormSubmit extends ActionBase {

    public FormSubmit(Manager manager) {
        super(manager);
    }

    public void goToMainPage(String url){
        webDriver.get(url);
    }

    public String submitForm(String depValue,String retValue,String promo) throws Exception {
        String result = "";

        goToMainPage("http://kannan16.marsair.tw/");
        setDropDownValue("dropDeparting",depValue);
        setDropDownValue("dropReturning",retValue);
        setTextBoxValue("boxPromo",promo);
        clickElement("submitSearch");
        waitForLink("Back");
        List<WebElement> paraElemets = findElementsByTagName("p");
        for (WebElement webElement : paraElemets){
            String temp = webElement.getText();

            if (!temp.equals("Back")){result = result+" "+temp;}
        }
        //System.out.println(result);


        return result.trim();
    }

}
