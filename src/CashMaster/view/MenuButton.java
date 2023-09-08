package CashMaster.view;

import CashMaster.calculator.FinancialCalculator;
import CashMaster.model.Record;
import CashMaster.service.RecordOperation;
import CashMaster.util.FileUtil;

import java.util.List;

import static CashMaster.view.Colors.*;

public class MenuButton {
  static List<Record> records = FileUtil.getRecords();

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
  public static final String INCOME_OR_EXP = ""
          +YELLOW + "Income or expenses:    "
          + WHITE_BOLD_BRIGHT + CYAN_BACKGROUND + "  1  -  INCOME      "  + RESET + "     "
          + WHITE_BOLD_BRIGHT + PURPLE_BACKGROUND + "  2  -  EXPENSE     " + RESET + "     ";

  public static final String SHOW_CHANGE_MENU = ""
      + YELLOW + "CHANGE MENU:   "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + " 1 - CHANGE CATEGORY " + RESET + "   "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + " 2 - CHANGE  COMMENT " + RESET + "   "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + " 3 - CHANGE  AMOUNT  " + RESET + "   "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + " 4 - CHANGE DATE OF  " + RESET + "   "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + " 5 -  SAVE  CHANGE   " + RESET + "   ";
  public static final String SHOW_FINANCE = ""
          + YELLOW + "FINANCIAL CONDITION:     "
          + WHITE_BOLD_BRIGHT + CYAN_BACKGROUND + "  TOTAL   INCOME   " + FinancialCalculator.calculateTotalIncome(records) + "     " + RESET + "        "
          + WHITE_BOLD_BRIGHT + PURPLE_BACKGROUND + "  TOTAL EXPENSES   " + FinancialCalculator.calculateTotalExpenses(records) + "     " + RESET + "        "
          + WHITE_BOLD_BRIGHT + GREEN_BACKGROUND + "      BALANCE      " + FinancialCalculator.calculateBalance(records) + "     "+ RESET + "   ";
}
