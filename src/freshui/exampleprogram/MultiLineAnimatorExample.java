package freshui.exampleprogram;

import freshui.FreshUI;
import freshui.graphics.Animator;
import freshui.graphics.LineAnimation;

import java.awt.*;

public class MultiLineAnimatorExample extends FreshUI {
    public void init(){
        // make the line animation objects
        LineAnimation[] lineAnimations = new LineAnimation[]{
                new LineAnimation(200,200,400,200),
                new LineAnimation(60,40, 100,300)
        };

        // set the program parent to this program
        lineAnimations[0].setProgramParent(this);
        lineAnimations[1].setProgramParent(this);

        // modify colors
        Color lineColor = new Color(197, 197, 197);
        lineAnimations[0].setColor(lineColor);
        lineAnimations[1].setColor(lineColor);
        setBackground(new Color(35, 35, 35));

        // start animations
        Animator a = new Animator(lineAnimations);
        a.startThreads();
    }
    public static void main(String[] args) {
        new MultiLineAnimatorExample().start();
    }
}
