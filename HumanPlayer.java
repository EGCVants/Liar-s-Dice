import java.util.Scanner;

public class HumanPlayer implements Player{
  private Coin [] humanCoins;
  private int numHeads;
  private int numTails;
  private Scanner sc;
  
  public HumanPlayer(Scanner scanned){
    numTails = 0;
    numHeads = 0;
    sc = scanned;
  }

  //Called every turn to remind player; to "see" their coins
  public String toString(){
    return numHeads + " heads and " + numTails + " tails";
  }

  public void playerFlipCoins(Coin[] gotCoins){
    humanCoins = gotCoins;
    for(int i = 0; i < humanCoins.length; i++){
      humanCoins[i].flipCoin();
      if(humanCoins[i].getCoin()){
        numHeads++; //Tracks the number of heads
      } else {
        numTails++; //Tracks the number of tails
      }
    }
  }
  public void firstBid(Bid firstBid){
    String yourFaceBid;
    int yourNumBid = 0; //What human player bids
    int choice = 0; //Choose off of menu
    
    //Display user coins
    System.out.println("You have " + toString());

    //Menu: for declaring either heads or tails (first turn only)
    System.out.println("What coin face do you want to bet:");
    System.out.println("1. Heads");
    System.out.println("2. Tails");
    choice = sc.nextInt();
    sc.nextLine();
    if(choice == 1){
      yourFaceBid = "heads";
      firstBid.updateFace(yourFaceBid);
    } else {
      yourFaceBid = "tails";
      firstBid.updateFace(yourFaceBid);
    }
    //Prompts for number of coins to bid
    System.out.println("How many heads/tails do you want to bid:");
    yourNumBid = sc.nextInt();
    sc.nextLine();
    firstBid.updateNumCoins(yourNumBid);
  }

  //Method for every other turn
  public void playerTurn(Bid nextBid){
    int choice = 0;
    System.out.println("You have " + toString());
    //Displays menu to either Raise or Call Liar
    System.out.println("What would you like to do:");
    System.out.println("1) Raise");
    System.out.println("2) Call Liar");
    choice = sc.nextInt();
    sc.nextLine();
    if(choice == 2){
      nextBid.callLiar();
    } else {
      int yourNumBid = 0;
      //Prompts for number of coins you want to raise bid to
      System.out.println("What are you raising the number of " + nextBid.getCoinFace() + " to:");
      yourNumBid = sc.nextInt();
      sc.nextLine();
      nextBid.updateNumCoins(yourNumBid);
    }
    
  }
  
  public int getPlayerCoins(String headsTails){
    if(headsTails.equals("heads")){
      return numHeads;
    } else {
      return numTails;
    }
  }
}