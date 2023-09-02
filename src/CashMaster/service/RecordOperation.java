package CashMaster.service;

import static CashMaster.util.DateUtil.parseDate;
import static CashMaster.view.PrintTable.FOOTER;
import static CashMaster.view.PrintTable.HEADER;
import static CashMaster.view.PrintTable.MIDDLE;

import CashMaster.model.Category;
import CashMaster.model.Record;
import CashMaster.util.FileUtil;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class RecordOperation {
  private static List<Record> records = FileUtil.getRecords();
  private static List<Category> categories = Category.createCategories();
  private static Record record = new Record();
  public static void createRecord(Scanner scanner) {
    System.out.println("Создание новой записи:");

    // Получите данные от пользователя
    System.out.print("Введите категорию: ");
    System.out.println();
    for (int i = 0; i < categories.size(); i++) {

      System.out.println("" + (i +1) + " "+ categories.get(i).getTitle());
    }
    String category = scanner.next();

    System.out.print("Введите комментарий: ");
    String comment = scanner.next();

    System.out.print("Введите сумму: ");
    double amount = scanner.nextDouble();

    System.out.print("Введите дату (dd.MM.yyyy): ");
    String dateStr = scanner.next();
    Date date = parseDate(dateStr);

    // Создайте объект Record с полученными данными
    Record record = new Record(0, category, comment, amount, date);

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
  public static void printList(List<Record> records){
    System.out.println(HEADER);
    for (Record record : records){
      String recordRow = String.format("│%6d│%24s│%25s│%22s│%24.2f│",
          record.getId(),record.getCategory(),record.getComment(),record.getAmount(),record.getDate());
      System.out.println(recordRow);
      System.out.println(MIDDLE);
    }
    System.out.println(FOOTER);
  }
}
