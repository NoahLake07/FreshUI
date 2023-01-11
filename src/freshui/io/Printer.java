package freshui.io;

public class Printer implements ConsoleColor {

    static boolean pause = true;
    static int pauseDelay = 10;

    public static void setDebugMode(boolean status){
        pause = status;
    }

    public static void println(String s, String cC){
        System.out.print(cC);
        System.out.println(s);
        System.out.print(RESET);
        debugPause();
    }

    public static void println(String s){
        System.out.println(s);
        debugPause();
    }

    public static void setColor(String color){
        System.out.print(color);
    }

    public static void reset(){
        System.out.print(RESET);
    }

    public static void print(String s, String cC){
        System.out.print(cC);
        System.out.print(s);
        System.out.print(RESET);
        debugPause();
    }

    public static void print(String s){
        System.out.println(s);
        debugPause();
    }

    private static void debugPause(){
        if(pause){
            try {
                Thread.sleep(pauseDelay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
