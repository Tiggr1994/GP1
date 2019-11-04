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

	public void sortimentFuellen(){
		Produkt[] sortiment = new Produkt[3];
		//Produkte konfigurieren
		sortiment[0] = produktErzeugen(1);
		sortiment[1] = produktErzeugen(2);
		sortiment[2] = produktErzeugen(3);

		//Preise setzen
		sortiment[0] = PreiseSetzen(sortiment[0]);
		sortiment[1] = PreiseSetzen(sortiment[1]);
		sortiment[2] = PreiseSetzen(sortiment[2]);
	}	

	public Sortiment getSortiment(){
		return this.sortiment;
	}

	public void sortimentLeeren(){
		sortiment.removeAll();
		System.out.println(">> Sortiment wurde geleert");
	}	

	private Produkt produktErzeugen(int produktNummer){
		System.out.println("Produktname von Produkt Nr."+produktNummer);
		String produktName = System.console().readLine();
		System.out.println("Markenname von Produkt Nr."+produktNummer );
		String produktMarke = System.console().readLine();
		return new Produkt(produktName,produktMarke);
	}

	private Produkt PreiseSetzen(Produkt produkt){
		Character firstLetter = produkt.getMarkenName().toLowerCase().charAt(0);
		if(firstLetter >='a' && firstLetter <= 'k'){
			System.out.println("Bitte geben sie den Nettopreis des Produktes: \"" +produkt.getProduktName() +"\" ein.");
			String netto = System.console().readLine();
			try{
				Double preis = Double.parseDouble(netto);
				System.out.println(preis);
				produkt.setPreisNetto(preis, 1);
				produkt.setPreisBrutto(preis/2,1);
			}catch(NumberFormatException ex){
				System.out.println("Der Preis darf nur zahlen enthalten");
			}
		}
		else{
			System.out.println("Bitte geben sie den Bruttopreis des Produktes:'"+produkt.getProduktName() + "' ein.");
			String brutto = System.console().readLine();
			try{
				Double preis = Double.parseDouble(brutto);
				produkt.setPreisNetto(preis, 2);
				produkt.setPreisBrutto(preis,1);
			}catch(NumberFormatException ex){
				System.out.println("Der Preis darf nur zahlen enthalten");
			}
		}
		return produkt;
	}
}