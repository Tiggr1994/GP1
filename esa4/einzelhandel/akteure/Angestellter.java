package einzelhandel.akteure;

import einzelhandel.waren.*;

/**
* <p>Die Klasse Angestellter verwaltet den virtuellen Shop und kann das Sortiment füllen oder leeren.</p>
* 
* @author Steven Tellekamp, Justus Hardtke, Maik Hämpke, Sebastian Naczk, Waqas Daud, Katharina Müller
* @version 1.0 08.11.2019
*
*/

public class Angestellter{

	Sortiment sortiment = new Sortiment();
	Produkt[] lager = new Produkt[4];

	public void sortimentFuellen(){
		Produkt[] sortiment = new Produkt[4];
		//Produkte konfigurieren
		sortiment[0] = produktErzeugen(1);
		sortiment[1] = produktErzeugen(2);
		sortiment[2] = produktErzeugen(3);
		sortiment[3] = produktErzeugen(4);

		//Preise setzen
		sortiment[0] = preiseSetzen(sortiment[0]);
		sortiment[1] = preiseSetzen(sortiment[1]);
		sortiment[2] = preiseSetzen(sortiment[2]);
		sortiment[3] = preiseSetzen(sortiment[3]);
		
		//Produkte dem Sortiment hinzufügen und einlagern
		this.sortiment.add(sortiment);
		
		for (int i = 0; i < 4; i++){
			lager[i] = sortiment[i];
			lager[i].setBestand(1);
			//System.out.println("Neues Produkt dem Lager hinzugefuegt");
		}

		System.out.println("\nMomentan vorhandene Produkte im Lager:");
		for (int i = 0; i < 4; i++){
			System.out.println("Markenname: " + lager[i].getMarkenName() + "\t\tProduktname: " + lager[i].getProduktName() + "\t\tBestand: " + lager[i].getBestand());
		}
		
	}	

	public Sortiment getSortiment(){
		return this.sortiment;
	}
	
	public Produkt[] getLager(){
		return this.lager;
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
		return new Produkt(produktMarke,produktName);
	}

	private Produkt preiseSetzen(Produkt produkt){
		Character firstLetter = produkt.getMarkenName().toLowerCase().charAt(0);
		if(firstLetter >='a' && firstLetter <= 'k'){
			System.out.println("Bitte geben Sie den Nettopreis des Produktes: \"" +produkt.getProduktName() +"\" ein.");
			String netto = System.console().readLine();
			try{
				Double preis = Double.parseDouble(netto);
				produkt.setPreisNetto(preis, 1);
				produkt.setPreisBrutto(preis/2,1);
			}catch(NumberFormatException ex){
				System.out.println("Der Preis darf nur Zahlen enthalten. Der Vorgang muss wiederholt werden");
				preiseSetzen(produkt);
			}
		}
		else{
			System.out.println("Bitte geben Sie den Bruttopreis des Produktes:'"+produkt.getProduktName() + "' ein.");
			String brutto = System.console().readLine();
			try{
				Double preis = Double.parseDouble(brutto);
				produkt.setPreisNetto(preis, 2);
				produkt.setPreisBrutto(preis,1);
			}catch(NumberFormatException ex){
				System.out.println("Der Preis darf nur Zahlen enthalten. Der Vorgang muss wiederholt werden");
				preiseSetzen(produkt);
			}
		}
		return produkt;
	}
}