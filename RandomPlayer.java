import java.util.Random;
public class RandomPlayer implements Player{
  private Coin [] randomCoins;
  private int numHeads;
  private int numTails;
  private Random pick = new Random();
  
  //Only used during coin reveal
  public String toString(){
    return numHeads + " heads and "  + numTails + " tails";
  }
  
  //Only keeps track of H/Ts for the final reveal
  public void playerFlipCoins(Coin[] gotCoins){
    randomCoins = gotCoins;
    for(int i = 0; i < randomCoins.length; i++){
      randomCoins[i].flipCoin();
      if(randomCoins[i].getCoin()){
        numHeads++;
      } else {
        numTails++;
      }
    }
  }

  public void firstBid(Bid compBid){
    String yourFaceBid;
    //Randomly picks heads or tails
    if(pick.nextBoolean()){
      yourFaceBid = "heads";
      compBid.updateFace(yourFaceBid);
    } else {
      yourFaceBid = "tails";
      compBid.updateFace(yourFaceBid);
    }
    //Random bid between 0 and 10 (10 being the total coins)
    compBid.updateNumCoins(pick.nextInt(2* (randomCoins.length) + 1));
  }

  public void playerTurn(Bid nextBid){
    //Bids shouldn't go over 10, simply to keep the game somewhat "realistic"
    if(pick.nextBoolean() && (nextBid.getNumCoins() <= 10)){
      nextBid.updateNumCoins((nextBid.getNumCoins() + 1));
    }
    else {
      nextBid.callLiar();
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