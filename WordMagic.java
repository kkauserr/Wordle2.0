import java.io.File;
import java.util.Scanner;

public class WordMagic {
    private static String answer;  // Initialization of Wordle solution and list of words
    private String[] wordList;

    private static final String ANSI_RED = "\u001b[41m";   // Gives color to letters in the console
    private static final String ANSI_GREEN = "\u001b[42m";
    private static final String ANSI_YELLOW = "\u001b[43m";
    private static final String ANSI_RESET = "\u001b[0m";

    public void printMenu() {  // Prints menu statement
        System.out.println("WORDLE\nTry to guess the word in less than 6 tries.");
    }

    public void wordGenerator() throws Exception {
        // Pass the path to the file as a parameter
        File file = new File("WordleWords5.txt");
        Scanner sc = new Scanner(file);
        wordList = new String[14855];
        int count = 0;

        while (sc.hasNextLine()) {
            if (count < wordList.length) {
                wordList[count] = sc.nextLine();
                count++;
            } else {
                break;  // Break if there are more lines than the size of the array
            }
        }

        if (count < wordList.length) {
            // Resize the array if fewer lines are read
            String[] temp = new String[count];
            System.arraycopy(wordList, 0, temp, 0, count);
            wordList = temp;
        }

        answer = wordList[(int) (Math.random() * wordList.length)];
    }

    public String getAnswer() {  // Getter for the Wordle solution
        return answer;
    }

    public String checkGuess(String guess) {
        // Sets the color for each letter in the guess based on if it is in the correct position
        String output = "";
        for (int i = 0; i < 5; i++) {
            if (guess.substring(i, i + 1).equals(answer.substring(i, i + 1))) {
                // Letter is a match
                output = output + " " + (ANSI_GREEN + guess.substring(i, i + 1).toUpperCase() + ANSI_RESET);
            } else if (answer.indexOf(guess.substring(i, i + 1)) > -1) {
                output = output + " " + (ANSI_YELLOW + guess.substring(i, i + 1).toUpperCase() + ANSI_RESET);
            } else {
                output = output + " " + (ANSI_RED + guess.substring(i, i + 1).toUpperCase() + ANSI_RESET);
            }
        }
        return output;
    }

    public boolean realWord(String guess) {
        // Checks if the user guess is part of the word list
        guess = guess.toLowerCase();  // Ensure guess is in lowercase
        for (String word : wordList) {
            if (guess.equals(word)) {
                return true;
            }
        }
        return false;
    }
}
