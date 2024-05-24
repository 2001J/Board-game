package walking.game.player;

import walking.game.util.Direction;

public class Player {
    private int score;
    protected Direction direction = Direction.UP;

   public int getScore() {
        return score;
    }

    public Direction getDirection() {
        return direction;
    }

    public Player() {
    }

    public void addToScore(int score) {
        this.score += score;
    }

    public void turn() {
        int nextOrdinal = (direction.ordinal() + 1) % Direction.values().length;
        direction = Direction.values()[nextOrdinal];
    }
}