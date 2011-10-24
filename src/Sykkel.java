public class Sykkel {
  private final static int MAXTID = 3;
  private static int nextID = 1;
   
  private int id;
   
  public Sykkel() {
    id = nextID++;
  }

  public int getId() {
    return id;
  }
  
} // End of Sykkel