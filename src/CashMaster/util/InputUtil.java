package CashMaster.util;

import static CashMaster.view.Colors.PURPLE;
import static CashMaster.view.Colors.RESET;

import java.util.Scanner;

public class InputUtil {
  /**
   * check for invalid input only numbers
   *
   * @param min
   * @param max
   * @return
   */
  public static int readIntLimited(int min, int max) {
    Scanner sc = new Scanner(System.in);
    int num = 0;
    do {
      try {
        num = Integer.parseInt(sc.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Enter only numbers");
        System.out.println();
      }
      if (!(num >= min && num <= max)) {
        System.out.println(PURPLE);
        System.out.printf("Enter a number from %d to %d:", min, max);
        System.out.println(RESET);
      }
    } while (!(num >= min && num <= max));
    return num;
  }
  /**
   * Truncates a string to a specified maximum length.
   *
   * @param str       The input string to be truncated.
   * @param maxLength The maximum length to which the string should be truncated.
   * @return A truncated string with a length not exceeding maxLength. If the input
   *         string is already shorter than or equal to maxLength, it is returned as is.
   */
  public static String stringLength(String str,int maxLength){
    if (str.length()> maxLength){
      return str.substring(0,maxLength);
    }
    return str;
  }
}
