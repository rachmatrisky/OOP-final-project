import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayButton extends Actor
{
    private GreenfootImage playImage = new GreenfootImage("playbutton.png");

    public PlayButton()
    {
        setImage(playImage);
    }

    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            MyWorld world = (MyWorld) getWorld();
            world.setGameRunning(true);
            world.removeObject(this);  // Remove the button after it's clicked
        }
    }
}