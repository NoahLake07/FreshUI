import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import javax.swing.*;
import java.awt.*;

public class FreshUI extends GraphicsProgram {

    public void init(){
        this.getMenuBar().setVisible(false);
        this.setName("FreshUI Window");
        this.setTitle("FreshUI Window");
        this.setSize(500,500);
    }

    public void setProgramName(String s){
        this.setTitle(s);
    }

    public static void main(String[] args) {
        new FreshUI().start();
    }

}
