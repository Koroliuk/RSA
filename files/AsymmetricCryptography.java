package com.company;

public class AsymmetricCryptography {
	public static ArrayList<Long> encrypt(ArrayList<Byte> byteArray, long publicExponent, long module) {
        ArrayList<Long> byteArrayOut = new ArrayList<>();
        for (byte elem : byteArray) {
            byteArrayOut.add(binPow((long) elem, publicExponent, module));
        }
        return byteArrayOut;
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
