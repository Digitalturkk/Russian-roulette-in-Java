import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

class RussianRoulette{
    public static int ranInt(int x){
        // Creating new random number as a staring point of our drum
        Random ranNumb = new Random();
        return ranNumb.nextInt(x) + 1;
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

        // String Array list for win dialog
        ArrayList<String> wonDialog = new ArrayList<>();
        wonDialog.add(0,""); // As in ranInt we have "+ 1" we couldn't get first index, so we need to add it all, and put there null string
        wonDialog.add(1,"You are really lucky!");
        wonDialog.add(2,"You won this time.");
        wonDialog.add(3,"Haha, isn't it funny?");
        wonDialog.add(4,"How Russians say 'born in a shirt' ");
        wonDialog.add(5,"Ohh, did you shit in your pants? Ahaha, wait... did you?");
        wonDialog.add(6,"It was so close...");
        wonDialog.add(7,"You are dealing with death!");
        wonDialog.add(8,"I remember, how i played this game first time, never lost till this time, ahaha");

        // String Array list for lose dialog
        ArrayList<String> loseDialog = new ArrayList<>();
        loseDialog.add(0,""); // Same logic
        loseDialog.add(1,"You loser");
        loseDialog.add(2,"His body is smelling, bring him out!");
        loseDialog.add(3,"HAHAHAHA");
        loseDialog.add(4,"Never deal with Death.");
        loseDialog.add(5,"Bring the other one!");
        loseDialog.add(6,"Wanna start again?");
        loseDialog.add(7,"I just started to like you...");

        // String array list for printing more interesting dialogs. The lucky ones with drum stuck
        String[] ld = {"", "The drum is stuck", "You lucky bitch...", "WTF IS WRONG WITH THIS GUN?", "You think that you are lucky?"};
        ArrayList<String> luckyDialog = new ArrayList<String>(List.of(ld));

        while (winScore != 5){
            System.out.println("Are you ready to load your revolver? y/n");
            String yOrn = yesNo.nextLine();

            if(yOrn.equals("y")){
                int start = ranInt(6);
                    if (start == deathNum) {
                        System.out.print("You dead. ");
                        System.out.println(loseDialog.get(ranInt(7)));
                        System.out.println("Your Win score is: " + winScore);
                        break;
                    } else {
                        /*
                        We need to be sure, that our number isn't repeating.
                        For this, we created an ArrayList (line: 30) where we will store our used random numbers.
                         */
                        if (!used.contains(start)){
                            used.add(start);
                            System.out.println(wonDialog.get(ranInt(8)));
                            System.out.println("Last "+gameScore+" games >:^)");
                            winScore++;
                            gameScore--;
                            // Можно и добвить прокрутку
                        } else {
                            start = ranInt(6);
                            System.out.println(luckyDialog.get(ranInt(5))+", try again >:^) ");
                        }
                    }
            }
            // Print прокрутку
        }
        if (winScore == 5){
            System.out.println("You won this game >:(");
        }
    }
}
