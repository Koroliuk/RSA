package com.company;

import java.util.ArrayList;

public class AsymmetricCryptography {

    public static ArrayList<Long> encrypt(ArrayList<Byte> byteArray, long publicExponent, long module) {
        ArrayList<Long> byteArrayOut = new ArrayList<>();
        for (byte elem : byteArray) {
            byteArrayOut.add(binPow(elem, publicExponent, module));
        }
        return byteArrayOut;
    }

    public static String decrypt(ArrayList<Long> longArray, long privateExponent, long module) {
        StringBuilder output = new StringBuilder("");
        for (int i = 0; i < longArray.size(); i++) {
            output.append((char) binPow(longArray.get(i), privateExponent, module));
        }
        return String.valueOf(output);
    }

    private static long binPow(long a, long n, long module) {
        if (n == 0)
            return 1;
        if (n % 2 == 1)
            return (binPow(a, n-1, module) * a) % module;
        else {
            long b = binPow(a, n/2, module);
            return (b * b) % module;
        }
    }
}
