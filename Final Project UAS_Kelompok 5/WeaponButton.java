import greenfoot.*;  

public class WeaponButton extends Property {
    Counter counter;
    private int weaponUpgrade = 1;
    
    public WeaponButton(Counter counter) {
        this.counter = counter;
        setImage(110, 55, "Weapon\nUpgrade");
    }
    
    public void act() {
        if (Greenfoot.mousePressed(this) && counter.money > 99) {
            counter.money -= 100;
            weaponUpgrade++;
            
        }
        
        if (weaponUpgrade > 3)
        {
            weaponUpgrade = 3;
        }
    }
    
    public int getWeaponUpgrade()
    {
        return weaponUpgrade;
    }
}
