import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Platform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Platform extends Actor
{ 
    //private int numeroPlataformas = getWorld().getObjects(Platform.class).size();
    /**
     * Act - do whatever the Platform wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(2);
        removePlataform();
    }
    
    /**
     * Remove plataforma se esta chega ao limite direito do Mundo,
     * adiciona nova plataforma após esta ser apagada
     */
    public void removePlataform()
    {
        if(getX() == 799)
        {
            getWorld().removeObject(this);
        }
    }
}
