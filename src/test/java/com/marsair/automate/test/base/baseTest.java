package com.marsair.automate.test.base;

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
public class baseTest {

   public static Manager manager = new Manager();




    @BeforeClass
    public static void setUpenv() throws Exception {
        System.setProperty("webdriver.chrome.driver",manager.getProItem().getItemFromProp("chromePath"));

        manager.getManager();
    }




    @AfterClass
    public static void closeRun(){

        manager.kill();
    }


}
