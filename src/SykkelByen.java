/* 
 * Innlevering 3 - 30/10-2011
 * Kristoffer Berdal - s180212
 * Jan E. Vandevjen - s180494
 * Tommy Nyrud - s180487
 * Informasjonsteknologi 1IA og
 * Dataingeniør 1AA 
 */

//Hovedprogrammet for Sykkelbyen
public final class SykkelByen {

  private Utleiested[] steder;
  private PersonRegister register;

  public SykkelByen(int antall, PersonRegister r) {
    register = r;
    steder = new Utleiested[antall];
    opprettSykkelSteder();
  }

  public void opprettSykkelSteder() {
    steder[0] = new Utleiested("Holbergs plass", 20, register);
    steder[1] = new Utleiested("Majorstua", 20, register);
    steder[2] = new Utleiested("Nasjonalteateret", 20, register);
    steder[3] = new Utleiested("Egertorvet", 20, register);
  }

  public static void main(String[] args) {
    PersonRegister register = new PersonRegister(10);
    new SykkelByen(10, register);
  }
}
