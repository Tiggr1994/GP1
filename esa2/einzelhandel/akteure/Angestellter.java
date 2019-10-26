package einzelhandel.akteure;

import einzelhandel.waren.*;

/**
* <p>Die Klasse Angestellter verwaltet den virtuellen Shop und kann das Sortiment füllen oder leeren.</p>
* 
* @author Steven Tellekamp, Justus Hardtke
* @version 1.1 24.10.2019
*
*/

public class Angestellter{

	Sortiment sortiment1 = new Sortiment();

	public Produkt sortimentFuellen(String markenName, String produktName){
		
		Produkt produkt1 = new Produkt(markenName, produktName);
		produkt1.setpreisBrutto(10.0, 1.07);
		System.out.println(">> Angestellter hat neues Produkt erstellt");
		
		sortiment1.add(produkt1.getproduktName(), "Von Irgendwo");
		
		return produkt1;
	}	
	
	public void sortimentLeeren(){
		
		sortiment1.removeAll();
		System.out.println("Sortiment wurde geleert");
		
	}	
	
	
}