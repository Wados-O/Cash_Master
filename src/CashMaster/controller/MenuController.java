package CashMaster.controller;

import static CashMaster.view.MenuButton.EXIT_BUTTON;

import CashMaster.Comparators.AmountComparator;
import CashMaster.Comparators.CategoryComparator;
import CashMaster.Comparators.CommentComparator;
import CashMaster.Comparators.DateComparator;
import CashMaster.Comparators.IdComparator;
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
      int choice = InputUtil.readIntLimited(1, 6);

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
      int choice = InputUtil.readIntLimited(1, 6);
      switch (choice) {
        case 1:
        CategoryComparator.sortByCategory(records);
          break;
        case 2:
         CommentComparator.sortByComment(records);
          break;
        case 3:
          AmountComparator.sortByAmount(records);
          break;
        case 4:
         DateComparator.sortByDate(records);
          break;
        case 5:
          IdComparator.sortById(records);
          break;
        case 6:
          FileUtil.saveToFile(records);
          mainMenu(sc);
          break;
      }
    }

  }

}
