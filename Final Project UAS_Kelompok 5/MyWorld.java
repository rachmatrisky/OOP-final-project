import greenfoot.*;

public class MyWorld extends World
{
    int count = 0;
    int spawnSpeed = 50;
    int randomSpawn = Greenfoot.getRandomNumber(4);
    Player mainPlayer = new Player();
    Counter counter = new Counter();
    HealthBar healthbar = new HealthBar();
    WeaponButton weaponButton = new WeaponButton(counter);
    SuperPower superPower = new SuperPower();
    PlayButton playButton = new PlayButton();

    private boolean isGameRunning = false;
    private GreenfootSound backgroundMusic = new GreenfootSound("gameplay.wav");

    public MyWorld()
    {
        super(600, 400, 1);
        mainPlayer = new Player(weaponButton, superPower);
        // change temporaly
        addObject(mainPlayer, getWidth() / 2, getHeight() / 2);
        addObject(counter, 80, 40);
        addObject(healthbar, mainPlayer.getX() - 5, mainPlayer.getY() - 50);
        addObject(weaponButton, 530, 40);
        addObject(superPower, mainPlayer.getX() + 10, mainPlayer.getY() - 80);
        addObject(playButton, getWidth() / 2, getHeight() / 2);
        
        setPaintOrder(PlayButton.class, Counter.class, WeaponButton.class, Player.class, HealthBar.class, SuperPower.class, Zombie.class);
    }

    public Player getPlayer()
    {
        return mainPlayer;
    }

    public void act()
    {
        count++;
        spawnZombies();
        System.out.println(spawnSpeed);
        
        if (count % 600 == 0)
        {
            spawnSpeed--;
        }
        
        if (spawnSpeed < 2)
        {
            spawnSpeed = 1;
        }

        if (Greenfoot.mouseClicked(playButton) && !isGameRunning) {
            setGameRunning(true);
            removeObject(playButton);
            // Add any additional initialization or actions you want when starting the game
        }

        // Check if the background music has finished playing and restart it
        if (!backgroundMusic.isPlaying()) {
            backgroundMusic.playLoop();
        }
    }

    public void spawnZombies()
    {
        if (count % spawnSpeed == 0)
        {   
            randomSpawn = Greenfoot.getRandomNumber(4);
            switch (randomSpawn)
            {
                case 0:
                    // spawn zombie randomly from the top side
                    addObject(new Zombie(1, "small_zombie.png", mainPlayer, counter), Greenfoot.getRandomNumber(getWidth()), 0);
                    break;
                case 1:
                    // spawn zombie randomly from the bottom side
                    addObject(new Zombie(2, "zombieboss.png", mainPlayer, counter), Greenfoot.getRandomNumber(getWidth()), getHeight());
                    break;
                case 2:
                    // spawn zombie randomly from the left side
                    addObject(new Zombie(1, "small_zombie.png", mainPlayer, counter), 0, Greenfoot.getRandomNumber(getHeight()));
                    break;
                case 3:
                    // spawn zombie randomly from the right side
                    addObject(new Zombie(2, "zombieboss.png", mainPlayer, counter), getWidth(), Greenfoot.getRandomNumber(getHeight()));
                    break;
            }
        }
    }

    public void setGameRunning(boolean running)
    {
        isGameRunning = running;
    }

    public boolean isGameRunning()
    {
        return isGameRunning;
    }
}
