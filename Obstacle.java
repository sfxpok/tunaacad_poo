import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Obstacle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstacle extends Actor
{
    /**
     * Act - do whatever the Obstacle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // move();
    }
    
    /**
     * Os obstáculos movem-se para a esquerda, 2 passos no eixo X de cada vez. Quando o mesmo
     * chega ao outro canto do Mundo (coordenada 0 do eixo X), ele é eliminado
     */

    public void move()
    {
        setLocation(getX() - 2, getY());
        
        if(getX() == 0 )
        {
            getWorld().removeObject(this);
        }
    }
}
