import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Obstacle_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstacle_1 extends Obstacle
{
    /**
     * Act - do whatever the Obstacle_1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        //generate();
        move();
    } 
    
    public void move()
    {
        setLocation(getX() - 2, getY() );
        
        if(getX() == 0)
        {
            getWorld().removeObject(this);
        }
    }
}
