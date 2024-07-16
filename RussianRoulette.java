import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

class RussianRoulette{
    public static int ranInt(){
        // Creating new random number as a staring point of our drum
        Random ranNumb = new Random();
        int ranNumber = ranNumb.nextInt(6) + 1;
        return ranNumber;
    }

    public static void main(String[] args){
        // Place of bullet in cylinder
        Random win = new Random();
        int deathNum = win.nextInt(6) + 1;

        // Scores in our game
        int winScore, gameScore;
        winScore = 0;
        gameScore = 5;

        // New objects from imported libleries
        Scanner yesNo = new Scanner(System.in);
        ArrayList<Integer> used = new ArrayList<Integer>();

        // String arrays for printing more interesting dialogs (working on it)

        while (winScore != 5){
            System.out.println("Are you ready to load your revolver? y/n");
            String yOrn = yesNo.nextLine();

            if(yOrn.equals("y")){
                int start = ranInt();
                    if (start == deathNum) {
                        System.out.println("You dead");
                        System.out.println("Your Win score is: " + winScore);
                        break;
                    } else {
                        /*
                        We need to be sure, that our number isn't repeating.
                        For this, we ctreated an ArrayList (line: 25) where we will store our used random numbers.   
                         */
                        if (!used.contains(start)){
                            used.add(start);
                            System.out.println("You won this time");
                            winScore++;
                            gameScore -= 1;
                            // Можно и добвить прокрутку
                        } else {
                            start = ranInt();
                            System.out.println("The drum has stuck, try again >:^) ");
                        }
                    }
            }
            // Print прокрутку
        }
    }
}
