import static org.junit.jupiter.api.Assertions.*;

import CashMaster.model.Record;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

class RecordTest {

  @Test
  void testConstructor() throws ParseException {
    Date date = new SimpleDateFormat("dd.MM.yyyy").parse("01.01.2023");
    Record record = new Record(1, "Food", "Lunch", 15.50, date);

    assertEquals(1, record.getId());
    assertEquals("Food", record.getCategory());
    assertEquals("Lunch", record.getComment());
    assertEquals(15.50, record.getAmount());
    assertEquals(date, record.getDate());
  }


  @Test
  void testGetId() {
    Record record = new Record(1);
    assertEquals(1, record.getId());
  }

  @Test
  void testGetCategory() {
    Record record = new Record();
    record.setCategory("Food");
    assertEquals("Food", record.getCategory());
  }

  @Test
  void testGetComment() {
    Record record = new Record();
    record.setComment("Lunch");
    assertEquals("Lunch", record.getComment());
  }

  @Test
  void testGetAmount() {
    Record record = new Record();
    record.setAmount(15.50);
    assertEquals(15.50, record.getAmount());
  }

  @Test
  void testGetDate() throws ParseException {
    Date date = new SimpleDateFormat("dd.MM.yyyy").parse("01.01.2023");
    Record record = new Record();
    record.setDate(date);
    assertEquals(date, record.getDate());
  }

}
