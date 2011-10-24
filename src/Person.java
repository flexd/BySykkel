import java.util.Date;
import java.text.DateFormat;

public class Person
{
   < datafelt >

   < konstruktør >

   < get-metoder for sykkel og idNr >


   public boolean godkjent()
   {
     < Metoden skal returnere true hvis personen ikke allerede leier
       en sykkel og ikke har noen merknader. Ellers false. >
   }

   public void setMerknad(Date t, String m)
   {
     < Metoden skal ut fra parametrene t og m lagre en tekst i datafeltet for
       merknader. I teksten skal tidspunktet formateres  slik det er beskrevet
       i oppgavens innledning. >
   }

   public boolean leiSykkel(Sykkel s)
   {
     < Hvis personen er godkjent, jfr. metoden godkjent(), skal metoden
       registrere at personen leier sykkelen s. Starttidspunktet for leietiden
       skal også registreres og skal være det samme som tidspunktet for når
       denne metoden blir kalt. Metoden skal så returnere true.
       Hvis personen ikke er godkjent, får vedkommende ikke leie sykkelen s
       og metoden skal returnere false. >
   }

   public int leietid(Date sluttTid)
   {
     < Metoden skal returnere antall påbegynte timer fra starttidspunktet for
       leien til sluttidspunktet angitt av parameteren sluttTid. >
   }

   public void leverInn()
   {
     < Metoden skal registrere innleveringstidpunktet (som vil  være det samme
       som tidspunktet for når denne metoden blir kalt). Videre skal leietiden
       beregnes. Hvis den lovlige leietiden er overskredet, skal det settes en
       merknad på personen. Denne skal inneholde innleveringstidspunktet og det
       antall timer leietiden er overskredet med. Uansett skal det registreres
       at personen ikke lenger leier sykkelen. >
   }

   public String toString()
   {
     < Metoden skal returnere en tekst som inneholder personens navn og idNr.
       Hvis personen leier en sykkel, skal sykkelens idNr tas med i teksten.
       Hvis personen har en merknad, skal denne også tas med i teksten. >
   }

} // end of class Person
