import java.awt.Graphics;

public abstract class Character {
    protected CellType cellType;
    protected Position position;

    protected void draw(Graphics graphics, Resource resource) {
        graphics.drawImage(resource.getImage(cellType),
                position.getX(), position.getY(), null);
    }
}
