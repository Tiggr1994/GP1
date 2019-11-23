package einzelhandel.waren;

/**
* <p>Die Klasse Sortiment verwaltet das Sortiment mit zwei Methoden.
 Mit einer Methode können neue Artikel aufgenommen werden mit der anderen wieder gelöscht werden.</p>
* 
* @author Steven Tellekamp, Justus Hardtke, Maik Hämpke, Sebastian Naczk, Waqas Daud, Katharina Müller
* @version 1.0 08.11.2019
*
*/

public class Sortiment{

	private SortimentEintrag[] sortimentEintraege = new SortimentEintrag[4];

	public void addSortimentEintrag(SortimentEintrag sortimentEintrag){
		boolean sortimentPlaced = false;
		//prüfen ob sortiment bereits vorhanden ist
		for(int i = 0; i < sortimentEintraege.length; i++){
			if(sortimentEintraege[i] != null && sortimentEintraege[i].equals(sortimentEintrag)){
				sortimentPlaced = true;
				break;
			}
		}
		//SortimentEintrag zum Sortiment hinzufügen
		if(sortimentPlaced == false){
			for(int i = 0; i < sortimentEintraege.length; i++){
				if(sortimentEintraege[i] == null){
					sortimentEintraege[i] = sortimentEintrag;
					sortimentPlaced = true;
					break;
				}
			}
		}
		if(sortimentPlaced == false){
			throw new IllegalArgumentException("Kein Sortimentplatz Frei");
		}
	}

	public void deleteSortimentEintragRandom(){
		for(int i = 0; i < sortimentEintraege.length; i++){
			if(sortimentEintraege[i] != null){
				sortimentEintraege[i] = null;
				break;
			}
		}
	}
	public void printSortiment(){
		System.out.println("---------------------------");
		System.out.println("Sortiment:");
		System.out.println("---------------------------");
		for (int i = 0; i < sortimentEintraege.length; i++){
			if(sortimentEintraege[i] != null){
				System.out.println("Markenname: " + sortimentEintraege[i].getMarkenName() 
								+  " ProduktName: " + sortimentEintraege[i].getProduktName() 
								+ " NettoPreis: " + sortimentEintraege[i].getPreisNetto()
								+ " Bezugsquelle: " + sortimentEintraege[i].getBezugsQuelle());
			}
		}
		System.out.println("---------------------------");
	}
}