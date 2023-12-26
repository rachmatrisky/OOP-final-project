import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends Property
{
    public GameOver(int time) {
        GreenfootImage image = new GreenfootImage("You Lose!\nYou survived for " + (time/60) + " seconds", 28, Color.WHITE, new Color(95, 43, 178));
        setImage(image);
    }
    
    public void act()
    {
    }
}
