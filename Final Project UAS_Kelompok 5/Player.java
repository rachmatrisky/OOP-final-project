import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private int speed = 3;
    int time = 0;
    WeaponButton weaponButton;
    SuperPower superPower;
    int superTimer;
    GreenfootSound laserSound = new GreenfootSound("laser.wav");
    
    public Player()
    {
        
    }
    
    public Player(WeaponButton weaponButton, SuperPower superPower)
    {
        this.superPower = superPower;
        this.weaponButton = weaponButton;
    }
    
    
    public void act()
    {
        time++;
        turnAround();
        moveAround();
        fireProjectile();
        hitByZombie();
        superPowerUsed();
    }
    
    public void turnAround()
    {
        if (Greenfoot.getMouseInfo() != null)
        {
            turnTowards(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());   
        }   
    }
    
    public void moveAround()
    {
        if (Greenfoot.isKeyDown("a"))
        {
            setLocation(getX() - speed, getY());
        }
        
        if (Greenfoot.isKeyDown("w"))
        {
            setLocation(getX(), getY() - speed);
        }
        
        if (Greenfoot.isKeyDown("d"))
        {
            setLocation(getX() + speed, getY());
        }
        
        if (Greenfoot.isKeyDown("s"))
        {
            setLocation(getX(), getY() + speed);
        }
    }
    
    public void fireProjectile()
    {
        if (Greenfoot.isKeyDown("space") && weaponButton.weaponUpgrade == 1)
        {
            Projectile projectile = new Projectile("yellow.png");
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation());
            projectile.move(25);
            laserSound.play();
        }
        
        if (Greenfoot.isKeyDown("space") && weaponButton.weaponUpgrade == 2)
        {
            Projectile projectile = new Projectile("yellow.png");
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation() - 5);
            projectile.move(20);
            laserSound.play();
            
            Projectile projectile2 = new Projectile("yellow.png");
            getWorld().addObject(projectile2, getX(), getY());
            projectile2.setRotation(getRotation() + 5);
            projectile2.move(20);
        }
        
        if (Greenfoot.isKeyDown("space") && weaponButton.weaponUpgrade == 3)
        {
            Projectile projectile = new Projectile("yellow.png");
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation() - 5);
            projectile.move(20);
            laserSound.play();
            
            Projectile projectile2 = new Projectile("yellow.png");
            getWorld().addObject(projectile2, getX(), getY());
            projectile2.setRotation(getRotation() + 5);
            projectile2.move(20);
            
            Projectile projectile3 = new Projectile("yellow.png");
            getWorld().addObject(projectile3, getX(), getY());
            projectile3.setRotation(getRotation());
            projectile3.move(20);
        }
    }
    
    public void superPowerUsed()
    {
        if (superPower.superCount > 99 && superTimer < 30)
        {
            Projectile projectile = new Projectile("blue.png");
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation() - 60);
            projectile.move(20);
            laserSound.play();
            
            Projectile projectile2 = new Projectile("blue.png");
            getWorld().addObject(projectile2, getX(), getY());
            projectile2.setRotation(getRotation() + 60);
            projectile2.move(20);
            
            Projectile projectile3 = new Projectile("blue.png");
            getWorld().addObject(projectile3, getX(), getY());
            projectile3.setRotation(getRotation());
            projectile3.move(20);
            
            Projectile projectile4 = new Projectile("blue.png");
            getWorld().addObject(projectile4, getX(), getY());
            projectile4.setRotation(getRotation() - 180);
            projectile4.move(20);
            
            Projectile projectile5 = new Projectile("blue.png");
            getWorld().addObject(projectile5, getX(), getY());
            projectile5.setRotation(getRotation() + 120);
            projectile5.move(20);
            
            Projectile projectile6 = new Projectile("blue.png");
            getWorld().addObject(projectile6, getX(), getY());
            projectile6.setRotation(getRotation() - 120);
            projectile6.move(20);
            
            superTimer++;
        }
        
        if (superTimer > 29)
        {
            superPower.superCount = 0;
            superTimer = 0;
        }
    }
    
    public boolean hitByZombie()
    {
        Actor zombie = getOneObjectAtOffset(0, 0, Zombie.class);
        
        if (zombie != null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
