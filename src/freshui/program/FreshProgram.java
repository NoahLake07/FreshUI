package freshui.program;

import acm.graphics.GCanvas;
import acm.program.GraphicsProgram;
import freshui.graphics.FCompound;
import freshui.graphics.FPanel;
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
        fc.setProgramParent(this);
        if(fc.getProgramParent() == this) {
            fc.addToParent(x,y);
        } else {
            log("Object not added: specified program parent did not match");
        }
    }

    public void add(FPanel fp, double x, double y){
        fp.setProgramParent(this);
        if(fp.getProgramParent() == this) {
            fp.addToParent(x,y);
        } else {
            log("Object not added: specified program parent did not match");
        }
    }

    public void add(FreshComponent fc){
        add(fc,0,0);
    }

    public void log(String log){
        System.out.println("FreshUI:Program:: " + log);
    }

}
