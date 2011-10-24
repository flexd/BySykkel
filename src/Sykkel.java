public class Sykkel {
  private final static int MAXTID = 3;
  private static int nextID = 1;
   
  private int id;
   
  public Sykkel() {
    id = nextID++;
  }

  public static int getMAXTID() {
    return MAXTID;
  }
  
  public int getID() {
    System.out.println("Id er : " + id);
    return id;
  }
  
} // End of Sykkel