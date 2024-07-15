import java.util.Random;
import java.util.Scanner;

class RussianRoulette{
    public static int ranInt(int ranNum){ //creating new random number
        Random ranNum = new Random();
        int ranNumb = ranNum.nextInt(6);
    }

    public static void main(String[] args){
        Random win = new Random();
        int deathNum = win.nextInt(6); // место пули

        int winScore, loseScore;
        winScore = 0;
        loseScore = 0;

        Scanner yesNo = new Scanner(System.in);

        while (winScore != 5 || loseScore != 1){
            System.out.println("Are you ready to load your revolver? y/n");
            String yOrn = yesNo.nextLine();

            if(yOrn.equals("y")){
                RussianRoulette gameStart = new RussianRoulette();
                int start = gameStart.ranInt();
                if(start == deathNum){
                    System.out.println("You dead");
                    loseScore++;
                } else {
                    System.out.println("You won this time");
                    // добавить счётчик оставшихся игр
                    // Можно и добвить прокрутку
                }
            }
        }
    }
}