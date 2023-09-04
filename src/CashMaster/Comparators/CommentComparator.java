package CashMaster.Comparators;
import CashMaster.model.Record;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CommentComparator {
  public static void sortByComment(List<Record> records) {
    Collections.sort(records, new Comparator<Record>() {
      @Override
      public int compare(Record record1, Record record2) {
        return record1.getComment().compareTo(record2.getComment());
      }
    });
  }


}
