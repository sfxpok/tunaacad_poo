import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Obstacle_2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstacle_2 extends Obstacle
{
    /**
     * Act - do whatever the Obstacle_2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
    }    
    
    public void move()
    {
        setLocation(getX() - 2, getY());
        
        if(getX() == 0 )
        {
            getWorld().removeObject(this);
        }
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
