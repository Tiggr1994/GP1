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

	private Produkt[] produkte = new Produkt[4];
	
	public void add(Produkt produkt){
		
		for (int i = 0; i < 4; i++){
			if(produkte[i] == null){
				System.out.println("Lagerplatz leer");
				produkte[i] = produkt;
				System.out.println("Neues Produkt hinzugefuegt.");
			}
		}
		
	}
	
	
	public Produkt[] getProdukte(){
		return this.produkte;
	}
}