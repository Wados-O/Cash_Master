package CashMaster.animation;

public class CleanConsole {
    public static void slowlyClean(){
        for (int i = 0; i < 10; i++) {
            System.out.println();
            Pause.middlePause();
        }
    }
}
