package CashMaster;

import CashMaster.controller.MenuController;
import CashMaster.util.FileUtil;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Runner extends MenuController {

  public static void main(String[] args) throws IOException, ParseException {
    FileUtil.readFile();
    MenuController.mainMenu(new Scanner(System.in));
  }

}
