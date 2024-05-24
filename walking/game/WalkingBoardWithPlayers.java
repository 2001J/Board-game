package walking.game;

import walking.game.player.Player;
import walking.game.util.Direction;
import walking.game.player.MadlyRotatingBuccaneer;

public class WalkingBoardWithPlayers extends WalkingBoard{
    private Player [] players;
    private int round;
    public static final int SCORE_EACH_STEP = 13;

    public WalkingBoardWithPlayers(int[][] board, int playerCount) {
        super(board);
        initPlayers(playerCount);
    }

    public WalkingBoardWithPlayers(int size, int playerCount) {
        super(size);
        initPlayers(playerCount);
    }

    private void initPlayers(int playerCount) {
        if (playerCount < 2) {
            throw new IllegalArgumentException("Player count must be at least 2");
        }

        players = new Player[playerCount];
        players[0] = new MadlyRotatingBuccaneer();
        for (int i = 1; i < playerCount; i++) {
            players[i] = new Player();
        }
    }

    public int[] walk(int... stepCounts) {
        int[] scores = new int[players.length];

        for (int round = 0; round < stepCounts.length; round++) {
            int totalSteps = 0; // Reset totalSteps for each player
            Player currentPlayer = players[round % players.length];
            currentPlayer.turn();
            
            int stepCount = stepCounts[round];

            for (int i = 0; i < stepCount; i++) {
                int score = moveAndSet(currentPlayer.getDirection(), Math.min(totalSteps + 1, SCORE_EACH_STEP));
                currentPlayer.addToScore(score);
                totalSteps++;
            }
            scores[round % players.length] = currentPlayer.getScore();
        }

        return scores;
    }


}