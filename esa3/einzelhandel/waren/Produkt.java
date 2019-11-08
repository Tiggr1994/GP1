package einzelhandel.waren;

/**
* <p>Die Klasse Produkt besitzt einige Eigenschaften, sowie Methoden zum lesen und setzen dieser Eigenschaften.
</p>
* 
* @author Steven Tellekamp, Justus Hardtke, Maik Hämpke, Sebastian Naczk, Waqas Daud, Katharina Müller
* @version 1.0 08.11.2019
*
*/

public class Produkt{

	private double preisBrutto;
	private double preisNetto;
	private String markenName;
	private String produktName;
	
	public Produkt(String markenName, String produktName){
		this.markenName = markenName;
		this.produktName = produktName;		
	}
	
	public String getMarkenName(){
		return markenName;
	}	
	
	public String getProduktName(){
		return produktName;
	}
	
	public double getPreisBrutto(){
		return preisBrutto;
	}
	
	public double getPreisNetto(){
		return preisNetto;
	}
	
	public void setPreisBrutto(double preis, double steuersatz){
		this.preisBrutto = preis * steuersatz;
	}

	public void setPreisNetto(double preis, double steuersatz){
		this.preisNetto = preis * steuersatz;
	}
	
	public String toString(String marke, String produkt, double brutto, double steuersatz){
		return "Markenname: " + marke + " Produktname: " + produkt + " Bruttopreis: " + brutto + " Umsatzsteuersatz: " + steuersatz;
	}
}