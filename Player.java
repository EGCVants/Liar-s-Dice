public interface Player{
  public String toString();
  public void playerFlipCoins(Coin[] theirCoins);  //Players flips and tracks their coins
  public void firstBid(Bid firstBid);
  public void playerTurn(Bid nextBid);
  //Returns Player number of head/tail to determine winner
  public int getPlayerCoins(String numHeadsTails); 
}