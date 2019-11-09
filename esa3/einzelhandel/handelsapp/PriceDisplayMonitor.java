package einzelhandel.handelsapp;

/**
* <p>Klasse zur Ausgabe auf dem Monitor.</p>
* 
* @author Steven Tellekamp, Justus Hardtke, Maik Hämpke, Sebastian Naczk, Waqas Daud, Katharina Müller
* @version 1.0 08.11.2019
*
*/

public class PriceDisplayMonitor extends PriceDisplay {

  public void writeln(String text, long number){ 
    System.out.println("> " + (number)+"   " + text +" <");
  };
}