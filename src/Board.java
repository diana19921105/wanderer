import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board extends JComponent implements KeyListener {

    protected static final int IMAGE_SIZE = 72;
    protected static final int BOARD_SIZE = 10;
    protected Resource resource;
    protected Grid grid;
    protected Hero hero;
    protected List<Skeleton> skeletons;
    protected Boss boss;

    public Board() {
        resource = new Resource();
        grid = new Grid(BOARD_SIZE);
        grid.setWall();
        hero = new Hero();
        initSkeletons(3);
        initBoss();
        setPreferredSize(new Dimension(BOARD_SIZE * IMAGE_SIZE, BOARD_SIZE * IMAGE_SIZE));
        setVisible(true);
    }

    public static void main(String[] args) {
        // Here is how you set up a new window and adding our board to it
        JFrame frame = new JFrame("RPG Game");
        Board board = new Board();
        frame.add(board);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
        // Here is how you can add a key event listener
        // The board object will be notified when hitting any key
        // with the system calling one of the below 3 methods
        frame.addKeyListener(board);
        // Notice (at the top) that we can only do this
        // because this Board class (the type of the board object) is also a KeyListener
    }

    private void initSkeletons(int number) {
        skeletons = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < number; i++) {
            Position position;
            do {
                position = new Position(random.nextInt(BOARD_SIZE), random.nextInt(BOARD_SIZE));
            } while (isPositionOccupied(position));
            skeletons.add(new Skeleton(position));
        }
    }

    private boolean isPositionOccupied(Position position) {
        return grid.isWall(position) || isSkeleton(position) || position.equals(hero.position);
    }

    private boolean isSkeleton(Position position) {
        for (Skeleton skeleton : skeletons) {
            if (skeleton.position.equals(position)) {
                return true;
            }
        }
        return false;
    }

    public void initBoss() {
        Random random = new Random();
        Position position;

        do {
            position = new Position(random.nextInt(BOARD_SIZE), random.nextInt(BOARD_SIZE));
        } while (isPositionOccupied(position));
        
        boss = new Boss(position);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        grid.draw(graphics, resource, IMAGE_SIZE);
        hero.draw(graphics, resource, IMAGE_SIZE);
        for (Skeleton skeleton : skeletons) {
            skeleton.draw(graphics, resource, IMAGE_SIZE);
        }
        boss.draw(graphics, resource, IMAGE_SIZE);
//        graphics.fillRect(12, 12, 5, 5);
//        graphics.drawString("Health point", 5, 5);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            hero.cellType = CellType.HERO_RIGHT;
            if (hero.position.getX() != BOARD_SIZE - 1 && !grid.isWall(new Position(hero.position.getX() + 1, hero.position.getY()))) {
                hero.position.incrementX();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            hero.cellType = CellType.HERO_LEFT;
            if (hero.position.getX() != 0 && !grid.isWall(new Position(hero.position.getX() - 1, hero.position.getY()))) {
                hero.position.decrementX();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            hero.cellType = CellType.HERO_UP;
            if (hero.position.getY() != 0 && !grid.isWall(new Position(hero.position.getX(), hero.position.getY() - 1))) {
                hero.position.decrementY();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            hero.cellType = CellType.HERO_DOWN;
            if (hero.position.getY() != BOARD_SIZE - 1 && !grid.isWall(new Position(hero.position.getX(), hero.position.getY() + 1))) {
                hero.position.incrementY();
            }
        }

        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}