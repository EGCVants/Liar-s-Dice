public class SmartPlayer implements Player{
  private Coin [] smartCoins;
  private int numHeads;
  private int numTails;
  
  public String toString(){
     return numHeads + " heads and "  + numTails + " tails";
  }
  
  public void playerFlipCoins(Coin[] gotCoins){
    smartCoins = gotCoins;
    for(int i = 0; i < smartCoins.length; i++){
      smartCoins[i].flipCoin();
      if(smartCoins[i].getCoin()){
        numHeads++;
      } else {
        numTails++;
      }
    }
  }
  //First Bid based on highest number between H or T they have.
  //First bid becomes 1 less than number of whatever they bid.
  public void firstBid(Bid firstBid){
    String faceBid;
    if(numHeads >= numTails){
      faceBid = "heads";
      firstBid.updateNumCoins(numHeads - 1);
    } else {
      faceBid = "tails";
      firstBid.updateNumCoins(numTails - 1);
    }
    firstBid.updateFace(faceBid);
  }
  
  public void playerTurn(Bid smartBid){
    //method retrieves smart player's H or T coins based on current coin face bid 
    int myCoins = getPlayerCoins(smartBid.getCoinFace());
    int currentBid = smartBid.getNumCoins();
    //somewhat tries to determine oppenent number of coin:
    //(myCoins + oppenentCoins = currentBid) = (oppenentCoins = currentBid - myCoins)
    int coinDiff = Math.abs(currentBid - myCoins); 

    //If the bid is less than number of smart player coins, risky to challenge
    //so raise until bid is at least number of coins of smartPlayer 
    if(currentBid < myCoins){ 
      smartBid.updateNumCoins(currentBid + myCoins / 3 + 1); //Always either 2 or 1
    } else if(coinDiff >= 4){ 
      //If difference is 4, implies that oppenent has 4 coins out of the bid; unlikely
      smartBid.callLiar();
    } else {
      smartBid.updateNumCoins(currentBid + 1);//Just increase bid by 1
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
