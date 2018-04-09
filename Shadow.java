import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shadow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shadow extends Actor
{
    /**
     * Act - do whatever the Shadow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //
    }
    
    public Shadow()
    {
        setRotation(45);
    }
    
    public void moveSombraP1(){
       
        int p2X = ((playerOne) getWorld().getObjects(playerOne.class).get(0)).getX();
        int p2Y = ((playerOne) getWorld().getObjects(playerOne.class).get(0)).getY();
        
        setLocation(p2X - 8, p2Y + 36);
       
    }
    
    public void moveSombraP2(){
       
        int p2X = ((playerTwo) getWorld().getObjects(playerTwo.class).get(0)).getX();
        int p2Y = ((playerTwo) getWorld().getObjects(playerTwo.class).get(0)).getY();
        
        setLocation(p2X - 8, p2Y + 36);
        
    }
    
    public void rodaSombra(){
        //
    }    
}
