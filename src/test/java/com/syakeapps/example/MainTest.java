package com.syakeapps.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MainTest {

    @Test
    public void testSayHello() {
        String actual = new Main().sayHello();
        assertEquals(Main.HELLO, actual);
    }
}
