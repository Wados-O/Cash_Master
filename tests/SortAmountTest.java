import static org.junit.jupiter.api.Assertions.*;

import CashMaster.Sorts.SortAmount;
import CashMaster.model.Record;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class SortAmountTest {
    @Test
    void testEmptyFile(){
        List<Record> records = new ArrayList<>();
        SortAmount.sortByAmount(records);
        assertEquals(0,records.size());
    }

}
