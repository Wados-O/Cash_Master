import static org.junit.jupiter.api.Assertions.*;

import CashMaster.model.Record;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

class RecordTest {
  /**
   * Test the constructor of the Record class.
   */
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
  /**
   * Test the getId method of the Record class.
   */

  @Test
  void testGetId() {
    Record record = new Record(1);
    assertEquals(1, record.getId());
  }
  /**
   * Test the getCategory method of the Record class.
   */
  @Test
  void testGetCategory() {
    Record record = new Record();
    record.setCategory("Food");
    assertEquals("Food", record.getCategory());
  }
  /**
   * Test the getComment method of the Record class.
   */
  @Test
  void testGetComment() {
    Record record = new Record();
    record.setComment("Lunch");
    assertEquals("Lunch", record.getComment());
  }
  /**
   * Test the getAmount method of the Record class.
   */
  @Test
  void testGetAmount() {
    Record record = new Record();
    record.setAmount(15.50);
    assertEquals(15.50, record.getAmount());
  }
  /**
   * Test the getDate method of the Record class.
   *
   * @throws ParseException if there is an issue parsing the date.
   */
  @Test
  void testGetDate() throws ParseException {
    Date date = new SimpleDateFormat("dd.MM.yyyy").parse("01.01.2023");
    Record record = new Record();
    record.setDate(date);
    assertEquals(date, record.getDate());
  }

}
