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
    ArrayList<Tile> tiles;
    int selected = 0;

    // colors
    public Color defaultColor, selectedColor;

    // size data
    private double width, height, tileW, tileH;

    // fresh component data
    private boolean isAdded = false;
    private boolean isVisible = false;
    private FreshProgram parent;
    private double baseX, baseY;

    public Runnable action = () -> {};

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
            Tile tile = new Tile(pages.get(i), i, tileW, tileH);
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
        tiles.add(new Tile(label, pages.size()-1, tileW, tileH));
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

    /**
     * Runs an action presented by the caller class
     */
    public void updatePage(){
        action.run();
    }

    public void setAction(Runnable newAction){
        action = newAction;
    }

    public Runnable getAction(){
        return action;
    }

    public int getSelected(){
        return selected+1;
    }

    public int getRawSelection(){
        return selected;
    }

    public void setSelected(int s){
        selected = s-1;
        action.run();
        updateColors();
    }

    public void setRawSelection(int s){
        selected = s;
    }

    private void updateColors(){
        for (int i = 0; i < tiles.size(); i++) {
            tiles.get(i).update();
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

    private class Tile extends FButton {

        int assignedPage;
        String label;

        public Tile(String s, int assigned, double w, double h){
            super(s,w,h);
            label = s;
            assignedPage = assigned;

            MouseAdapter tileAdapter = new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    selected = assignedPage;
                    updateColors();
                    updatePage();
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    if(!isSelected()){
                        setColor(FColor.darker(defaultColor, 0.8));
                    }
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if(!isSelected()){
                        setColor(defaultColor);
                    }
                }
            };
            addMouseListener(tileAdapter);
        }

        public boolean isSelected(){
            return selected==assignedPage;
        }

        public void update(){
            if(isSelected()){
                setColor(selectedColor);
            } else {
                setColor(defaultColor);
            }
        }
    }

    public Color getDefaultColor(){
        return defaultColor;
    }

    public Color getSelectedColor(){
        return selectedColor;
    }

    public void setDefaultColor(Color defaultColor) {
        this.defaultColor = defaultColor;
    }

    public void setSelectedColor(Color selectedColor) {
        this.selectedColor = selectedColor;
    }
}
