package com.tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.company.GenerateKeys;
import com.company.Key;

import org.junit.Test;

public class GenerateKeysTest {

    @Test
    public void gcdExtended() {
        assertArrayEquals(GenerateKeys.gcdExtended(180L, 150L), new long[]{30L, 1L, -1L});
    }

    @Test
    public void inverseModule() {
        assertEquals(GenerateKeys.inverseModule(65537L, 9167368L), 4992825L);
    }

    @Test
    public void generateKeys() {
        Key[] pairOfKeys = GenerateKeys.generateKeys(3557L, 2579L);
        assertTrue(pairOfKeys[0].getFirstNum() == 65537L);
        assertTrue(pairOfKeys[0].getSecondNum() == 9173503L);
        assertTrue(pairOfKeys[1].getFirstNum() == 4922825L);
        assertTrue(pairOfKeys[1].getSecondNum() == 9173503L);
    }
}