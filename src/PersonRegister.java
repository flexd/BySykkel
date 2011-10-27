/* 
 * Innlevering 3 - 30/10-2011
 * Kristoffer Berdal - s180212
 * Jan E. Vandevjen - s180494
 * Tommy Nyrud - s180487
 * Informasjonsteknologi 1IA og
 * Dataingeniør 1AA 
 */

//Klasse som oppretter og leter igjennom Person objekter

public class PersonRegister
{
   private Person[] personer;


   public PersonRegister(int antall)
   {
     personer = new Person[antall];
     opprettPersonregister();
   }
   
   //Metoden oppretter 10 brukere i har valgt å navngi. 
   public final void opprettPersonregister()
   {
     personer[0] = new Person("Mester Tommy");
     personer[1] = new Person("Kristoffer");
     personer[2] = new Person("Jan");
     personer[3] = new Person("Skrue McDuck");
     personer[4] = new Person("Donald Duck");
     personer[5] = new Person("Albert Einstein");
     personer[6] = new Person("Petter Smart");
     personer[7] = new Person("Dennis Ritchie");
     personer[8] = new Person("C'thululu");
     personer[9] = new Person("Marie Hufsa");
   }
   
   //Metode som leter etter et person objekt med personID lik parameteret som blir sendt med
   public Person finnPerson(int personID)
   {
     for (int i = 0; i < personer.length; i++) {
       Person person = personer[i];
       if (person != null && person.getID() == personID) {
         return person;
       }
     }
     return null;
     }
   
   //Metode som finner hvilket Person objekt som eier Sykkel med sykkelID gitt som parameter
   public Person finnSykkelBruker(int sykkelID)
   {
     for (int i = 0; i < personer.length; i++) {
       Person person = personer[i];
       if (person != null && person.getSykkel() != null && person.getSykkel().getID() == sykkelID) {
         return person;
       }
     }
     return null;
   }   
} 
