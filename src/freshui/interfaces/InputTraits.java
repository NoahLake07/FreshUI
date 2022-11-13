package freshui.interfaces;

import java.awt.*;

public interface InputTraits {

    void setLabel(String s);
    String getLabel();

    String getInputText();
    void setInputText(String s);

    Color getLabelColor();
    void setLabelColor(Color c);

}
