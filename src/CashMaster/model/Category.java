package CashMaster.model;

public class Category {
private int id ;
private String title;
private boolean allowed;

  public Category(int id, String title, boolean allowed) {
    this.id = id;
    this.title = title;
    this.allowed = allowed;
  }


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public boolean isAllowed() {
    return allowed;
  }

  public void setAllowed(boolean allowed) {
    this.allowed = allowed;
  }
}
