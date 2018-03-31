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
    // private int x;
    // private int y;
    
    private boolean createdObsOne = false;
    // private boolean createdObsTwo;
    
    /**
     * Construtor do Mundo
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
        
        playerTwo jogadorDois = new playerTwo();
        addObject(jogadorDois, 50, 260);
        addObject(jogadorDois.getLifeCounter(), 70, 50);
        
        createPlatform();
    }
    
    public void act()
    {
       // obstacle_1 e obstacle_2 nao sao nomes bons, alterar quando houver as imagens corretas

       sideScrollPlatform();
       createObstacle();
    }   
    
    /**
     * Cria um obstaculo aleatoriamente no Mundo desde que o mesmo nao esteja por cima das
     * plataformas. Se e o caso, entao esse obstaculo nao e gerado. Ambos os obstaculos sao
     * gerados conforme uma condiçao no fim deste metodo, onde a mesma esta dependente se um
     * dado obstaculo ja foi gerado ou nao.
     */
    
    public void createObstacle() {
     
        if(Greenfoot.getRandomNumber(100) < 0.5)
        { 
            int x = getWidth();
            int y = Greenfoot.getRandomNumber(getHeight());
            
            if(avoidConflict(y)) {
                return;
            }
            
            if(!createdObsOne) {
                createObstacleOne(x, y);
                createdObsOne = true;
            }
            else {
                createObstacleTwo(x, y);
                createdObsOne = false;
            }

        }
        
    }
    
    public boolean avoidConflict(int y) {
    
        if(y > 0 && y < 20 || y > 270 && y < 320 || y > 550 && y < 600) {
            return true;
        }
        else {
            return false;
        }
        
    }
    
    public void createObstacleOne(int x, int y)
    {
        addObject(new Obstacle_1(), x, y);
    }
    
    public void createObstacleTwo(int x, int y)
    {
        addObject(new Obstacle_2(), x, y);
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
