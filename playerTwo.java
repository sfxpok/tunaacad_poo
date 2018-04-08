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
    private int scoreToGetLife = 60;
    // private boolean jumping;
    

    public playerTwo()
    {
        //
        setImage(skinPlayerWalk);
    }
    
    public void act() 
    {
      checkFall();
      checkKey();
      movement();
      captureObstacle_1();
      captureObstacle_2();
      addLifeWithScore();
    }
    
    public void gameOver() {
        
        //lifeCounter.setValue(0);
        lifeCounter.subtract(1);
        //getWorld().removeObject(this);
        getWorld().showText("GAME OVER", getWorld().getWidth()/2, getWorld().getHeight()/2);
        
        getWorld().showText("Player 1 wins!", getWorld().getWidth()/2, getWorld().getHeight()/2+100);
        
        Greenfoot.playSound("trumpetfail.wav");
        //getWorld().showText("Player 1 Score: " + getPoints(), 150, 530);
        setImage(skinPlayerGameOver);
        Greenfoot.stop();
        // return;
        
    }
    
    /**
     * Retorna o numero de vidas dentro da classe Counter
     */
    
    public Counter getLifeCounter()
    {
        return lifeCounter;
    }   
    
    /**
     * Adiciona 20 pontos ao jogador
     */
    
    public void addPoints()
    {
        score = score + 20;
    }
    
    /**
     * Retira 10 pontos ao jogador
     */
    
    public void removePoints()
    {
        score = score - 10;
    }
    
    /**
     * Retorna os pontos que o jogador tem
     */
    
    public int getPoints()
    {
        return score;
    }
    
    /**
     * Incrementa o numero de vidas do jogador se o jogador atingiu uma certa pontuaçao. A variavel
     * receivedLife e util aqui porque evita que o jogador receba vidas infinitivamente (AINDA POR
     * MUDAR)
     */
    
    public void addLifeWithScore()
    {
        
        if(receivedLife == true && getPoints() <= scoreToGetLife * (i+1)) {
            receivedLife = false;
        }
        
        if(getPoints() >= scoreToGetLife * i && getPoints() <= scoreToGetLife * (i+1) && receivedLife == false) {
            lifeCounter.add(1);
            receivedLife = true;
            i++;
        }
    }
    
    public void movement()
    {
        if(Greenfoot.isKeyDown("right"))
        {
           move(5); 
           if(jumping == false)
           {
               setImage(skinPlayerFly);
           }
        }
        if(Greenfoot.isKeyDown("left"))
        {
           move(-5); 
        }
    }
   
    
    /**
     * Faz com que o jogador salte, desde que teja no chao e que a tecla i esteja a ser pressionada
     */
    
    public void checkKey()
    {
        if(Greenfoot.isKeyDown("up") && jumping == false)
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
            //Greenfoot.playSound("deepmaleburp.wav");
        }
    }
    
    public void captureObstacle_2()
    {
        if(isTouching(Obstacle_2.class))
        {
            if (lifeCounter.getValue() == 1)
            {
                gameOver();
                return;
            }
            
            lifeCounter.subtract(1);
            removeTouching(Obstacle_2.class);
            removePoints();
            getWorld().showText("Player 2 Score: " + score, 130, getWorld().getHeight() - 300);
            Greenfoot.playSound("ow.wav");
        }
    }
}