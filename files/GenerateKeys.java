package com.company;

public class GenerateKeys {

    public static Key[] generateKeys(long prime1, long prime2) {
        long module = prime1*prime2;
        long phi = (prime1-1L)*(prime2-1L);
        long publicExponent = 65537L; // One of Fermat prime numbers
        long secretExponent = inverseModule(publicExponent, phi);
        Key[] pairOfKeys = new Key[2];
        pairOfKeys[0] = new Key(publicExponent, module);
        pairOfKeys[1] = new Key(secretExponent, module);
        return pairOfKeys;
    }

    private static long inverseModule(long num, long module) {
        long[] result = gcdExtended(num, module);
        long x = result[1];
        return (x % module+module)%module;
    }

    private static long[] gcdExtended(long a, long b) {
        if (a == 0L) {
            return new long[]{b, 0L, 1L};
        }
        long[] result = gcdExtended(b%a, a);
        long d = result[0];
        long x1 = result[1];
        long y1 = result[2];
        long x = y1-(b/a)*x1;
        long y = x1;
        return new long[]{d, x, y};
    }
}
