package CashMaster.Comparators;

import java.util.Collections;
import java.util.Comparator;
import CashMaster.model.Record;
import java.util.List;

public class DateComparator {
  public static void sortByDate(List<Record> records) {
    Collections.sort(records, new Comparator<Record>() {
      @Override
      public int compare(Record record1, Record record2) {
        return record2.getDate().compareTo(record1.getDate());
      }
    });
  }




}

