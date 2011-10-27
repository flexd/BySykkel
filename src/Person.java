/* 
 * Innlevering 3 - 30/10-2011
 * Kristoffer Berdal - s180212
 * Jan E. Vandevjen - s180494
 * Tommy Nyrud - s180487
 * Informasjonsteknologi 1IA og
 * Dataingeniør 1AA
 */

//Denne klassen sørger for konstruksjon og kontroll av Person objekter

import java.util.Date;
import java.text.DateFormat;
import javax.swing.JOptionPane;

public class Person
{
	private String navn;
	private int id;
	private Sykkel sykkel;
	private String merknad = "";
	private Date startTid;
	private static int nesteNr = 0; //Global tellevariabel for alle person objektene
   
	//Konstruktør som også gir Person objektet en ny id
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
   
   //Sjekker om personen verken eier en sykkel eller har en merknad
   public boolean godkjent()
   {
    if (sykkel == null && merknad.equals("")) {
      return true;
    }
    return false;
   }
   
   //Oppretter, og legger til merknader på brukeren
   public void setMerknad(Date t, String m) {
     DateFormat df = DateFormat.getInstance(); 
     merknad+= df.format(t) + " : " + m + "\n";
     JOptionPane.showMessageDialog(null, "Følgende merknad er registert - " + merknad);
   }
   
   //Knytter en bruker til en sykkel
   public boolean leiSykkel(Sykkel s) {
     if(godkjent()) {
      sykkel = s;
      startTid = new Date();
      return true;
     }
     return false;
   }
   
   //Regner ut leietid, rundet opp til nærmeste hele time
   public int leietid(Date sluttTid) {
    long varighet = (sluttTid.getTime() - startTid.getTime()); 
    int varighetTimer = (int) Math.ceil(varighet / 3600000);
	   
    return varighetTimer;
   }
   
   //Leverer inn sykkelen, og registerer en merknad om bruker har levert for sent.
   public void leverInn() {
     Date innTid = new Date();
	   
     if(leietid(innTid) > Sykkel.getMAXTID()) {
		   
      if(leietid(innTid) - Sykkel.getMAXTID() == 1 ) {
        setMerknad(innTid, "Sykkel ble levert " + (leietid(innTid) - Sykkel.getMAXTID()) + " time for sent");
      }
		   
      else {
        setMerknad(innTid, "Sykkel ble levert " + (leietid(innTid) - Sykkel.getMAXTID()) + " timer for sent");
      }
     }
     sykkel = null;
   }

  
   //Skriver ut relevant informasjon om brukeren
  @Override
   public String toString() {
	   String utskrift = navn + " ID nummer: " + id + "\n";
	   
	   if(sykkel != null) {
		   utskrift += "Sykkel id: " + sykkel.getID() + "\n";
	   }
	   
	   if(merknad != "") {
		   utskrift += merknad;
	   }
	   
	   return utskrift;
   }

} 
