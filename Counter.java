import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color.*;
 
/**
 * Contador de vidas
 * 
 * @author
 * @version
 */
public class Counter extends Actor
{
    private static final Color TRANSPARENT = new Color(0,0,0,0);
    
    private GreenfootImage background;
    private int value;
    private int target;
 
    /**
     * Construtor do contador
     */
    public Counter()
    {
        background = getImage();  // get image from class
        value = 5;
        target = 5;
        updateImage();
    }
     
    /**
     * Atualizaçao do contador quando o Actor apanha algum item
     */
    public void act() 
    {
        if (value > target ) {
            value--;
            updateImage();
        }
        else if (value < target) {
            value++;
            updateImage();
        }
    }
 
    /**
     * Adiçao de vidas
     */
    public void add(int score)
    {
        target += score;
    }
    
    /**
     * Subtracçao das vidas
     */
    public void subtract(int score)
    {
        target -= score;
    }
 
    /**
     * "Getter" das vidas
     */
    public int getValue()
    {
        return value;
    }
 
    /**
     * "Setter" das vidas
     */
    public void setValue(int newValue)
    {
        target = newValue;
        value = newValue;
        updateImage();
    }
 
    /**
     * Actualizaçao da imagem que representa o numero de vidas restante
     */
    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage(background);
        GreenfootImage text = new GreenfootImage("" + value, 22, Color.WHITE, TRANSPARENT);
        image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
                        (image.getHeight()-text.getHeight())/2);
        setImage(image);
    }
   
}
