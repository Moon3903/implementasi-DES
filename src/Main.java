import java.util.Scanner;

public class Main {
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_RESET = "\u001B[0m";

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int input;
    StringBuilder plaintext;
    String key;

    Des cipher = new Des();

    while (true) {
      System.out.println("Menu: \n" +
          "1. Enkripsi DES\n" +
          "2. Dekripsi DES\n" +
          "3. Enkripsi Triple DES\n" +
          "4. Dekripsi Triple DES\n" +
          "0. Exit");
      input = scan.nextInt();
      if (input == 1) {
        scan.nextLine();
        System.out.println("Masukan plain text");
        plaintext = new StringBuilder(scan.nextLine());
        System.out.println("Masukan kunci (16 digit hexadecimal)");
        key = scan.nextLine();

        StringBuilder result = new StringBuilder();

        while (plaintext.length() % 8 != 0) {
          plaintext.append('\t');
        }

        for (String i : plaintext.toString().split("(?<=\\G........)")) {
          System.out.println("encrypting " + i);
          result.append(cipher.encrypt(i, key));
        }

        System.out.println("cipher: " + ANSI_RED + result + ANSI_RESET);
        System.out.println("Masukan apapun untuk melanjutkan");
        scan.nextLine();
      } else if (input == 2) {
        scan.nextLine();
        System.out.println("Masukan cipher text");
        plaintext = new StringBuilder(scan.nextLine());
        System.out.println("Masukan kunci (16 digit hexadecimal)");
        key = scan.nextLine();

        StringBuilder result = new StringBuilder();

        for (String i : plaintext.toString().split("(?<=\\G................)")) {
          result.append(cipher.decrypt(i, key));
        }

        System.out.println("plain text: " + ANSI_RED + result.toString().replaceAll("\t","") + ANSI_RESET);
        System.out.println("Masukan apapun untuk melanjutkan");
        scan.nextLine();
      } else if (input == 3) {
        scan.nextLine();
        System.out.println("Masukan plain text");
        plaintext = new StringBuilder(scan.nextLine());

        String key1, key2;

        System.out.println("Masukan kunci 1 (16 digit hexadecimal)");
        key1 = scan.nextLine();
        System.out.println("Masukan kunci 2 (16 digit hexadecimal)");
        key2 = scan.nextLine();

        StringBuilder result = new StringBuilder();

        while (plaintext.length() % 8 != 0) {
          plaintext.append('\t');
        }

        for (String i : plaintext.toString().split("(?<=\\G........)")) {
          System.out.println("encrypting " + i);
          result.append(cipher.tripleDesEncrypt(i, key1, key2));
        }
        System.out.println("cipher: " + ANSI_RED + result + ANSI_RESET);
        System.out.println("Masukan apapun untuk melanjutkan");
        scan.nextLine();
      } else if (input == 4) {
        scan.nextLine();
        System.out.println("Masukan cipher text");
        plaintext = new StringBuilder(scan.nextLine());

        String key1, key2;

        System.out.println("Masukan kunci 1 (16 digit hexadecimal)");
        key1 = scan.nextLine();
        System.out.println("Masukan kunci 2 (16 digit hexadecimal)");
        key2 = scan.nextLine();

        StringBuilder result = new StringBuilder();

        for (String i : plaintext.toString().split("(?<=\\G................)")) {
          result.append(cipher.tripleDesDecrypt(i, key1, key2));
        }

        System.out.println("plain text: " + ANSI_RED + result.toString().replaceAll("\t","") + ANSI_RESET);
        System.out.println("Masukan apapun untuk melanjutkan");
        scan.nextLine();
      } else {
        break;
      }
    }
//    INIBUATTESTINK
//    AABB0918AABB0918
//    BB0918AABB0918BB
  }
}