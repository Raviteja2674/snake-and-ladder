import java.util.Random;
        import java.util.Scanner;

public class SnakeAndLadderGame {

    private static final int BOARD_SIZE = 100;
    private static final int[] SNAKES = {16, 47, 49, 56, 62, 64, 87, 93, 95, 98};
    private static final int[] LADDERS = {1, 4, 9, 21, 28, 36, 51, 71, 80};

    private int playerPosition;

    public SnakeAndLadderGame() {
        playerPosition = 1;
    }

    private int rollDice() {
        Random random = new Random();
        return random.nextInt(6) + 1; // Generate a random number between 1 and 6
    }

    private int getNextPosition(int currentPosition, int diceValue) {
        int newPosition = currentPosition + diceValue;

        // Check if the newPosition is a snake or ladder
        for (int snake : SNAKES) {
            if (newPosition == snake) {
                System.out.println("Oops! Snake at position " + snake + ". Go down!");
                return 1; // Go back to the start
            }
        }

        for (int ladder : LADDERS) {
            if (newPosition == ladder) {
                System.out.println("Yay! Ladder at position " + ladder + ". Climb up!");
                return 1; // Go back to the start
            }
        }

        // Ensure the newPosition does not exceed the board size
        return Math.min(newPosition, BOARD_SIZE);
    }

    private void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Snake and Ladder Game!");

        while (playerPosition < BOARD_SIZE) {
            System.out.println("Press Enter to roll the dice.");
            scanner.nextLine();

            int diceValue = rollDice();
            System.out.println("You rolled a " + diceValue + ".");

            playerPosition = getNextPosition(playerPosition, diceValue);

            System.out.println("You are now at position " + playerPosition + ".");

            if (playerPosition == BOARD_SIZE) {
                System.out.println("Congratulations! You won!");
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        SnakeAndLadderGame game = new SnakeAndLadderGame();
        game.play();
    }
}
