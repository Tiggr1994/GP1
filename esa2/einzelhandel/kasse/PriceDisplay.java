package einzelhandel.kasse;

/**
* <p>Die Klasse TischrechnerController steuert die Aktionen 
* des Tischrechners. </p>
* <p>Dies schließt Eingaben und Ausgaben ein.
* Diese werden von den Objekten der Klasse aber nicht selbst 
* ausgeführt, sondern nur angestoßen (aufgerufen).</p>
* 
* @author Steven Tellekamp, Justus Hardtke
* @version 1.1 24.10.2019
*
*/

abstract public class PriceDisplay{

  abstract public void writeln(String text, long price);

}