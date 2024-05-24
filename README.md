# Board-game
The project involves developing two classes: WalkingBoard and WalkingBoardExtended, with corresponding test suites.

For the WalkingBoard class:

It represents a board with a figure standing on position x, y, where each position has an associated value.
Initialization can be done in two ways: either with a size×size board or with given dimensions and initial values.
Operations include methods to retrieve position, tile value, all tile values, determine step direction, and move the figure while updating tile values accordingly.
JUnit 5 tests include:

testSimpleInit(size): Tests the initialization of the board with a specified size.
testCustomInit(x, y, expected): Tests the initialization of the board with custom dimensions and initial values.

testMoves(): Tests movement on the board, ensuring the board's contents are updated correctly, handling edge cases such as moving outside the board boundaries.

For the WalkingBoardExtended class:

It extends WalkingBoard and introduces player functionality.
Players take turns moving on the board, with a special player, MadlyRotatingBuccaneer, having unique movement behavior.
Player movement involves turning direction, taking steps, updating scores, and moving on the board.
JUnit 5 tests involve simulating player movements on separate boards with different numbers of players, checking resulting board contents and player scores.
The goal is to ensure all structural tests pass for both classes, indicating correct functionality and behavior.
