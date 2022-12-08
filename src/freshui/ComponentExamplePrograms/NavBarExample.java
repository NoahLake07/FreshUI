package freshui.ComponentExamplePrograms;

import freshui.gui.NavBar;
import freshui.program.FreshProgram;

import javax.swing.*;
import java.util.ArrayList;

public class NavBarExample extends FreshProgram {

    public void init(){
        // page data
        JLabel pg1 = new JLabel("This is page one.");
        JLabel pg2 = new JLabel("This is page two.");
        JLabel pg3 = new JLabel("This is page three.");
        JLabel pg4 = new JLabel("This is page four.");

        // setup page navigation
        ArrayList<String> pages = new ArrayList<>();
        pages.add("Page 1");
        pages.add("Page 2");
        pages.add("Page 3");
        pages.add("Page 4");
        NavBar nb = new NavBar(pages,getWidth(),getHeight()/10);
        add(nb, 0,getHeight() - nb.getHeight());
        nb.setAction(new Runnable() {
            @Override
            public void run() {
                switch(nb.getSelected()){
                    case 1:
                        pg1.setVisible(true);
                        pg2.setVisible(false);
                        pg3.setVisible(false);
                        pg4.setVisible(false);
                        break;

                    case 2:
                        pg1.setVisible(false);
                        pg2.setVisible(true);
                        pg3.setVisible(false);
                        pg4.setVisible(false);
                        break;

                    case 3:
                        pg1.setVisible(false);
                        pg2.setVisible(false);
                        pg3.setVisible(true);
                        pg4.setVisible(false);
                        break;

                    case 4:
                        pg1.setVisible(false);
                        pg2.setVisible(false);
                        pg3.setVisible(false);
                        pg4.setVisible(true);
                        break;

                }
            }
        });

        add(pg1, 30,30);
        add(pg2, 30,30);
        add(pg3, 30,30);
        add(pg4, 30,30);
        nb.setSelected(1);
    }

    public static void main(String[] args) {
        new NavBarExample().start();
    }

}
