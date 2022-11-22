package freshui.interfaces;

import java.awt.*;

public interface HeaderTraits {

    String getText();
    void setText(String s);

    Font getFont();
    void setFont(Font f);
    void setFont(String fontName, int fontType, int size);
    void setFont(String fontName);

    Color getTextColor();
    void setTextColor(Color c);

}
