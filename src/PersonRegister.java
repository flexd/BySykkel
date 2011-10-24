public class PersonRegister
{
   private Person[] personer;


   public PersonRegister(int antall)
   {
     personer = new Person[antall];
     opprettPersonregister();
   }

   public  void opprettPersonregister()
   {
     < Her skal du opprette konkrete Person-objekter og sette dem inn
       i arrayen, f.eks 10 stykker. Du vil trenge dem for å kunne teste
       ut programmet. >
   }

   public Person finnPerson(int personId)
   {
     < Metoden skal lete etter en person (et person-objekt) med idNr lik
       parameteren personId. Hvis personen finnes i registeret, skal person-
       objektet returneres fra metoden. I motsatt fall skal metoden returnere
       null. NB! Vi kjenner ikke til antall person-objekter i arrayen og vet
       heller ikke om disse ligger etter hverandre. >
   }

   public Person finnSykkelBruker(int sykkelId)
   {
     < Metoden skal lete etter en person (et person-objekt) som leier en sykkel
       med idNr lik parameteren sykkelId. Hvis en slik person finnes i registeret,
       skal person-objektet returneres fra metoden. I motsatt fall skal metoden
       returnere null. NB! Vi kjenner ikke til antall person-objekter i arrayen
       og heller ikke om disse ligger etter hverandre. >
   }

} // end of class PersonRegister
