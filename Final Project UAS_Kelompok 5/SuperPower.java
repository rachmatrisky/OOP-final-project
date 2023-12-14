import greenfoot.*;

public class SuperPower extends Actor
{
    final int SUPER_POWER_LIMIT = 100;
    int superCount;
    int count;
    
    
    public SuperPower()
    {
        setImage(new GreenfootImage(SUPER_POWER_LIMIT + 2, 12));
        getImage().drawRect(0, 0, SUPER_POWER_LIMIT + 1, 11);
        getImage().setColor(Color.BLUE);
        getImage().fillRect(1, 1, superCount, 10);
    }
    
    public void act()
    {
        setImage(new GreenfootImage(SUPER_POWER_LIMIT + 2, 12));
        getImage().drawRect(0, 0, SUPER_POWER_LIMIT + 1, 11);
        getImage().setColor(Color.BLUE);
        getImage().fillRect(1, 1, superCount, 10);
        
        World world = getWorld();
        MyWorld myWorld = (MyWorld) world;
        
        setLocation(myWorld.getPlayer().getX() + 5, myWorld.getPlayer().getY() - 35);
        
        // Check for the space key press to use the superpower
        // if (Greenfoot.isKeyDown("space"))
        // {
            // useSuper();
        // }
        useSuper();
    }
    
    public void useSuper()
    {
        // Play the laser sound when the superpower is used
        // laserSound.play();
        count++;
        
        if (count % 5 == 0)
        {
            superCount++;
        }
        
        if (superCount > SUPER_POWER_LIMIT)
        {
            superCount = 0;
        }
    }
}
