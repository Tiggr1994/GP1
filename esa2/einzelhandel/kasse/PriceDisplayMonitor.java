package einzelhandel.kasse;

/**
* <p>Klasse zur Ausgabe auf dem Monitor.</p>
* 
* @author Steven Tellekamp, Justus Hardtke, Maik Hämpke, Sebastian Naczk, Waqas Daud
* @version 1.0 26.10.2019
*
*/

public class PriceDisplayMonitor extends PriceDisplay {

  public void writeln(String text, long number){ 
    System.out.println("> " + (number)+"   " + text +" <");
  };
}