package einzelhandel.akteure;

import einzelhandel.waren.Produkt;

/**
* <p>Die Klasse ProbeKunde kauft Artikel aus dem Sortiment und lässt sich davon eine Rechnung geben.
Anschließend ist der Artikel ausverkauft und muss aus dem Sortiment entfernt werden.</p>
* 
* @author Steven Tellekamp, Justus Hardtke, Maik Hämpke, Sebastian Naczk, Waqas Daud
* @version 1.0 26.10.2019
*
*/

public class ProbeKunde{

	public void kaufe(Produkt produkt){
		System.out.println(">> Kunde kauft Produkt: => " + produkt.getProduktName() + "");
	}
}