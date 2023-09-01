package CashMaster.util;

import CashMaster.model.Category;
import CashMaster.model.Record;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class FileUtil {
  private static String saveFile = "res/record.csv";
  private static List<Record> records = new ArrayList<>();
  private static final String SEP = ";;;";

  public static void readFile() throws IOException, ParseException {
    File file = new File(saveFile);
    if (!file.exists() || file.length() == 0) {
      return;
    }

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] parts = line.split(SEP);
        if (parts.length == 5) {
          int id = Integer.parseInt(parts[0]);
          String categoryTitle = parts[1];
          String comment = parts[2];
          double amount = Double.parseDouble(parts[3]);
          Date date = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse(parts[4]);

          Category category = new Category(categoryTitle); // Assuming you have a Category constructor that takes a title
          Record record = new Record(id, category, comment, amount, date);
          records.add(record);
        }
      }
    }
  }

}
