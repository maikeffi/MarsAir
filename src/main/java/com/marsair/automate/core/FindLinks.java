package com.marsair.automate.core;

/**
 * Created by Kannan Maikeffi on 10-08-2016.
 */
public class FindLinks extends ActionBase {
    public FindLinks(Manager manager) throws Exception {
        super(manager);
    }

    public boolean  isLinkFound(String text) throws Exception {
        boolean isFound = false;
        goToMainPage();
        try {
            isFound = findElementByLinkText(text).isDisplayed();
        }catch (Exception e){
            return  false;
        }

        return isFound ;
    }

    public String clickLinkAndSendBackTitle(String text) throws Exception {
        goToMainPage();
        findElementByLinkText(text).click();
        return returnPageTitle();
    }
}
