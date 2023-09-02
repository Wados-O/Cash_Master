package CashMaster;

import CashMaster.controller.MenuController;
import java.util.Scanner;

public class Runner extends MenuController {

  public static void main(String[] args) {

    MenuController.mainMenu(new Scanner(System.in));
  }

}
