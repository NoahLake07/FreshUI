package freshui.util;

import java.awt.Color;
import java.util.ArrayList;

public class FColor {

    public static final ArrayList<Color> presetColors = new ArrayList<>();

    private static void setupColors(){
        presetColors.add(new Color(232, 38, 38));
        presetColors.add(new Color(236, 141, 45));
        presetColors.add(new Color(238, 190, 62));
        presetColors.add(new Color(66, 236, 93));
        presetColors.add(new Color(71, 197, 141));
        presetColors.add(new Color(52, 123, 185));
        presetColors.add(new Color(91, 58, 213));
        presetColors.add(new Color(206, 64, 197));
    }

    public static Color getRandomColor(ArrayList<Color> colorList){

        if(presetColors.size() == 0){
            setupColors();
        }

        ArrayList<Color> pickedColorList = colorList;
        int random = (int) (Math.random()*(colorList.size()-1));

        return pickedColorList.get(3);
    }

}
