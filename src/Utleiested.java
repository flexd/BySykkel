/* 
 * Innlevering 3 - 30/10-2011
 * Kristoffer Berdal - s180212
 * Jan E. Vandevjen - s180494
 * Tommy Nyrud - s180487
 * Informasjonsteknologi 1IA og
 * Dataingeniør 1AA 
 */

// Klasse som håndterer Utleiestedene, Vindusklassen og events.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Utleiested extends JFrame implements ActionListener {

  private Stativ stativet;
  private JTextField personIDFelt, sykkelIDFelt;
  private JTextArea display;
  private JLabel personIDlabel, sykkelIDlabel;
  private JButton ut, inn;
  private PersonRegister personer;

  public Utleiested(String navn, int antall, PersonRegister p) {
    super("BYSYKKEL " + navn);
    personer = p;
    stativet = new Stativ(antall);

    personIDlabel = new JLabel("Person ID");
    personIDFelt = new JTextField(4);
    ut = new JButton("Leie");
    sykkelIDlabel = new JLabel("Sykkel ID");
    sykkelIDFelt = new JTextField(4);
    inn = new JButton("Levere");

    // Lytte etter hendelser.

    ut.addActionListener(this);
    inn.addActionListener(this);
    display = new JTextArea(6, 15);
    display.setEditable(false);
    display.setLineWrap(true);

    JScrollPane content = new JScrollPane(display);
    content.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    Container c = getContentPane();

    setLayout(new FlowLayout());

    c.add(personIDlabel);
    c.add(personIDFelt);
    c.add(ut);
    c.add(sykkelIDlabel);
    c.add(sykkelIDFelt);
    c.add(inn);
    c.add(content);

    setSize(200, 200);
    setVisible(true);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  // Leier ut sykkelen
  public void leiUt() {
    boolean failed = false;
    int personID = -1;
    try {
      String personIDstring = personIDFelt.getText();
      personID = Integer.parseInt(personIDstring) - 1;
    } catch (Exception e) {
      failed = true;
    }

    // Ingen problemer med å parse Stringen i tekstfeltet til integer.
    if (!failed) {
      Person person = personer.finnPerson(personID);
      if (person != null) {
        // Success, vi har en person.
        String resultat = stativet.leiUt(person);
        display.append(resultat);
      } else {
        // Sorry personen finnes ikke i registeret.
        display.append("Personen finnes ikke i register\n");
      }
    }

  }

  // Metode for å levere inn sykkel, 
  public void leverInn() {

    boolean failed = false;
    int sykkelID = -1;
    try {
      String sykkelIDstring = sykkelIDFelt.getText();
      sykkelID = Integer.parseInt(sykkelIDstring) - 1;
    } catch (Exception e) {
      failed = true;
    }
    // Ingen problemer, yay!
    if (!failed) {
      Person person = personer.finnSykkelBruker(sykkelID);
      String resultat = "";

      if (person != null) {
        // Success, vi har en person.
        resultat = stativet.leverInn(person);
      } else {
        resultat = "Det finnes ingen person med dette ID eller så har ingen leid denne sykkelen.\n";
      }
      display.append(resultat);
    } else {
      // Sorry personen finnes ikke i registeret.
      display.append("Du må faktisk skrive inn et id\n");
    }
  }

  // Enkel @override metode for å håndtere knapper! :-D
  @Override
  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == ut) {
      leiUt();
    } else if (e.getSource() == inn) {
      leverInn();
    }
  }
}// end of class Utleiested
