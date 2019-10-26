package einzelhandel.waren;

/**
* <p>Die Klasse Sortiment verwaltet das Sortiment mit zwei Methoden.
 Mit einer Methode können neue Artikel aufgenommen werden mit der anderen wieder gelöscht werden.</p>
* 
* @author Steven Tellekamp, Justus Hardtke
* @version 1.1 24.10.2019
*
*/

public class Sortiment{

	private String artikel;
	private String bezugsquelle;
	
	
	public void add(String artikel, String bezugsquelle){
		this.artikel = artikel;
		this.bezugsquelle = bezugsquelle;
		
		System.out.println(">> Neues Produkt dem Sortiment hinzugefuegt. Artikel: '" + artikel + "', Bezugsquelle: '" + bezugsquelle + "'");
	}	
	
	public void removeAll(){
		artikel = "";
		bezugsquelle = "";
		
	}
	
	
}