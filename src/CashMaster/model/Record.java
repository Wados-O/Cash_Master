package CashMaster.model;

import java.util.Date;

public class Record {
  private int id;
  private Category category;
  private String comment;
  private double amount;
  private Date date;

  public Record(int id, Category category, String comment, double amount, Date date) {
    this.id = id;
    this.category = category;
    this.comment = comment;
    this.amount = amount;
    this.date = date;
  }

  public Record() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Category getCategory() {
    return category;
  }

//  public void setCategory(String category) {
//    this.category = category;
//  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }
}
