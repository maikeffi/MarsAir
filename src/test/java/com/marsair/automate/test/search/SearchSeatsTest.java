package com.marsair.automate.test.search;

import com.marsair.automate.test.base.BaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isOneOf;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;
import org.hamcrest.*;

/**
 * Created by Kannan Maikeffi on 10-08-2016.
 */
@RunWith(value = Parameterized.class)
public class SearchSeatsTest extends BaseTest {

    public String depValue;
    public String retValue;
    public String expectedValue1;
    public String expectedValue2;


    public SearchSeatsTest(String depValue, String retValue, String expectedValue1,String expectedValue2) {
        this.depValue = depValue;
        this.retValue = retValue;
        this.expectedValue1 = expectedValue1;
        this.expectedValue2 = expectedValue2;
    }


    @Parameters( name = "{index}: submitFrom({0} and {1}) and get output({2} or {3})" )
    public static Collection stringInput(){
        return Arrays.asList(new Object[][]{
                {"July","July","Unfortunately, this schedule is not possible. Please try again.","Unfortunately, this schedule is not possible. Please try again."},
                {"July","December","Unfortunately, this schedule is not possible. Please try again.","Unfortunately, this schedule is not possible. Please try again."},
                {"July","July (next year)","Sorry, there are no more seats available.","Seats available! Call now on 0800 MARSAIR to book!"},
                {"July (next year)","July (next year)","Unfortunately, this schedule is not possible. Please try again.","Unfortunately, this schedule is not possible. Please try again."},
                {"December","July (next year)","Unfortunately, this schedule is not possible. Please try again.","Unfortunately, this schedule is not possible. Please try again."},
                {"December","December (next year)","Sorry, there are no more seats available.","Seats available! Call now on 0800 MARSAIR to book!"},
                {"December","December (two years from now)","Sorry, there are no more seats available.","Seats available! Call now on 0800 MARSAIR to book!"},
                {"July","December (two years from now)","Sorry, there are no more seats available.","Seats available! Call now on 0800 MARSAIR to book!"},
                {"July (next year)","December (two years from now)","Sorry, there are no more seats available.","Seats available! Call now on 0800 MARSAIR to book!"},
                {"July (next year)","December","Unfortunately, this schedule is not possible. Please try again.","Unfortunately, this schedule is not possible. Please try again."},
                {"December (two years from now)","December (two years from now)","Unfortunately, this schedule is not possible. Please try again.","Unfortunately, this schedule is not possible. Please try again."}

        });
    }




    @Test
    public void run() throws Exception {


        //assertEquals("Finding seats on MarsAir",expected,manager.getFormSubmit().submitForm(depValue,retValue,""));
        //assertThat(myString, anyOf(is("value1"), is("value2"));
        //trying to use hamcrest matcher here !! so that assertion can happen against 2 values

        /**try {
            assertThat(manager.getFormSubmit().submitForm(depValue,retValue,""),isOneOf(expectedValue1,expectedValue2));
        }catch (AssertionError e){
            System.out.println("Test Failed");
            System.out.println("Expected : "+expectedValue1 +" or "+expectedValue2);
            System.out.println("Actual : "+manager.getFormSubmit().submitForm(depValue,retValue,""));
        }**/

        assertThat(manager.getFormSubmit().submitForm(depValue,retValue,""),isOneOf(expectedValue1,expectedValue2));



    }
}
