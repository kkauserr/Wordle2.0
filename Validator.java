public class Validator {
    private int count;

    public Validator() {  // Constructor initializing variable for number of guesses
        count = 0;
    }

    public void countIncrease() {  // Increments number of guesses by 1
        if (count < 6) {
            count++;
        }
    }

    public int getCount() {  // Getter for number of guesses
        return count;
    }

    public void triesLeft() {  // Calculates and prints number of tries left
        int maxGuesses = 6;
        System.out.println((maxGuesses - count) + " tries left");
    }

    public void finalMessage() {  // Gives different messages based on number of tries used to find the solution
        switch (count) {
            case 1:
                System.out.println("Excellent!");
                break;
            case 2:
                System.out.println("Nice job!");
                break;
            case 3:
                System.out.println("Great!");
                break;
            case 4:
                System.out.println("Good job.");
                break;
            case 5:
                System.out.println("That was close.");
                break;
            case 6:
                System.out.println("Phew.");
                break;
            default:
                System.out.println("Invalid number of tries.");
                break;
        }
    }
}
