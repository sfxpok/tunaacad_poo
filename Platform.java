import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *
 */
public class Platform extends Actor
{ 
    /**
     * Act - do whatever the Platform wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(2);
        removePlatform();
    }
    
    /**
     * Remove plataforma se esta chega ao limite (à direita) do Mundo
     */
    public void removePlatform()
    {
        if(getX() == 799)
        {
            getWorld().removeObject(this);
        }
    }
}
