package CashMaster.service;


import static CashMaster.view.PrintTable.FOOTER;
import static CashMaster.view.PrintTable.HEADER;
import static CashMaster.view.PrintTable.MIDDLE;

import CashMaster.model.Category;
import CashMaster.model.Record;
import CashMaster.util.DateUtil;
import CashMaster.util.FileUtil;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

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

    System.out.println("RECORD ID: " + id);
    System.out.println("Income or expenses:");
    System.out.println("Income 1 | Expenses 2");
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
        // Handle the exception or ask the user to input the date again.
        return; // Exit the method.
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

  public static void createRecord(Scanner scanner) throws ParseException {
    System.out.println("Создание новой записи:");

    // Получите данные от пользователя
    System.out.print("Введите категорию: ");
    System.out.println();
    for (int i = 1; i < categories.size(); i++) {
      System.out.println("" + i  + " " + categories.get(i).getTitle());
    }
    String category = scanner.next();
    scanner.nextLine();

    System.out.print("Введите комментарий: ");
    String comment = scanner.nextLine();
    double amount = 0.0; // Инициализируйте amount значением по умолчанию

    // Проверяем, правильно ли пользователь ввел сумму
    boolean validAmount = false;
    while (!validAmount) {
      try {
        System.out.print("Введите сумму: ");
        amount = scanner.nextDouble();
        validAmount = true; // Если ввод правильный, выходим из цикла
      } catch (InputMismatchException e) {
        System.out.println("Некорректный ввод. Введите сумму с использованием десятичной точки.");
        scanner.nextLine(); // Очищаем буфер ввода
      }
    }

    System.out.print("Введите дату (dd.MM.yyyy): ");
    String dateStr = scanner.next();
    Date date = DateUtil.parseStrToDate(dateStr);

    // Создайте объект Record с полученными данными
    Record record = new Record(Record.getNewId(records), category, comment, amount, date);

    // Добавьте запись в список records
    records.add(record);
    System.out.println("Запись успешно создана.");
  }
  public static String stringLength(String str,int maxLength){
    if (str.length()> maxLength){
      return str.substring(0,maxLength);
    }
    return str;
  }
  public static void printList(List<Record> records) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    System.out.println(HEADER);
    for (int i = 0; i < records.size(); i++) {
      Record record = records.get(i);
      Category category = getCategoryById(record.getCategory());

      String formattedDate = dateFormat.format(record.getDate());
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

  public static void updateRecord(Scanner scanner) throws ParseException {
    System.out.println("Изменение записи:");

    // Получите идентификатор записи, которую пользователь хочет изменить
    System.out.print("Введите идентификатор записи для изменения: ");
    int recordId = scanner.nextInt();

    // Поиск записи по идентификатору
    Record recordToUpdate = null;
    int indexToUpdate = -1;
    for (int i = 0; i < records.size(); i++) {
      if (records.get(i).getId() == recordId) {
        recordToUpdate = records.get(i);
        indexToUpdate = i;
        break;
      }
    }

    // Проверка, найдена ли запись
    if (recordToUpdate == null) {
      System.out.println("Запись с указанным идентификатором не найдена.");
      return;
    }

    // Выведите текущие данные записи
    System.out.println("Текущие данные записи:");
    System.out.println("Категория: " + recordToUpdate.getCategory());
    System.out.println("Комментарий: " + recordToUpdate.getComment());
    System.out.println("Сумма: " + recordToUpdate.getAmount());
    System.out.println("Дата: " + new SimpleDateFormat("dd.MM.yyyy").format(recordToUpdate.getDate()));

    // Предоставьте опции для обновления полей записи
    System.out.println("Выберите, какие данные вы хотите изменить (введите номер):");
    System.out.println("1. Категория");
    System.out.println("2. Комментарий");
    System.out.println("3. Сумма");
    System.out.println("4. Дата");

    int choice = scanner.nextInt();
    scanner.nextLine(); // Съедаем перевод строки

    switch (choice) {
      case 1:
        System.out.print("Введите новую категорию: ");
        String newCategory = scanner.nextLine();
        recordToUpdate.setCategory(newCategory);
        break;
      case 2:
        System.out.print("Введите новый комментарий: ");
        String newComment = scanner.nextLine();
        recordToUpdate.setComment(newComment);
        break;
      case 3:
        System.out.print("Введите новую сумму: ");
        double newAmount = scanner.nextDouble();
        recordToUpdate.setAmount(newAmount);
        break;
      case 4:
        System.out.print("Введите новую дату (dd.MM.yyyy): ");
        String newDateStr = scanner.next();
        Date newDate = DateUtil.parseStrToDate(newDateStr);
        recordToUpdate.setDate(newDate);
        break;
      default:
        System.out.println("Неверный выбор.");
        break;
    }

    records.set(indexToUpdate, recordToUpdate);
    System.out.println("Запись успешно изменена.");
  }

  public static void deleteRecord(List<Record> records)throws IOException {
    System.out.println("Удаление записи:");
Scanner scanner = new Scanner(System.in);
    // Получите идентификатор записи, которую пользователь хочет удалить
    System.out.print("Введите идентификатор записи для удаления: ");
    int recordId = scanner.nextInt() -1;

    records.removeIf(record -> record.getId() ==recordId  );
    System.out.println("Запись успешно удалена");
  }
  private static Category getCategoryById(String categoryId) {
    for (Category category : categories) {
      if (String.valueOf(category.getId()).equals(categoryId)) {
        return category;
      }
    }
    return null;
  }
}
