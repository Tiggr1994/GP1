package einzelhandel.kasse;

/**
* <p>Basisklasse um Preise auf einem Ausgabe Gerät dar zu stellen.</p>
* 
* @author Steven Tellekamp, Justus Hardtke, Maik Hämpke, Sebastian Naczk, Waqas Daud
* @version 1.0 26.10.2019
*
*/

abstract public class PriceDisplay{

  abstract public void writeln(String text, long price);
}