public class Bid {
  private int numbOfHT;
  private String coinFace;
  private boolean liarCalled;

  public Bid(){
    numbOfHT = 0;
    liarCalled = false;
  }
  public String toString(){
    return "The current bid is " + numbOfHT + " " + coinFace;
  }

  //Applies to first turn only
  public void updateFace(String newFace){
    coinFace = newFace;
  }
  //Changed every turn by player
  public void updateNumCoins(int newBid){
    numbOfHT = newBid;
  }
  public void callLiar(){
    liarCalled = true;
  }
  public String getCoinFace(){
    return coinFace;
  }
  public int getNumCoins(){
    return numbOfHT;
  }
  public boolean getLiarCall(){
    return liarCalled;
  }
}