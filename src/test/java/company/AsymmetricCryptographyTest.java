package company;


import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AsymmetricCryptographyTest {

    private static final ArrayList<Byte> byteArray = new ArrayList<>();
    private static final ArrayList<Long> longArrayExpected = new ArrayList<>();
    private static final String stringOfInput = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";


    @BeforeClass
    public static void createTestData() {
        for (final char elem : stringOfInput.toCharArray()) {
            byteArray.add((byte) elem);
        }
        final StringBuilder stringOfOutput = new StringBuilder();
        stringOfOutput.append("204a38 4a2ecf 8752f1 5610ef 387aff 1f38ef ");
        stringOfOutput.append("3c73ec 32292b 6fb1dc 12eb29 387aff 1f38ef ");
        stringOfOutput.append("75a9c2 4a2ecf 294eca 4a2ecf 8752f1 1f38ef ");
        stringOfOutput.append("6fb1dc 3c73ec 771548 1f38ef 353ce6 387aff ");
        stringOfOutput.append("5610ef 771548 36ed4b 1f38ef 50386 4a2ecf ");
        stringOfOutput.append("dded5 6fb1dc 5610ef 50386 771548 5610ef ");
        stringOfOutput.append("771548 12eb29 8752f1 1f38ef 353ce6 75a9c2 ");
        stringOfOutput.append("3c73ec 32292b 3c73ec 6fb1dc 50386 3c73ec dded5 ");
        stringOfOutput.append("692027 1f38ef 5610ef 294eca 3c73ec 771548 1f5bd5 ");
        for (final String elem : String.valueOf(stringOfOutput).split(" ")) {
            longArrayExpected.add(Long.parseLong(elem, 16));
        }
    }

    @Test
    public void binPow() {
        assertEquals(109205L, AsymmetricCryptography.binPow(5L, 13L, 122255L));
        assertEquals(1026L, AsymmetricCryptography.binPow(3L, 16L, 2255L));
        assertEquals(3495L, AsymmetricCryptography.binPow(7L, 9L, 6743L));
        assertEquals(1949L, AsymmetricCryptography.binPow(18L, 6L, 5675L));
        assertEquals(1L, AsymmetricCryptography.binPow(2L, 24L, 85L));
    }

    @Test
    public void encrypt() {
        ArrayList<Long> longArrayActual = AsymmetricCryptography.encrypt(byteArray, 65537L, 9173503L);
        for (int i = 0; i < longArrayActual.size(); i++) {
            assertEquals(longArrayActual.get(i), longArrayExpected.get(i));
        }
    }

    @Test
    public void decrypt() {
        assertEquals(AsymmetricCryptography.decrypt(longArrayExpected, 4922825L, 9173503L), stringOfInput);
    }
}