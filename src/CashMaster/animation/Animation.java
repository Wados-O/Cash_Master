package CashMaster.animation;

import static CashMaster.animation.CleanConsole.fastClean;
import static CashMaster.animation.CleanConsole.slowlyClean;
import static CashMaster.animation.Logo.*;
import static CashMaster.animation.Pause.longPause;
import static CashMaster.animation.Pause.shortPause;

public class Animation {
    public static void animation() {
        logoWados();

   fastClean();
        stringPresent();
        slowlyClean();
        longPause();
        slowlyClean();
        logoProject();
        slowlyClean();


    }

}
