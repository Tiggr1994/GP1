package einzelhandel.kasse;

import java.text.SimpleDateFormat;
import java.util.Date;

import einzelhandel.akteure.*;
import einzelhandel.waren.*;

/**
* <p>Die Klasse HandelsController steuert die Aktionen 
* der Kasse. </p>
* <p>Dies schließt Eingaben und Ausgaben ein.
* Diese werden von den Objekten der Klasse aber nicht selbst 
* ausgeführt, sondern nur angestoßen (aufgerufen).</p>
* 
* @author Steven Tellekamp, Justus Hardtke, Maik Hämpke, Sebastian Naczk, Waqas Daud, Katharina Müller
* @version 1.0 08.11.2019
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

		printSortiment(angestellter.getSortiment().getProdukte());
		printWarenkorb(probeKunde.getGewaehlteProdukte());

		kassenDruck(probeKunde.getGewaehlteProdukte());
		rechnungDrucken(probeKunde.getGewaehlteProdukte());
	}

	public void printSortiment(Produkt[] produkte){
		System.out.println("-------------------");
		System.out.println("Sortiment:");
		System.out.println("-------------------");
		if(produkte[0] != null){
			System.out.println("Produktname: "+produkte[0].getProduktName()+ " Markenname: "+ produkte[0].getMarkenName());
		}
		if(produkte[1] != null){
			System.out.println("Produktname: "+produkte[1].getProduktName()+ " Markenname: "+ produkte[1].getMarkenName());
		}
		if(produkte[2] != null){
			System.out.println("Produktname: "+produkte[2].getProduktName()+ " Markenname: "+ produkte[2].getMarkenName());
		}
		System.out.println("-------------------");
	}

	public void printWarenkorb(Produkt[] produkte){
		System.out.println("-------------------");
		System.out.println("Warenkorb:");
		System.out.println("-------------------");
		if(produkte[0] != null){
			System.out.println("Produktname: "+produkte[0].getProduktName()+ " Markenname: "+ produkte[0].getMarkenName());
		}
		if(produkte[1] != null){
			System.out.println("Produktname: "+produkte[1].getProduktName()+ " Markenname: "+ produkte[1].getMarkenName());
		}
		if(produkte[2] != null){
			System.out.println("Produktname: "+produkte[2].getProduktName()+ " Markenname: "+ produkte[2].getMarkenName());
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

	public void rechnungDrucken(Produkt[] produkte){
		System.out.println("-------------------");
		System.out.println("Vielen Dank für ihren Einkauf");
		System.out.println("Datum des Einkaufs: " + SimpleDateFormat.getDateInstance().format(new Date()));
		System.out.println("-------------------");
		if(produkte[0] != null){
			this.priceDisplayStandardPaperRoll.writeln(produkte[0].getProduktName(), (long)produkte[0].getPreisBrutto());
		}
		if(produkte[1] != null){
			this.priceDisplayStandardPaperRoll.writeln(produkte[1].getProduktName(), (long)produkte[1].getPreisBrutto());
		}
		if(produkte[2] != null){
			this.priceDisplayStandardPaperRoll.writeln(produkte[2].getProduktName(), (long)produkte[2].getPreisBrutto());
		}
		System.out.println("-------------------");
	}  

	public void kassenDruck(Produkt[] produkte){
		System.out.println("-------------------");
		System.out.println("Erkannte Kassen Produkte:");
		System.out.println("-------------------");
		if(produkte[0] != null){
			System.out.println("Produktname: "+produkte[0].getProduktName()+ " Markenname: "+ produkte[0].getMarkenName());
		}
		if(produkte[1] != null){
			System.out.println("Produktname: "+produkte[1].getProduktName()+ " Markenname: "+ produkte[1].getMarkenName());
		}
		if(produkte[2] != null){
			System.out.println("Produktname: "+produkte[2].getProduktName()+ " Markenname: "+ produkte[2].getMarkenName());
		}
		System.out.println("-------------------");
	}
}