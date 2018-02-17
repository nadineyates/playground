import java.util.Scanner;
import java.util.Random; 


public class NumberGame {
    // This game asks the user to guess the winning number in the range of 1 to 99
    private static boolean gameWon=false;
    private static int countdown=10; 
    final private static int winningNumber = GenerateRandomNumber();
    private static Scanner sc = new Scanner(System.in); 
    private static boolean debug = true;

    public static void main(String[] args) {

        Debugging();

        while ((!gameWon) && countdown !=0) {
            int guess = GetUserInput();
            gameWon = DidUserWin(guess);
            countdown-- ;
        }

        if (gameWon) {
            System.out.println("BINGO! Aren't you clever!!!");
        }
        else {
            System.out.println("YOU LOST! Oh dear! Better luck next time.");
        }
}

    private static boolean DidUserWin(int guess) {
    	if (guess > winningNumber) {
            System.out.println("No - too big");
            return false;
        }
        if (guess < winningNumber) {
            System.out.println("No - too small");
            return false;
        }
        else return true;
	    }

	private static int GetUserInput() {
        System.out.println("You have " + countdown + " tries left. Try to guess the number: ");
        int inputedGuess = sc.nextInt();
        return inputedGuess;
    }

	private static int GenerateRandomNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(99);
        return randomNumber;
    }

	private static void Debugging() {
        if (debug) {
            System.out.println(winningNumber);
        }
	}
}
