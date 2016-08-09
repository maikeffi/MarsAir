package com.marsair.automate.core;

import org.openqa.selenium.WebDriver;

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
}
