package com.marsair.automate.core;

import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Ganga Hawa on 09-08-2016.
 */
public class FormSubmit extends ActionBase {

    public FormSubmit(Manager manager) throws Exception {
        super(manager);
    }



    public String submitForm(String depValue,String retValue,String promo) throws Exception {
        String result = "";

        goToMainPage();
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

        if (!promo.equals("")){
            result = result.replace("Seats available!","").replace("Call now on 0800 MARSAIR to book!","").trim();
        }


        return result.trim();
    }

}
