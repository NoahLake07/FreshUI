package freshui.program;

import acm.graphics.GCanvas;
import acm.program.GraphicsProgram;
import freshui.interfaces.FreshComponent;

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
        this.getMenuBar().setVisible(false);
    }

    public void setProgramName(String s){
        this.setTitle(s);
        this.getMenuBar().setName(s);
    }

    public void add(FreshComponent fc, double x, double y){
        if(fc.getProgramParent() == this) {
            fc.addToParent();
            fc.setLocation(x, y);
        } else {
            log("Object not added: specified program parent did not match");
        }
    }

    public void log(String log){
        System.out.println("FreshUI:Program:: " + log);
    }

}
