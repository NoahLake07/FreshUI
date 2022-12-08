package freshui.gui;
import freshui.graphics.FButton;
import freshui.interfaces.FreshComponent;
import freshui.program.FreshProgram;
import freshui.util.FColor;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class NavBar implements FreshComponent {

    // data
    ArrayList<String> pages;
    ArrayList<FButton> tiles;
    int selected = 0;

    // colors
    Color defaultColor, selectedColor;

    // size data
    private double width, height, tileW, tileH;

    // fresh component data
    private boolean isAdded = false;
    private boolean isVisible = false;
    private FreshProgram parent;
    private double baseX, baseY;

    public NavBar(ArrayList<String> pageList){
        this(pageList, 350, 50,null);
    }

    public NavBar(ArrayList<String> pageList, double w, double h){
        this(pageList, w, h, null);
    }

    public NavBar(ArrayList<String> pageList, double w, double h, FreshProgram fpParent){
        pages = pageList;
        tiles = new ArrayList<>();
        parent = fpParent;

        // set general size
        width = w;
        height = h;

        // set tile size
        tileW = width / pages.size();
        tileH = height;

        // set colors to default
        defaultColor = new Color(57, 180, 218);
        selectedColor = new Color(217, 135, 28);

        // set up the tiles
        for (int i = 0; i < pages.size(); i++) {
            FButton tile = new FButton(pages.get(i),tileW, tileH);
            System.out.println("Button Setup.");
            tile.setColor(defaultColor);
            tile.setOutlineVisible(true);
            tile.setOutlineColor(FColor.darker(defaultColor, 0.8));

            int assignedPage = i;
            tile.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    selected = assignedPage;
                    updateColors();
                }

                @Override
                public void mouseEntered(MouseEvent e){

                }

                @Override
                public void mouseExited(MouseEvent e){

                }
            });
            tiles.add(tile);
        }
        updateColors();
    }

    public void addTile(String label){
        // set tile size
        tileW = width / tiles.size()+1;
        tileH = height;

        // add the button to the bar
        pages.add(label);
        tiles.add(new FButton(label,tileW, tileH));
        System.out.println("Button Setup.");
        int finalI = tiles.size()-1;
        tiles.get(tiles.size()-1).addMouseListener( new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selected = finalI;
                updateBounds();
            }
        });
        updateColors();
    }

    private void updateBounds() {
        if (width > 0 && height > 0) {
            tileW = width / pages.size();
            tileH = height;
            for (int i = 0; i < tiles.size(); i++) {
                tiles.get(i).setBounds(baseX + (i * tileW), baseY, tileW, tileH);
            }
        } else {
            try {
                throw new Exception("Cannot update a NavBar without given bounds");
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        updateColors();
    }

    private void updateColors(){
        for (int i = 0; i < tiles.size()-1; i++) {
            if(i == selected){
                tiles.get(i).setColor(selectedColor);
                tiles.get(i).setOutlineVisible(false);
            } else {
                tiles.get(i).setColor(defaultColor);
                tiles.get(i).setOutlineVisible(true);
                tiles.get(i).setOutlineColor(FColor.darker(defaultColor, 0.8));
            }
        }
    }

    @Override
    public void setLocation(double x, double y) {
        baseX = x;
        baseY = y;
        updateBounds();
    }

    @Override
    public double getX() {
        return baseX;
    }

    @Override
    public double getY() {
        return baseY;
    }

    @Override
    public double getWidth() {
        return width;
    }

    public double getTileWidth(){
        return tileW;
    }

    @Override
    public double getHeight() {
        return height;
    }

    public double getTileHeight(){
        return tileH;
    }

    @Override
    public void setWidth(double w) {
        width = w;
        updateBounds();
    }

    @Override
    public void setHeight(double h) {
        height = h;
        updateBounds();
    }

    @Override
    public void setBounds(double x, double y, double w, double h) {
        baseX = x;
        baseY = y;
        width = w;
        height = h;
    }

    @Override
    public void setSize(double w, double h) {
        width = w;
        height = h;
        updateBounds();
    }

    @Override
    public void addToParent(double x, double y) {
        baseX = x;
        baseY = y;

        for (int i = 0; i < tiles.size(); i++) {
            parent.add(tiles.get(i), 0,0);
            System.out.println("Added tile " + i);
        }

        updateBounds();
        isAdded = true;
    }

    @Override
    public boolean isAdded() {
        return isAdded;
    }

    @Override
    public boolean isVisible() {
        return isVisible;
    }

    @Override
    public void setVisible(boolean b) {
        isVisible = b;
        for (int i = 0; i < tiles.size()-1; i++) {
            tiles.get(i).setVisible(b);
        }
    }

    @Override
    public FreshProgram getProgramParent() {
        return parent;
    }

    @Override
    public void setProgramParent(FreshProgram fpParent) {
        parent = fpParent;
    }
}
