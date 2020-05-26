package com.company;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
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
               FileReader fileInput = new FileReader(fileInputString);
               Scanner scannerIn = new Scanner(fileInput);
               StringBuilder stringOfInput = new StringBuilder("");
               while (scannerIn.hasNextLine()) {
                   stringOfInput.append(scannerIn.nextLine());
               }
               fileInput.close();
               ArrayList <Byte> byteArray = new ArrayList<>();
               for (char elem : String.valueOf(stringOfInput).toCharArray()) {
                   byteArray.add((byte) elem);
               }
               ArrayList<Long> outputArray = AsymmetricCryptography.encrypt(byteArray, publicExponent, module);
               FileWriter fileOutput = new FileWriter(fileOutputString);
               for (long elem : outputArray) {
                   fileOutput.write(Long.toHexString(elem)+" ");
               }
               fileOutput.close();
               System.out.println("Done");
           } else if (definer == 'd') {
               String[] input = command.split(" ");
               long privateExponent = Long.parseLong(input[1]);
               long module = Long.parseLong(input[2]);
               String fileInputString = input[3];
               String fileOutputString = input[4];
               FileReader fileInput = new FileReader(fileInputString);
               Scanner scannerIn = new Scanner(fileInput);
               ArrayList<Long> longArray = new ArrayList<>();
               while (scannerIn.hasNextLine()) {
                   for (String s : scannerIn.nextLine().split(" ")) {
                       longArray.add(Long.parseLong(s, 16));
                   }
               }
               String outputString = AsymmetricCryptography.decrypt(longArray, privateExponent, module);
               FileWriter fileOutput = new FileWriter(fileOutputString);
               fileOutput.write(outputString);
               fileOutput.close();
               System.out.print("Done");
           } else if (definer == 'g') {
               String[] input = command.split(" ");
               long prime1 = Long.parseLong(input[1]);
               long prime2 = Long.parseLong(input[2]);
               Key[] pairOfKeys = GenerateKeys.generateKeys(prime1, prime2);
               System.out.println("Public key: {"+pairOfKeys[0].firstNum+", "+pairOfKeys[0].secondNum+"}");
               System.out.println("Private key: {"+pairOfKeys[1].firstNum+", "+pairOfKeys[1].secondNum+"}");
           } else if (definer == 'G') {
               long prime1 = 3557;
               long prime2 = 2579;
               Key[] pairOfKeys = GenerateKeys.generateKeys(prime1, prime2);
               System.out.println("Public key: {"+pairOfKeys[0].firstNum+", "+pairOfKeys[0].secondNum+"}");
               System.out.println("Private key: {"+pairOfKeys[1].firstNum+",  "+pairOfKeys[1].secondNum+"}");
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
                "Primes must be more than 1000 to make RSA more safer");
    }
}
