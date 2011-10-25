public class Sykkel {
  private final static int MAXTID = 3;
  private static int nextID = 0;
  private int stativID = -1;
  private int id;
  private int leidAvID = -1;
   
  public Sykkel(int sID) {
    id = nextID++;
    stativID = sID; // StativID er ID til sykkelen i stativet den er i akkurat NUH.
  }

  public static int getMAXTID() {
    return MAXTID;
  }

  public int getLeidAvID() {
    return leidAvID;
  }

  public void setLeidAvID(int leidAvID) {
    this.leidAvID = leidAvID;
  }
  
  public int getStativID() {
    return stativID;
  }
  
  
  public int getID() {
    System.out.println("Id er : " + id);
    return id;
  }
  
} // End of Sykkel