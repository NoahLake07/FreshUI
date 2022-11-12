package freshui.util;

public class Animator implements Runnable {

    boolean stopped, running;

    public Animator(){
        stopped = true;
    }

    @Override
    public void run(){
        stopped = false;
        running = true;
    }

}
