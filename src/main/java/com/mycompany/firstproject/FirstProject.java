package com.mycompany.firstproject;
import java.util.Scanner;

public class FirstProject {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Username input and validation
        String name;
        System.out.print("Please enter your name (should contain an underscore and be more than 5 characters): ");
        name = sc.next();

        boolean isUsernameValid = false;  // Track if the username is valid

        if (name.length() > 5 && name.contains("_")) {
            System.out.println("Username successfully captured");
            isUsernameValid = true;
        } else {
            System.out.println("Username is not correctly formatted. Please ensure that your username contains an underscore and is more than 5 characters in length.");
        }

        // Password input and validation
        String password;
        System.out.print("Please enter your password (at least 8 characters, with a capital letter, a number, and a special character): ");
        password = sc.next();

        boolean isPasswordValid = validatePassword(password);  // Track if the password is valid

        if (isPasswordValid) {
            System.out.println("Password successfully captured");
        } else {
            System.out.println("Password is not correctly formatted. Please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
        }

        // Final login success or failure message
        if (isUsernameValid && isPasswordValid) {
            System.out.println("Logged in successfully");
        } else {
            System.out.println("Failed to log in");
        }

        sc.close(); // Closing scanner to avoid resource leak
    }

    // Password validation method
    public static boolean validatePassword(String password) {
        if (password.length() < 8) {
            return false; // Password should be at least 8 characters long
        }

        boolean hasUppercase = false;
        boolean hasNumber = false;
        boolean hasSpecialChar = false;

        // Define the special characters allowed
        String specialCharacters = "!@#$%^&*";

        // Loop through each character in the password
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (specialCharacters.contains(Character.toString(c))) {
                hasSpecialChar = true;
            }

            // If all conditions are met, return true
            if (hasUppercase && hasNumber && hasSpecialChar) {
                return true;
            }
        }

        // Return false if any condition is not met
        return false;
    }
}

    
        
    
    
