import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

class RussianRoulettePC {
    
    public static int ranInt(int x){
        // Creating new random number as a staring point of our drum
        Random ranNumb = new Random();
        return ranNumb.nextInt(x) + 1;
    }
    
    public static void main(String[] args){
        // Place of bullet in cylinder
        int deathNum = ranInt(6);

        // Scores in our game
        int winScore, gameScore, pcScore;
        pcScore = 0;
        winScore = 0;
        gameScore = 5;

        // New objects from imported libraries
        Scanner yesNo = new Scanner(System.in);
        ArrayList<Integer> used = new ArrayList<>();

        // String Array list for win dialogs
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

        // String array list for pc dialogs
        ArrayList<String> pcDialog = new ArrayList<>();
        pcDialog.add(0,"");
        pcDialog.add(1,"Did you see that?! Ahaha");
        pcDialog.add(2,"I'm lucky!");
        pcDialog.add(3,"I'm the BOSS");
        pcDialog.add(4,"I remember, how i played this game first time, never lost till this time...");
        pcDialog.add(5, "Ohh, i love this Game!");
        pcDialog.add(6, "You think you can beat me?");
        pcDialog.add(7, "I'm waiting your death >:^) ");

        while (gameScore != 0){
            System.out.println("Are you ready to play with death? y/n");
            String yOrn = yesNo.nextLine();

            if(yOrn.equals("y")){
                int start = ranInt(6);
                    if (start == deathNum) {
                        System.out.print("\nYou dead. ");
                        System.out.println("\n" + loseDialog.get(ranInt(7)));
                        System.out.println("Your Win score is: " + winScore);
                        break;
                    } else {
                        /*
                        We need to be sure, that our number isn't repeating.
                        For this, we created an ArrayList (line: 25) where we will store our used random numbers.
                         */
                        if (!used.contains(start)){
                            used.add(start);
                            System.out.println(wonDialog.get(ranInt(8)));
                            winScore++;
                            gameScore--;
                            // Можно и добвить прокрутку
                        }
                    }
                System.out.println("\nIt's my turn >:^) ");
                int pcStart = ranInt(6);
                if (pcStart == deathNum){
                    System.out.print("*GUN SHOT SOUND*, \nYou won!");
                    break;
                } else {
                    used.add(pcStart);
                    pcScore++;
                    gameScore--;
                    System.out.println(pcDialog.get(ranInt(7)));
                    System.out.println("\nYour turn.");
                }
            }
        }
        if (gameScore == 0) {
            System.out.println("\n*You take the gun and make a shot, it was your last shot* \nYou dead");
        }
    }
}
