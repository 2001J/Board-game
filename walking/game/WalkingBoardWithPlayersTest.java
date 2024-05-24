package walking.game;

import java.util.Arrays;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;


import walking.game.player.Player;
import walking.game.util.Direction;
import walking.game.player.MadlyRotatingBuccaneer;


// JUnit 5 tests: create walk1 and walk2 that walk on two separate boards 
// that feature different numbers of players. In each one, 
// let each players take a step at least three times.
//  Check the resulting contents of each board and also check the final scores of the players.


public class WalkingBoardWithPlayersTest {

 
    @Test
    void walk1() {
        // Initialize a board with 2 players
        WalkingBoardWithPlayers board1 = new WalkingBoardWithPlayers(5, 2);

        // Define step counts
        int[] stepCounts1 = {1, 1, 1, 1};

        // Let each player on the board take a step three times
        int[] scores1 = new int[0];
        for (int i = 0; i < 3; i++) {
            scores1 = board1.walk(stepCounts1);
        }

        // Check the final scores of the players
        assertArrayEquals(new int[]{11, 16}, scores1);

        // Check the resulting contents of the board
        int[][] expectedBoard1 = {
            {3, 1, 1, 3, 3},
            {1, 1, 1, 3, 3},
            {1, 1, 3, 3, 3},
            {1, 3, 3, 3, 3},
            {3, 3, 3, 3, 3}
        };
        assertArrayEquals(expectedBoard1, board1.getTiles());
    }

    @Test
    void walk2() {
        // Initialize a board with 3 players
        WalkingBoardWithPlayers board2 = new WalkingBoardWithPlayers(5, 3);

        // Define step counts
        int[] stepCounts2 = {1, 1, 1};

        // Let each player on the board take a step three times
        int[] scores2 = new int[0];
        for (int i = 0; i < 3; i++) {
            scores2 = board2.walk(stepCounts2);
        }

        // Check the final scores of the players
        assertArrayEquals(new int[]{6, 9, 9}, scores2);

        // Check the resulting contents of the board
        int[][] expectedBoard2 = {
            {3, 1, 1, 1, 3},
            {3, 3, 3, 1, 3},
            {1, 1, 1, 1, 3},
            {3, 3, 3, 3, 3},
            {3, 3, 3, 3, 3}
        };
        assertArrayEquals(expectedBoard2, board2.getTiles());
    }
}

