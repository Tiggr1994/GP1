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
	Lager lager = new Lager();

	public void produkteErstellen(int anzahl){
		for (int i = 0; i < anzahl; i++){
			var produkt = produktErzeugen(i+1);
			lager.addProdukt(produkt,1);
		}
		printLager();
	}

	public Sortiment getSortiment(){
		return this.sortiment;
	}

	public void sortimentLeeren(){
		sortiment.removeAll();
		System.out.println(">> Sortiment wurde geleert");
	}	

	private void printLager(){
		System.out.println("---------------------------");
		System.out.println("Lager:");
		System.out.println("---------------------------");
		LagerPosten[] lagerPosten = lager.getLagerPosten();
		for (int i = 0; i < lagerPosten.length; i++){
			if(lagerPosten[i] != null){
				System.out.println("Markenname:" + lagerPosten[i].getProdukt().getMarkenName() 
								+  " ProduktName:" + lagerPosten[i].getProdukt().getProduktName() 
								+ " NettoPreis:" + lagerPosten[i].getProdukt().getPreisNetto());
			}
		}
		System.out.println("---------------------------");
	}

	private Produkt produktErzeugen(int produktNummer){
		System.out.println("Produktname von Produkt Nr."+produktNummer+"eingeben");
		String produktName = System.console().readLine();
		System.out.println("Markenname von Produkt Nr."+produktNummer+"eingeben.");
		String produktMarke = System.console().readLine();
		boolean isNumber = true;
		Double nettoPrice = 0.0;
		do{
			System.out.println("Nettopreis von Produkt Nr."+produktNummer+"eingeben.");
			String netto = System.console().readLine();
			if(checkIfIsNumber(netto)){
				isNumber = false;
				nettoPrice = Double.parseDouble(netto);
			}else{
				System.out.println("Bitte geben sie eine Zahl an, ihre eingabe war nicht korrekt. Der Vorgang wird wiederholt");
			}
		}while(isNumber);
		Produkt produkt = new Produkt(produktMarke,produktName);
		produkt.setPreisNetto(nettoPrice, 1);
		produkt.setPreisBrutto(nettoPrice, 19);
		return produkt;
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