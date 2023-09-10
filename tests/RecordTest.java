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
class RecordTest {
  @Test
  void testConstructor()throws ParseException{
    Date date = new SimpleDateFormat("dd.MM.yyyy").parse("01.01.2023");
    Record record = new Record(1,"Food","Lunch",15.50,date);

    assertEquals(1,record.getId());
    assertEquals("Food",record.getCategory());
    assertEquals("Lunch",record.getComment());
    assertEquals(15.50,record.getAmount());
    assertEquals(date,record.getDate());
  }


  @Test
  void testGetId(){
    Record record = new Record(1);
    assertEquals(1,record.getId());
  }
  @Test
  void testGetCategory(){
    Record record = new Record();
    record.setCategory("Food");
    assertEquals("Food",record.getCategory());
  }

}
