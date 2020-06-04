package com.tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import com.company.GenerateKeys;
import com.company.Key;

import org.junit.Test;

public class GenerateKeysTest {

    @Test
    public void gcdExtended() {
        assertArrayEquals(GenerateKeys.gcdExtended(180L, 150L), new long[]{30L, 1L, -1L});
        assertArrayEquals(GenerateKeys.gcdExtended(18L, 668L), new long[]{2L, -37L, 1L});
        assertArrayEquals(GenerateKeys.gcdExtended(678L, 15L), new long[]{3L, 1L, -45L});
        assertArrayEquals(GenerateKeys.gcdExtended(747L, 56L), new long[]{1L, 3L, -40L});
        assertArrayEquals(GenerateKeys.gcdExtended(86L, 822L), new long[]{2L, -86L, 9L});
    }

    @Test
    public void inverseModule() {
        assertEquals(GenerateKeys.inverseModule(65537L, 9167368L), 4922825L);
        assertEquals(GenerateKeys.inverseModule(5537L, 91678L), 53563L);
        assertEquals(GenerateKeys.inverseModule(67L, 918L), 781L);
        assertEquals(GenerateKeys.inverseModule(65987L, 9168L), 3083L);
        assertEquals(GenerateKeys.inverseModule(37L, 68L), 57L);
    }

    @Test
    public void generateKeys() {
        final Key[] pairOfKeys = GenerateKeys.generateKeys(3557L, 2579L);
        assertEquals(65537L, pairOfKeys[0].getFirstNum());
        assertEquals(9173503L, pairOfKeys[0].getSecondNum());
        assertEquals(4922825L, pairOfKeys[1].getFirstNum());
        assertEquals(9173503L, pairOfKeys[1].getSecondNum());
    }
}