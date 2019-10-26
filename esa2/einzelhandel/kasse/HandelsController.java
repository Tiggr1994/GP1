package einzelhandel.kasse;

import einzelhandel.akteure.*;
import einzelhandel.waren.*;

/**
* <p>Die Klasse HandelsController steuert die Aktionen 
* der Kasse. </p>
* <p>Dies schließt Eingaben und Ausgaben ein.
* Diese werden von den Objekten der Klasse aber nicht selbst 
* ausgeführt, sondern nur angestoßen (aufgerufen).</p>
* 
* @author Steven Tellekamp, Justus Hardtke, Maik Hämpke, Sebastian Naczk, Waqas Daud
* @version 1.0 26.10.2019
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
		Produkt produkt = angestellter.sortimentFuellen("Beste Marke", "Bestes Produkt");
		ProbeKunde probeKunde = new ProbeKunde();
		System.out.println(">> Neuer Probekunde wurde erzeugt");
		probeKunde.kaufe(produkt);

		registrierePosten(produkt.getProduktName(), produkt.getPreisBrutto());
		System.out.println("\n>>Kunde verlangt Rechnung\n");
		Rechnung(produkt);
		angestellter.sortimentLeeren();
		System.out.println("\nEnde");
	}
  
	public void registrierePosten(String produktName, double bruttoPreis){
		System.out.println("\nRegistrierte Posten:");
		System.out.println("-------------------");
		this.priceDisplayMonitor.writeln(produktName, (long)bruttoPreis);
		this.priceDisplayStandardPaperRoll.writeln(produktName, (long)bruttoPreis);
		System.out.println("-------------------");
	}

	public void Rechnung(Produkt produkt){
		System.out.println("Rechnung:");
		System.out.println("-------------------");
		this.priceDisplayMonitor.writeln(produkt.getProduktName(), (long)produkt.getPreisBrutto());
		this.priceDisplayStandardPaperRoll.writeln(produkt.getProduktName(), (long)produkt.getPreisBrutto());
		System.out.println("-------------------");
	}  
}