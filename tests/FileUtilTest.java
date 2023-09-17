import static org.junit.jupiter.api.Assertions.*;

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

class FileUtilTest {
private static final String testFile = "res/testRecord.csv";
  private static final String SEP = ";;;";
  /**
   * This method is annotated with @BeforeEach, and it is executed before each test method.
   * Its purpose is to set up the test environment and ensure a clean state before each test.
   */
  @BeforeEach
  void setUp(){
    File file = new File(testFile);
    if (file.exists()){
      file.delete();
    }

  }
  /**
   * This JUnit test case is designed to test the 'readFile' method of a financial records program.
   * It checks whether the method correctly reads data from a file and populates a list of records.
   */
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
  /**
   * This JUnit test case is designed to test the 'saveToFile' method of a financial records program.
   * It verifies whether the method correctly saves and reads records to/from a file.
   */
  @Test
  void saveToFile() throws ParseException, IOException {
    Date date1 = new SimpleDateFormat("dd.MM.yyyy").parse("01.01.2023");
    Date date2 = new SimpleDateFormat("dd.MM.yyyy").parse("02.01.2023");
    Record record1 = new Record(1, "Food", "Lunch", 15.50, date1);
    Record record2 = new Record(2, "Transport", "Buy fuel", 20.00, date2);
    List<Record> recordsToSave = List.of(record1, record2);
    String testFile = "res/test_record.csv";

    FileUtil.setSaveFile(testFile);
    FileUtil.saveToFile(recordsToSave);

    List<Record> savedRecords = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(testFile))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] parts = line.split(SEP);
        if (parts.length == 5) {
          int id = Integer.parseInt(parts[0]);
          String category = parts[1];
          String comment = parts[2];
          double amount = Double.parseDouble(parts[3]);
          Date date = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse(parts[4]);
          Record savedRecord = new Record(id, category, comment, amount, date);
          savedRecords.add(savedRecord);
        }
      }
    }

    assertEquals(recordsToSave.size(), savedRecords.size());
    for (int i = 0; i < recordsToSave.size(); i++) {
      assertEquals(recordsToSave.get(i), savedRecords.get(i));
    }
  }
}