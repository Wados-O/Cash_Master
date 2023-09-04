package CashMaster.Sorts;
import CashMaster.model.Record;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortId {
  public static void sortById(List<Record> records) {
    Collections.sort(records, new Comparator<Record>() {
      @Override
      public int compare(Record record1, Record record2) {
        return Integer.compare(record1.getId(), record2.getId());
      }
    });
  }
}
