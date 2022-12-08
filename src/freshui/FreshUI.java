package freshui;
import freshui.graphics.FButton;
import freshui.graphics.FRect;
import freshui.gui.NavBar;
import freshui.gui.input.Input;
import freshui.program.FreshProgram;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class FreshUI extends FreshProgram {
    /*
    FreshUI - Java Toolkit
    Developed by Noah Lake
    */

    public void init(){
        ArrayList<String> pages = new ArrayList<>();
        pages.add("Page 1");
        pages.add("Page 2");
        pages.add("Page 3");
        pages.add("Page 4");

        NavBar nb = new NavBar(pages,getWidth(),getHeight()/10);
        add(nb, 0,getHeight() - nb.getHeight());
    }

    public static void main(String[] args) {
        new FreshUI().start();
    }

}
