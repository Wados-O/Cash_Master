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
        return formattedDate;
      } catch (Exception e) {
      }
    }

    System.out.println(
        Colors.YELLOW + "Invalid date format. Use [dd.MM.yyyy]." + Colors.RESET);
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
    throw new ParseException("Invalid date format.",0);
  }
}
