package freshui.graphics;

import freshui.gui.Dropdown;

import javax.swing.*;

public class DropdownTile extends FCompound {

    FRect tile = new FRect(50,10);
    JLabel text = new JLabel("Dropdown");

    public DropdownTile(String toDisplay, Dropdown parent){
        add(tile);
        text.setText(toDisplay);
        add(text, tile.getWidth()/10,tile.getHeight()/2 - text.getHeight()/2,parent.getParent().getGCanvas());
    }

}
