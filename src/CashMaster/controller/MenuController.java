package CashMaster.controller;

import static CashMaster.util.InputUtil.readIntLimited;
import static CashMaster.view.MenuButton.EXIT_BUTTON;
import static CashMaster.view.MenuButton.SHOW_FINANCE;

import CashMaster.Sorts.SortAmount;
import CashMaster.Sorts.SortCategory;
import CashMaster.Sorts.SortComment;
import CashMaster.Sorts.SortDate;
import CashMaster.Sorts.SortId;
import CashMaster.model.Record;
import CashMaster.service.RecordOperation;
import CashMaster.util.FileUtil;
import CashMaster.view.MenuButton;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class MenuController {

  static List<Record> records = FileUtil.getRecords();

  /**
   * Displays the main menu of the application and handles user input to perform corresponding operations.
   *
   * @param sc A Scanner object for user input.
   * @throws IOException If there is an I/O error while reading or writing data.
   * @throws ParseException If there is an error in parsing date input.
   */
  public static void mainMenu(Scanner sc) throws IOException, ParseException {
    boolean isRun = true;
    while (isRun) {

      RecordOperation.printList(records);
      System.out.println();
      System.out.println(MenuButton.SHOW_FIRST_MENU);
      System.out.println();
      System.out.println(SHOW_FINANCE);
      System.out.println();
      System.out.println(EXIT_BUTTON);
      System.out.println();
      int choice = readIntLimited(1, 6);

      switch (choice) {
        case 1:
          RecordOperation.addRecord(records);
          break;
        case 2:
          RecordOperation.editRecord(sc);
          break;
        case 3:
          RecordOperation.deleteRecord(records);
          break;
        case 4:
          sortRecords(sc);
          break;
        case 5:
          FileUtil.saveToFile(records);
          break;
        case 6:
          FileUtil.saveToFile(records);
          System.exit(0);
          break;
      }
    }
  }

  public static void sortRecords(Scanner sc) throws IOException, ParseException {

    while (true) {
      RecordOperation.printList(records);
      System.out.println();
      System.out.println(MenuButton.SHOW_SORT_MENU);
      System.out.println();
      System.out.println(SHOW_FINANCE);
      System.out.println();
      System.out.println(EXIT_BUTTON);
      int choice = readIntLimited(1, 6);
      switch (choice) {
        case 1:
        SortCategory.sortByCategory(records);
          break;
        case 2:
         SortComment.sortByComment(records);
          break;
        case 3:
          SortAmount.sortByAmount(records);
          break;
        case 4:
         SortDate.sortByDate(records);
          break;
        case 5:
          SortId.sortById(records);
          break;
        case 6:
          FileUtil.saveToFile(records);
          mainMenu(sc);
          break;
      }
    }

  }

}
