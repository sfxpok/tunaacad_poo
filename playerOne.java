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
    // public  boolean canGenerateObstacles;
    // private boolean jumping;
    private int capturePenInARow;

    public playerOne()
    {
        setImage(skinPlayerWalk);
    }
    
    public void act() 
    {
      checkFall();
      checkKey();
      movement();
      captureGuitar();
      capturePen();
      addLifeWithScore();
      //gameOver();
    }
    
   public void gameOver() {
        
        //lifeCounter.setValue(0);
        lifeCounter.subtract(1);
        //getWorld().removeObject(this);
        getWorld().showText("GAME OVER", getWorld().getWidth()/2, getWorld().getHeight()/2);
        
        getWorld().showText("Player 2 wins!", getWorld().getWidth()/2, getWorld().getHeight()/2-100);
        
        Greenfoot.playSound("soul_gameover_hit_break.wav");
        //getWorld().showText("Player 1 Score: " + getPoints(), 150, 530);
        setImage(skinPlayerGameOver);
        
        ((Mundo)getWorld()).removeObjects(); // typecasting
      
        // Greenfoot.stop();
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
     * Retira 20 pontos ao jogador (overload)
     */

    public void removePoints(int pointsToRemove) {
        score = score - pointsToRemove;
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
    o jogador não receba vidas de forma infinita) e se atingiu scoreToGetLife*i pontos
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
    
    /**
     * Controlos dados ao jogador, mas só ao movimento para a esquerda e direita.   
     */

    public void movement()
    {
        if(Greenfoot.isKeyDown("d")) // override
        {
           move(5); 
           if(jumping == false)
           {
               setImage(skinPlayerFly);
           }
        }
        if(Greenfoot.isKeyDown("a")) // override
        {
           move(-5); 
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
     * Se o jogador captura a guitarra, a mesma desaparece e é atribuido mais 20 pontos ao jogador
     */

    public void captureGuitar()
    {
        if(isTouching(Guitar.class))
        {
            capturePenInARow = 0;
            removeTouching(Guitar.class);
            addPoints();
            getWorld().showText("Player 1 Score: " + score, 130, getWorld().getHeight() - 10);
            Greenfoot.playSound("battle_item_eat.wav");
        }
    }
    
    /**
     * Se o jogador captura a caneta, a mesma desaparece e é atribuido menos 10 pontos ao jogador.
     * Se o jogador tem 1 vida, este método recorre ao método gameOver() para terminar o jogo.
     */

    public void capturePen()
    {
        if(isTouching(Pen.class))
        {
            
            if (lifeCounter.getValue() == 1)
            {
                gameOver();
                return; // nao tirar este return
            }

            capturePenInARow++;

            if(capturePenInARow == 2) {
                removePoints(20); // overload
            }
            else {
                removePoints();
            }

            lifeCounter.subtract(1);
            removeTouching(Pen.class);
            getWorld().showText("Player 1 Score: " + score, 130, getWorld().getHeight() - 10);
            Greenfoot.playSound("soul_damage_1.wav");

        }
    }
}