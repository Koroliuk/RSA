package com.company;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
           String command = scanner.nextLine();
           char definer = command.charAt(0);
           if (definer == 'q') {
               System.out.println("Bye!");
               break;
           } else if (definer == 'e') {
               String[] input = command.split(" ");
               long publicExponent = Long.parseLong(input[1]);
               long module = Long.parseLong(input[2]);
               String fileInputString = input[3];
               String fileOutputString = input[4];
               FileInputStream fileInput = new FileInputStream(fileInputString);
               BufferedInputStream fin = new BufferedInputStream(fileInput);
           } else if (definer == 'd') {
               System.out.print("d");
           } else if (definer == 'g') {
               String[] input = command.split(" ");
               long prime1 = Long.parseLong(input[1]);
               long prime2 = Long.parseLong(input[2]);
               Key[] pairOfKeys = GenerateKeys.generateKeys(prime1, prime2);
               System.out.println("Public key: {"+pairOfKeys[0].firstNum+" "+pairOfKeys[0].secondNum+"}");
               System.out.println("Private key: {"+pairOfKeys[1].firstNum+" "+pairOfKeys[1].secondNum+"}");
           } else if (definer == 'G') {
               long prime1 = 3557;
               long prime2 = 2579;
               Key[] pairOfKeys = GenerateKeys.generateKeys(prime1, prime2);
               System.out.println("Public key: {"+pairOfKeys[0].firstNum+" "+pairOfKeys[0].secondNum+"}");
               System.out.println("Private key: {"+pairOfKeys[1].firstNum+" "+pairOfKeys[1].secondNum+"}");
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
                "h -- Help\n" +
                "q -- Exit\n");
    }
}
