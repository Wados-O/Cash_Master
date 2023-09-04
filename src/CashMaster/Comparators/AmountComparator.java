package CashMaster.Comparators;
import CashMaster.model.Record;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AmountComparator {
  public static void sortByAmount(List<Record> records) {
    Collections.sort(records, new Comparator<Record>() {
      @Override
      public int compare(Record record1, Record record2) {
        return Double.compare(record2.getAmount(), record1.getAmount());
      }
    });
  }
}
