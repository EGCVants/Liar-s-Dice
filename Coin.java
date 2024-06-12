import java.util.Random;

public class Coin{
  private boolean coinFace;

  public Coin(){
    coinFace = false;
  }
  
  public boolean flipCoin(){
    Random flipped = new Random();
    int face = flipped.nextInt(2);
    if(face == 1){
      coinFace = true; //heads
    }
    //Otherwise, just returns false, represents tails
    return coinFace; 
  }

  public boolean getCoin(){
    return coinFace;
  }
}