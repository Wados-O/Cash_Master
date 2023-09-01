package CashMaster.view;

public class PrintTable {

  public static final String HEADER = """
      ┌──────┬────────────────────┬───────────────────────────────┬────────────────────┬───────────────────┐
      │  id  │     CATEGORY       │          COMMENT              │      AMOUNT        │       DATE        │
      ├──────┼────────────────────┼───────────────────────────────┼────────────────────┼───────────────────┤  """;

  public static final String MIDDLE = "├──────┼────────────────────┼───────────────────────────────┼────────────────────┼───────────────────┤";
  public static final String FOOTER = "└──────┴────────────────────┴───────────────────────────────┴────────────────────┴───────────────────┘";
}