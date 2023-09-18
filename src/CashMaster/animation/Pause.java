package CashMaster.animation;

public class Pause {
    public static void longPause(){
        int pause = 2000;
        long start = System.currentTimeMillis();
        while (start >= System.currentTimeMillis() - pause);
    }
}
