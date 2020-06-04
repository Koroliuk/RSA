package com.tests;

import com.company.Main;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class MainTest {
    // This class is a system test for program

    @Test
    public void qCommand() throws IOException {
        Assert.assertEquals(Main.executeCommand("q"), "Bye!");
    }

    @Test
    public void hCommand() throws IOException {
        String helpString;
        helpString = ("---- RSA ----\n" +
                "e <public exp> <mod> <file in> <file out> -- Encrypt file\n" +
                "d <private exp> <mod> <file in> <file out> -- Decrypt file\n" +
                "g <prime1> <prime2> -- Generate key pair from primes\n" +
                "G -- Generate key pair from default primes\n" +
                "h -- Help\n" +
                "q -- Exit\n" +
                "Primes must be more than 1000 to make RSA more safer");
        Assert.assertEquals(Main.executeCommand("h"), helpString);
    }

    @Test
    public void gCommandWithDefaultPrimes() throws IOException {
        String expectedResult;
        expectedResult = "Public key: {65537, 9173503}\n" +
                "Private key: {4922825, 9173503}";
        Assert.assertEquals(Main.executeCommand("G"), expectedResult);
    }

    @Test
    public void gCommandWithUserPrimes() throws IOException {
        String expectedResult;
        expectedResult = "Public key: {65537, 15096379}\n" +
                "Private key: {14301673, 15096379}";
        Assert.assertEquals(Main.executeCommand("g 4079 3701"), expectedResult);
    }

    @Test
    public void eCommand() throws IOException {
        Assert.assertEquals(Main.executeCommand("e 65537 9173503 test1.txt test2.txt"), "Done");
    }

    @Test
    public void dCommand() throws IOException {
        Assert.assertEquals(Main.executeCommand("d 4922825 9173503 test2.txt test3.txt"), "Done");
    }
}