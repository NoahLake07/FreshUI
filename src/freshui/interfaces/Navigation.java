package freshui.interfaces;

import java.util.ArrayList;

public interface Navigation<T> {

   void setSelected(int page);
   int getSelected();

   void addTile(T ti);
   T getTile(int i);
   ArrayList<T> getTiles();
   void setTiles(ArrayList<T> tiles);

}
