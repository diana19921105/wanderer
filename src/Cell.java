import java.awt.Graphics;

public class Cell {
    protected Position position;
    protected CellType cellType;

    public Cell(Position position, CellType cellType) {
        this.position = position;
        this.cellType = cellType;
    }

    public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }

    public void draw(Graphics graphics, Resource resource, int imageSize) {
        graphics.drawImage(resource.getImage(this.cellType),
                position.getX() * imageSize, position.getY() * imageSize, null);

    }
}