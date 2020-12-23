import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Grid {
    private final List<List<Cell>> grid = new ArrayList<>();
    private final List<Position> walls = List.of(new Position(1, 8), new Position(2, 8),
            new Position(3, 8), new Position(3, 9), new Position(3, 0), new Position(3, 1),
            new Position(3, 2), new Position(1, 2), new Position(2, 2), new Position(5, 1),
            new Position(5, 2), new Position(5, 3), new Position(5, 4), new Position(7, 1),
            new Position(7, 2), new Position(8, 1), new Position(8, 2), new Position(6, 4),
            new Position(7, 4), new Position(8, 4), new Position(0, 4), new Position(1, 4),
            new Position(2, 4), new Position(3, 4), new Position(1, 5), new Position(1, 6),
            new Position(3, 6), new Position(3, 5), new Position(5, 6), new Position(5, 7),
            new Position(6, 7), new Position(6, 6), new Position(8, 6), new Position(8, 7),
            new Position(8, 8), new Position(5, 9), new Position(6, 9));

    public Grid(int size) {
        for (int i = 0; i < size; i++) {
            List<Cell> row = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                row.add(new Cell(new Position(i, j), CellType.FLOOR));
            }

            grid.add(row);
        }
    }

    public void draw(Graphics graphics, Resource resource, int imageSize) {
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.size(); j++) {
                grid.get(i).get(j).draw(graphics, resource, imageSize);
            }
        }
    }

    public void setWall() {
        for (Position wall : walls) {
            grid.get(wall.getX()).get(wall.getY()).setCellType(CellType.WALL);
        }
    }
}
