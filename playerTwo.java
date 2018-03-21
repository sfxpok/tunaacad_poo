import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class playerTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class playerTwo extends Player
{
    private int gravity;
    /**
     * Act - do whatever the playerTwo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
    }    
    
    public void move()
    {
        /*if(Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY() - 1 );
        }
        */
        /*if(Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY() + 1 );
        }
        */
         if(Greenfoot.isKeyDown("left"))
        {
            setLocation(getX() - 1, getY() );
        }
        
         if(Greenfoot.isKeyDown("right"))
        {
            setLocation(getX() + 1, getY() );
        }
    }
}
