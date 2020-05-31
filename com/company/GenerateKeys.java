package com.company;

public class GenerateKeys {

    public static Key[] generateKeys(final long prime1, final long prime2) {
        final long module = prime1 * prime2;
        final long phi = (prime1 - 1L) * (prime2 - 1L);
        final long publicExponent = 65537L; // One of Fermat prime numbers
        final long secretExponent = inverseModule(publicExponent, phi);
        final Key[] pairOfKeys = new Key[2];
        pairOfKeys[0] = new Key(publicExponent, module);
        pairOfKeys[1] = new Key(secretExponent, module);
        return pairOfKeys;
    }

    private static long inverseModule(final long num, final long module) {
        final long[] result = gcdExtended(num, module);
        final long x = result[1];
        return (x % module + module) % module;
    }

    private static long[] gcdExtended(final long a, final long b) {
        if (a == 0L) {
            return new long[] { b, 0L, 1L };
        }
        final long[] result = gcdExtended(b % a, a);
        final long d = result[0];
        final long x1 = result[1];
        final long y1 = result[2];
        final long x = y1 - (b / a) * x1;
        return new long[]{d, x, x1};
    }
}
