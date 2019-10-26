package einzelhandel.akteure;

import einzelhandel.waren.*;

/**
* <p>Die Klasse Angestellter verwaltet den virtuellen Shop und kann das Sortiment füllen oder leeren.</p>
* 
* @author Steven Tellekamp, Justus Hardtke, Maik Hämpke, Sebastian Naczk, Waqas Daud
* @version 1.0 26.10.2019
*
*/

public class Angestellter{

	Sortiment sortiment = new Sortiment();

	public Produkt sortimentFuellen(String markenName, String produktName){
		Produkt produkt = new Produkt(markenName, produktName);
		produkt.setPreisBrutto(10.0, 1.07);
		System.out.println(">> Angestellter hat neues Produkt erstellt");
		sortiment.add(produkt.getProduktName(), produkt.getMarkenName());
		return produkt;
	}	
	
	public void sortimentLeeren(){
		sortiment.removeAll();
		System.out.println(">> Sortiment wurde geleert");
	}	
}