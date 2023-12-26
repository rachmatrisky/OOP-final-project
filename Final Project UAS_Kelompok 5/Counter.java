import greenfoot.*;  

public class Counter extends Property {
    // encapsulation
    int score;
    int money;
    int time;
    
    public Counter() {
    }
    
    public void act() {
        time++;
        setImage();
    }
    
    public void setImage() {
        World world = getWorld();
        MyWorld myWorld = (MyWorld) world;
        
        GreenfootImage image = new GreenfootImage(120, 80); // Ukuran gambar disesuaikan
        int borderThickness = 5; // Ketebalan border
        
        // Mengisi seluruh area dengan warna ungu
        image.setColor(new Color(95, 43, 178)); // Warna ungu
        image.fill(); // Mengisi seluruh area dengan warna ungu
        
        // Menggambar teks berwarna putih di dalam border
        image.setColor(Color.WHITE); // Warna putih
        image.setFont(new Font("Arial", true, false, 18)); // Ukuran font disesuaikan
        image.drawString("Score: " + score + "\nCash: " + money + "\nTime: " + (time / 60), 10, 20);
        
        // Menggambar border di atas teks untuk efek border
        image.setColor(new Color(128, 0, 128)); // Warna ungu
        image.drawRect(borderThickness / 2, borderThickness / 2, image.getWidth() - borderThickness, image.getHeight() - borderThickness); // Menggambar border di atas teks
        
        setImage(image);
    }
}
