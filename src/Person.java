import java.util.Date;
import java.text.DateFormat;

public class Person
{
	String navn;
	int id;
	Sykkel sykkel;
	String merknad;
	int StartTid;
	int nesteNr;
	
	public Person(String navn) {
		this.navn = navn;
		id = nesteNr++;	
	}

   public int getID() {
	   return id;
   }

   public Sykkel getSykkel() {
	   return sykkel;
   }

   public boolean godkjent()
   {
	   if (sykkel == null && merknad == null) {
		   return true;
	   }

	   return false;
   }

   public void setMerknad(Date t, String m) {
	   DateFormat df = DateFormat.getInstance();
	   
	   merknad+= df.format(t) + " " + m + "\n";
   }

   public boolean leiSykkel(Sykkel s) {
     /*
     < Hvis personen er godkjent, jfr. metoden godkjent(), skal metoden
       registrere at personen leier sykkelen s. Starttidspunktet for leietiden
       skal også registreres og skal være det samme som tidspunktet for når
       denne metoden blir kalt. Metoden skal så returnere true.
       Hvis personen ikke er godkjent, får vedkommende ikke leie sykkelen s
       og metoden skal returnere false. >
      * 
      */
     return false;
   }

   public int leietid(Date sluttTid) {
     /*
     < Metoden skal returnere antall påbegynte timer fra starttidspunktet for
       leien til sluttidspunktet angitt av parameteren sluttTid. >
      * 
      */
     return 0;
   }

   public void leverInn() {
     /*
     < Metoden skal registrere innleveringstidpunktet (som vil  være det samme
       som tidspunktet for når denne metoden blir kalt). Videre skal leietiden
       beregnes. Hvis den lovlige leietiden er overskredet, skal det settes en
       merknad på personen. Denne skal inneholde innleveringstidspunktet og det
       antall timer leietiden er overskredet med. Uansett skal det registreres
       at personen ikke lenger leier sykkelen. >
      * 
      */
   }

   public String toString() {
     /*
     < Metoden skal returnere en tekst som inneholder personens navn og idNr.
       Hvis personen leier en sykkel, skal sykkelens idNr tas med i teksten.
       Hvis personen har en merknad, skal denne også tas med i teksten. >
      * 
      */
     return null;
   }

} // end of class Person
