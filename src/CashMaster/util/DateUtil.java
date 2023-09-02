package CashMaster.util;

import CashMaster.view.Colors;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
  public static String parseDateStr(Date date) {
    SimpleDateFormat[] dateFormats = {
        new SimpleDateFormat("dd-MM-yyyy"),
        new SimpleDateFormat("dd,MM,yyyy"),
        new SimpleDateFormat("dd/MM/yyyy"),
        new SimpleDateFormat("dd.MM.yyyy")
    };

    for (SimpleDateFormat dateFormat : dateFormats) {
      try {
        String formattedDate = dateFormat.format(date);
        // Если форматирование прошло успешно, возвращаем полученную строку
        return formattedDate;
      } catch (Exception e) {
        // Продолжаем итерироваться по форматам, если текущий не подходит
      }
    }

    System.out.println(
        Colors.YELLOW + "Неверный формат даты. Используйте [dd.MM.yyyy]." + Colors.RESET);
    return null;
  }
  public static Date parseStrToDate(String string)throws ParseException{
    SimpleDateFormat[] dateFormats = {
        new SimpleDateFormat("dd-MM-yyyy"),
        new SimpleDateFormat("dd,MM,yyyy"),
        new SimpleDateFormat("dd/MM/yyyy"),
        new SimpleDateFormat("dd.MM.yyyy")
    };
    for (SimpleDateFormat dateFormat : dateFormats){
      try{
        dateFormat.setLenient(false);
        return dateFormat.parse(string);
      }catch (ParseException e){

      }
    }
    throw new ParseException("Неверный формат даты.",0);
  }
}
