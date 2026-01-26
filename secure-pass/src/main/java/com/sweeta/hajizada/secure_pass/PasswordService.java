package com.sweeta.hajizada.secure_pass;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import org.springframework.stereotype.Service;

/**
 * service class responsible for password security analysis.
 * this class handles the business logic for evaluating password complexity.
 */
@Service
public class PasswordService {

    /**
     * Analyzes the strength of a given password based on length and complexity.
     *
     * @param password the plain-text password to evaluate.
     * @return A string indicating the strength level(WEAK, MEDIUM, STRONG).
     */
    public String checkStrength(String password) {
        if (password == null || password.isEmpty()) return "No password provided";

        int score = 0;

        // 1. Length Check: Standard security practice requires at least 8 characters.
        if (password.length() >= 8) score++;
        if (password.length() >= 12) score++;

        // 2. Complexity Check (Does it contain a digit?) using Regex.
        if (password.matches(".*\\d.*")) score++;

        // 3. Special Character Check
        if (password.matches(".*[!@#$%^&*].*")) score++;

        // Return a label based on the score
        if (score < 2) return "WEAK";
        if (score < 4) return "MEDIUM";
        return "STRONG";
    }

    /**
     * Converts a plain-text password into a SHA-1 Hash.
     * Cyber Concept: One-way Hashing for Secure Data Comparison.
     */
    public String convertToSha1(String password) {
        try {
            // MessageDigest is a built-in Java tool for creating hashes
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            byte[] hashBytes = digest.digest(password.getBytes());

            // Convert the byte array into a readable Hexadecimal String (all caps)
            return HexFormat.of().withUpperCase().formatHex(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-1 Algorithm not found", e);
        }
    }
}