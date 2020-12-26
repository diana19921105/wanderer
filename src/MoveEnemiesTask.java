import java.util.Random;
import java.util.TimerTask;

public class MoveEnemiesTask extends TimerTask {
    private Board board;

    public MoveEnemiesTask(Board board) {
        this.board = board;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (Skeleton skeleton : board.skeletons) {
            skeleton.position = moveToRandomPosition(random, skeleton);
        }
        board.boss.position = moveToRandomPosition(random, board.boss);
        board.repaint();
    }

    private Position moveToRandomPosition(Random random, Character character) {
        Position position = null;
        do {
            int randomDimension = random.nextInt(2);
            int randomDirection = random.nextInt(2);

            if (randomDimension == 0 && randomDirection == 0) {
                position = new Position(character.position.getX() + 1, character.position.getY());
            }
            if (randomDimension == 0 && randomDirection == 1) {
                position = new Position(character.position.getX() - 1, character.position.getY());
            }
            if (randomDimension == 1 && randomDirection == 0) {
                position = new Position(character.position.getX(), character.position.getY() + 1);
            }
            if (randomDimension == 1 && randomDirection == 1) {
                position = new Position(character.position.getX(), character.position.getY() - 1);
            }

        } while (position.getX() == Board.BOARD_SIZE ||
                position.getX() == -1 || position.getY() == Board.BOARD_SIZE ||
                position.getY() == -1 || board.isPositionOccupied(position));

        return position;
    }
}

