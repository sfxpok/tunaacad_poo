import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class World here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mundo extends World
{
    private GreenfootImage fundo;
    //private Counter livesCounter = new Counter("Lives", 3);
    //private int counter;
    /**
     * Constructor for objects of class Mundo.
     * 
     */
    public Mundo()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        fundo = getBackground();
        fundo.setColor(Color.GRAY);
        fundo.fill();
        playerOne jogadorUm = new playerOne();
        addObject(jogadorUm, 50, 530);
        addObject(jogadorUm.getLifeCounter(), 20, 20);
        addObject(new Platform(), 400,  580);
    }
    
    public void act()
    {
       // obstacle_1 e obstacle_2 nao sao nomes bons, alterar quando houver as imagens corretas
        
       generateObstacle_1(); 
       generateObstacle_2(); 
    }   
    
    public void generateObstacle_1()
    {
        if(Greenfoot.getRandomNumber(100) < 1)
        { 
            int x = getWidth();
            int y = Greenfoot.getRandomNumber( getHeight()/2 ) + getHeight()/2 - 23 ; // 23?
            addObject(new Obstacle_1(), x, y);
        }
    }
    
    public void generateObstacle_2()
    {
        if(Greenfoot.getRandomNumber(100) < 1)
        { 
            int x = getWidth();
            int y = Greenfoot.getRandomNumber( getHeight()/2 ) + getHeight()/2 - 23 ; // 23?
            addObject(new Obstacle_2(), x, y);
        }
    }
    
    
    
}
