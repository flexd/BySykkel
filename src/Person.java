import java.util.Date;
import java.text.DateFormat;
import javax.swing.JOptionPane;

public class Person
{
	String navn;
	int id;
	Sykkel sykkel;
	String merknad;
	Date startTid;
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
		   JOptionPane.showMessageDialog(null, "godkjent() ble true");
		   return true;
	   }
	   JOptionPane.showMessageDialog(null, "godkjent() ble false");
	   return false;
   }

   public void setMerknad(Date t, String m) {
	   DateFormat df = DateFormat.getInstance();
	   merknad+= df.format(t) + " : " + m + "\n";
	   JOptionPane.showMessageDialog(null, "merknad registert");
   }

   public boolean leiSykkel(Sykkel s) {
	   if(godkjent() == true) {
		   sykkel = s;
		   startTid = new Date();
		   JOptionPane.showMessageDialog(null, "leiSykkel() ble true");
		   return true;
	   }
	   JOptionPane.showMessageDialog(null, "leiSykkel() ble false");  
	   return false;
   }

   public int leietid(Date sluttTid) {
	   long varighet = (sluttTid.getTime() - startTid.getTime()); 
	   int varighetTimer = (int) Math.ceil(varighet / 3600000);
	   
	   return varighetTimer;
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
