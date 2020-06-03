package com.tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import com.company.AsymmetricCryptography;

import org.junit.Test;

public class AsymmetricCryptographyTest {
    
    @Test
    public void binPow() {
        assertTrue(AsymmetricCryptography.binPow(5L, 13L, 122255L) == 109205L);
    }

    @Test
    public void encrypt() {
        String stringOfInput = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";
        ArrayList<Byte> byteArray = new ArrayList<>();
        for (char elem : String.valueOf(stringOfInput).toCharArray()) {
            byteArray.add((byte) elem);
        }
        ArrayList<Long> byteArrayOut = new ArrayList<>();
        StringBuilder stringOfOutput = new StringBuilder();
        stringOfOutput.append("1e5f8 47bce 87b40 71ae3 33103 62cff 636c0 ");
        stringOfOutput.append("817ed c58c6 9cd2c 33103 62cff a5f1c 47bce ");
        stringOfOutput.append("59466 47bce 87b40 62cff c58c6 636c0 7f595 ");
        stringOfOutput.append("62cff a325e 33103 71ae3 7f595 1ceb6 62cff ");
        stringOfOutput.append("64cd4 47bce 66bb1 c58c6 71ae3 64cd4 7f595 ");
        stringOfOutput.append("71ae3 7f595 9cd2c 87b40 62cff a325e a5f1c ");
        stringOfOutput.append("636c0 817ed 636c0 c58c6 64cd4 636c0 66bb1 ");
        stringOfOutput.append("44956 62cff 71ae3 59466 636c0 7f595 1595b ");
        for (String elem : String.valueOf(stringOfOutput).split(" ")) {
            byteArrayOut.add(Long.parseLong(elem, 16));
        }
        assertTrue(AsymmetricCryptography.encrypt(byteArray, 65537L, 9173503L) == byteArrayOut);
    }
}