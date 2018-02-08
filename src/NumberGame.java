import java.util.Scanner;

public class NumberGame {
    // this game asks the user to guess the winning number in the range of 1 to 99
    public static void main(String[] args) {
        // multiply the randomn number by 100 as randomn returns a float less than 0, and add 1 to in case it returned 0
        int randomnNumber = (int) (Math.random() * 100) + 1;
        boolean bingo = false;
        // nice for debugging but next line is the spoiler
        System.out.print(randomnNumber);
        
        for (int i = 10; i > 0; i--) {
            System.out.println("You have " + i + " tries left. Guess the number: ");
            Scanner sc = new Scanner(System.in);
            int guess = sc.nextInt();
            //remember to add checking if int and to also change type to string (note to self: Integer.parseInt(str))
            if (guess > randomnNumber) {
                System.out.println("No - too big");
            }
            else if (guess < randomnNumber) {
                System.out.println("No - too small");
            }
            else {
                if (guess == randomnNumber) {
                    bingo = true;
                    break;
                }
            }
            }
        if (bingo) {
            System.out.println("BINGO!!!!");
        }
        else {
            System.out.println("LOSER!!!!! hint: use a binary sort");
            }
        }
    }
