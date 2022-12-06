package freshui.gui;

import freshui.Constants;
import freshui.graphics.FButton;
import freshui.interfaces.FreshComponent;
import freshui.program.FreshProgram;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class NavigationBar implements FreshComponent {

    // data
    ArrayList<String> pages;
    ArrayList<FButton> tiles;
    Image navImage;

    // size data
    private double width, height, tileW, tileH;

    // placement data
    private int pagePlacement;

    // fresh component data
    private boolean isAdded = false;
    private boolean isVisible = false;
    private boolean hasImage = false;
    private FreshProgram parent;
    private double baseX, baseY;

    public NavigationBar(ArrayList<String> tiles){
        this(tiles, 400, 40, Constants.BOTTOM, null,null);
    }

    public NavigationBar(ArrayList<String> pageList, double w, double h, int placement, Image img, FreshProgram fpParent){
        pages = pageList;
        tiles = new ArrayList<>();
        parent = fpParent;
        width = w;
        height = h;
        pagePlacement = placement;

        if(img != null){
            hasImage = true;
            navImage = img;
        }

        setupTiles();
    }

    private void setupTiles(){
        if(width > 0 && height > 0){
            if(pagePlacement == Constants.TOP || pagePlacement == Constants.BOTTOM) {
                tileW = width / pages.size();
                tileH = height;
            } else if (pagePlacement == Constants.LEFT || pagePlacement == Constants.RIGHT){
                tileW = width;
                tileH = height / pages.size();
            } else if (pagePlacement == Constants.CENTER){
                tileW = width / pages.size();
                tileH = height;
            } else {
                try {
                    throw new Exception("Invalid Parameter Given: Page Placement");
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }

            for (int i = 0; i < pages.size()-1; i++) {
                tiles.add(new FButton(pages.get(i)));
            }
        } else {
            try {
                throw new Exception("Cannot setup a NavBar without a width and height");
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
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

    public void updateBounds(){
        // TODO update bounds
    }

    @Override
    public void setSize(double w, double h) {

        // TODO set tile sizes
    }

    @Override
    public void addToParent(double x, double y) {
        baseX = x;
        baseY = y;
        //TODO add
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
