package einzelhandel.handelsapp;
import einzelhandel.akteure.*;
import einzelhandel.waren.*;

public class Kasse{

	PriceDisplay priceDisplayMonitor = new PriceDisplayMonitor();
	
	public void registriereWare(Produkt produkt,int anzahl){
		this.priceDisplayMonitor.writeln(produkt.getProduktName(), calculatePrice(produkt, anzahl));
	}

	private boolean isListedSortiment(Produkt produkt){
		SortimentEintrag eintrag = new SortimentEintrag(produkt.getMarkenName(), produkt.getMarkenName(), "Kaufhaus", produkt.getPreisNetto());
		SortimentEintrag[] sortiment = Sortiment.getInstance().getSortimentEintraege();
		for(int i = 0; i < sortiment.length; i++){
			if(sortiment[i] != null && sortiment[i].equals(eintrag)){
				return true;
			}
		}
		return false;
	}

	private double calculatePrice(Produkt produkt, int anzahl){
		double price = produkt.getPreisNetto() * anzahl;
		if(!isListedSortiment(produkt)){
			price = price /2;
		}
		price =  price * 1.19;
		return round(price,2);
	}
	private double round(double value, int places){
		double scale = Math.pow(10, places);
		return Math.round(value * scale) / scale;
	}
}