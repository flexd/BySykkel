public class Stativ
{
   private Sykkel[] stativ;
   private int antall = 0;
   private int maxAntall = 0;
   public Stativ(int antallSykler)
   {
     maxAntall = antallSykler;
     stativ = new Sykkel[antallSykler];
     fyllStativet();
   }

   public void fyllStativet()
   {
     /*
     < Her skal du opprette konkrete Sykkel-objekter og sette dem inn
       i arrayen. Et passende antall vil være halvparten av hva det er plass til. >
      */
     for (int i = 0; i < maxAntall/2; i++) {
       stativ[antall++] = new Sykkel();
     }
   }

   public int getAntall() {
    return antall;
   }
   public Sykkel finnLedigSykkel() {
     for (int i = 0; i < stativ.length; i++) {
       Sykkel sykkel = stativ[i];
       if (sykkel != null) {
         return sykkel;
       }
     }
     return null;
   }
    public int finnLedigPlass() {
     for (int i = 0; i < stativ.length; i++) {
       Sykkel sykkel = stativ[i];
       if (sykkel == null) {
         return i;
       }
     }
     return -1;
   }
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
     if (getAntall() > 0) {
       Sykkel sykkel = finnLedigSykkel();
       if (s.leiSykkel(sykkel)) {
         stativ[sykkel.getID()] = null; // Fjerne sykkelen fra stativet.
         return "Ta sykkel fra plass " + (1+sykkel.getID());
       }
       else { 
         // NO SOUP FOR YOU!
         return "Du får ikke leie sykkel fordi du enten har leid en sykkel fra før eller har noen negative merknader!";
       }
     }
     else {
      return "Det er desverre ingen ledige sykler på dette stativet, men det ser du vel dummen! :-D";
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
        return "Sett sykkelen på plass " + ledigPlass;
      }
      else {
        return "Stativet er fullt som du sikkert ser, returner sykkelen et annet sted";
      } 
   }

}// end of class Sykkel
