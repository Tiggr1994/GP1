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
			Produkt produkt = produktErzeugen(i+1);
			SortimentEintrag sortimentEintrag = new SortimentEintrag(produkt.getMarkenName(),produkt.getProduktName(),"Kaufhaus" ,produkt.getPreisNetto());
			lager.addProdukt(produkt,1);
			sortiment.addSortimentEintrag(sortimentEintrag);
		}
		lager.printLager();
		sortiment.printSortiment();
	}

	public Sortiment getSortiment(){
		return this.sortiment;
	}

	public Lager getLager(){
		return this.lager;
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