package com.marsair.automate.test.search;

import com.marsair.automate.test.base.baseTest;
import org.junit.Test;

/**
 * Created by Ganga Hawa on 10-08-2016.
 */
public class searchSeatsTest extends baseTest {

    @Test
    public void run() throws Exception {
        manager.getFormSubmit().submitForm("July","December (two years from now)","AF3-FJK-418");
        //Assert.assertTrue();

    }
}
