package einzelhandel.handelsapp;

/**
* <p>Basisklasse um Preise auf einem Ausgabe Gerät dar zu stellen.</p>
* 
* @author Steven Tellekamp, Justus Hardtke, Maik Hämpke, Sebastian Naczk, Waqas Daud, Katharina Müller
* @version 1.0 08.11.2019
*
*/

abstract public class PriceDisplay{

  abstract public void writeln(String text, double price);
}