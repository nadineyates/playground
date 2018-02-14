import java.util.Scanner;
import java.util.Random; 

public class NumberGame {
    // This game asks the user to guess the winning number in the range of 1 to 99
    public static void main(String[] args) {
    	boolean debug = true;
        boolean gameWon=false;
        boolean endGame=false;
        int countdown=10; // this is set to the number of tries the user gets
        
    	if(args.length==0) {
    	      debug = false;
    	   }
    	   else {
    		   if (args [0] == "-d") { 
    			   debug = true;
    		   }
    		   else  System.out.println("invalid parameter");
   	    }

        final int winningNumber = generateRandomNumber();
        
        if (debug) { 
        	System.out.print(winningNumber);
        }
   
        while (!endGame) {
        	if (countdown > 0) {
        		int guess = getuserinput(countdown);
        		if (endGame = processGuess(guess,winningNumber)) {
        			gameWon= true;        			
        		}
        	}
    		else {	
    			gameWon=false;
        		endGame=true;
    		}
        	countdown--; 
        }

        if (gameWon) {
        	System.out.println("BINGO! Aren't you clever!!!");
        }
        else {
        	System.out.println("YOU LOST! Oh dear! Better luck next time.");
        }
}


	private static boolean processGuess(int guess, int winningNumber) {
		// Check whether the user has entered the winning number
		if (guess > winningNumber) {
			System.out.println("No - too big");
			return false;
        }
        else if (guess < winningNumber) {
        	System.out.println("No - too small");
        	return false;
        }
        else return true;
	}

	private static int getuserinput(int NumberOfTries) {
		// Get the input from the user
		System.out.println("You have " + NumberOfTries + " tries left. Try to guess the number: ");
		Scanner sc = new Scanner(System.in); 
		int inputedGuess = sc.nextInt();
		return inputedGuess;
	}

	private static int generateRandomNumber() {
		// Generate the winning number 
		Random random = new Random();
	    int randomNumber = random.nextInt(99);
		return randomNumber;
	}
}
