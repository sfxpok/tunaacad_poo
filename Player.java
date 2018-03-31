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
    protected int score = 0;
    // private int lives = 2;
    protected boolean jumping;
    protected boolean receivedLife;
    private int i = 1;
    
    // protected GreenfootImage image1;
    // protected GreenfootImage image2;
    // protected GreenfootImage image3;
    // protected GreenfootImage image4;
    
    protected GreenfootImage skinPlayerWalk;
    protected GreenfootImage skinPlayerJump;
    protected GreenfootImage skinPlayerCrouch;
    protected GreenfootImage skinPlayerGameOver;
    
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
        // image1 = new GreenfootImage("ninja_normal.png"); // poe as imagens num array?
        // image2 = new GreenfootImage("ninja_jump.png");
        // image3 = new GreenfootImage("ninja_crouch.png");
        // image4 = new GreenfootImage("ninja_over.png");
        // setImage(image1);
        
        skinPlayerWalk = new GreenfootImage("ninja_normal.png");
        skinPlayerJump = new GreenfootImage("ninja_jump.png");
        skinPlayerCrouch = new GreenfootImage("ninja_crouch.png");
        skinPlayerGameOver = new GreenfootImage("ninja_over.png");
        setImage(skinPlayerWalk);
    }
    
    /**
     * Verificaçao se o jogador esta no chao ou nao.
     * Esta verificaçao tem como auxiliar, o chao, sendo esse chao um Actor que tambem esta a
     * detectar se o jogador esta no chao ou nao.
     */
    
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
    
    /**
     * Permite que o jogador se mova no chao (?)
     */
    
    public void moveToGround(Actor ground)
    {
        int groundHeight = ground.getImage().getHeight();
        int newY = ground.getY() - (groundHeight + getImage().getHeight())/2;
        
        setLocation(getX(), newY);
        jumping = false;
        setImage(skinPlayerWalk);
    }
    
    /**
     * Verifica se o jogador esta a cair
     */
    
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
    
    /**
     * Habilidade de poder saltar
     */
    
    public void jump()
    {
        vSpeed = vSpeed - jumpStrength;
        jumping = true;
        fall();
        setImage(skinPlayerJump);
    }
    
    /**
     * O jogador cai com uma determinada velocidade se o mesmo esta no ar
     */
    
    public void fall()
    {
        setLocation( getX(), getY() + vSpeed );
        if(vSpeed <= 9)
        {
            vSpeed = vSpeed + accel;
        }
        jumping = true;
        
    }
    
    public void gameOver() {
        
        //lifeCounter.setValue(0);
        lifeCounter.subtract(1);
        //getWorld().removeObject(this);
        getWorld().showText("GAME OVER", getWorld().getWidth()/2, getWorld().getHeight()/2);
        Greenfoot.playSound("trumpetfail.wav");
        //getWorld().showText("Player 1 Score: " + getPoints(), 150, 530);
        setImage(skinPlayerGameOver);
        Greenfoot.stop();
        // return;
        
    }
    
}
