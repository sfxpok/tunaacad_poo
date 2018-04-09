import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class startOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class startOver extends Button
{
    /**
     * Act - do whatever the startOver wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.mouseClicked(this))
    	{
    	    // Greenfoot.start();
    	    Greenfoot.setWorld(new Menu());
    	    Greenfoot.playSound("battle_item_equip.wav");
    	}
    }     
}
