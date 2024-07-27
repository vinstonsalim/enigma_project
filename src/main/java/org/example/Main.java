package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Rotors Configurations (Left, Middle, Right)? ");
            String input2 = reader.readLine();
            Character[] configurations = input2.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
            EnigmaMachine enigmaMachine = new EnigmaMachine(configurations);


            System.out.print("Enter text to encrypt/decrypt: ");
            String inputText = reader.readLine();
            StringBuilder result = new StringBuilder();

            for (char c : inputText.toCharArray()) {
                if(c == ' ')
                {
                    result.append(" ");
                    continue;
                }

                result.append(enigmaMachine.encrypt(c));
            }

            System.out.println("Result: " + result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}