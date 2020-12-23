import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Resource {

    protected HashMap<CellType, BufferedImage> images = new HashMap<>();

    public Resource() {
        images.put(CellType.FLOOR, loadImage("img/floor.png"));
        images.put(CellType.WALL, loadImage("img/wall.png"));
        images.put(CellType.HERO_DOWN, loadImage("img/hero-down.png"));
        images.put(CellType.SKELETON, loadImage("img/skeleton.png"));
        images.put(CellType.HERO_UP, loadImage("img/hero-up.png"));
        images.put(CellType.HERO_RIGHT, loadImage("img/hero-right.png"));
        images.put(CellType.BOSS, loadImage("img/boss.png"));
        images.put(CellType.HERO_LEFT, loadImage("img/hero-left.png"));
    }

    protected BufferedImage loadImage(String path) {

        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            System.out.println("Image can't be found at: " + path);
            System.exit(1);
        }
        return null;
    }

    public BufferedImage getImage(CellType key){
        return images.get(key);
    }
}
