package freshui.gui;

import freshui.graphics.FCompound;
import freshui.graphics.FRect;
import freshui.program.FreshProgram;

import java.awt.*;

public class Header extends FCompound {
    private FreshProgram freshProgramParent;
    private int scaleFactor;
    private Color headerColor,textColor;
    double headerHeight;
    Font headerFont;

    /**
     * Constructs a header that contains a label inside. The label can be repositioned
     * and moved at will, and the fill color can also be changed.
     * With this constructor, the color of the header is defaulted to gray, and the
     * text color is defaulted to black.
     *
     * @param width     The width of the header
     * @param text      Text to be used as the title in the header
     * @param alignment The horizontal alignment of the text inside the header
     */
    public Header(int width, String text, int alignment, FreshProgram parent) {
        freshProgramParent = parent;

        // setting variables to default
        scaleFactor = 10;
        headerColor = Color.GRAY;
        textColor = Color.BLACK;
        headerHeight = freshProgramParent.getHeight() / scaleFactor;

    }
}
