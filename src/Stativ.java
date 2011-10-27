/* 
 * Innlevering 3 - 30/10-2011
 * Kristoffer Berdal - s180212
 * Jan E. Vandevjen - s180494
 * Tommy Nyrud - s180487
 * Informasjonsteknologi 1IA og
 * Dataingeniør 1AA 
 */

/*Klasse som kontrollerer stativer, den inneholder metoder for å finne ledige plasser, fylle stativet, 
 * lokalisere sykler osv.   
 */
public class Stativ {

  private Sykkel[] stativ;
  private int nextStativID = 0;
  private int maxAntall = 0;

  public Stativ(int antallSykler) {
    maxAntall = antallSykler;
    stativ = new Sykkel[antallSykler];
    fyllStativet();
  }

  //Metode som fyller en stativ array med sykler.
  public final void fyllStativet() {
    for (int i = 0; i < (maxAntall / 2); i++) {
      Sykkel s = new Sykkel(nextStativID);
      stativ[nextStativID++] = s; //Lager ny sykkel m/stativID for dette stativet.
    }
  }

  //Metode som leter etter en ledig sykkel i stativet
  public Sykkel finnLedigSykkel() {
    for (int i = 0; i < stativ.length; i++) {
      Sykkel sykkel = stativ[i];
      if (sykkel != null) {
        return sykkel;
      }
    }
    return null;
  }

  //Finner en sykkel lik sykkelID sendt med som parameter
  public Sykkel finnSykkel(int sykkelID) {
    for (int i = 0; i < stativ.length; i++) {
      Sykkel sykkel = stativ[i];
      if (sykkel != null && sykkel.getID() == sykkelID) {
        return sykkel;
      }
    }
    return null;
  }

  //Metoden finner en ledig plass i stativet
  public int finnLedigPlass() {
    for (int i = 0; i < stativ.length; i++) {
      Sykkel sykkel = stativ[i];
      if (sykkel == null) {
        return i;
      }
    }
    return -1;
  }

  //Lar en person leie en ledig sykkel fra stativet
  public String leiUt(Person s) {
    if (stativ.length > 0) {
      Sykkel sykkel = finnLedigSykkel();
      if (s.leiSykkel(sykkel)) {
        stativ[sykkel.getStativID()] = null; // Fjerne sykkelen fra stativet.
        return "Ta sykkel med ID: " + (1 + sykkel.getID()) + " fra plass " + (1 + sykkel.getStativID()) + ".\n Dette ID-nummeret må du oppgi når du skal levere sykkelen\n";
      } else {

        return "Du får ikke leie sykkel fordi du enten har leid en sykkel fra før eller har noen negative merknader!\n";
      }
    } else {
      return "Det er desverre ingen ledige sykler på dette stativet\n";
    }
  }

  //Metode for å levere inn en sykkel
  public String leverInn(Person s) {
    int ledigPlass = finnLedigPlass();
    if (ledigPlass != -1) {
      stativ[ledigPlass] = s.getSykkel();
      s.leverInn();
      return "Sett sykkelen på plass " + (1 + ledigPlass) + "\n";
    } else {
      return "Stativet er fullt, returner sykkelen et annet sted\n";
    }
  }
}
