import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public  class Transaction {
    private Date date;
    private String description;
    private Category category;
    private double amount;

    public Transaction(Date date, String description, Category category, double amount) {
      this.date = date;
      this.description = description;
      this.category = category;
      this.amount = amount;
    }

    public Date getDate() {
      return date;
    }

    public String getDescription() {
      return description;
    }

    public Category getCategory() {
      return category;
    }

    public double getAmount() {
      return amount;
    }
  }






