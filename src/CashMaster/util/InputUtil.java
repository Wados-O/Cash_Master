package CashMaster.util;

import static CashMaster.view.Colors.PURPLE;
import static CashMaster.view.Colors.RESET;

import java.util.Scanner;

public class InputUtil {
  /**
   * Reads an integer value from the console within a specified range.
   *
   * @param min The minimum acceptable integer value.
   * @param max The maximum acceptable integer value.
   * @return An integer value entered by the user within the specified range.
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
        System.out.printf("Please enter a number from %d to %d:", min, max);
        System.out.println(RESET);
      }
    } while (!(num >= min && num <= max));
    return num;
  }
  public static String readStringLimited(int min , int max){
    Scanner sc = new Scanner(System.in);
    String input;
    while (true){
      input = sc.nextLine();
      if (input.length() >= min && input.length() <= max ){
        break;
      }else {
        System.out.println(PURPLE);
        System.out.printf("Enter a string from %d to %d",min,max );
        System.out.println(RESET);
      }
    }
    return input;
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
