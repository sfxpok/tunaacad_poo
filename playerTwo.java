import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class playerTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class playerTwo extends Player
{
    private int i = 1;
    private int score;
    private boolean receivedLife;
    // private boolean jumping;

    public playerTwo()
    {
        //
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
        
        // if (capturedEnemy) {
            // i--;
            // capturedEnemy = false;
        // }
        
        if(receivedLife == true && getPoints() <= 60 * (i+1)) {
            receivedLife = false;
        }
        
        if(getPoints() >= 60 * i && getPoints() <= 60 * (i+1) && receivedLife == false) {
            lifeCounter.add(1);
            receivedLife = true;
            i++;
        }
    }
    
    public void move()
    {
        if(Greenfoot.isKeyDown("l"))
        {
           move(5); 
        }
        if(Greenfoot.isKeyDown("j"))
        {
           move(-5); 
        }
        if(Greenfoot.isKeyDown("k"))
        {
            setImage(image3);
            setLocation(getX(), getY() + 10);
        }
    }
    
    public void checkKey()
    {
        if(Greenfoot.isKeyDown("i") && jumping == false)
        {
            jump();
        }
    }
    
    public void captureObstacle_1()
    {
        if(isTouching(Obstacle_1.class))
        {
            removeTouching(Obstacle_1.class);
            addPoints();
            getWorld().showText("Player 2 Score: " + score, 130, getWorld().getHeight() - 300);
        }
    }
    
    public void captureObstacle_2()
    {
        if(isTouching(Obstacle_2.class))
        {
            
            //i--;
            
            if (lifeCounter.getValue() == 1)
            {
                //lifeCounter.setValue(0);
                lifeCounter.subtract(1);
                //getWorld().removeObject(this);
                getWorld().showText("GAME OVER", getWorld().getWidth()/2, getWorld().getHeight()/2);
                //getWorld().showText("Player 1 Score: " + getPoints(), 150, 530);
                setImage(image4);
                Greenfoot.stop();
                return; // nao tirar este return
            }
            lifeCounter.subtract(1);
            removeTouching(Obstacle_2.class);
            removePoints();
            getWorld().showText("Player 2 Score: " + score, 130, getWorld().getHeight() - 300);
            
            
        }
    }
}