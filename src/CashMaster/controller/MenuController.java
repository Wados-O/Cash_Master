package CashMaster.controller;

import CashMaster.Sorts.SortsSource;
import CashMaster.model.Category;
import CashMaster.model.Record;
import CashMaster.service.RecordOperation;
import CashMaster.service.RecordsService;
import CashMaster.util.FileUtil;
import CashMaster.util.InputUtil;
import CashMaster.view.MenuButton;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class MenuController {

  static List<Record> records = FileUtil.getRecords();


  public static void mainMenu(Scanner sc) throws IOException, ParseException {
    boolean isRun = true;
    while (isRun) {
      System.out.println(MenuButton.SHOW_FIRST_MENU);
      RecordOperation.printList(records);
      int choice = InputUtil.readIntLimited(1, 5);

      switch (choice) {
        case 1:
          RecordOperation.createRecord(sc);
          break;
        case 2:
          RecordOperation.updateRecord(sc);
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
      }
    }
  }

  public static void sortRecords(Scanner sc) throws IOException, ParseException {
    while (true) {
      System.out.println(MenuButton.SHOW_SORT_MENU);
      RecordOperation.printList(records);
      int choice = sc.nextInt();
      switch (choice) {
        case 1:
          SortsSource.sortByCategory(records);
          break;
        case 2:
          SortsSource.sortByComment(records);
          break;
        case 3:
          SortsSource.sortByAmount(records);
          break;
        case 4:
          SortsSource.sortByDate(records);
          break;
        case 5:
          mainMenu(sc);
          break;
      }
    }

  }

}
