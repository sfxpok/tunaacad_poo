import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Pen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pen extends Obstacle
{
    /**
     * Act - do whatever the Pen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
    }
    
    /**public void updateCounter()
    {
        if (Counter.getValue() == 1)
        {
            Counter.setValue(0);
            getWorld().removeObject(this);
            Greenfoot.stop();
            return;
        }
        Counter.subtract(1);
    }**/
}
