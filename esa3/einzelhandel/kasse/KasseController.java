package einzelhandel.handelsapp;


/**
* <p>Die Klasse KasseController steuert die Aktionen 
* der Kasse. </p>
* <p>Dies schließt Eingaben und Ausgaben ein.
* Diese werden von den Objekten der Klasse aber nicht selbst 
* ausgeführt, sondern nur angestoßen (aufgerufen).</p>
* 
* @author Steven Tellekamp, Justus Hardtke, Maik Hämpke, Sebastian Naczk, Waqas Daud, Katharina Müller
* @version 1.0 08.11.2019
*
*/
public class KasseController{

	ArithmeticUnit alu;
	PriceDisplay priceDisplayMonitor;
	PriceDisplay priceDisplayStandardPaperRoll;


	KasseController(){
	this.alu                           = new ArithmeticUnit();
	this.priceDisplayMonitor           = new PriceDisplayMonitor();
	this.priceDisplayStandardPaperRoll = new PriceDisplayStandardPaperRoll();
	}

	public void run(){
    //this.priceDisplayMonitor.writeln("Summe", this.alu.add(op1, op2));
    //this.priceDisplayStandardPaperRoll.writeln("Summe", this.alu.add(op1, op2));
	}
  
	public void registrierePosten(String produktName, long bruttoPreis){
		
	this.priceDisplayMonitor.writeln(produktName, bruttoPreis);
	this.priceDisplayStandardPaperRoll.writeln(produktName, bruttoPreis);

	}
  
	public String Rechnung(){
		return "";
	}
}