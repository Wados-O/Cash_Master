package CashMaster.util;

import CashMaster.model.Record;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtil {
  private static String saveFile = "res/records.csv";
  private static List<Record> records = new ArrayList<>();
  private static final String SEP = ";;";

  public static void readFile()throws IOException {
    File file = new File(saveFile);
    if (!file.exists() || file.length() == 0){
      return;
    }
    Scanner sc = new Scanner(file);
    //TODO file reader
  }

}
