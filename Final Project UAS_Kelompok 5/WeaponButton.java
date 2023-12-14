import greenfoot.*;  

public class WeaponButton extends Actor {
    Counter counter;
    int weaponUpgrade = 1;
    
    public WeaponButton(Counter counter) {
        this.counter = counter;
        updateImage();
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
    
    public void updateImage() {
        GreenfootImage image = new GreenfootImage(110, 55); // Ukuran gambar disesuaikan
        int borderThickness = 3; // Ketebalan border
        
        // Mengisi seluruh area dengan warna ungu sebagai background
        image.setColor(new Color(95, 43,178)); // Warna ungu
        image.fill(); // Mengisi seluruh area dengan warna ungu
        
        // Menggambar teks berwarna putih di dalam background ungu
        image.setColor(Color.WHITE); // Warna putih
        image.setFont(new Font("Arial", true, false, 18)); // Ukuran font disesuaikan
        image.drawString("Weapon\nUpgrade", 10, 25);
        
        setImage(image);
    }
}
