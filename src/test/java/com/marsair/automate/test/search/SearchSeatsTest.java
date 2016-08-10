package com.marsair.automate.test.search;

import com.marsair.automate.test.base.BaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;

/**
 * Created by Ganga Hawa on 10-08-2016.
 */
@RunWith(value = Parameterized.class)
public class SearchSeatsTest extends BaseTest {



    @Parameters
    public static Collection stringInput(){
        return Arrays.asList(new Object[][]{
                {"July","July","Unfortunately, this schedule is not possible. Please try again."},
                {"July","December","Unfortunately, this schedule is not possible. Please try again."},
                {"July","July (next year)","Sorry, there are no more seats available."}
        });
    }

    public String depValue;
    public String retValue;
    public String expected;


    public SearchSeatsTest(String depValue, String retValue, String expected) {
        this.depValue = depValue;
        this.retValue = retValue;
        this.expected = expected;
    }




    @Test
    public void run() throws Exception {
        ;

        assertEquals("Should be correct",expected,manager.getFormSubmit().submitForm(depValue,retValue,""));
        //Assert.assertTrue();

    }
}
