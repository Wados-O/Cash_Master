import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BudgetTracker {

  private static double balance = 0;
  private static List<Transaction> transactions = new ArrayList<>();
  private static List<Category> categories = new ArrayList<>();

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("Выберите действие:");
      System.out.println("1. Добавить доход");
      System.out.println("2. Добавить расход");
      System.out.println("3. Посмотреть баланс");
      System.out.println("4. Выйти");
      int choice = scanner.nextInt();

      switch (choice) {
        case 1:
          addTransaction(scanner, true);
          break;
        case 2:
          addTransaction(scanner, false);
          break;
        case 3:
          viewBalance();
          break;
        case 4:
          scanner.close();
          System.exit(0);
          break;
        default:
          System.out.println("Неверный выбор. Пожалуйста, выберите снова.");
      }
    }
  }

  private static void addTransaction(Scanner scanner, boolean isIncome) {
    System.out.print("Введите дату (гггг-мм-дд): ");
    String dateStr = scanner.next();
    Date date = new Date(Date.parse(dateStr));

    System.out.print("Введите описание: ");
    String description = scanner.next();

    System.out.print("Введите категорию: ");
    String categoryName = scanner.next();
    Category category = findOrCreateCategory(categoryName);

    System.out.print("Введите сумму: ");
    double amount = scanner.nextDouble();

    Transaction transaction = new Transaction(date, description, category, amount);

    if (isIncome) {
      balance += amount;
    } else {
      balance -= amount;
    }

    transactions.add(transaction);
    System.out.println("Транзакция успешно добавлена.");
  }

  private static Category findOrCreateCategory(String categoryName) {
    for (Category category : categories) {
      if (category.getName().equals(categoryName)) {
        return category;
      }
    }

    Category newCategory = new Category(categoryName);
    categories.add(newCategory);
    return newCategory;
  }

  private static void viewBalance() {
    System.out.println("Текущий баланс: " + balance);
  }
}

