import java.util.Scanner;

public class DesController {
  private static final String ANSI_RED = "\u001B[31m";
  private static final String ANSI_GREEN = "\033[0;32m";
  private static final String ANSI_RESET = "\u001B[0m";
  private static final String KEY = "AABB0918AABB0918";

  Des cipher = new Des();

  public String encrypDes(StringBuilder plaintext) {
    StringBuilder result = new StringBuilder();

    while (plaintext.length() % 8 != 0) {
      plaintext.append('\t');
    }

    for (String i : plaintext.toString().split("(?<=\\G........)")) {
      System.out.println("encrypting " + i);
      result.append(cipher.encrypt(i, KEY));
    }

    return result.toString();
  }

  public String decryptDes(StringBuilder plaintext) {
    StringBuilder result = new StringBuilder();

    for (String i : plaintext.toString().split("(?<=\\G................)")) {
      result.append(cipher.decrypt(i, KEY));
    }

    return ANSI_GREEN + result.toString().replaceAll("\t","") + ANSI_RESET;
  }
}
