package CashMaster.util;

import CashMaster.model.Record;
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
import java.util.Scanner;

public class FileUtil {

  private static String saveFile = "res/record.csv";
  private static List<Record> records = new ArrayList<>();
  private static final String SEP = ";;;";
  /**
   * Reads data from a file and populates a list of records.
   *
   * @throws IOException    If an I/O error occurs while reading the file.
   * @throws ParseException If there's an error parsing the data from the file.
   */

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
          String category = parts[1];
          String comment = parts[2];
          double amount = Double.parseDouble(parts[3]);

          Date date = new SimpleDateFormat("dd.MM.yyyy").parse(parts[4]);

          Record record = new Record(id, category, comment, amount, date);
          records.add(record);
        }
      }
    }
  }

  /**
   * Saves a list of records to a file.
   *
   * @param records The list of records to be saved.
   * @throws IOException If an I/O error occurs while writing to the file.
   */
  public static void saveToFile(List<Record> records) throws IOException {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(saveFile))) {
      for (Record record : records) {
        String line = record.getId() + SEP +
            record.getCategory() + SEP + //
            record.getComment() + SEP +
            record.getAmount() + SEP +
            new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).format(record.getDate());
        bw.write(line);
        bw.newLine();
      }
    }
  }

  /**
   * Sets the path to the file where records will be saved.
   *
   * @param saveFile The path to the file.
   */
  public static void setSaveFile(String saveFile) {
    FileUtil.saveFile = saveFile;
  }
  /**
   * Retrieves the list of records.
   *
   * @return The list of records.
   */
  public static List<Record> getRecords() {
    return records;
  }
}
