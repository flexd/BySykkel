public class PersonRegister
{
   private Person[] personer;


   public PersonRegister(int antall)
   {
     personer = new Person[antall];
     opprettPersonregister();
   }

   public final void opprettPersonregister()
   {
     /*
     < Her skal du opprette konkrete Person-objekter og sette dem inn
       i arrayen, f.eks 10 stykker. Du vil trenge dem for å kunne teste
       ut programmet. >
      * 
      */
     personer[0] = new Person("Mester Tommy");
     personer[1] = new Person("Kristoffer");
     personer[2] = new Person("Jan");
     personer[3] = new Person("Skrue McDuck");
     personer[4] = new Person("Donald Duck");
     personer[5] = new Person("Albert Einstein");
     personer[6] = new Person("Petter Smart");
     personer[7] = new Person("Dennis Ritchie");
     personer[8] = new Person("C'thululu");
     personer[9] = new Person("Hufsa");
     
     // 10 personer. Go to start and collect 200$
   }

   public Person finnPerson(int personID)
   {
     /*
     < Metoden skal lete etter en person (et person-objekt) med idNr lik
       parameteren personId. Hvis personen finnes i registeret, skal person-
       objektet returneres fra metoden. I motsatt fall skal metoden returnere
       null. NB! Vi kjenner ikke til antall person-objekter i arrayen og vet
       heller ikke om disse ligger etter hverandre. >
      */
     for (int i = 0; i < personer.length; i++) {
       Person person = personer[i];
       if (person != null && person.getID() == personID) {
         return person;
       }
     }
     return null;
     }

   public Person finnSykkelBruker(int sykkelID)
   {
     /*
     < Metoden skal lete etter en person (et person-objekt) som leier en sykkel
       med idNr lik parameteren sykkelId. Hvis en slik person finnes i registeret,
       skal person-objektet returneres fra metoden. I motsatt fall skal metoden
       returnere null. NB! Vi kjenner ikke til antall person-objekter i arrayen
       og heller ikke om disse ligger etter hverandre. >
      * 
      */
     for (int i = 0; i < personer.length; i++) {
       Person person = personer[i];
       if (person != null && person.getSykkel().getID() == sykkelID) {
         return person;
       }
     }
     return null;
   }

} // end of class PersonRegister
