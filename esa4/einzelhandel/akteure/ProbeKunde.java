package einzelhandel.akteure;

import einzelhandel.waren.Lager;
import einzelhandel.waren.LagerPosten;
import einzelhandel.waren.Produkt;
import einzelhandel.waren.Sortiment;
import einzelhandel.handelsapp.Kasse;

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
	private Kasse kasse = new Kasse();
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
					System.out.println(">> Produkt: "+ boughtProdukt.getProdukt().getProduktName() + " wurde " +rng+"x gekauft.");
				}catch(IllegalArgumentException ex){
					System.out.println(">> Im Lager ist die Anzahl:"+rng+" von Produkt: "+ Lager.getInstance().getLagerPosten()[i].getProdukt().getProduktName() +" nicht mehr vorhanden.");
				}
			}
		}
	}

	public void einkaufen(){
		LagerPosten[] posten = Lager.getInstance().getLagerPosten();
		for(int i = 0; i < posten.length; i++){
			if(posten[i] != null){
				int anzahl = zahlEinlesen(posten[i].getProdukt(), posten[i].getAnzahl());
				if(anzahl != 0){
					kasse.registriereWare(posten[i].getProdukt(),anzahl);
				}
			}
		}
	}
	private int zahlEinlesen(Produkt produkt, int vorrat){
		boolean isNumber = false;
		int anzahl = 0;
		do{
			System.out.println("Geben Sie an wie viel sie von Produkt: "+ produkt.getProduktName()+" kaufen moechten. Die Anzahl muss zwischen 0 und "+vorrat+" liegen.");
			String anzahlString = System.console().readLine();
			if(checkIfIsNumber(anzahlString)){
				anzahl = Integer.parseInt(anzahlString);
				if(anzahl < 0 || anzahl > vorrat){
					System.out.println("Die Eingabe war nicht korrekt wodurch der Vorgang widerholt werden muss. Die Anzahl muss zwischen 0 und "+vorrat+" liegen.");
				}else{
					isNumber = true;
				}
			}else{
				System.out.println("Die Eingabe war nicht korrekt. Der Vorgang muss wiederholt werden");
			}
		}while(!isNumber);
		return anzahl;
	}

	private boolean checkIfIsNumber(String string){
		try{
			Double.parseDouble(string);
			return true;
		}catch(Exception ex){
			return false;
		}
	}
}
