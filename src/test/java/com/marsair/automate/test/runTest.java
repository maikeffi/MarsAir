package com.marsair.automate.test;

import com.marsair.automate.core.Manager;
import com.marsair.automate.utils.GetItem;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

/**
 * Created by Ganga Hawa on 09-08-2016.
 */
public class runTest {
   public static GetItem getItem = new GetItem();
   public static Manager manager = new Manager();


    @BeforeClass
    public static void setUpenv() throws Exception {
        System.setProperty("webdriver.chrome.driver",getItem.getItem("chromePath"));

        manager.getCrDriver().getDriver().get("http://kannan16.marsair.tw/");
    }


    @Test
    public void run() throws Exception {
        System.out.println(getItem.getItem("dropDeparting"));

    }

    @AfterClass
    public static void closeRun(){
        manager.getCrDriver().dismiss();
    }


}
