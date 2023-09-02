package CashMaster.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Record {
  private int id;
  private String category;
  private String comment;
  private double amount;
  private Date date;

  public Record(int id,String category, String comment, double amount, Date date) {
    this.id = id;
    this.category = category;
    this.comment = comment;
    this.amount = amount;
    this.date = date;
  }

  public Record(int id) {
    this.id = id;
  }

  public Record() {

  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

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
public static int getNewId(List<Record> records){
    int max = 1;
    for (Record record : records){
      if (record.getId() >= max){
        max = record.getId() +1;
      }
    }
    return max;
}
  @Override
  public String toString() {
    return "Record{" +
        "id=" + id +
        ", category=" + category +
        ", comment='" + comment + '\'' +
        ", amount=" + amount +
        ", date=" + date +
        '}';
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Record record = (Record) obj;
    return id == record.id && Double.compare(record.amount, amount) == 0
        && Objects.equals(category, record.category) && Objects.equals(comment,
        record.comment) && Objects.equals(date, record.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, category, comment, amount, date);
  }
}
