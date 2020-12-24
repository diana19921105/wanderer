import java.awt.Graphics;

public abstract class Character {
    protected CellType cellType;
    protected Position position;

    protected void draw(Graphics graphics, Resource resource, int imageSize) {
        graphics.drawImage(resource.getImage(cellType),
                position.getX() * imageSize, position.getY() * imageSize, null);
    }
}
