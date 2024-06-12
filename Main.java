import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Player one;
    Player two;
    Bid bid = new Bid();
    Coin [] p1Coins = new Coin[5];
    Coin [] p2Coins = new Coin[5];
    Scanner sc = new Scanner (System.in);

    //Initializes and creates two arrays of coins for each player
    for(int i = 0; i < p1Coins.length; i++){
      p1Coins[i] = new Coin();
      p2Coins[i] = new Coin();
    }
    
    //Display Menu
    System.out.println("How would you like to play:");
    System.out.println("1. Human vs Computer(Random)");
    System.out.println("2. Human vs Computer(Smart)");
    System.out.println("3. Computer(Random) vs Human");
    System.out.println("4. Computer(Random) vs Computer(Random)");
    System.out.println("5. Computer(Random) vs Computer(Smart)");
    System.out.println("6. Computer(Smart) vs Human");
    System.out.println("7. Computer(Smart) vs Computer(Random)");
    System.out.println("8. Computer(Smart) vs Computer(Smart)");
    int choice = sc.nextInt();
    sc.nextLine();
    if(choice == 2){
      one = new HumanPlayer(sc);
      two = new SmartPlayer();
    } else if(choice == 3){
      one = new RandomPlayer();
      two = new HumanPlayer(sc);
    } else if (choice == 4){
      one = new RandomPlayer();
      two = new RandomPlayer();
    } else if (choice == 5){
      one = new RandomPlayer();
      two = new SmartPlayer();
    } else if (choice == 6){
      one = new SmartPlayer();
      two = new HumanPlayer(sc);
    } else if (choice == 7){
      one = new SmartPlayer();
      two = new RandomPlayer();
    } else if (choice == 8){
      one = new SmartPlayer();
      two = new SmartPlayer();
    } else {                     //First Option
      one = new HumanPlayer(sc);
      two = new RandomPlayer();
    }
    play(one, two, p1Coins, p2Coins, bid);
  }

  public static void play(Player one, Player two,
                          Coin [] p1Coins, Coin [] p2Coins, Bid bid){
    int turnCount = 0;
    //Each Player recieves and flips their coins
    one.playerFlipCoins(p1Coins);
    two.playerFlipCoins(p2Coins);
    
    //First Turn
    System.out.println("Player 1's turn");
    one.firstBid(bid);
    
    //Every other turn
    while(!(bid.getLiarCall())){ 
      //Display current bid at the start of turn
      System.out.println(bid);
      turnCount++;
      //Who bids next is based on current turnCount 
      System.out.println("Player " + (turnCount % 2 + 1) + "'s turn");
      if((turnCount % 2) == 0){ //Even numbers
        one.playerTurn(bid);
      }
      else { //Odd numbers
        two.playerTurn(bid);
      }
    }
    //Liar called, establishes who is bidder 
    //and who is challenger based on ending turnCount
    if((turnCount % 2) == 0){//Is Even, therefore ended on P1 turn
      String bidder = "Player two";
      String challenger = "Player one";
      System.out.println(challenger + " has challenged " + bidder);
      endTurn(two, one, bid, bidder, challenger);
    } else { //Is Odd, therefore ended on P2 turn
      String bidder = "Player one";
      String challenger = "Player two";
      System.out.println(challenger + " has challenged " + bidder);
      endTurn(one, two, bid, bidder, challenger); //Calls public method below
    }
  }

  public static void endTurn(Player bidder, Player challenger, Bid lastBid, 
                                             String whoBid, String whoChal){
    //Gets number of H or T coins of both players based on coin face being bid
    int bidderCoins = bidder.getPlayerCoins(lastBid.getCoinFace());
    int challengerCoins = challenger.getPlayerCoins(lastBid.getCoinFace());
    
    //Displays bid and player Coins
    System.out.println(lastBid);
    //Both players have coins displayed by toString methods
    System.out.println(whoChal + " has " + challenger);
    System.out.println(whoBid + " has " + bidder);

    //Determines winner
    //For bidder, total coins of coinFace has to be as big as the final bid
    if(lastBid.getNumCoins() <= (bidderCoins + challengerCoins)){
      System.out.println(whoBid + " wins");
    } else {
      System.out.println(whoChal + " wins");
    }
  }
}
