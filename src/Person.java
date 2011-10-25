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
	static int nesteNr = 0;
	
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
	   Date innTid = new Date();
	   
	   if(leietid(innTid) > Sykkel.getMAXTID()) {
		   
		   if(leietid(innTid) - 3 == 1 ) {
		   setMerknad(innTid, "Sykkel ble levert " + (leietid(innTid) - Sykkel.getMAXTID()) + " time for sent");
		   }
		   
		   else {
			   setMerknad(innTid, "Sykkel ble levert " + (leietid(innTid) - Sykkel.getMAXTID()) + " timer for sent");
		   }
	   }
	   sykkel = null;
   }

  

  @Override
   public String toString() {
	   String utskrift = navn + " ID nummer: " + id + "\n";
	   
	   if(sykkel != null) {
		   utskrift += "Sykkel id: " + sykkel.getID() + "\n";
	   }
	   
	   if(merknad != null) {
		   utskrift += merknad;
	   }
	   
	   return utskrift;
   }

} 
