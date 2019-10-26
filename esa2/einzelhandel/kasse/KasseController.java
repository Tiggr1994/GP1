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
public class KasseController{

	ArithmeticUnit alu;
	PriceDisplay priceDisplayMonitor;
	PriceDisplay priceDisplayStandardPaperRoll;


	KasseController(){
	this.alu                           = new ArithmeticUnit();
	this.priceDisplayMonitor           = new PriceDisplayMonitor();
	this.priceDisplayStandardPaperRoll = new PriceDisplayStandardPaperRoll();
	}

	/**
	* <p>Die Main-Methode der Klasse IsNoApplication enthält
	* den Aufruf einer Methode, die das Java-System mitbringt
	* und die die gewünschte Begrüßung ausgibt.</p>
	*
	* <p>Die main-Methode einer Klasse erlaubt der 
	* Java-Laufzeit-Umgebung einen Programmstart auszuführen.
	* Erläuterungen dazu werden im Kursverlauf gegeben.</p>
	*
	* @param args <p>Die Kommandozeilenparameter,falls diese 
				beim Programmstart vom user eingegeben worden sind.</p>
	* @return (nothing) 
	*/

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