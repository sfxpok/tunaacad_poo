import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo
/**
 * Write a description of class playerOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class playerOne extends Player
{
    private final int MAX_LIVES = 5;
    
    private int vSpeed = 0;
    private int accel = 1;
    private int jumpStrength = 20;
    private int score = 0;
    private int lives = 2;
    private boolean jumping;
    
    private GreenfootImage image1;
    private GreenfootImage image2;
    private GreenfootImage image3;
    private GreenfootImage image4;
    
    Counter lifeCounter = new Counter(); // instance of Counter
    
    public playerOne()
    {
        image1 = new GreenfootImage("ninja_normal.png");
        image2 = new GreenfootImage("ninja_jump.png");
        image3 = new GreenfootImage("ninja_crouch.png");
        image4 = new GreenfootImage("ninja_over.png");
        setImage(image1);
    }
    
    public void act() 
    {
      checkFall();
      checkKey();
      move();
      captureObstacle_1();
      captureObstacle_2();
      addLifeWithScore();
    }
    
    public Counter getLifeCounter()
    {
        return lifeCounter;
    }   
    
    public void addPoints()
    {
        score = score + 20;
    }
    
    public void removePoints()
    {
        score = score - 10;
    }
    
    public int getPoints()
    {
        return score;
    }
    
    public void addLifeWithScore()
    {
        for(int i = 1; i < 100; i++)
        {
            if(getPoints() >= 200 * i)
            {
                lifeCounter.add(1);
            }
        }
    }
    
    public void move()
    {
        if(Greenfoot.isKeyDown("d"))
        {
           move(5); 
        }
        if(Greenfoot.isKeyDown("a"))
        {
           move(-5); 
        }
        if(Greenfoot.isKeyDown("s"))
        {
            setImage(image3);
            setLocation(getX(), getY() + 10);
        }
    }
    
    public void checkKey()
    {
        if(Greenfoot.isKeyDown("w") && jumping == false)
        {
            jump();
        }
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
    
    public void captureObstacle_1()
    {
        if(isTouching(Obstacle_1.class))
        {
            removeTouching(Obstacle_1.class);
            addPoints();
            getWorld().showText("Score:" + score, 80, getWorld().getHeight() - 20);
        }
    }
    
    public void captureObstacle_2()
    {
        if(isTouching(Obstacle_2.class))
        {
            if (lifeCounter.getValue() == 1)
            {
                lifeCounter.setValue(0);
                //getWorld().removeObject(this);
                getWorld().showText("GAME OVER", getWorld().getWidth()/2, getWorld().getHeight()/2);
                getWorld().showText("Player 1 Score: " + getPoints(), 150, 530);
                setImage(image4);
                Greenfoot.stop();
                //return;
            }
            lifeCounter.subtract(1);
            removeTouching(Obstacle_2.class);
            removePoints();
            getWorld().showText("Score:" + score, 80, getWorld().getHeight() - 20);
        }
    }
}