import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends Actor
{
    /**
     * Act - do whatever the Projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage bulletImage;
    
    public Projectile(String bulletImage)
    {
        setImage(new GreenfootImage(bulletImage));
        getImage().scale(20, 20);
    }
    
    public void act()
    {
        move(10);
        if (isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }
    
    
}
