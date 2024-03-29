package CashMaster.view;

public class PrintTable {
  public static void cleanConsole(){
    for (int i = 0; i < 10; i++) {
      System.out.println();
    }
  }

  public static final String HEADER = """
      ┌──────┬─────────────────────────────┬─────────────────────────────────────────┬──────────────────────────────┬────────────────────────────┐
      │  id  │     CATEGORY                │               COMMENT                   │            AMOUNT            │            DATE            │
      ├──────┼─────────────────────────────┼─────────────────────────────────────────┼──────────────────────────────┼────────────────────────────┤  """;

  public static final String MIDDLE = "├──────┼─────────────────────────────┼─────────────────────────────────────────┼──────────────────────────────┼────────────────────────────┤";
  public static final String FOOTER = "└──────┴─────────────────────────────┴─────────────────────────────────────────┴──────────────────────────────┴────────────────────────────┘";
}
