package CashMaster.util;

import CashMaster.view.Colors;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
  public static Date parseDate(String dateStr) {
    SimpleDateFormat dateFormatDash = new SimpleDateFormat("dd-MM-yyyy");
    SimpleDateFormat dateFormatComa = new SimpleDateFormat("dd,MM,yyyy");
    SimpleDateFormat dateFormatSlash = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat dateFormatDot = new SimpleDateFormat("dd.MM.yyyy");

    try {
      if (dateStr.contains("-")) {
        return dateFormatDash.parse(dateStr);
      } else if (dateStr.contains(".")) {
        return dateFormatDot.parse(dateStr);
      } else if (dateStr.contains(",")) {
        return dateFormatComa.parse(dateStr);
      } else if (dateStr.contains("/")) {
        return dateFormatSlash.parse(dateStr);
      } else {
        System.out.println(
            Colors.YELLOW + "Неверный формат даты. Используйте [dd.MM.yyyy]." + Colors.RESET);
        return null;
      }
    } catch (ParseException e) {
      e.printStackTrace();
      return null;
    }
  }
}
