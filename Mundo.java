import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *
 */
public class Mundo extends World
{
    private GreenfootImage fundo;
    
    private boolean createdGuitar = false;

    private Color aMinhaCor;
    
    private int r = 255;
    private int g = 255;
    private int b = 0;
    private boolean colorStop = false; // Pára de incrementar a cor azul se True
    
    /**
     * O construtor cria um mundo do tamanho 800x600 com um fundo cinzento.
     * O jogadorUm e jogadorDois instancias das classes playerOne e playerTwo, respetivamente. 
     */
    public Mundo()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        
        fundo = getBackground();
        fundo.setColor(Color.GRAY);
        fundo.fill();
        
        playerOne jogadorUm = new playerOne();
        shadowPlayerOne shadowOne = new shadowPlayerOne();
        addObject(jogadorUm, 50, 549);
        addObject(shadowOne, 50, 549);
        addObject(jogadorUm.getLifeCounter(), 70, getHeight()/2 + 50);        
        
        playerTwo jogadorDois = new playerTwo();
        shadowPlayerTwo shadowTwo = new shadowPlayerTwo();
        addObject(jogadorDois, 50, 260);
        addObject(shadowTwo, 50, 549);
        addObject(jogadorDois.getLifeCounter(), 70, 50);
        
        createPlatform();
        
        setPaintOrder(Shadow.class); //Da prioridade aos objetos desta classe
    }
    
    public void act()
    {
       sideScrollPlatform();
       createObstacle();
       pintaMundo();
    } 
    
    /**
     * Este método remove as sombras e ambos os jogadores quando o jogo acaba
     * e coloca um objeto no mundo que se clicado permite voltar ao Menu
     */
    public void removeObjects() {  
        removeObjects(getObjects(Player.class));
        removeObjects(getObjects(Shadow.class));
        
        continueGame();     
    }
    
    /**
     * Cria um botão para reiniciar o jogo
     */
    public void continueGame() {   
        startOver rebootGame = new startOver();
        addObject(rebootGame, 650, 375); 
    }
    
    /**
     * Este método alterna a cor de fundo do Mundo, continuamente (entre amarelo e azul)
     */
    public void pintaMundo()
    {
        if(b < 255 && colorStop == false){
            r--;
            g--;
            b++;
            if(b == 255){
                colorStop = true;
            }
        }

        if(colorStop == true){
            b--;
            r++;
            g++;
            if(b == 0){
                colorStop = false;
            }
        }

        fundo = getBackground();
        Color aMinhaCor = new Color(r,g,b);
        fundo.setColor(aMinhaCor);
        fundo.fill();
    }
    
    /**
     * Adiciona a plataforma no meio do mundo e no chao
     */
    public void createPlatform() {      
        //Adiciona plataformas no meio do Mundo
        addObject(new Platform(), 0, getHeight()/2);
        addObject(new Platform(), getWidth()/2, getHeight()/2);
        
        //Adiciona plataformas no fundo do Mundo
        addObject(new Platform(), 0, (getHeight())-10);
        addObject(new Platform(), getWidth()/2, (getHeight())-10);
    }
    
    /**
     * Cria um obstaculo aleatoriamente no Mundo desde que o mesmo nao esteja por cima das
     * plataformas. Se e o caso, entao esse obstaculo nao e gerado. Ambos os obstaculos sao
     * gerados conforme uma condiçao no fim deste metodo, onde a mesma esta dependente se um
     * dado obstaculo ja foi gerado ou nao.
     */    
    public void createObstacle() {   
        if(Greenfoot.getRandomNumber(100) < 0.5)
        { 
            int x = getWidth();
            int y = Greenfoot.getRandomNumber(getHeight());
            
            if(avoidConflict(y)) { //Este metodo encontra-se logo abaixo
                return;
            }
            
            if(!createdGuitar) {
                createGuitar(x, y);
                createdGuitar = true;
            }
            else {
                createPen(x, y);
                createdGuitar = false;
            }

        }       
    }
    
    /**
     * Este metodo faz com que os obstaculos nao fiquem por cima das plataformas ou quase fora do
     * Mundo
     */    
    public boolean avoidConflict(int y) {
    
        if(y > 0 && y < 20 || y > 270 && y < 320 || y > 550 && y < 600) {
            return true;
        }
        else {
            return false;
        }
        
    }
    
    /**
     * Cria o obstaculo (guitarra)
     */
    public void createGuitar(int x, int y)
    {
        addObject(new Guitar(), x, y);
    }
    
    /**
     * Cria o inimigo (caneta)
     */    
    public void createPen(int x, int y)
    {
        addObject(new Pen(), x, y);
    }
    
    /**
     * Remove plataforma se esta chega ao limite direito do Mundo,
     * adiciona nova plataforma após esta ser apagada
     */
    public void sideScrollPlatform(){ //movePlataforma();
        int numPlatforms = getObjects(Platform.class).size();
        int yCoordPlatformMiddle = getHeight()/2;
        int yCoordPlatformBottom = getHeight()-10;
        
        Platform platform = new Platform();
        if(numPlatforms == 2){
            addObject(new Platform(), 0, yCoordPlatformMiddle);
            addObject(new Platform(), 0, yCoordPlatformBottom);
        }
    }   
}
