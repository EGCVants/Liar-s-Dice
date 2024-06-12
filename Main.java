import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Coin coin = new Coin();
        Scanner sc = new Scanner (System.in);
        Coin [] p1Coins = new Coin[5];
        Coin [] p2Coins = new Coin[5];

        //Initializes and create two arrays of coins for each player
        for(int i = 0; i < p1Coins.length; i++){
            p1Coins[i] = new Coin();
            p2Coins[i] = new Coin();
            p1Coins[i].flipCoin();
            p2Coins[i].flipCoin();
            //System.out.println(p1Coins[i]);
        }
        //coin.flipCoin();
        Player one= new RandomPlayer();
        Player two = new HumanPlayer(sc);
        System.out.println("How would you like to play:");
        System.out.println("1. Human vs Computer(Random");
        System.out.println("2. Human vs Computer(Smart)");
        int choice = sc.nextInt();
        sc.nextLine();

        if(choice == 1){
            one = new RandomPlayer();
            two = new HumanPlayer(sc);
        } else if(choice == 2){
            System.out.println("hi");
        }

        System.out.println("Player 1 has bet " + one.firstBid(p1Coins));
        two.firstBid(p2Coins);
    }
}
/*
Make a bid
Raise
Call liar
*/