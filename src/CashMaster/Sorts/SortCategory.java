package CashMaster.Sorts;

import CashMaster.model.Record;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortCategory {
  public static void sortByCategory(List<Record> records) {
    Collections.sort(records, new Comparator<Record>() {
      @Override
      public int compare(Record record1, Record record2) {
        return record1.getCategory().compareTo(record2.getCategory());
      }
    });
  }

}
