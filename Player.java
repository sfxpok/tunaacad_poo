import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    
    private final int MAX_LIVES = 5;
    
    private int vSpeed = 0;
    private int accel = 1;
    private int jumpStrength = 20;
    private int score = 0;
    // private int lives = 2;
    protected boolean jumping;
    private boolean receivedLife;
    private int i = 1;
    
    private boolean capturedEnemy;
    
    protected GreenfootImage image1;
    protected GreenfootImage image2;
    protected GreenfootImage image3;
    protected GreenfootImage image4;
    
    Counter lifeCounter = new Counter(); // instance of Counter
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    
    public Player()
    {
        image1 = new GreenfootImage("ninja_normal.png");
        image2 = new GreenfootImage("ninja_jump.png");
        image3 = new GreenfootImage("ninja_crouch.png");
        image4 = new GreenfootImage("ninja_over.png");
        setImage(image1);
    }
    
    public void fall()
    {
        setLocation( getX(), getY() + vSpeed );
        if(vSpeed <= 9)
        {
            vSpeed = vSpeed + accel;
        }
        jumping = true;
        
    }
    
    public boolean onGround()
    {
        int spriteHeight = getImage().getHeight();
        int yDistance = (int) (spriteHeight / 2 + 5);
        
        Actor ground = getOneObjectAtOffset ( 0, getImage().getHeight()/2, Platform.class );
        if(ground == null)
        {
            return false;
        }
        else
        {
            moveToGround(ground);
            return true;
        }
    }
    
    public void moveToGround(Actor ground)
    {
        int groundHeight = ground.getImage().getHeight();
        int newY = ground.getY() - (groundHeight + getImage().getHeight())/2;
        
        setLocation(getX(), newY);
        jumping = false;
        setImage(image1);
    }
    
    public void checkFall()
    {
        if(onGround())
        {
            vSpeed = 0;
        }
        else
        {
            fall();
        }
    }
    
    
    public void jump()
    {
        vSpeed = vSpeed - jumpStrength;
        jumping = true;
        fall();
        setImage(image2);
    }
    
}
