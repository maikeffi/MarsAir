package com.marsair.automate.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Ganga Hawa on 11-08-2016.
 */
public class FFDriver {

    WebDriver ffDriver = new FirefoxDriver();

    public void dismiss(){
        ffDriver.quit();
    }

    public WebDriver getDriver() {


        return  ffDriver;
    }
}
