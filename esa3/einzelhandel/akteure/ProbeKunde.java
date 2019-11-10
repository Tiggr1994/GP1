package einzelhandel.akteure;

import einzelhandel.waren.Produkt;
import einzelhandel.waren.Sortiment;

/**
* <p>Die Klasse ProbeKunde kauft Artikel aus dem Sortiment und lässt sich davon eine Rechnung geben.
Anschließend ist der Artikel ausverkauft und muss aus dem Sortiment entfernt werden.</p>
* 
* @author Steven Tellekamp, Justus Hardtke, Maik Hämpke, Sebastian Naczk, Waqas Daud
* @version 1.0 26.10.2019
*
*/

public class ProbeKunde{

	private Produkt[] produkteInWarenkorb = new Produkt[3];
	private Sortiment sortiment;
	private int algoPosition = 0;

	public ProbeKunde(Sortiment sortiment){
		this.sortiment = sortiment;
	}

	public void kaufe(Produkt produkt,Sortiment sortiment){
		System.out.println(">> Kunde kauft Produkt: => " + produkt.getProduktName() + "");
	}

	public void einkaufen(){
		try{
		int anzahl = produktKaufAnzahlWaehlen();
		this.produkteWaehlen(anzahl);
		}catch(IllegalArgumentException ex){
			System.out.println("Sie haben eine ungueltige Eingabe gemacht. Der Vorgang muss wiederholt werden");
			einkaufen();
		}
	}

	public Produkt[] getGewaehlteProdukte(){
		return produkteInWarenkorb;
	}

	private Integer produktKaufAnzahlWaehlen(){
		System.out.println("Geben sie die Anzahl der Produkte die sie kaufen moechten an. Die Zahl muss zwischen 1 und 3 liegen");
		String anzahlString = System.console().readLine();
		int anzahl = Integer.parseInt(anzahlString);
		if(anzahl < 1 || anzahl > 3){
			throw new IllegalArgumentException("Die Zahl muss zwischen 1 und 3 liegen");
		}
		return anzahl;
	}

	private void produkteWaehlen(int anzahl){
		
		try{
			if(anzahl > 0){
				this.produkteInWarenkorb[algoPosition] = sortiment.getProdukte()[produktPositionWaehlen()];
				algoPosition++;
			}
			if(anzahl > 1){
				this.produkteInWarenkorb[algoPosition] = sortiment.getProdukte()[produktPositionWaehlen()];
				algoPosition++;
			}
			if(anzahl == 3){
				this.produkteInWarenkorb[algoPosition] = sortiment.getProdukte()[produktPositionWaehlen()];
				algoPosition++;
			}
		}catch(IllegalArgumentException ex){
			System.out.println("Sie haben eine ungueltige Eingabe gemacht. Der Vorgang muss wiederholt werden");
			produkteWaehlen(anzahl);
		}
	}

	private int produktPositionWaehlen(){
		System.out.println("Geben sie die Position des Produktes im Sortiment an. Die zahl muss zwischen 1 und 3 liegen");
		String anzahlString = System.console().readLine();
		int position = Integer.parseInt(anzahlString);
		if(position < 1 || position > 3){
			throw new IllegalArgumentException("Die Zahl muss zwischen 1 und 3 liegen");
		}
		return position -1;
	}
}
