package einzelhandel.kasse;

/**
* <p>Klasse zur Ausgabe auf dem Monitor.</p>
* 
* @author Steven Tellekamp, Justus Hardtke
* @version 1.1 24.10.2019
*
*/

public class PriceDisplayMonitor extends PriceDisplay {

  public void writeln(String text, long number){ 
    System.out.println("> " + (number)+"   " + text +" <");
  };

}