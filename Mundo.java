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
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        
        fundo = getBackground();
        fundo.setColor(Color.GRAY);
        fundo.fill();
        
        playerOne jogadorUm = new playerOne();
        addObject(jogadorUm, 50, 549);
        addObject(jogadorUm.getLifeCounter(), 70, getHeight()/2 + 50);
        
        createPlatform();
        
    }
    
    public void act()
    {
       // obstacle_1 e obstacle_2 nao sao nomes bons, alterar quando houver as imagens corretas
        
       createObstacle_1(); 
       createObstacle_2();
       sideScrollPlatform();
    }   
    
    public void createObstacle_1()
    {
        if(Greenfoot.getRandomNumber(100) < 0.5)
        { 
            int x = getWidth();
            int y = Greenfoot.getRandomNumber(getHeight()/2) + getHeight()/2 - 23;
            
            if(y > 270 && y < 320) {
                return;
            }
            
            addObject(new Obstacle_1(), x, y);
        }
    }
    
    public void createObstacle_2()
    {
        if(Greenfoot.getRandomNumber(100) < 0.5)
        { 
            int x = getWidth();
            int y = Greenfoot.getRandomNumber(getHeight()/2) + getHeight()/2 - 23;
            
            if(y > 270 && y < 320) {
                return;
            }
            
            addObject(new Obstacle_2(), x, y);
        }
    }
    
    /**
     * Adiciona a plataforma no meio do mundo e no chao
     */
    public void createPlatform() {      
        //Adiciona plataformas no meio do Mundo
        addObject(new Platform(), 0, getHeight()/2);
        addObject(new Platform(), getWidth()/2, getHeight()/2);
        
        //Adiciona plataformas no fundo do Mundo
        addObject(new Platform(), 0, (getHeight())-10);
        addObject(new Platform(), getWidth()/2, (getHeight())-10);
    }
    
    /**
     * Remove plataforma se esta chega ao limite direito do Mundo,
     * adiciona nova plataforma após esta ser apagada
     */
    public void sideScrollPlatform(){
        int numPlatforms = getObjects(Platform.class).size();
        Platform platform = new Platform();
        //if(getObjects(Platform.class).isEmpty()){
        if(numPlatforms == 2){
            addObject(new Platform(), 0, getHeight()/2);
            addObject(new Platform(), 0, (getHeight())-10);
        }
    }
    
    
    
}
