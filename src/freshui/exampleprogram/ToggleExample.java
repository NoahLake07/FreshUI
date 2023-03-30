package freshui.exampleprogram;

import freshui.FreshUI;
import freshui.gui.Header;
import freshui.gui.Toggle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ToggleExample extends FreshUI {

    JLabel labelA, labelB;
    Toggle toggleA, toggleB;

    final static int TOGGLE_LABEL_SPACING = 40;
    final static int SWITCH_Y_SPACING = 30;

    public ToggleExample(){
        this.start();
        this.setProgramName("FreshUI Toggle Component Example");
        this.setSize(450,400);

        addComponents();
    }

    private void addComponents(){
        Header header = new Header(this.getWidth(),"FreshUI Example Program", CENTER, this);
        add(header);

        toggleA = new Toggle();
        add(toggleA,40,header.getHeight()+40);

        labelA = new JLabel("STATUS OF SWITCH: " + toggleA.toString().toUpperCase());
        add(labelA,toggleA.getX()+toggleA.getWidth()+TOGGLE_LABEL_SPACING,toggleA.getY());

        MouseListener mouseAdapterOne = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                update();
            }
        };

        toggleB = new Toggle();
        add(toggleB, toggleA.getX(),toggleA.getY()+toggleA.getHeight()+SWITCH_Y_SPACING);
        toggleB.setStatus(false);
        toggleB.setColorA(new Color(118, 12, 201));

        labelB = new JLabel("TOGGLE A IS NOW DISABLED");
        add(labelB, toggleB.getX()+toggleB.getWidth()+TOGGLE_LABEL_SPACING,toggleB.getY());

        toggleA.addMouseListener(mouseAdapterOne);
        toggleB.addMouseListener(mouseAdapterOne);

        update();

    }

    private void update(){
        labelA.setText("STATUS OF SWITCH: " + toggleA.toString().toUpperCase());

        if(toggleB.getStatus()){
            toggleA.setEnabled(true);
            labelB.setText("TOGGLE A IS NOW ENABLED");
        } else {
            toggleA.setEnabled(false);
            labelB.setText("TOGGLE A IS NOW DISABLED");
        }
    }

    public static void main(String[] args) {
        new ToggleExample();
    }

}
