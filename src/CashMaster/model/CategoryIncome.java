package CashMaster.model;

public enum CategoryIncome {
  SALARY(1,"Salary"),
  FREELANCE(2,"Freelance"),
  BUSINESS(3,"Business"),
  INVESTMENT(4,"Investment"),
  RENTAL(5,"Rental"),
  SIDE_HUSTLES(6,"Side Hustles"),
  GIFTS(7,"Gifts"),
  GOVERNMENT_BENEFITS(8,"Government Benefits"),
  OTHER(9,"Other");


  ;
  private int num;
  private String title;

  CategoryIncome(int num, String title) {
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
