package CashMaster.util;

import static CashMaster.view.Colors.PURPLE;
import static CashMaster.view.Colors.RESET;

import java.util.Scanner;

public class InputUtil {
  /**
   * проверка неправильного ввода только цифры
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
        System.out.println("Вводите только цифры");
        System.out.println();
      }
      if (!(num >= min && num <= max)) {
        System.out.println(PURPLE);
        System.out.printf("Введите число от %d до %d:", min, max);
        System.out.println(RESET);
      }
    } while (!(num >= min && num <= max));
    return num;
  }

}
