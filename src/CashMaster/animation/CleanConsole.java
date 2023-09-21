package CashMaster.animation;

import static CashMaster.animation.Pause.middlePause;
import static CashMaster.animation.Pause.shortPause;

public class CleanConsole {
    public static void slowlyClean(){
        for (int i = 0; i < 10; i++) {
            System.out.println();
            middlePause();
        }
    }
    public static void fastClean(){
        for (int i = 0; i < 10; i++) {
            System.out.println();
            shortPause();
        }
    }
}
