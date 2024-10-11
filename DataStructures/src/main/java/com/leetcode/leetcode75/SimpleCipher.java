package com.leetcode.leetcode75;

public class SimpleCipher {
    public static String decrypt(String encryptedText, int k) {

        int ordA = 'A';
        int orda = 'a';
        StringBuilder output = new StringBuilder();
        for (char ch: encryptedText.toCharArray()) {
            if (Character.isDigit(ch)) {
                output.append((Character.getNumericValue(ch) + k) % 10);
            } else if (Character.isAlphabetic(ch)) {
                if (Character.isUpperCase(ch)) {
                    int temp = (ch - ordA - k + 26) % 26;
                    output.append((char) (ordA + temp));
                } else {
                    int temp = (ch - orda - k + 26) % 26;
                    output.append((char) (orda + temp));
                }
            } else {
                output.append(ch);
            }
        }
        return output.toString();

        /*StringBuilder decryptedText = new StringBuilder();

        // Loop through each character in the encrypted string
        for (char ch : encryptedText.toCharArray()) {
            // Find the 0-based index of the character ('A' = 0, 'B' = 1, ..., 'Z' = 25)
            int currentIndex = ch - 'A';

            // Decrypt by moving k steps counterclockwise (subtract k, and handle wrapping using modulo 26)
            int newIndex = (currentIndex - k + 26) % 26;

            // Convert the new index back to a character
            char decryptedChar = (char) ('A' + newIndex);

            // Append the decrypted character to the result
            decryptedText.append(decryptedChar);
        }

        return decryptedText.toString();*/
    }

    public static void main(String[] args) {
        // Example usage
        String encryptedText = "VGXGPU"; // Encrypted string
        int k = 12; // Counterclockwise shift value

        String decrypted = decrypt(encryptedText, k);
        System.out.println("Decrypted string: " + decrypted);
    }
}
