package einzelhandel.waren;

/**
* <p>Die Klasse LagerPosten besitzt einige Eigenschaften, sowie Methoden zum lesen und setzen dieser Eigenschaften.
</p>
* 
* @author Steven Tellekamp, Justus Hardtke, Maik Hämpke, Sebastian Naczk, Waqas Daud, Katharina Müller
* @version 1.0 08.11.2019
*
*/

public class LagerPosten{
	private Produkt produkt;
	private int anzahl;

	public LagerPosten(Produkt produkt, int anzahl){
		this.produkt = produkt;
		this.anzahl = anzahl;
	}

	public void addProdukte(int anzahl){
		this.anzahl += anzahl;
	}

	public void takeProdukte(int anzahl){
		this.anzahl -= anzahl;
	}
}