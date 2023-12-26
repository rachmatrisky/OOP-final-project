import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zombie extends Actor
{
    int health;
    GreenfootImage zombieImage;
    Player player;
    Counter counter;
    
    public Zombie(int health, String zombieImage, Player mainPlayer, Counter counter)
    {
        player = mainPlayer;
        this.counter = counter;
        this.health = health;
        setImage(new GreenfootImage(zombieImage));
    }
    
    public void act()
    {
        // Add your action code here.
        moveTowardsPlayer();
        getHit();
    }
    
    public void moveTowardsPlayer()
    {
        move(1);
        // change temporaly
        turnTowards(player.getX(), player.getY());
    }
    
    public void getHit()
    {
        Actor projectile = getOneIntersectingObject(Projectile.class);
        if (projectile != null)
        {
            health--;
            getWorld().removeObject(projectile);
        }
        
        if (health == 0)
        {
            counter.score++;
            counter.money += 5;
            getWorld().removeObject(this);
        }
    }
}
