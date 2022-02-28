package dicegames;

import com.sun.jdi.event.MethodExitEvent;

import java.util.Scanner;

public class Pig {
    private final Scanner scan;
    private final Die die;
    private int playerOnePoints;
    private int playerTwoPoints;


    public Pig(){
        die = new Die();
        scan = new Scanner(System.in);
    }
    public void welcomeGame(){
        System.out.println("Welcome to the Pig Game!");
    }


    public void gameOver(){
        System.out.println("Thanks for playing!");
        System.exit(0);
    }

    public void checkWinCondition(int points){
        if(points >=100){
            System.out.println("Congratulations you win");
            gameOver();
        }
    }

    public void playerOneTurn(){
        boolean finished = false;

        System.out.println("Player One's turn!");
        while (!finished) {
            System.out.println("Do you Wish to throw the dice? yes/no");
            String svar = scan.nextLine();
            if(svar.equalsIgnoreCase("No")){
                finished = true;
            }else {
                die.roll();
                if(die.getFaceValue() == 1){
                    System.out.println("You Threw 1, you suck");
                    finished = true;
                }else {
                    playerOnePoints = playerOnePoints + die.getFaceValue();
                    System.out.println("Player one points is" + getPlayerOnePoints());
                    checkWinCondition(getPlayerOnePoints());
                }
            }
        }
        playerTwoTurn();
    }

    public void playerTwoTurn(){
        boolean finished = false;

        System.out.println("Player Two's turn!");
        while (!finished) {
            System.out.println("Do you Wish to throw the dice? yes/no");
            String svar = scan.nextLine();
            if(svar.equalsIgnoreCase("No")){
                finished = true;
            }else {
                die.roll();
                if(die.getFaceValue() == 1){
                    System.out.println("You Threw 1, you suck");
                    finished = true;
                }else {
                    playerTwoPoints = playerTwoPoints + die.getFaceValue();
                    System.out.println("Player Two points is" + getPlayerTwoPoints());
                    checkWinCondition(getPlayerTwoPoints());
                }
            }
        }
        playerOneTurn();
    }
    public int getPlayerOnePoints() {
        return playerOnePoints;
    }

    public int getPlayerTwoPoints() {
        return playerTwoPoints;
    }

}
