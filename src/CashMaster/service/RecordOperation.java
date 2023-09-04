package CashMaster.service;


import static CashMaster.view.Colors.RESET;
import static CashMaster.view.PrintTable.FOOTER;
import static CashMaster.view.PrintTable.HEADER;
import static CashMaster.view.PrintTable.MIDDLE;

import CashMaster.model.Category;
import CashMaster.model.Record;
import CashMaster.util.DateUtil;
import CashMaster.util.FileUtil;
import CashMaster.view.Colors;
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
  static List<Category> categories = Category.createCategories();
 static Record record = new Record();
  public static void addRecord(List<Record> records, List<Category> categories) throws IOException, ParseException {

    Scanner sc = new Scanner(System.in);
    DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    Record record = new Record();

    Calendar today = Calendar.getInstance();
    Date currentDate = today.getTime();
    Date stDate = currentDate;

    String incomeCategory = "INCOME";
    boolean income = false;
    int multiply = 1;
    int id = Record.getNewId(records);

//    if (!records.isEmpty()) {
//      // Создайте список, содержащий все существующие ID.
//      List<Integer> existingIds = records.stream()
//          .map(Record::getId)
//          .collect(Collectors.toList());
//
//      // Найдите минимальный доступный ID, начиная с 1.
//      while (existingIds.contains(id)) {
//        id++;
//      }
//    }
    System.out.println("RECORD ID: " + id);
    System.out.println("Income or expenses:");
    System.out.println("Income 1           |            Expenses 2");
    String incOrExp = sc.nextLine();
    if (incOrExp.equalsIgnoreCase("1")) {
      income = true;
    }
    if (!income) {
      for (int i = 0; i < 10; ++i) {
        System.out.println("" + i + " " + categories.get(i).getTitle());
      }
      System.out.print("Choose category from list (0-9): ");
      int cat = Integer.parseInt(sc.nextLine());
      incomeCategory = categories.get(cat).getTitle();
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

  public static String stringLength(String str,int maxLength){
    if (str.length()> maxLength){
      return str.substring(0,maxLength);
    }
    return str;
  }
  public static void printList(List<Record> records) {
    PrintTable.cleanConsole();

    System.out.println(HEADER);
    for (int i = 0; i < records.size(); i++) {
      Record record = records.get(i);
      String recordRow = String.format("│%-6d│%-29s│%-31s│%-30s│%-28s│",
              record.getId(),
              record.getCategory(),
              record.getComment(),
              record.getAmount(),
              DateUtil.parseDateStr(record.getDate()));

      System.out.println(recordRow);
      System.out.println(MIDDLE);
    }
    System.out.println(FOOTER);
  }

  public static void editRecord(Scanner scanner) throws ParseException {
    System.out.println("Edit record :");

    System.out.print("Enter id of record: ");
    int recordId = scanner.nextInt();

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
      System.out.println("Not found record .");
      return;
    }


    System.out.println("Current record :");
    System.out.println("Category: " + recordToUpdate.getCategory());
    System.out.println("Comment: " + recordToUpdate.getComment());
    System.out.println("Amount: " + recordToUpdate.getAmount());
    System.out.println("Date: " + new SimpleDateFormat("dd.MM.yyyy").format(recordToUpdate.getDate()));

    System.out.println("What would you like to change :");
    System.out.println("1. Category");
    System.out.println("2. Comment");
    System.out.println("3. Amount");
    System.out.println("4. Date");

    int choice = scanner.nextInt();
    scanner.nextLine();

    switch (choice) {
      case 1:
        System.out.println("Available categories:");
        for (int i = 0; i < 10; i++) {
          System.out.println(i + 1 + ". " + categories.get(i).getTitle());
        }
        System.out.print("Enter the number of the new category: ");
        int categoryChoice = scanner.nextInt();
        scanner.nextLine();

        if (categoryChoice >= 1 && categoryChoice <= categories.size()) {
          String newCategory = categories.get(categoryChoice - 1).getTitle();
          recordToUpdate.setCategory(newCategory);
        } else {
          System.out.println("Invalid category choice.");
          break;
        }
        break;
      case 2:
        System.out.print("Enter new comment: ");
        String newComment = scanner.nextLine();
        recordToUpdate.setComment(newComment);
        break;
      case 3:
        System.out.print("Enter new amount: ");
        double newAmount = scanner.nextDouble();
        recordToUpdate.setAmount(newAmount);
        break;
      case 4:
        System.out.print("Enter new date (dd.MM.yyyy): ");
        String newDateStr = scanner.next();
        Date newDate = DateUtil.parseStrToDate(newDateStr);
        recordToUpdate.setDate(newDate);
        break;
      default:
        System.out.println("Invalid choice.");
        break;
    }

    records.set(indexToUpdate, recordToUpdate);
    System.out.println("Record was changing.");
  }

  public static void deleteRecord(List<Record> records)throws IOException {
    System.out.println("Delete record:");
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter id record to delete: ");
    int recordId = scanner.nextInt();

    records.removeIf(record -> record.getId() ==recordId  );
    System.out.println("Record was deleted");
  }
  private static Category getCategoryById(String categoryId) {
    for (Category category : categories) {
      if (String.valueOf(category.getId()).equals(categoryId)) {
        return category;
      }
    }
    return null;
  }



  public static double calculateTotalIncome(List<Record> records){
    double totalIncome = 0.0;
    for (Record record : records){
      if (record.getAmount()>0){
        totalIncome+= record.getAmount();
      }
    }
    return totalIncome;
  }
  public static double calculateTotalExpenses(List<Record> records){
    double totalExpenses = 0.0;
    for (Record record : records){
      if (record.getAmount()< 0){
        totalExpenses+=record.getAmount();
      }
    }
    return Math.abs(totalExpenses);
  }
  public static double calculateBalance(List<Record> records){
    double totalIncome = 0.0;
    double totalExpenses = 0.0;
    for (Record record : records){
      if (record.getAmount()>0){
        totalIncome += record.getAmount();
      }else {
        totalExpenses += record.getAmount();
      }
    }
    return  totalIncome + totalExpenses;
  }
  public static void printIncome(List<Record>records){
    System.out.println();
    System.out.print(Colors.WHITE_BRIGHT + "Total Income:       " + calculateTotalIncome(records) + "          |||||         ");
    System.out.print("Total Expenses:        " + calculateTotalExpenses(records)+"            |||||         ");
    System.out.print("Balance:    " + calculateBalance(records) + RESET);
    System.out.println();
    System.out.println();
  }

}
