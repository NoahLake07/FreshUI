package freshui.interfaces;

import acm.graphics.GObject;
import freshui.program.FreshProgram;

import java.awt.*;

public interface FreshComponent {

    /// region Location Methods
    void setLocation(double x, double y);
    double getX();
    double getY();
    /// endregion

    /// region Dimension Methods
    double getWidth();
    double getHeight();

    void setWidth(double w);
    void setHeight(double h);
    void setBounds(double x, double y, double w, double h);
    void setSize(double w, double h);
    /// endregion

    /// region Visibility Methods
    boolean isVisible();
    void setVisible(boolean b);
    /// endregion

    /// region Parent Link Methods
    void addToParent(double x, double y);
    boolean isAdded();
    FreshProgram getProgramParent();
    void setProgramParent(FreshProgram fpParent);
    /// endregion

}
