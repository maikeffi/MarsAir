package com.marsair.automate.test.promo;

import com.marsair.automate.test.base.BaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isOneOf;
import static org.junit.Assert.assertThat;

/**
 * Created by Kannan Maikeffi on 11-08-2016.
 */
@RunWith(value = Parameterized.class)
public class SearchWithPromoTest extends BaseTest {

    public String depValue;
    public String retValue;
    public String promoCode;
    public String expectedValue1;
   //public String expectedValue2;

    public SearchWithPromoTest(String depValue, String retValue, String promoCode, String expectedValue1) {
        this.depValue = depValue;
        this.retValue = retValue;
        this.promoCode = promoCode;
        this.expectedValue1 = expectedValue1;
        //this.expectedValue2 = expectedValue2;
    }



    @Parameters( name = "{index}: submitFrom({0} {1} {2}) and get {3}" )
    public static Collection stringInput(){
        return Arrays.asList(new Object[][]{
                {"July","December (two years from now)","AF3-FJK-418","Promotional code AF3-FJK-418 used: 30% discount!"},
                {"July","December (two years from now)","JJ5-OPQ-128","Promotional code JJ5-OPQ-128 used: 50% discount!"},
                {"July","December (two years from now)","JJ1-OPQ-126","Sorry, code JJ1-OPQ-126 is not valid"},
                {"July","July (next year)","JJ1-OPQ-126","Sorry, there are no more seats available."},
                {"July","December (next year)","XX1-ABC-124","Sorry, there are no more seats available."},
                {"July","December","XX1-ABC-124","Unfortunately, this schedule is not possible. Please try again."}
        });
    }

    @Test
    public void run() throws Exception {
        //manager.getFormSubmit().submitForm(depValue,retValue,promoCode);
        //System.out.println(expectedValue1);
        assertThat(manager.getFormSubmit().submitForm(depValue,retValue,promoCode),is(expectedValue1));
    }
}
