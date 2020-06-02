package com.tests;

import static org.junit.Assert.assertTrue;

import com.company.Key;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class KeyTest {
    private Key key;
    private long num1, num2;
    
    @BeforeClass
    public void init() {
        num1 = 3001L;
        num2 = 2591L;
        key = new Key(num1, num2);
    }

    @AfterClass
    public void tearDown() {
        key = null;
    }

    @Test 
    public void getFirstNum() {
        assertTrue(key.getFirstNum() == num1);
    }
    
    @Test
    public void getSecondNum() {
        assertTrue(key.getSecondNum() == num2);
    }
}