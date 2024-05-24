package walking.game;

import java.util.Arrays;

import walking.game.util.Direction;


public class WalkingBoard {
    private int[][] tiles;
    private int x; // row index
    private int y; // column index
    public static final int BASE_TILE_SCORE = 3;

    public int[][] getTiles() {
        int[][] copy = new int[tiles.length][];
        for(int i = 0; i < tiles.length; i++) {
            copy[i] = Arrays.copyOf(tiles[i], tiles[i].length);
        }
        return copy;
    }

    public WalkingBoard(int size) {
        this.tiles = new int[size][size];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                this.tiles[i][j] = BASE_TILE_SCORE;
            }
        }

        this.x = 0;
        this.y = 0;
    }

    public WalkingBoard(int[][] tiles) {
        int rows = tiles.length;
        int cols = tiles[0].length;
        this.tiles = new int[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                this.tiles[i][j] = tiles[i][j] < BASE_TILE_SCORE ? BASE_TILE_SCORE : tiles[i][j];
            }
        } 
        this.x = 0;
        this.y = 0;
    }

    public int[] getPosition() {
        return new int[]{x, y};
    }

    public boolean isValidPosition(int x, int y) {
        return x >= 0 && x < tiles.length && y >= 0 && y < tiles[0].length;
    }

    public int getTile(int x, int y){
        if (!isValidPosition(x, y)){
            throw new IllegalArgumentException("Out of bounds");
        }
        return tiles[x][y];
    }

    public static int getXStep(Direction direction) {
        switch(direction) {
            case UP:
                return -1;
            case DOWN:
                return 1;
            default:
                return 0;
        }
    }

    public static int getYStep(Direction direction) {
        switch(direction) {
            case LEFT:
                return -1;
            case RIGHT:
                return 1;
            default:
                return 0;
        }
    }

    public int moveAndSet(Direction direction, int steps) {
        int newX = x;
        int newY = y;
        for (int i = 0; i < steps; i++) {
            newX += getXStep(direction);
            newY += getYStep(direction);
            if (!isValidPosition(newX, newY)) {
                return 0; // Return 0 if the move is not valid
            }
            x = newX;
            y = newY;
        }
        int oldValue = tiles[x][y]; // Save the old value of the new position
        tiles[x][y] = steps; // Update the tile value at the new position
        return oldValue; // Return the old value of the new position
    }

   
    
}
