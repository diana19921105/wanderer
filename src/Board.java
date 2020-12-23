import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Board extends JComponent implements KeyListener {

    protected static final int IMAGE_SIZE = 72;
    protected static final int BOARD_SIZE = 10;
    protected Resource resource;
    protected Grid grid;
    protected Hero hero;

    public Board() {
        resource = new Resource();
        grid = new Grid(BOARD_SIZE);
        grid.setWall();
        hero = new Hero();
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
    // To be a KeyListener the class needs to have these 3 methods in it

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        grid.draw(graphics, resource, IMAGE_SIZE);
        hero.draw(graphics, resource);
//        graphics.fillRect(12, 12, 5, 5);
//        graphics.drawString("Health point", 5, 5);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}