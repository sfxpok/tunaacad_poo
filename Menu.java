import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *
 */
public class Menu extends World
{
    Button play = new Play();
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {
        super(800, 600, 1);
        drawPlayButton();
    }

    private void drawPlayButton(){
         addObject(play, 394, 550);
    }
}
