package com.marsair.automate.test.links;

import com.marsair.automate.test.base.BaseTest;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

/**
 * Created by Kannan Maikeffi on 11-08-2016.
 */
//@RunWith(value = Parameterized.class)
public class FindLinksTest extends BaseTest {

    @Test
    public void findLink() throws Exception {

        assertEquals(true, manager.getFindLinks().isLinkFound("Book a ticket to the red planet now!"));

    }

    @Test
    public void findClickedPageTitle() throws Exception {
        assertEquals("Title of page","Mars Airlines: Home",manager.getFindLinks().clickLinkAndSendBackTitle("MarsAir"));
    }
}
