package com.syakeapps.jtp.logging;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.slf4j.cal10n.LocLogger;

public class LoggerFactoryTest {

    @Test
    public void test_getLogger() throws Exception {
        /* SETUP */

        /* INVOCATION */
        LocLogger actual = LoggerFactory.getLogger(LoggerFactoryTest.class);

        /* ASSERTION */
        assertNotNull(actual);
    }
}
