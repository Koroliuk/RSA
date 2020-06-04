package com.company;

import java.util.ArrayList;

public class AsymmetricCryptography {

    public static ArrayList<Long> encrypt(final ArrayList<Byte> byteArray, final long publicExponent,
            final long module) {
        final ArrayList<Long> byteArrayOut = new ArrayList<>();
        for (final byte elem : byteArray) {
            byteArrayOut.add(binPow(elem, publicExponent, module));
        }
        return byteArrayOut;
    }

    public static String decrypt(final ArrayList<Long> longArray, final long privateExponent, final long module) {
        final StringBuilder output = new StringBuilder("");
        for (final Long aLong : longArray) {
            output.append((char) binPow(aLong, privateExponent, module));
        }
        return String.valueOf(output);
    }

    public static long binPow(final long a, final long n, final long module) {
        if (n == 0)
            return 1;
        if (n % 2 == 1)
            return (binPow(a, n - 1, module) * a) % module;
        else {
            final long b = binPow(a, n / 2, module);
            return (b * b) % module;
        }
    }
}