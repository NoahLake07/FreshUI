package freshui.program;

import acm.graphics.GCanvas;
import acm.program.GraphicsProgram;
import javax.swing.*;

public abstract class FreshProgram extends GraphicsProgram {

    public GCanvas myCanvas = this.getGCanvas();

    public final int CENTER = SwingConstants.CENTER;
    public final int LEFT = SwingConstants.LEFT;
    public final int RIGHT = SwingConstants.RIGHT;

    public void init(){
        this.getMenuBar().setVisible(false);
        this.setProgramName("FreshUI Window");
        log("INITIALIZED");
    }

    public void run(){

    }

    public void setProgramName(String s){
        this.setTitle(s);
        this.getMenuBar().setName(s);
    }

    public void log(String log){
        System.out.println("FreshUI:Program:: " + log);
    }

}
