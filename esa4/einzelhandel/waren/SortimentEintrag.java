package einzelhandel.waren;

/**
* <p>Die Klasse SortimentEintrag.
 Mit einer Methode können neue Artikel aufgenommen werden mit der anderen wieder gelöscht werden.</p>
* 
* @author Steven Tellekamp, Justus Hardtke, Maik Hämpke, Sebastian Naczk, Waqas Daud, Katharina Müller
* @version 1.0 08.11.2019
*
*/

public class SortimentEintrag{
	private String markenName;
	private String produktName;
	private String bezugsQuelle;
	private double preisNetto;

	public SortimentEintrag(String markenName, String produktName, String bezugsQuelle, Double preisNetto){
		this.markenName = markenName;
		this.produktName = produktName;
		this.bezugsQuelle = bezugsQuelle;
		this.preisNetto = preisNetto;
	}

	public String getMarkenName(){
		return markenName;
	}	
	
	public String getProduktName(){
		return produktName;
	}

	public String getBezugsQuelle(){
		return bezugsQuelle;
	}	
	
	public double getPreisNetto(){
		return preisNetto;
	}

	@Override
	public boolean equals(Object o){
		if(o == this){
			return true;
		}
		
		if (!(o instanceof SortimentEintrag)) { 
            return false; 
		} 

		SortimentEintrag sortimentEintrag = (SortimentEintrag) o;
		return preisNetto == sortimentEintrag.getPreisNetto()
			&& markenName.equals(sortimentEintrag.getMarkenName())
			&& produktName.equals(sortimentEintrag.getProduktName())
			&& bezugsQuelle.equals(sortimentEintrag.getBezugsQuelle());
	}
}