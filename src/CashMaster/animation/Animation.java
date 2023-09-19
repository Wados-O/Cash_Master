package CashMaster.animation;

import static CashMaster.animation.CleanConsole.slowlyClean;
import static CashMaster.animation.Logo.*;
import static CashMaster.animation.Pause.longPause;

public class Animation {
    public static void animation() {
        logoWados();

        slowlyClean();
        stringPresent();
        slowlyClean();
        longPause();
        slowlyClean();
        logoProject();
        slowlyClean();


    }

}
