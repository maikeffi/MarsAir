package com.marsair.automate.core;

import com.marsair.automate.utils.GetItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Kannan Maikeffi on 09-08-2016.
 */
public class CRDriver {


    WebDriver chDriver = new ChromeDriver();


    public void dismiss(){
        chDriver.quit();
    }

    public WebDriver getDriver() {


        return  chDriver;
    }
}
