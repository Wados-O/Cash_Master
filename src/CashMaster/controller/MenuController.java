package CashMaster.controller;

import CashMaster.service.RecordOperation;
import CashMaster.service.RecordsService;
import CashMaster.util.InputUtil;
import CashMaster.view.MenuButton;
import java.util.Scanner;

public class MenuController {

  public static void mainMenu(Scanner sc) {
    boolean isRun = true;
    while (true) {
      System.out.println(MenuButton.SHOW_FIRST_MENU);
      int choice = InputUtil.readIntLimited(1, 5);

      switch (choice) {
        case 1:
          RecordOperation.createRecord(sc);
          break;
        case 2:
          break;
        case 3:
          break;
        case 4:
          break;
        case 5:
          break;
      }
    }
  }

  public static void sortRecords() {

  }

}
