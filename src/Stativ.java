/* 
 * Innlevering 3 - 30/10-2011
 * Kristoffer Berdal - s180212
 * Jan E. Vandevjen - s180494
 * Tommy Nyrud - s180487
 * Informasjonsteknologi 1IA og
 * Dataingeni�r 1AA 
 */

/*Klasse som kontrollerer stativer, den inneholder metoder for � finne ledige plasser, fylle stativet, 
 * lokalisere sykler osv.   
 */
public class Stativ
{
   private Sykkel[] stativ;
   private int nextStativID = 0;
   private int maxAntall = 0;
   
   public Stativ(int antallSykler)
   {
     maxAntall = antallSykler;
     stativ = new Sykkel[antallSykler];
     fyllStativet();
   }
   
   //Metode som fyller en stativ array med sykler.
   public void fyllStativet()
   {
     for (int i = 0; i < (maxAntall/2); i++) {
       Sykkel s = new Sykkel(nextStativID);
       stativ[nextStativID++] = s; //Lager ny sykkel m/stativID for dette stativet.
     }
   }
   
   public int getNextStativID() {
    return nextStativID;
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
   
   //
   public String leiUt(Person s)
   {
     /*
     < Metoden skal registrere at personen representert ved parameteren s
       leier en sykkel under følgende tre forutsetninger:
       - Personen har ingen merknader.
       - Personen leier ingen sykkel fra før.
       - Det er en ledig sykkel i stativet.
       Hvis alle betingelsene er oppfylt, skal sykkelen fjernes fra stativet og
       leie av sykkelen skal registreres på personen. Metoden skal så returnere
       en tekst med informasjon om hvilken sykkel som skal brukes, for eksempel:
       "Ta sykkel på plass 1". Husk at plassene går fra 1 og oppover. Hvis leie
       av sykkel ikke lar seg gjøre skal metoden returnere en tekst med
       informasjon om hva det skyldes. >*/
     if (stativ.length > 0) {
       Sykkel sykkel = finnLedigSykkel();
       if (s.leiSykkel(sykkel)) {
         stativ[sykkel.getStativID()] = null; // Fjerne sykkelen fra stativet.
         return "Ta sykkel med ID: " + (1+sykkel.getID()) + " fra plass " + (1+sykkel.getStativID()) + ".\n Dette ID-nummeret må du oppgi når du skal levere sykkelen\n";
       }
       else { 
         // NO SOUP FOR YOU!
         return "Du f�r ikke leie sykkel fordi du enten har leid en sykkel fra f�r eller har noen negative merknader!\n";
       }
     }
     else {
      return "Det er desverre ingen ledige sykler p� dette stativet\n";
     }
   }

   public String leverInn(Person s )
   {
     /*
     < Metoden skal sørge for at sykkelen som personen, representert ved
       parameteren s,leier blir "satt tilbake i stativet", under forutsetning
       av at det er plass i stativet. Videre må det registreres at personen nå
       ikke lenger leier sykkelen. Hvis det er plass skal metoden returnere en
       tekst som angir hvor sykkelen skal plasseres, for eksempel:
       "Sett sykkelen på plass 12".I motsatt fall skal det returneres en tekst
       som ber syklisten levere sykkelen et annet sted. >
      */
      int ledigPlass = finnLedigPlass();
      if (ledigPlass != -1) {
        stativ[ledigPlass] = s.getSykkel();
        s.leverInn();
        return "Sett sykkelen på plass " + (1+ledigPlass) + "\n";
      }
      else {
        return "Stativet er fullt, returner sykkelen et annet sted\n";
      } 
   }

}// end of class Sykkel
