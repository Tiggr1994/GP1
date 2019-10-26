package einzelhandel.kasse;

import einzelhandel.akteure.*;
import einzelhandel.waren.*;

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
public class HandelsController{

	ArithmeticUnit alu;
	PriceDisplay priceDisplayMonitor;
	PriceDisplay priceDisplayStandardPaperRoll;

	HandelsController(){
	this.alu                           = new ArithmeticUnit();
	this.priceDisplayMonitor           = new PriceDisplayMonitor();
	this.priceDisplayStandardPaperRoll = new PriceDisplayStandardPaperRoll();
	}

	public void run(){
	
	Angestellter angestellter = new Angestellter();
	System.out.println("\n\n>> Neuer Angestellter wurde erzeugt");

	
	// Einlesen momentan durch die festen Werte ersetzt
	Produkt p = angestellter.sortimentFuellen("Beste Marke", "Bestes Produkt");
	

	ProbeKunde k = new ProbeKunde();
	System.out.println(">> Neuer Probekunde wurde erzeugt");
	k.kaufe(p);

	registrierePosten(p.getproduktName(), p.getpreisBrutto());
	Rechnung(p);

	angestellter.sortimentLeeren();

	System.out.println("\nEnde");
	}
  
	public void registrierePosten(String produktName, double bruttoPreis){
	
	System.out.println("\nRegistrierte Posten:\n");
	this.priceDisplayMonitor.writeln(produktName, (long)bruttoPreis);
	this.priceDisplayStandardPaperRoll.writeln(produktName, (long)bruttoPreis);

	}
  
	public void Rechnung(Produkt p){
		System.out.println("\n\nRechnung:\n\n" + p.toString(p.getmarkenName(), p.getproduktName(), p.getpreisBrutto(), 7));
	}  

}