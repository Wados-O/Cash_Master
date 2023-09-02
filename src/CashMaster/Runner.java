package CashMaster;

import CashMaster.controller.MenuController;
import java.io.IOException;
import java.util.Scanner;

public class Runner extends MenuController {

  public static void main(String[] args) throws IOException {

    MenuController.mainMenu(new Scanner(System.in));
  }

}
