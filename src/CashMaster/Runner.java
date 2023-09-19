package CashMaster;

import CashMaster.controller.MenuController;
import CashMaster.util.FileUtil;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import static CashMaster.animation.Animation.animation;

public class Runner extends MenuController {

  public static void main(String[] args) throws IOException, ParseException {
    animation();
    FileUtil.readFile();
    MenuController.mainMenu(new Scanner(System.in));
  }

}
