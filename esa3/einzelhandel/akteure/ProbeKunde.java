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

	public ProbeKunde(Sortiment sortiment){
		this.sortiment = sortiment;
	}

	public void kaufe(Produkt produkt,Sortiment sortiment){
		System.out.println(">> Kunde kauft Produkt: => " + produkt.getProduktName() + "");
	}

	public void einkaufen(){
		Integer anzahl = produktKaufAnzahlWaehlen();
		produkteWaehlen(anzahl);
	}

	public Produkt[] getGewaehlteProdukte(){
		return produkteInWarenkorb;
	}

	private Integer produktKaufAnzahlWaehlen(){
		System.out.println("Geben sie die Anzahl der Produkte die sie kaufen möchten an. Die Zahl muss zwischen 1 und 3 liegen");
		String anzahlString = System.console().readLine();
		Integer anzahl = Integer.parseInt(anzahlString);
		return anzahl;
	}

	private void produkteWaehlen(int anzahl){
		if(anzahl >= 1){
			this.produkteInWarenkorb[0] = sortiment.getProdukte()[0];
		}else if(anzahl >= 2){
			this.produkteInWarenkorb[1] = sortiment.getProdukte()[1];
		}else if(anzahl == 3){
			this.produkteInWarenkorb[2] = sortiment.getProdukte()[2];
		}
	}
}