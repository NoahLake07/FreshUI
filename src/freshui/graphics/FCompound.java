package freshui.graphics;

import acm.graphics.GCanvas;
import acm.graphics.GCompound;
import acm.graphics.GMath;
import java.awt.*;

public class FCompound extends GCompound {

    public final void add(Component var1, double var2, double var4, GCanvas gc) {
        var1.setLocation(GMath.round(var2), GMath.round(var4));
        gc.add(var1);
    }

}
