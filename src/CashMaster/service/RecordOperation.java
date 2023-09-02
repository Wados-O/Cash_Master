package CashMaster.service;

import static CashMaster.util.DateUtil.parseDate;
import static CashMaster.view.PrintTable.FOOTER;
import static CashMaster.view.PrintTable.HEADER;
import static CashMaster.view.PrintTable.MIDDLE;

import CashMaster.model.Category;
import CashMaster.model.Record;
import CashMaster.util.DateUtil;
import CashMaster.util.FileUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class RecordOperation {
  static List<Record> records = FileUtil.getRecords();
  static List<Category> categories = Category.createCategories();
 static Record record = new Record();
  public static void createRecord(Scanner scanner) {
    System.out.println("Создание новой записи:");

    // Получите данные от пользователя
    System.out.print("Введите категорию: ");
    System.out.println();
    for (int i = 0; i < categories.size(); i++) {
      System.out.println("" + (i + 1) + " " + categories.get(i).getTitle());
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
    Date date = parseDate(dateStr);

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

      String recordRow = String.format("│%-6d│%-20s│%-31s│%-20s│%-19s│",
          i + 1,
          category != null ? category.getTitle() : "Unknown",
          record.getComment(),
          record.getAmount(),
          formattedDate);
      System.out.println(recordRow);
      System.out.println(MIDDLE);
    }
    System.out.println(FOOTER);
  }
  public static void updateRecord(Scanner scanner) {
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
        Date newDate = parseDate(newDateStr);
        recordToUpdate.setDate(newDate);
        break;
      default:
        System.out.println("Неверный выбор.");
        break;
    }

    records.set(indexToUpdate, recordToUpdate);
    System.out.println("Запись успешно изменена.");
  }

  public static void deleteRecord(Scanner scanner) {
    System.out.println("Удаление записи:");

    // Получите идентификатор записи, которую пользователь хочет удалить
    System.out.print("Введите идентификатор записи для удаления: ");
    int recordId = scanner.nextInt();

    // Поиск записи по идентификатору и удаление ее, если она найдена
    Record recordToRemove = null;
    for (Record record : records) {
      if (record.getId() == recordId) {
        recordToRemove = record;
        break;
      }
    }

    // Проверка, найдена ли запись для удаления
    if (recordToRemove != null) {
      records.remove(recordToRemove);
      System.out.println("Запись успешно удалена.");
    } else {
      System.out.println("Запись с указанным идентификатором не найдена.");
    }
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
