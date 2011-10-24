< import-setninger >

public class Utleiested  < Nødvendig kode for en vindusklasse og lytteklasse >
{
   private Stativ stativet;
   private JTextField  personIdFelt, sykkelIdFelt;
   private JTextArea display;
   private JButton ut, inn ;
   private PersonRegister personer;

   public Utleiested(String navn, int antall, PersonRegister p)
   {
     super("BYSYKKEL " + navn);
     personer = p;
     stativet = new Stativ(antall);

     < Oppretter skjermkomponentene >

     < Knytter knappene til lytteobjektet >

     Container c = getContentPane();
     setLayout(new FlowLayout());

     < Legger skjermkomponentene ut på vinduet >

     setSize(200, 200);
     setVisible(true);
     setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }

   public void leiUt()
   {
     < Metoden skal leie ut en sykkel til personen med det id-nummer som er
       skrevet inn i tekstfeltet for dette. Hvis personen er registrert og er
       godkjent for utleie, skal det skrives ut i tekstområdet hvilken sykkel
       vedkommende skal ta. I motsatt fall skal det skrives ut en passende
       feilmelding. Denne skal inneholde årsaken til at peronen ikke fikk leie
       sykkelen. >
   }

   public void leverInn()
   {
     < Metoden skal registrere at en sykkel leveres inn. Hvis sykkelen er
       registrert utleid skal innleveringen registreres på personen som har
       leid sykkelen og det må registreres at sykkelen settes tilbake i stativet.
       I tekstområdet skal det skrives hvor sykkelen skal plasseres. Hvis
       sykkelens id-nummer er ukjent, skal det gis beskjed om det. >
   }

   public void actionPerformed(ActionEvent e )
   {
     < Metoden skal sørge for at leiUt() kalles når det klikkes på knappen
       "Leie", og at leverInn() kalles når det klikkes på  knappen "Levere" >
   }

}// end of class Utleiested
