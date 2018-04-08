import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo

/**
 * Write a description of class playerOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class playerOne extends Player
{

    private int i = 1;
    private int score;
    private boolean receivedLife;
    // private boolean jumping;

    public playerOne()
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
    
    public void gameOver() {
        
        //lifeCounter.setValue(0);
        lifeCounter.subtract(1);
        //getWorld().removeObject(this);
        getWorld().showText("GAME OVER", getWorld().getWidth()/2, getWorld().getHeight()/2);
        
        getWorld().showText("Player 2 wins!", getWorld().getWidth()/2, getWorld().getHeight()/2-100);
        
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
    * Uma vida é dada ao jogador se e só se o mesmo pode receber a vida (isto depende do booleano receivedLife para que
    o jogador não receba vidas de forma infinita) e se atingiu 60*i pontos
    */
    
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
    
    /**
     * Controlos dados ao jogador
     */

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
            setImage(skinPlayerCrouch);
            setLocation(getX(), getY() + 10);
        }
    }
    
    /**
     * Permite que o jogador salte se uma determinada tecla é carregada
     */

    public void checkKey()
    {
        if(Greenfoot.isKeyDown("w") && jumping == false)
        {
            jump();
        }
    }
    
    /**
     * Se o jogador apanhou o obstáculo 1 (barril), ele recebe 20 pontos e o obstáculo desaparece
     */

    public void captureObstacle_1()
    {
        if(isTouching(Obstacle_1.class))
        {
            removeTouching(Obstacle_1.class);
            addPoints();
            getWorld().showText("Player 1 Score: " + score, 130, getWorld().getHeight() - 10);
        }
    }
    
    /**
     * Se o jogador apanhou o obstaculo 2 (aranha), ele perde 10 pontos e o obstáculo desaparece. Também abre a possibilidade de o jogador perder o jogo
     * se o mesmo atinge 0 ou menos pontos
     */

    public void captureObstacle_2()
    {
        if(isTouching(Obstacle_2.class))
        {
            
            //i--;
            
            if (lifeCounter.getValue() == 1)
            {
                gameOver();
                return; // nao tirar este return
            }
            lifeCounter.subtract(1);
            removeTouching(Obstacle_2.class);
            removePoints();
            getWorld().showText("Player 1 Score: " + score, 130, getWorld().getHeight() - 10);
            
            
        }
    }
}