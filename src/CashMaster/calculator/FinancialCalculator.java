package CashMaster.calculator;

import static CashMaster.view.Colors.RESET;

import CashMaster.model.Record;
import CashMaster.util.FileUtil;
import CashMaster.view.Colors;
import java.util.List;

public class FinancialCalculator {

  static List<Record> records = FileUtil.getRecords();
  /**
   * Calculates the total income from a list of financial records.
   *
   * @param records The list of financial records to calculate income from.
   * @return The total income as a double value.
   */

  public static double calculateTotalIncome(List<Record> records){
    double totalIncome = 0.0;
    for (Record record : records){
      if (record.getAmount()>0){
        totalIncome+= record.getAmount();
      }
    }
    return totalIncome;
  }

  /**
   * Calculates the total expenses from a list of financial records.
   *
   * @param records The list of financial records to calculate expenses from.
   * @return The total expenses as a positive double value.
   */
  public static double calculateTotalExpenses(List<Record> records){
    double totalExpenses = 0.0;
    for (Record record : records){
      if (record.getAmount()< 0){
        totalExpenses+=record.getAmount();
      }
    }
    return Math.abs(totalExpenses);
  }

  /**
   * Calculates the balance based on a list of financial records.
   *
   * @param records The list of financial records to calculate the balance from.
   * @return The balance, which is the difference between total income and total expenses.
   */
  public static double calculateBalance(List<Record> records){
    double totalIncome = 0.0;
    double totalExpenses = 0.0;
    for (Record record : records){
      if (record.getAmount()>0){
        totalIncome += record.getAmount();
      }else {
        totalExpenses += record.getAmount();
      }
    }
    return  totalIncome + totalExpenses;
  }
  /**
   * Prints a summary of total income, total expenses, and the balance to the console.
   * Do not delete . Can be used.
   * @param records The list of financial records to calculate and display income and expenses from.
   */
  public static void printIncome(List<Record>records){
    System.out.println();
    System.out.print(Colors.WHITE_BRIGHT + "Total Income:       " + calculateTotalIncome(records) + "          |||||         ");
    System.out.print("Total Expenses:        " + calculateTotalExpenses(records)+"            |||||         ");
    System.out.print("Balance:    " + calculateBalance(records) + RESET);
    System.out.println();
    System.out.println();
  }
}
