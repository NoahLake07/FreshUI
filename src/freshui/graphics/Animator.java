package freshui.graphics;

public class Animator {
    Runnable[] r;
    Thread[] threads;
    public Animator( Runnable[] runnables){
        r = runnables;
        threads = new Thread[r.length];
    }
    public void startThreads(){
        for (int i = 0; i < r.length; i++) {
            threads[i] = new Thread(r[i]);
            threads[i].start();
        }
    }

    public void stopThreads(){
        for (int i = 0; i < r.length; i++) {
            threads[i].interrupt();
        }
    }
}