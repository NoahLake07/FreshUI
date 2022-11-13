package freshui.interfaces;

import java.awt.*;

public interface ObjectOutline {

    void setOutlineThickness(int pixels);
    int getOutlineThickness();

    void setOutlineColor(Color c);
    Color getOutlineColor();

    void setOutlineVisible(boolean b);
    boolean isOutlineVisible();

}
