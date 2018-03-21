import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color.*;
 
/**
 * A simple counter with graphical representation as an actor on screen.
 * 
 * @author mik
 * @version 1.0
 */
public class Counter extends Actor
{
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;
    private int value;
    private int target;
 
    /**
     * Create a new counter, initialised to 0.
     */
    public Counter()
    {
        background = getImage();  // get image from class
        value = 5;
        target = 5;
        updateImage();
    }
     
    /**
     * Animate the display to count up (or down) to the current target value.
     */
    public void act() 
    {
        if (value > target ) {
            value--;
            updateImage();
        }
        else if (value < target) {
            value++;
            updateImage();
        }
    }
 
    /**
     * Add a new score to the current counter value.
     */
    public void add(int score)
    {
        target += score;
    }
    
    public void subtract(int score)
    {
        target -= score;
    }
 
    /**
     * Return the current counter value.
     */
    public int getValue()
    {
        return value;
    }
 
    /**
     * Set a new counter value.
     */
    public void setValue(int newValue)
    {
        target = newValue;
        value = newValue;
        updateImage();
    }
 
    /**
     * Update the image on screen to show the current value.
     */
    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage(background);
        GreenfootImage text = new GreenfootImage("" + value, 22, Color.WHITE, transparent);
        image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
                        (image.getHeight()-text.getHeight())/2);
        setImage(image);
    }
   
}
