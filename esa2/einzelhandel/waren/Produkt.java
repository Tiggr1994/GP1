package einzelhandel.waren;

/**
* <p>Die Klasse Produkt besitzt einige Klasseneigenschaften, sowie Methoden zum lesen und setzen dieser Eigenschaften.
</p>
* 
* @author Steven Tellekamp, Justus Hardtke
* @version 1.1 24.10.2019
*
*/

public class Produkt{

	private double preisBrutto;
	private double preisNetto;
	private String markenName;
	private String produktname;
	
	public Produkt(String markenName, String produktName){
		this.markenName = markenName;
		this.produktname = produktName;		
	}
	
	public String getmarkenName(){
		return markenName;
	}	
	
	public String getproduktName(){
		return produktname;
	}
	
	public double getpreisBrutto(){
		return preisBrutto;
	}
	
	public double getpreisNetto(){
		return preisNetto;
	}
	
	public void setpreisBrutto(double preis, double steuersatz){
		this.preisBrutto = preis * steuersatz;
	}

	public void setpreisNetto(double preis, double steuersatz){
		preisNetto = preis * steuersatz;
	}
	
	public String toString(String marke, String produkt, double brutto, double satz){
		
		return "Markenname: " + marke + " Produktname: " + produkt + " Bruttopreis: " + brutto + " Umsatzsteuersatz: " + satz;
	}
	
}