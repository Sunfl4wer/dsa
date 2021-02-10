package chapter3;

import javax.swing.*;

public class CaesarCipher {
  protected char[] encoder = new char[26];
  protected char[] decoder = new char[26];

  public CaesarCipher(final int rotation) {
    for (int i = 0; i < 26; i++) {
      encoder[i] = (char) ('A' + (i + rotation) % 26);
      decoder[i] = (char) ('A' + (i - rotation + 26) % 26);
    }
  }

  public String encrypt(final String message) {
    return transform(message, encoder);
  }

  public String decrypt(final String secret) {
    return transform(secret, decoder);
  }

  private String transform(final String text,
                           final char[] code) {
    char[] message = text.toCharArray();
    for (int i = 0; i < message.length; i++) {
      if (Character.isUpperCase(message[i])) {
        int j = message[i] - 'A';
        message[i] = code[j];
      }
    }
    return new String(message);
  }

  public static void main(final String[] args) {
    CaesarCipher cipher = new CaesarCipher(3);
    System.out.println("Encryption code = " + new String(cipher.encoder));
    System.out.println("Decryption code = " + new String(cipher.decoder));
    String message = "THIS IS AN EXAMPLE MESSAGE; THE WEATHER IS NICE TODAY.";
    String coded = cipher.encrypt(message);
    System.out.println("Secret: " + coded);
    String decoded = cipher.decrypt(coded);
    System.out.println("Message: " + decoded);
  }
}
