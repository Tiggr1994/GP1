package einzelhandel.handelsapp;

import java.text.SimpleDateFormat;
import java.util.Date;

import einzelhandel.akteure.*;
import einzelhandel.waren.*;
import java.util.Random;

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
		ProbeKunde kunde = new ProbeKunde();
		System.out.println("\n>> Neuer Angestellter wurde erzeugt");
		angestellter.produkteErstellen(4);
		System.out.println("\n>> Sortiment wurde erzeugt und Produkte eingelagert");
		System.out.println(">> Muenze wird geworfen");
		int rng = 1 + (int)(Math.random() * ((2 - 1) + 1));
		if(rng == 1){
			Sortiment.getInstance().deleteSortimentEintragRandom();
			System.out.println(">> Es wurde ein Sortimenteintrag geloescht");
		}else{
			System.out.println(">> Es wurde kein Sortimenteintrag geloescht");
		}
		Sortiment.getInstance().printSortiment();
		System.out.println(">> Kunde kauft ein");
		kunde.einkaufRandom();
		Lager.getInstance().printLager();
		kunde.einkaufen();
		kunde.einkaufenAbschließen();
		System.out.println(">> Kunde verlangt Kassenzettel");
		kunde.rechnungVerlangen();
	}
}