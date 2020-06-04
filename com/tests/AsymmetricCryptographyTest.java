package com.tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import com.company.AsymmetricCryptography;

import org.junit.BeforeClass;
import org.junit.Test;

public class AsymmetricCryptographyTest {
    private final ArrayList<Byte> byteArray = new ArrayList<>();
    private final ArrayList<Long> longArray = new ArrayList<>();
    final String stringOfInput = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";


    @BeforeClass
    public void createTestData() {
        for (final char elem : String.valueOf(stringOfInput).toCharArray()) {
            byteArray.add((byte) elem);
        }
        final StringBuilder stringOfOutput = new StringBuilder();
        stringOfOutput.append("1e5f8 47bce 87b40 71ae3 33103 62cff 636c0 ");
        stringOfOutput.append("817ed c58c6 9cd2c 33103 62cff a5f1c 47bce ");
        stringOfOutput.append("59466 47bce 87b40 62cff c58c6 636c0 7f595 ");
        stringOfOutput.append("62cff a325e 33103 71ae3 7f595 1ceb6 62cff ");
        stringOfOutput.append("64cd4 47bce 66bb1 c58c6 71ae3 64cd4 7f595 ");
        stringOfOutput.append("71ae3 7f595 9cd2c 87b40 62cff a325e a5f1c ");
        stringOfOutput.append("636c0 817ed 636c0 c58c6 64cd4 636c0 66bb1 ");
        stringOfOutput.append("44956 62cff 71ae3 59466 636c0 7f595 1595b ");
        for (final String elem : String.valueOf(stringOfOutput).split(" ")) {
            longArray.add(Long.parseLong(elem, 16));
        }
    }
    
    @Test
    public void binPow() {
        assertTrue(AsymmetricCryptography.binPow(5L, 13L, 122255L) == 109205L);
    }

    @Test
    public void encrypt() {
        assertTrue(AsymmetricCryptography.encrypt(byteArray, 65537L, 9173503L) == longArray);
    }

    @Test 
    public void decrypt() {
        assertTrue(AsymmetricCryptography.decrypt(longArray, 4922825L, 9173503L) == stringOfInput);
    }
}