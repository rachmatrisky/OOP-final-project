import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{
    private int time;
    private int health = 50;
    GreenfootSound defeatSound = new GreenfootSound("defeat.wav");

    public HealthBar()
    {
        setImage(new GreenfootImage(52, 12));
        getImage().drawRect(0, 0, 51, 11);
        getImage().setColor(Color.RED);
        getImage().fillRect(1, 1, health, 10);
    }

    public void act()
    {
        time++;
        
        setImage(new GreenfootImage(80, 12));
        getImage().drawRect(0, 0, 51, 11);
        getImage().setColor(Color.RED);
        getImage().fillRect(1, 1, health, 10);

        World world = getWorld();
        MyWorld myWorld = (MyWorld) world;

        setLocation(myWorld.getPlayer().getX() - 5, myWorld.getPlayer().getY() - 20);
        loseHealth();
    }
    
    public int getTime()
    {
        return time;
    }

    public void loseHealth()
    {
        World world = getWorld();
        MyWorld myWorld = (MyWorld) world;

        if (myWorld.getPlayer().hitByZombie())
        {
            health--;
        }

        if (health <= 0)
        {
            // getWorld().showText("You Lose! \n You survived for " + (time / 60) + " seconds,", getWorld().getWidth() / 2, getWorld().getHeight() / 2);
            // endGame();
            getWorld().addObject(new GameOver(time), getWorld().getWidth() / 2, getWorld().getHeight() / 2);
            defeatSound.play();
            Greenfoot.stop();
        }
    }
    
    // public void endGame()
    // {
        // GreenfootImage image = new GreenfootImage(150, 50);
        
        // image.setColor(new Color(95, 43, 178));
        // image.fill();
        
        // image.setColor(Color.WHITE);
        // image.setFont(new Font("Arial", true, false, 18));
        // image.drawString("You Lose!\nYou survived for " + (time / 60) + " seconds.", getWorld().getWidth() / 2, getWorld().getHeight() / 2);
        
        // setImage(image);
        
        // // getWorld().addObject(image, getWorld().getWidth() / 2, getWorld().getHeight() / 2);
    // }
}
