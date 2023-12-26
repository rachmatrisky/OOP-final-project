import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Property here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Property extends Actor
{
    public void act()
    {
        
    }
    
    public void setImage(int imageWidth, int imageHeight, String text) {
        World world = getWorld();
        MyWorld myWorld = (MyWorld) world;
        
        GreenfootImage image = new GreenfootImage(imageWidth, imageHeight); // Ukuran gambar disesuaikan
        // int borderThickness = 5; // Ketebalan border
        
        // Mengisi seluruh area dengan warna ungu
        image.setColor(new Color(95, 43, 178)); // Warna ungu
        image.fill(); // Mengisi seluruh area dengan warna ungu
        
        // Menggambar teks berwarna putih di dalam border
        image.setColor(Color.WHITE); // Warna putih
        image.setFont(new Font("Arial", true, false, 18)); // Ukuran font disesuaikan
        image.drawString(text, 10, 20);
        
        setImage(image);
    }
}
