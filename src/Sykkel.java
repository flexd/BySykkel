/* 
 * Innlevering 3 - 30/10-2011
 * Kristoffer Berdal - s180212
 * Jan E. Vandevjen - s180494
 * Tommy Nyrud - s180487
 * Informasjonsteknologi 1IA og
 * Dataingeniør 1AA 
 */

//Klasse for for sørger for å konstruksjon og kontroll av Sykkelobjekter

public class Sykkel {
  private final static int MAXTID = 3;
  private static int nextID = 0;
  private int stativID = -1;
  private int id;
   
  public Sykkel(int sID) {
    id = nextID++;
    stativID = sID; // StativID er ID til sykkelen i stativet den er i akkurat nå.
  }

  public static int getMAXTID() {
    return MAXTID;
  }
  
  public int getStativID() {
    return stativID;
  }
  
  
  public int getID() {
    return id;
  }
  
}