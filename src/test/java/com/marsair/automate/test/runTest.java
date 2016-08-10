package com.marsair.automate.test;

import com.marsair.automate.core.ActionBase;
import com.marsair.automate.core.Manager;
import com.marsair.automate.utils.GetItem;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

/**
 * Created by Ganga Hawa on 09-08-2016.
 */
public class runTest {

   public static Manager manager = new Manager();




    @BeforeClass
    public static void setUpenv() throws Exception {
        System.setProperty("webdriver.chrome.driver",manager.getProItem().getItemFromProp("chromePath"));

        manager.getCrDriver().getDriver().get("http://kannan16.marsair.tw/");
    }


    @Test
    public void run() throws Exception {
        System.out.println(manager.getProItem().getItemFromProp("dropDeparting"));
        //Assert.assertTrue();

    }

    @AfterClass
    public static void closeRun(){

        manager.getCrDriver().dismiss();
    }


}
