package einzelhandel.waren;

/**
* <p>Die Klasse Sortiment verwaltet das Sortiment mit zwei Methoden.
 Mit einer Methode können neue Artikel aufgenommen werden mit der anderen wieder gelöscht werden.</p>
* 
* @author Steven Tellekamp, Justus Hardtke, Maik Hämpke, Sebastian Naczk, Waqas Daud, Katharina Müller
* @version 1.0 08.11.2019
*
*/

public class Lager{

	private LagerPosten[] lagerPosten = new LagerPosten[4];

	public LagerPosten[] getLagerPosten(){
		return this.lagerPosten;
	}

	public void addProdukt(Produkt produkt, int anzahl){
		boolean produktPlaced = false;
		//prüfen ob produkt bereits vorhanden ist => wenn ja dann nur anzahl addieren 
		for(int i = 0; i < lagerPosten.length; i++){
			if(lagerPosten[i] != null && lagerPosten[i].getProdukt().equals(produkt)){
				lagerPosten[i].addProdukte(anzahl);
				produktPlaced = true;
				break;
			}
		}
		//Produkt zum Lager hinzufügen
		if(produktPlaced == false){
			for(int i = 0; i < lagerPosten.length; i++){
				if(lagerPosten[i] == null){
					LagerPosten posten = new LagerPosten(produkt,anzahl);
					lagerPosten[i] = posten;
					produktPlaced = true;
					break;
				}
			}
		}
		if(produktPlaced == false){
			throw new IllegalArgumentException("Kein Lagerplatz Frei");
		}
	}

	public void takeProdukt(Produkt produkt, int anzahl){
		for(int i = 0; i < lagerPosten.length; i++){
			if(lagerPosten[i] != null && lagerPosten[i].getProdukt().equals(produkt)){
				if(lagerPosten[i].getAnzahl() >= anzahl){
					lagerPosten[i].takeProdukte(anzahl);
				}
				else{
					throw new Exception("Nicht genug Produkte vorhanden");
				}
			}
		}
		cleanLager();
	}
	
	private void cleanLager(){
		for(int i = 0; i < lagerPosten.length; i++){
			if(lagerPosten[i] != null && lagerPosten[i].getAnzahl() == 0){
				lagerPosten[i] = null;
			}
		}
	}
}