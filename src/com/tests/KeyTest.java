package com.tests;

import static org.junit.Assert.assertEquals;

import com.company.Key;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class KeyTest {
    private static Key key;
    private static long num1;
    private static long num2;
    
    @BeforeClass
    public static void init() {
        num1 = 3001L;
        num2 = 2591L;
        key = new Key(num1, num2);
    }

    @AfterClass
    public static void tearDown() {
        key = null;
    }

    @Test 
    public void getFirstNum() {
        assertEquals(key.getFirstNum(), num1);
    }
    
    @Test
    public void getSecondNum() {
        assertEquals(key.getSecondNum(), num2);
    }
}