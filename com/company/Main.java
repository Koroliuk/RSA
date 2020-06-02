package com.company;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(final String[] args) throws IOException {
        final Scanner scanner = new Scanner(System.in);
        while (true) {
            final String command = scanner.nextLine();
            final char definer = command.charAt(0);
            if (definer == 'q') {
                System.out.println("Bye!");
                scanner.close();
                break;
            } else if (definer == 'e') {
                final String[] input = command.split(" ");
                final long publicExponent = Long.parseLong(input[1]);
                final long module = Long.parseLong(input[2]);
                final String fileInputString = input[3];
                final String fileOutputString = input[4];
                final FileReader fileInput = new FileReader(fileInputString);
                final Scanner scannerIn = new Scanner(fileInput);
                final StringBuilder stringOfInput = new StringBuilder();
                while (scannerIn.hasNextLine()) {
                    stringOfInput.append(scannerIn.nextLine());
                }
                scannerIn.close();
                fileInput.close();
                final ArrayList<Byte> byteArray = new ArrayList<>();
                for (final char elem : String.valueOf(stringOfInput).toCharArray()) {
                    byteArray.add((byte) elem);
                }
                final ArrayList<Long> outputArray = AsymmetricCryptography.encrypt(byteArray, publicExponent, module);
                final FileWriter fileOutput = new FileWriter(fileOutputString);
                for (final long elem : outputArray) {
                    fileOutput.write(Long.toHexString(elem) + " ");
                }
                fileOutput.close();
                System.out.println("Done");
            } else if (definer == 'd') {
                final String[] input = command.split(" ");
                final long privateExponent = Long.parseLong(input[1]);
                final long module = Long.parseLong(input[2]);
                final String fileInputString = input[3];
                final String fileOutputString = input[4];
                final FileReader fileInput = new FileReader(fileInputString);
                final Scanner scannerIn = new Scanner(fileInput);
                final ArrayList<Long> longArray = new ArrayList<>();
                while (scannerIn.hasNextLine()) {
                    for (final String s : scannerIn.nextLine().split(" ")) {
                        longArray.add(Long.parseLong(s, 16));
                    }
                }
                scannerIn.close();
                final String outputString = AsymmetricCryptography.decrypt(longArray, privateExponent, module);
                final FileWriter fileOutput = new FileWriter(fileOutputString);
                fileOutput.write(outputString);
                fileOutput.close();
                System.out.println("Done");
            } else if (definer == 'g') {
                final String[] input = command.split(" ");
                final long prime1 = Long.parseLong(input[1]);
                final long prime2 = Long.parseLong(input[2]);
                final Key[] pairOfKeys = GenerateKeys.generateKeys(prime1, prime2);
                System.out.println("Public key: {" + pairOfKeys[0].getFirstNum() + ", " + pairOfKeys[0].getSecondNum() + "}");
                System.out.println("Private key: {" + pairOfKeys[1].getFirstNum() + ", " + pairOfKeys[1].getSecondNum() + "}");
            } else if (definer == 'G') {
                final long prime1 = 3557;
                final long prime2 = 2579;
                final Key[] pairOfKeys = GenerateKeys.generateKeys(prime1, prime2);
                System.out.println("Public key: {" + pairOfKeys[0].getFirstNum() + ", " + pairOfKeys[0].getSecondNum() + "}");
                System.out.println("Private key: {" + pairOfKeys[1].getFirstNum() + ",  " + pairOfKeys[1].getSecondNum() + "}");
            } else if (definer == 'h') {
                helpMessage();
            } else {
                System.out.println("Type h to know more");
            }
        }
    }

    private static void helpMessage() {
        System.out.print("---- RSA ----\n" +
                "e <public exp> <mod> <file in> <file out> -- Encrypt file\n" +
                "d <private exp> <mod> <file in> <file out> -- Decrypt file\n" +
                "g <prime1> <prime2> -- Generate key pair from primes\n" +
                "G -- Generate key pair from default primes\n" +
                "h -- Help\n" +
                "q -- Exit\n" +
                "Primes must be more than 1000 to make RSA more safer\n");
    }
}