package einzelhandel.handelsapp;

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
	private boolean headerPrinted = false;

	HandelsController(){
		this.alu                           = new ArithmeticUnit();
		this.priceDisplayMonitor           = new PriceDisplayMonitor();
		this.priceDisplayStandardPaperRoll = new PriceDisplayStandardPaperRoll();
	}

	public void run(){
		Angestellter angestellter = new Angestellter();
		System.out.println("\n>> Neuer Angestellter wurde erzeugt");
		angestellter.sortimentFuellen();
		System.out.println("\n>> Sortiment wurde erzeugt");
		ProbeKunde probeKunde = new ProbeKunde(angestellter.getSortiment());
		System.out.println(">> Neuer Probekunde wurde erzeugt");
		probeKunde.einkaufen();
		System.out.println(">> Probekunde hat eingekauft");

		printSortiment(angestellter.getSortiment().getProdukte());
		printWarenkorb(probeKunde.getGewaehlteProdukte());

		System.out.println(">> Probekunde geht an die Kasse");
		Produkt[] produkte = probeKunde.getGewaehlteProdukte();
		kassenDruck(produkte);
		if(produkte[0] != null){
			rechnungDruckenNeu(produkte[0], "", 0, 0, 0, 0);
		}
		if(produkte[1] != null){
			rechnungDruckenNeu(produkte[1], "", 0, 0, 0, 0);
		}
		if(produkte[2] != null){
			rechnungDruckenNeu(produkte[2], "", 0, 0, 0, 0);
		}
		rechnungDruckenNeu(null,"Summe", getSumme(produkte), getHighestPrice(produkte), getLowestPrice(produkte), getAveragePrice(produkte));
		//rechnungDrucken(probeKunde.getGewaehlteProdukte());
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

	public void rechnungDrucken(Produkt[] produkt){
		System.out.println("-------------------");
		System.out.println("Vielen Dank fuer ihren Einkauf");
		System.out.println("Datum des Einkaufs: " + SimpleDateFormat.getDateInstance().format(new Date()));
		System.out.println("-------------------");
		if(produkt[0] != null){
			this.priceDisplayStandardPaperRoll.writeln(produkt[0].getProduktName(), (long)produkt[0].getPreisBrutto());
		}
		if(produkt[1] != null){
			this.priceDisplayStandardPaperRoll.writeln(produkt[1].getProduktName(), (long)produkt[1].getPreisBrutto());
		}
		if(produkt[2] != null){
			this.priceDisplayStandardPaperRoll.writeln(produkt[2].getProduktName(), (long)produkt[2].getPreisBrutto());
		}
		System.out.println("-------------------");
	}  

	public void kassenDruck(Produkt[] produkt){
		System.out.println("-------------------");
		System.out.println("Erkannte Kassen Produkte:");
		System.out.println("-------------------");
		if(produkt[0] != null){
			System.out.println("Produktname: "+produkt[0].getProduktName()+ " Markenname: "+ produkt[0].getMarkenName());
		}
		if(produkt[1] != null){
			System.out.println("Produktname: "+produkt[1].getProduktName()+ " Markenname: "+ produkt[1].getMarkenName());
		}
		if(produkt[2] != null){
			System.out.println("Produktname: "+produkt[2].getProduktName()+ " Markenname: "+ produkt[2].getMarkenName());
		}
		System.out.println("-------------------");
	}

	public void rechnungDruckenNeu(Produkt produkt, String signalString, double summe, double highestPrice, double lowestPrice, double average){
		if(!headerPrinted){
			System.out.println(">>Rechnung wird erstellt");
			System.out.println("-------------------");
			System.out.println("Vielen Dank fuer ihren Einkauf");
			System.out.println("Datum des Einkaufs: " + SimpleDateFormat.getDateInstance().format(new Date()));
			this.headerPrinted = true;
		}
		if(produkt != null){
			this.priceDisplayStandardPaperRoll.writeln(produkt.getProduktName(),(long)produkt.getPreisNetto());
		}

		if(signalString == "Summe"){
			System.out.println("Summe: "+ summe);
			System.out.println("\n");
			System.out.println("Billigster Preis: "+ lowestPrice);
			System.out.println("Teuerster Preis: "+ highestPrice);
			System.out.println("Durchschnittspreis: "+ average);
			System.out.println("\n");
			System.out.println("-------------------");
			System.out.println("Beehren sie uns bald wieder");
			System.out.println("-------------------");
		}
	}

	public double getHighestPrice(Produkt[] produkt){
		double highestPrice = Double.MIN_VALUE;
		if(produkt[0] != null && highestPrice < produkt[0].getPreisNetto()){
			highestPrice = produkt[0].getPreisNetto();
		}
		if(produkt[1] != null && highestPrice < produkt[1].getPreisNetto()){
			highestPrice = produkt[1].getPreisNetto();
		}
		if(produkt[2] != null && highestPrice < produkt[2].getPreisNetto()){
			highestPrice = produkt[2].getPreisNetto();
		}
		return highestPrice;
	}

	public double getLowestPrice(Produkt[] produkt){
		double lowestPrice = Double.MAX_VALUE;
		if(produkt[0] != null && lowestPrice > produkt[0].getPreisNetto()){
			lowestPrice = produkt[0].getPreisNetto();
		}
		if(produkt[1] != null && lowestPrice > produkt[1].getPreisNetto()){
			lowestPrice = produkt[1].getPreisNetto();
		}
		if(produkt[2] != null && lowestPrice > produkt[2].getPreisNetto()){
			lowestPrice = produkt[2].getPreisNetto();
		}
		return lowestPrice;
	}
	
	public double getAveragePrice(Produkt[] produkte){
		int anzahl = 0;
		if(produkte[0] != null){
			anzahl++;
		}
		if(produkte[1] != null){
			anzahl++;
		}
		if(produkte[2] != null){
			anzahl++;
		}
		return getSumme(produkte) / anzahl;
	}
	public double getSumme(Produkt[] produkte){
		double summe = 0;
		if(produkte[0] != null){
			summe+= produkte[0].getPreisNetto();
		}
		if(produkte[1] != null){
			summe+= produkte[1].getPreisNetto();
		}
		if(produkte[2] != null){
			summe+= produkte[2].getPreisNetto();
		}
		return summe;
	}
}