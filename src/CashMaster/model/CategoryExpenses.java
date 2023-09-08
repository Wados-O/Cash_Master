package CashMaster.model;

public enum CategoryExpenses {
  FOOD(1,"Food"),
  GOODS(2, "Goods"),
  CLOTHES(3, "Clothes"),
  ENTERTAINMENT(4, "Entertainment"),
  HOUSE(5, "House"),
  TRANSPORT(6, "Transport"),
  FUEL(7, "Fuel"),
  HOBBY(8, "Hobby"),
  VACATIONS(9, "Vacations"),
  MEDICINE(10, "Medicine"),
  OTHER(11,"Other");


  private final int num;
  private String title;

  CategoryExpenses(int num, String title) {
    this.num = num;
    this.title = title;
  }

  public int getNum() {
    return num;
  }

  public String getTitle() {
    return title;
  }
}
