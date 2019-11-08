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
		angestellter.sortimentFuellen();
		ProbeKunde probeKunde = new ProbeKunde(angestellter.getSortiment());
		System.out.println(">> Neuer Probekunde wurde erzeugt");
		probeKunde.einkaufen();
		var length = angestellter.getSortiment().getProdukte().length;
		var stringInt = Integer.toString(length);
		System.out.println("Länge: => "+stringInt);

		printSortiment(angestellter.getSortiment().getProdukte());
		printWarenkorb(probeKunde.getGewaehlteProdukte());


		System.out.println(">> EINKAUFEN!");
		//registrierePosten(produkt.getProduktName(), produkt.getPreisBrutto());
		//System.out.println("\n>>Kunde verlangt Rechnung\n");
		//Rechnung(produkt);
		//angestellter.sortimentLeeren();
		//System.out.println("\nEnde");
	}

	public void printSortiment(Produkt[] produkte){
		System.out.println("Sortiment:");
		System.out.println("-------------------");
		//if(produkte[0] != null){
			System.out.println("Produktname: "+produkte[0].getProduktName()+ "Markenname: "+ produkte[0].getMarkenName());
		//} else if(produkte[1] != null){
			System.out.println("Produktname: "+produkte[1].getProduktName()+ "Markenname: "+ produkte[1].getMarkenName());
		//}else if(produkte[2] != null){
			System.out.println("Produktname: "+produkte[2].getProduktName()+ "Markenname: "+ produkte[2].getMarkenName());
		//}
		System.out.println("-------------------");
	}

	public void printWarenkorb(Produkt[] produkte){
		System.out.println("Warenkorb:");
		System.out.println("-------------------");
		if(produkte[0] != null){
			System.out.println("Produktname: "+produkte[0].getProduktName()+ "Markenname: "+ produkte[0].getMarkenName());
		} else if(produkte[1] != null){
			System.out.println("Produktname: "+produkte[1].getProduktName()+ "Markenname: "+ produkte[1].getMarkenName());
		}else if(produkte[2] != null){
			System.out.println("Produktname: "+produkte[2].getProduktName()+ "Markenname: "+ produkte[2].getMarkenName());
		}
		System.out.println("-------------------");
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