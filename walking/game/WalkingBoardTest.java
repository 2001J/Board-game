package walking.game;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;

import walking.game.util.Direction;


public class WalkingBoardTest {

    @ParameterizedTest
    @CsvSource({"1", "2", "5", "10", "15", "20", "25", "50", "100"})
    void testSimpleInit(int size) {
        WalkingBoard board = new WalkingBoard(size);
        assertEquals(size, board.getTiles().length);
        assertEquals(WalkingBoard.BASE_TILE_SCORE, board.getTile(size / 2, size / 2));

        // Check the values at the edges of the board
        assertEquals(WalkingBoard.BASE_TILE_SCORE, board.getTile(0, 0));
        if (size > 1) {
            assertEquals(WalkingBoard.BASE_TILE_SCORE, board.getTile(size - 1, size - 1));
            assertEquals(WalkingBoard.BASE_TILE_SCORE, board.getTile(0, size - 1));
            assertEquals(WalkingBoard.BASE_TILE_SCORE, board.getTile(size - 1, 0));
        }
    }

    @ParameterizedTest
    @CsvSource({"5,5,3", "10,10,2", "15,15,1", "20,20,4", "25,25,5", "30,30,0", "35,35,-1"})
    void testCustomInit(int x, int y, int expected) {
        int[][] initArray = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                initArray[i][j] = expected;
            }
        }
        WalkingBoard board = new WalkingBoard(initArray);
        assertEquals(expected < WalkingBoard.BASE_TILE_SCORE ? WalkingBoard.BASE_TILE_SCORE : expected, board.getTile(x / 2, y / 2));

        // Test that values smaller than BASE_TILE_SCORE are replaced with BASE_TILE_SCORE
        if (expected < WalkingBoard.BASE_TILE_SCORE) {
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    assertEquals(WalkingBoard.BASE_TILE_SCORE, board.getTile(i, j));
                }
            }
        }

        // Test that modifying the original array does not affect the WalkingBoard
        initArray[x / 2][y / 2] = 0;
        assertEquals(expected < WalkingBoard.BASE_TILE_SCORE ? WalkingBoard.BASE_TILE_SCORE : expected, board.getTile(x / 2, y / 2));

        // Test that modifying the return value of getTiles() does not affect the WalkingBoard
        board.getTiles()[x / 2][y / 2] = 0;
        assertEquals(expected < WalkingBoard.BASE_TILE_SCORE ? WalkingBoard.BASE_TILE_SCORE : expected, board.getTile(x / 2, y / 2));
    }

   @Test
    public void testMoveAndSet() {
        
        WalkingBoard board = new WalkingBoard(3);

        //  Move right 2 steps
        assertEquals(WalkingBoard.BASE_TILE_SCORE, board.moveAndSet(Direction.RIGHT, 2));
        assertEquals(2, board.getTile(0, 2));

        //  Move down 1 step
        assertEquals(WalkingBoard.BASE_TILE_SCORE, board.moveAndSet(Direction.DOWN, 1));
        assertEquals(1, board.getTile(1, 2));

        //  Move left 2 steps
        assertEquals(WalkingBoard.BASE_TILE_SCORE, board.moveAndSet(Direction.LEFT, 2));
        assertEquals(2, board.getTile(1, 0));

        //  Move up 1 step
        assertEquals(WalkingBoard.BASE_TILE_SCORE, board.moveAndSet(Direction.UP, 1));
        assertEquals(1, board.getTile(0, 0));

        //  Try to move up 2 steps (outside of the board)
        assertEquals(0, board.moveAndSet(Direction.UP, 2));
        assertEquals(2, board.getTile(1, 0)); // Position is unchanged

        // try to move up 9 steps (outside of the board)
        assertEquals(0, board.moveAndSet(Direction.UP, 9));
        assertEquals(2, board.getTile(1, 0)); // Position is unchanged

        //  Try to move down 3 steps (outside of the board)
        assertEquals(0, board.moveAndSet(Direction.DOWN, 3));
        assertEquals(2, board.getTile(1, 0)); // Position is unchanged

        // Try to move down 10 steps (outside of the board)
        assertEquals(0, board.moveAndSet(Direction.DOWN, 10));
        assertEquals(2, board.getTile(1, 0)); // Position is unchanged
    }

}



