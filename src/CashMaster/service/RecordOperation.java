package CashMaster.service;

import static CashMaster.view.Colors.RESET;
import static CashMaster.view.MenuButton.INCOME_OR_EXP;
import static CashMaster.view.PrintTable.FOOTER;
import static CashMaster.view.PrintTable.HEADER;
import static CashMaster.view.PrintTable.MIDDLE;

import CashMaster.model.CategoryExpenses;
import CashMaster.model.CategoryIncome;
import CashMaster.model.Record;
import CashMaster.util.DateUtil;
import CashMaster.util.FileUtil;
import CashMaster.util.InputUtil;
import CashMaster.view.Colors;
import CashMaster.view.MenuButton;
import CashMaster.view.PrintTable;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RecordOperation {
  static List<Record> records = FileUtil.getRecords();
  static Record record = new Record();

  /**
   * Adds a new financial record to the list of records and saves it to a file.
   *
   * @throws IOException    If there is an issue with file operations.
   * @throws ParseException If there is an issue with parsing date input.
   */
  public static void addRecord(List<Record> records) throws IOException, ParseException {
    Scanner sc = new Scanner(System.in);
    DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    Calendar today = Calendar.getInstance();
    Date currentDate = today.getTime();
    Date stDate = currentDate;

    String incomeCategory = "INCOME";
    boolean income = false;
    int multiply = 1;
    int id = Record.getNewId(records);

    System.out.println("RECORD ID: " + id);
    System.out.println(INCOME_OR_EXP);
    String incOrExp = sc.nextLine();
    if (incOrExp.equalsIgnoreCase("1")) {
      income = true;
    }

    if (!income) {
      for (CategoryExpenses category : CategoryExpenses.values()) {
        System.out.println(category.getNum() + " " + category.getTitle());
      }
      System.out.print("Choose category from list (1-11): ");
      int cat = Integer.parseInt(sc.nextLine());
      incomeCategory = CategoryExpenses.values()[cat - 1].getTitle();
    } else {
      for (CategoryIncome category : CategoryIncome.values()) {
        System.out.println(category.getNum() + " " + category.getTitle());
      }
      System.out.print("Choose category from list (1-9): ");
      int cat = Integer.parseInt(sc.nextLine());
      incomeCategory = CategoryIncome.values()[cat - 1].getTitle();
    }

    System.out.println("Enter comment:");
    String comment = sc.nextLine();

    System.out.println("Input amount:");
    double amount = Double.parseDouble(sc.nextLine());

    System.out.println("Current date: " + dateFormat.format(currentDate));
    System.out.print("Input Date or 'ENTER' for current date (dd.MM.yyyy): ");
    String startDate = sc.nextLine();
    if (!startDate.isEmpty()) {
      try {
        stDate = dateFormat.parse(startDate);
      } catch (ParseException e) {
        System.out.println("Invalid date format. Please use dd.MM.yyyy format.");
        return;
      }
    }

    Record record = new Record();
    record.setId(id);
    record.setCategory(incomeCategory);
    record.setComment(comment);
    if (!income) {
      amount *= -1;
    }
    amount *= multiply;
    record.setAmount(amount);
    record.setDate(stDate);
    records.add(record);
    FileUtil.saveToFile(records);
  }



  /**
   * Prints a list of financial records in a tabular format to the console.
   */
  public static void printList(List<Record> records) {
    PrintTable.cleanConsole();

    System.out.println(HEADER);
    for (int i = 0; i < records.size(); i++) {
      Record record = records.get(i);
      String comment = InputUtil.stringLength(record.getComment(), 31);
      String recordRow = String.format("│%-6d│%-29s│%-41s│%-30s│%-28s│",
          record.getId(),
          record.getCategory(),
          comment,
          record.getAmount(),
          DateUtil.parseDateStr(record.getDate()));

      System.out.println(recordRow);
      System.out.println(MIDDLE);
    }
    System.out.println(FOOTER);
  }


  public static void editRecord(List<Record> records) throws ParseException {
    Scanner sc = new Scanner(System.in);
    System.out.println("Edit record:");

    System.out.print("Enter id of record: ");
    int recordId = sc.nextInt();
    sc.nextLine(); // consume newline

    Record recordToUpdate = null;
    int indexToUpdate = -1;

    for (int i = 0; i < records.size(); i++) {
      if (records.get(i).getId() == recordId) {
        recordToUpdate = records.get(i);
        indexToUpdate = i;
        break;
      }
    }

    if (recordToUpdate == null) {
      System.out.println("Not found record.");
      return;
    }

    System.out.println("Current record:");
    System.out.println("Category: " + recordToUpdate.getCategory());
    System.out.println("Comment: " + recordToUpdate.getComment());
    System.out.println("Amount: " + recordToUpdate.getAmount());
    System.out.println("Date: " + new SimpleDateFormat("dd.MM.yyyy").format(recordToUpdate.getDate()));

    System.out.println("Select what you want to edit:");
    System.out.println("1. Category");
    System.out.println("2. Comment");
    System.out.println("3. Amount");
    System.out.println("4. Date");
    System.out.print("Enter your choice (1-4): ");
    int choice = sc.nextInt();
    sc.nextLine(); // consume newline

    switch (choice) {
      case 1:
        System.out.println("Is it an income or an expense? (1 for income, 2 for expense): ");
        int incomeOrExpense = sc.nextInt();
        sc.nextLine(); // consume newline

        if (incomeOrExpense == 1) {
          // Income category
          System.out.println("Available income categories:");
          String[] incomeCategoryTitles = getCategoryTitles(CategoryIncome.values());

          for (int i = 0; i < incomeCategoryTitles.length; i++) {
            System.out.println((i + 1) + " " + incomeCategoryTitles[i]);
          }
          System.out.print("Choose income category from list (1-" + incomeCategoryTitles.length + "): ");
          int incomeCat = Integer.parseInt(sc.nextLine());
          String newIncomeCategory = incomeCategoryTitles[incomeCat - 1];
          recordToUpdate.setCategory(newIncomeCategory);
        } else if (incomeOrExpense == 2) {
          // Expense category
          System.out.println("Available expense categories:");
          String[] expenseCategoryTitles = getCategoryTitles(CategoryExpenses.values());

          for (int i = 0; i < expenseCategoryTitles.length; i++) {
            System.out.println((i + 1) + " " + expenseCategoryTitles[i]);
          }
          System.out.print("Choose expense category from list (1-" + expenseCategoryTitles.length + "): ");
          int expenseCat = Integer.parseInt(sc.nextLine());
          String newExpenseCategory = expenseCategoryTitles[expenseCat - 1];
          recordToUpdate.setCategory(newExpenseCategory);
        } else {
          System.out.println("Invalid choice.");
          return;
        }
        break;
      case 2:
        System.out.print("Enter new comment: ");
        String newComment = sc.nextLine();
        recordToUpdate.setComment(newComment);
        break;
      case 3:
        System.out.print("Enter new amount: ");
        double newAmount = sc.nextDouble();
        sc.nextLine(); // consume newline
        recordToUpdate.setAmount(newAmount);
        break;
      case 4:
        System.out.print("Enter new date (dd.MM.yyyy): ");
        String newDateStr = sc.nextLine();
        Date newDate = DateUtil.parseStrToDate(newDateStr);
        if (newDate != null) {
          recordToUpdate.setDate(newDate);
        } else {
          System.out.println("Invalid date format. No changes were made.");
          return;
        }
        break;
      default:
        System.out.println("Invalid choice.");
        return;
    }

    records.set(indexToUpdate, recordToUpdate);
    System.out.println("Record was changed.");
  }


  /**
   * Checks if a given string represents an income category by comparing it with category titles.
   *
   * @param category The category string to be checked.
   * @return {@code true} if the provided category string matches any income category title; {@code false} otherwise.
   */
  private static boolean isIncomeCategory(String category) {
    for (CategoryIncome incomeCategory : CategoryIncome.values()) {
      if (incomeCategory.getTitle().equals(category)) {
        return true;
      }
    }
    return false;
  }
  /**
   * Converts an array of enumerations into an array of strings containing the names of each enumeration element.
   *
   * @param categories The array of enumerations to be converted into an array of strings.
   * @return An array of strings containing the names of the enumeration elements.
   */
  private static String[] getCategoryTitles(Enum<?>[] categories) {
    String[] categoryTitles = new String[categories.length];
    for (int i = 0; i < categories.length; i++) {
      categoryTitles[i] = categories[i].toString();
    }
    return categoryTitles;
  }


  /**
   * Deletes a financial record from the list of records by its ID.
   *
   * @throws IOException If there is an issue with file operations.
   */
  public static void deleteRecord(List<Record> records) throws IOException {
    System.out.println("Delete record:");
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter id record to delete: ");
    int recordId = scanner.nextInt();

    records.removeIf(record -> record.getId() == recordId);
    System.out.println("Record was deleted");
  }
}
