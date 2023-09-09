import static org.junit.jupiter.api.Assertions.*;

import CashMaster.model.Record;
import CashMaster.util.FileUtil;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileUtilTest {
private static final String testFile = "res/testRecord.csv";
  @BeforeEach
  void setUp(){
    File file = new File(testFile);
    if (file.exists()){
      file.delete();
    }

  }

  @Test
  void readFile() throws IOException , ParseException {
  String testCsvData =  "1;;;Food;;;Lunch;;;15.50;;;01.01.2023\n" +
      "2;;;Transportation;;;Bus Fare;;;20.00;;;02.01.2023";
    try(BufferedWriter writer = new BufferedWriter(new FileWriter(testFile))) {
      writer.write(testCsvData);
    }
    FileUtil.setSaveFile(testFile);
    FileUtil.readFile();

    List<Record> records = FileUtil.getRecords();
    assertEquals(2,records.size());
    Record firstRecord = records.get(0);
    assertEquals(1,firstRecord.getId());
    assertEquals("Food",firstRecord.getCategory());
    assertEquals("Lunch",firstRecord.getComment());
    assertEquals(15.50,firstRecord.getAmount(),0.01);
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    Date expectedDate = dateFormat.parse("01.01.2023");
    assertEquals(expectedDate, firstRecord.getDate());

  }

  @Test
  void saveToFile() {
  }

  @Test
  void setSaveFile() {
  }

  @Test
  void getRecords() {
  }
}