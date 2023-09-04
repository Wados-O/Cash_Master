package CashMaster.view;

import static CashMaster.view.Colors.GREEN;
import static CashMaster.view.Colors.GREEN_BACKGROUND;
import static CashMaster.view.Colors.RESET;
import static CashMaster.view.Colors.WHITE_BOLD_BRIGHT;
import static CashMaster.view.Colors.YELLOW;
import static CashMaster.view.Colors.YELLOW_BACKGROUND;

public class MenuButton {
  public static final String EXIT_BUTTON = ""
      + GREEN + "SAVE AND OUT:    "
      + GREEN_BACKGROUND + WHITE_BOLD_BRIGHT + "  6 - EXIT   " + RESET;

  public static final String SHOW_FIRST_MENU = ""
      + YELLOW + "MAIN MENU:   "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + "  1 - ADD RECORD     " + RESET + "   "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + "  2 - CHANGE RECORD  " + RESET + "   "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + "  3 - DELETE RECORD  " + RESET + "   "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + "  4 - SORT MENU      " + RESET + "   "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + "  5 -  SAVE CHANGE   " + RESET + "   ";

  public static final String SHOW_SORT_MENU = ""
      + YELLOW + "SORT MENU:   "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + "  1 - CATEGORY SORT  " + RESET + "   "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + "  2 - COMMENT SORT   " + RESET + "   "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + "  3 - AMOUNT  SORT   " + RESET + "   "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + "  4 - SORT BY DATE   " + RESET + "   "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + "  5 - SORT  BY  ID   " + RESET + "   ";

  public static final String SHOW_CHANGE_MENU = ""
      + YELLOW + "SORT MENU:   "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + " 1 - CHANGE CATEGORY " + RESET + "   "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + " 2 - CHANGE  COMMENT " + RESET + "   "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + " 3 - CHANGE  AMOUNT  " + RESET + "   "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + " 4 - CHANGE DATE OF  " + RESET + "   "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + " 5 -  SAVE  CHANGE   " + RESET + "   ";
}
