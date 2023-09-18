package CashMaster.animation;

public class Pause {
    public static void longPause(){
        int pause = 2000;
        long start = System.currentTimeMillis();
        while (start >= System.currentTimeMillis() - pause);
    }
    public static void middlePause(){
        int pause =500;
        long start = System.currentTimeMillis();
        while (start >= System.currentTimeMillis() - pause);
    }
    public static void shortPause(){
        int pause = 200;
        long start = System.currentTimeMillis();
        while (start >= System.currentTimeMillis() - pause);
    }
    public static void momentPause(){
        int pause = 100;
        long start = System.currentTimeMillis();
        while (start >= System.currentTimeMillis() - pause);
    }
}
