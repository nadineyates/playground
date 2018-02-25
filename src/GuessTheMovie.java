import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessTheMovie {

    private static Scanner sc = new Scanner(System.in); 
    private static int countdown=15; 
    private static boolean debug=true;
    final static private int movieIndex = GenerateRandomNumber();
    private static String displayMovie;
    private static String [] workingMovie;
    private static String [] storedMovie;
    
    public static void main(String[] args) throws Exception {
        final String winningMovie = SetWinningMovie();
       workingMovie=winningMovie.split("");
       storedMovie=winningMovie.split("");
       
       InitializeDisplay();
       while ((!GameWon()) && countdown !=0) {
    	   PlayGame(GetUserInput());
           countdown-- ;
       }
       if (GameWon()) {
           System.out.println("BINGO! Aren't you clever!!!");
       }
       else {
           System.out.println("YOU LOST! Oh dear! Better luck next time.");
       }
	}

	private static boolean GameWon() {
        if (Arrays.equals(workingMovie, storedMovie)) {
        return true;
        }
        else {
            return false;
        }
	}

	private static void PlayGame(String letter) {
        StringBuffer letterIn = new StringBuffer(workingMovie.length);
       	for (int i=0; i < workingMovie.length; i++) {
       		if (letter.equals(storedMovie[i])) {
                workingMovie[i]=storedMovie[i];
    		}
            displayMovie = letterIn.append(workingMovie[i]).append(" ").toString();
        }
        System.out.println("You are guessing: " + displayMovie);
	}
		
	private  static void InitializeDisplay() {
        StringBuffer letterIn = new StringBuffer(workingMovie.length);
    	for (int i=0; i < workingMovie.length; i++) {
            if (!isWhiteSpace(workingMovie[i])) {
                workingMovie[i] = "_";
            }
            displayMovie = letterIn.append(workingMovie[i]).append(" ").toString();
        }
        System.out.println("You are guessing: " + displayMovie);
	}

	private static String SetWinningMovie() throws FileNotFoundException {
    	File movieList = new File("ListOfMovies.txt");
       	Scanner sc = new Scanner (movieList);
        for (int i = 1; i < movieIndex; i++) {
	        sc.nextLine();
	    }
	     String movie = sc.nextLine();
	     Debugging(movieIndex + " " + movie);
	     return movie;
    }

	private static int GenerateRandomNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(25);
       return randomNumber;
    }
	
     private static void Debugging(String message) {
        if (debug) {
            System.out.println(message);
        }
    }
     public static boolean isWhiteSpace(String value) {
        return value == null || value.trim().isEmpty();
    }

     private static String GetUserInput() {
    	 System.out.println("You have " + countdown + " tries left. Guess the letter: ");
    	 String inputedGuess = sc.nextLine();
    	 return inputedGuess;
         }
	}

