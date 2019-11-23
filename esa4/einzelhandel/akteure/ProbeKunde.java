package einzelhandel.akteure;

import einzelhandel.waren.Lager;
import einzelhandel.waren.LagerPosten;
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
	private LagerPosten[] warenKorb = new LagerPosten[4];

	public LagerPosten[] getWarenKorb(){
		return this.warenKorb;
	}

	public void einkaufRandom(){
		int rng;
		for(int i = 0; i < Lager.getInstance().getLagerPosten().length; i++){
			if(Lager.getInstance().getLagerPosten()[i] != null){
				rng = 1 + (int)(Math.random() * ((2 - 1) + 1));
				try{
					LagerPosten boughtProdukt = Lager.getInstance().getLagerPosten()[i];
					Lager.getInstance().takeProdukt(boughtProdukt.getProdukt(), rng);
					warenKorb[i] = boughtProdukt;
					System.out.println(">> Produkt:"+ boughtProdukt.getProdukt().getProduktName() + " wurde " +rng+"x gekauft.");
				}catch(IllegalArgumentException ex){
					System.out.println(">> Im Lager ist die Anzahl:"+rng+" von Produkt:"+ Lager.getInstance().getLagerPosten()[i].getProdukt().getProduktName() +" nicht mehr vorhanden.");
				}
			}
		}
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
}
