package CashMaster.Sorts;

import CashMaster.model.Record;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class sortsSource {

  /**
   * Sort LIst of All Records by Category
   *
   * @param records List of Record with payments
   * @return new sorted LIst of Records
   */
  public static List<Record> sortByCategory(List<Record> records) {
    List<Record> result;
    result = records.stream()
        .sorted(Comparator.comparing(Record::getCategory))
        .collect(Collectors.toList());
    return result;
  }

  /**
   * Sort LIst of All Records by Amount
   *
   * @param records List of Record with payments
   * @return new sorted LIst of Records
   */

  public static List<Record> sortByAmount(List<Record> records) {
    List<Record> result;
    result = records.stream()
        .sorted(Comparator.comparing(Record::getAmount))
        .collect(Collectors.toList());
    return result;
  }

  /**
   * Sort LIst of All Records by Date
   *
   * @param records List of Record with payments
   * @return new sorted LIst of Records
   */

  public static List<Record> sortByDate(List<Record> records) {
    List<Record> result;
    result = records.stream()
        .sorted(Comparator.comparing(Record::getDate))
        .collect(Collectors.toList());
    return result;
  }
}
