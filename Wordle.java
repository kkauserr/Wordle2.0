import java.util.Scanner;

public class Wordle {
    public static void main(String[] args) throws Exception {
        Validator counter = new Validator();   // Create object to keep track of number of guesses
        String guess = "";  // Initialize variable for user guesses
        Scanner in = new Scanner(System.in);  // Create scanner object to read user input

        WordMagic word = new WordMagic();  // Create object to access WordMagic methods 
        word.wordGenerator();   // Generates wordle solution
        String actual = word.getAnswer();  

        word.printMenu();

        while (counter.getCount() < 6) {  // Number of guesses must be less than 6
            guess = in.nextLine(); // Reads user guess

            if (!word.realWord(guess)) {   // Checks if user guess is part of wordle database
                System.out.println("Enter a valid 5-letter word");
            } else { // Checks the positions of each letter of guess and colors each letter
                System.out.println(word.checkGuess(guess));
                counter.countIncrease();
                if (guess.equals(actual)) { // Prints message if solution is found
                    counter.finalMessage();
                    break;  // Exit loop if the correct word is guessed
                } else {   // Displays number of tries left
                    counter.triesLeft();
                }
            }
        }

        if (!guess.equals(actual)) {  // Gives solution if not found by user 
            System.out.println("\nOut of tries! The word is " + actual + ".");
        }

        in.close(); // Close the scanner object
    }
}
