import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends Actor
{
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
