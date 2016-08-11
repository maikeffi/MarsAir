package com.marsair.automate.test.base;

import com.marsair.automate.core.ActionBase;
import com.marsair.automate.core.Manager;
import com.marsair.automate.test.promo.SearchWithPromoTest;
import com.marsair.automate.test.search.SearchSeatsTest;
import com.marsair.automate.utils.GetItem;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.openqa.selenium.WebDriver;

/**
 * Created by Kannan Maikeffi on 09-08-2016.
 */
//@RunWith(Suite.class)
//@SuiteClasses({SearchSeatsTest.class,SearchWithPromoTest.class})
public class BaseTest {

   public static Manager manager = new Manager();





    @BeforeClass
    public  static void setUpenv() throws Exception {
        System.out.println("Initiating Webdriver");
        System.setProperty("webdriver.chrome.driver",manager.getProItem().getItemFromProp("chromePath"));
        manager.getManager();
         //manager.getCrDriver();

    }




    @AfterClass
    public  static void closeRun(){
        System.out.println("Kill Webdriver");
        manager.kill();
    }


}
