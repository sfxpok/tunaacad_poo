import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *
 */
public class Player extends Actor
{
    
    private final int MAX_LIVES = 2;
    
    private int vSpeed = 0;
    private int accel = 1;
    private int jumpStrength = 20; // Basicamente a altura do salto
    protected int score = 0;

    protected boolean jumping;
    protected boolean receivedLife;
    protected int scoreToGetLife = 60;
    
    protected GreenfootImage skinPlayerWalk;
    protected GreenfootImage skinPlayerJump;
    protected GreenfootImage skinPlayerFly;
    protected GreenfootImage skinPlayerGameOver;
    
    Counter lifeCounter = new Counter();
    
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
        skinPlayerWalk = new GreenfootImage("tuna_standing.png");
        skinPlayerJump = new GreenfootImage("tuna_jumping.png");
        skinPlayerFly = new GreenfootImage("tuna_movement_3.png");
        skinPlayerGameOver = new GreenfootImage("ninja_over.png");
        
        setImage(skinPlayerWalk);
    }
   
    /**
     * Controlos definidos ao movimento do jogador (apenas para esquerda e direita)
     */
    public void movement()
    {
        if(Greenfoot.isKeyDown("d"))
        {
           move(5);
           if(jumping == false)
           {
               setImage(skinPlayerFly);
           }
        }
        if(Greenfoot.isKeyDown("a"))
        {
           move(-5);
        }
    }
    
    /**
     * Verificaçao se o jogador está no chão ou nao.
     * Esta verificaçao tem como auxiliar, o chao, sendo esse chao um Actor que tambem esta a
     * detectar se o jogador esta no chao ou nao.
     */    
    public boolean onGround()
    {
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
     * Permite que o jogador se mova no chao
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
}
