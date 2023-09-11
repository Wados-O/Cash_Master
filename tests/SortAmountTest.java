import static org.junit.jupiter.api.Assertions.*;

import CashMaster.Sorts.SortAmount;
import CashMaster.model.Record;
import CashMaster.util.FileUtil;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SortAmountTest {
    @Test
    void testEmptyFile(){
        List<Record> records = new ArrayList<>();
        SortAmount.sortByAmount(records);
        assertEquals(0,records.size());
    }

}
