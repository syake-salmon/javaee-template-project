package com.syakeapps.jtp.logging;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.cal10n.LocLogger;

import com.syakeapps.jtp.testutil.TestLogger;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ org.slf4j.LoggerFactory.class })
public class LoggerFactoryTest {

    private TestLogger logger;

    @Before
    public void doBefore() throws Exception {
        logger = new TestLogger();

        PowerMockito.mockStatic(org.slf4j.LoggerFactory.class);
        PowerMockito
                .when(org.slf4j.LoggerFactory
                        .getLogger(LoggerFactoryTest.class.getName()))
                .thenReturn(logger);
    }

    @Test
    public void test_getLogger_ja() throws Exception {
        /* SETUP */
        Locale.setDefault(Locale.JAPAN);

        /* INVOCATION */
        LocLogger locLogger = LoggerFactory.getLogger(LoggerFactoryTest.class);
        locLogger.info(Messages.EXAMPLE);
        List<String> actual = logger.getEvents();

        /* ASSERTION */
        assertTrue(actual.size() == 1);
        assertEquals("これはサンプルです。", actual.get(0));
    }

    @Test
    public void test_getLogger_en() throws Exception {
        /* SETUP */
        Locale.setDefault(Locale.US);

        /* INVOCATION */
        LocLogger locLogger = LoggerFactory.getLogger(LoggerFactoryTest.class);
        locLogger.info(Messages.EXAMPLE);
        List<String> actual = logger.getEvents();

        /* ASSERTION */
        assertTrue(actual.size() == 1);
        assertEquals("This is a example.", actual.get(0));
    }
}
