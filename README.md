# Board-game
# Board Game Project

This project involves developing two classes: `WalkingBoard` and `WalkingBoardExtended`, along with their corresponding test suites. The development followed a Test-Driven Development (TDD) approach.

## Classes Overview

### WalkingBoard

- Represents a board with a figure standing on position (x, y), where each position has an associated value.
- Initialization can be done in two ways: either with a size×size board or with given dimensions and initial values.
- Operations include methods to:
  - Retrieve position
  - Retrieve tile value
  - Retrieve all tile values
  - Determine step direction
  - Move the figure while updating tile values accordingly

### WalkingBoardExtended

- Extends `WalkingBoard` and introduces player functionality.
- Players take turns moving on the board, with a special player, `MadlyRotatingBuccaneer`, having unique movement behavior.
- Player movement involves:
  - Turning direction
  - Taking steps
  - Updating scores
  - Moving on the board

## JUnit 5 Tests

### Basic Suite Test

- `testSimpleInit(size)`: Tests the initialization of the board with a specified size.
- `testCustomInit(x, y, expected)`: Tests the initialization of the board with custom dimensions and initial values.
- `testMoves()`: Tests movement on the board, ensuring the board's contents are updated correctly, handling edge cases such as moving outside the board boundaries.

### Extended Suite Test

- Simulates player movements on separate boards with different numbers of players.
- Checks resulting board contents and player scores.
- Ensures all structural tests pass for both classes, indicating correct functionality and behavior.

### Full Test Suite

- Combines both the basic and extended suite tests.
- Compiles all classes and runs all tests to ensure comprehensive coverage and correct functionality.

## Cloning the Repository

To clone the repository, run the following command:

```bash
git clone https://github.com/2001J/Board-game.git
cd Board-game
```

## Compiling the Classes

To compile the classes, navigate to the project directory and run:

```bash
javac -cp .:junit5all.jar:checkthat.jar *.java
```

## Running the Tests

To run the full extended suite and see the detailed test results, use the following command:

```bash
./check.cmd walking/game/tests/WalkingBoardFullTestSuite.java walking.game.tests.WalkingBoardFullTestSuite
```

This command will compile and run `walking.game.tests.WalkingBoardFullTestSuite`, providing a comprehensive test report:

```
Test suite: compiling and running walking.game.tests.WalkingBoardFullTestSuite
javac -cp .:junit5all.jar:checkthat.jar walking/game/tests/WalkingBoardFullTestSuite.java
java -javaagent:checkagent.jar -jar junit5all.jar execute -E junit-vintage --disable-banner -cp . -cp checkthat.jar -c walking.game.tests.WalkingBoardFullTestSuite
╷
└─ WalkingBoardFullTestSuite ✔
   ├─ WalkingBoardBasicTestSuite ✔
   │  ├─ StructuralTests ✔
   │  │  ├─ DirectionStructureTest ✔
   │  │  │  └─ testEnum() ✔
   │  │  └─ WalkingBoardStructureTest ✔
   │  │     ├─ methodGetTile() ✔
   │  │     ├─ constructor01() ✔
   │  │     ├─ constructor02() ✔
   │  │     ├─ fieldBASE_TILE_SCORE() ✔
   │  │     ├─ fieldX() ✔
   │  │     ├─ fieldY() ✔
   │  │     ├─ methodGetX() ✔
   │  │     ├─ methodGetY() ✔
   │  │     ├─ methodIsValidPosition() ✔
   │  │     ├─ fieldTiles() ✔
   │  │     ├─ methodMoveAndSet() ✔
   │  │     └─ methodGetPosition() ✔
   │  └─ FunctionalTests ✔
   │     └─ WalkingBoardTest ✔
   │        ├─ testSimpleInit(int) ✔
   │        │  ├─ [1] 1 ✔
   │        │  ├─ [2] 2 ✔
   │        │  ├─ [3] 5 ✔
   │        │  ├─ [4] 10 ✔
   │        │  ├─ [5] 15 ✔
   │        │  ├─ [6] 20 ✔
   │        │  ├─ [7] 25 ✔
   │        │  ├─ [8] 50 ✔
   │        │  └─ [9] 100 ✔
   │        ├─ testMoveAndSet() ✔
   │        └─ testCustomInit(int, int, int) ✔
   │           ├─ [1] 5, 5, 3 ✔
   │           ├─ [2] 10, 10, 2 ✔
   │           ├─ [3] 15, 15, 1 ✔
   │           ├─ [4] 20, 20, 4 ✔
   │           ├─ [5] 25, 25, 5 ✔
   │           ├─ [6] 30, 30, 0 ✔
   │           └─ [7] 35, 35, -1 ✔
   └─ WalkingBoardExtendedTestSuite ✔
      ├─ StructuralTests ✔
      │  ├─ WalkingBoardWithPlayersStructureTest ✔
      │  │  ├─ constructor01() ✔
      │  │  ├─ constructor02() ✔
      │  │  ├─ methodInitPlayers() ✔
      │  │  ├─ methodWalk() ✔
      │  │  ├─ fieldPlayers() ✔
      │  │  ├─ fieldSCORE_EACH_STEP() ✔
      │  │  └─ fieldRound() ✔
      │  └─ PlayerStructureTest ✔
      │     ├─ constructor() ✔
      │     ├─ methodTurn() ✔
      │     ├─ methodAddToScore() ✔
      │     ├─ fieldScore() ✔
      │     └─ fieldDirection() ✔
      └─ FunctionalTests ✔
         └─ WalkingBoardWithPlayersTest ✔
            ├─ walk1() ✔
            └─ walk2() ✔
[All 44/44 tests successful]
```

## Additional Notes

- Ensure you have JDK and JUnit 5 installed on your machine.
- Adjust the paths in the commands according to your project structure and environment.

By following these instructions, you should be able to clone the repository, compile the classes, and run the tests from the command line.

Here is the link to the project: [Board-game](https://github.com/2001J/Board-game.git)

