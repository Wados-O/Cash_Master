package CashMaster.controller;

import static CashMaster.util.InputUtil.readIntLimited;
import static CashMaster.view.MenuButton.EXIT_BUTTON;

import CashMaster.Sorts.SortAmount;
import CashMaster.Sorts.SortCategory;
import CashMaster.Sorts.SortComment;
import CashMaster.Sorts.SortDate;
import CashMaster.Sorts.SortId;
import CashMaster.model.Category;
import CashMaster.model.Record;
import CashMaster.service.RecordOperation;
import CashMaster.util.FileUtil;
import CashMaster.util.InputUtil;
import CashMaster.view.MenuButton;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class MenuController {

  static List<Record> records = FileUtil.getRecords();
  static List<Category> categories = Category.createCategories();


  public static void mainMenu(Scanner sc) throws IOException, ParseException {
    boolean isRun = true;
    while (isRun) {

      RecordOperation.printList(records);
      System.out.println(MenuButton.SHOW_FIRST_MENU);
    // RecordOperation.calcTotalAmount(records);
      RecordOperation.printIncome(records);
      System.out.println(EXIT_BUTTON);
      int choice = readIntLimited(1, 6);

      switch (choice) {
        case 1:
          RecordOperation.addRecord(records,categories);
          break;
        case 2:
          RecordOperation.editRecord(sc);
          break;
        case 3:
          RecordOperation.deleteRecord(records);
          //todo delete records
          break;
        case 4:
          //todo sort menu;
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
      System.out.println(MenuButton.SHOW_SORT_MENU);
      RecordOperation.printIncome(records);
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
