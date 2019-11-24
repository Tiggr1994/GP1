package einzelhandel.handelsapp;
import einzelhandel.akteure.*;
import einzelhandel.waren.*;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.text.SimpleDateFormat;

public class Kasse{

	PriceDisplay priceDisplayMonitor = new PriceDisplayMonitor();
	Map<Produkt,Double> registrierteProdukte = new HashMap<Produkt,Double>();
	
	public void registriereWare(Produkt produkt,int anzahl, String summe){
		if(summe == "Summe"){
			System.out.println("Summe: "+ calculateSumme());
		}else{
			double price = calculatePrice(produkt, anzahl);
			if(!isListedSortiment(produkt)){
				Produkt tempProdukt = new Produkt("Ausverkauf", produkt.getProduktName());
				tempProdukt.setPreisNetto(produkt.getPreisNetto(), 1); 
				registrierteProdukte.put(tempProdukt, price);
			}else{
				registrierteProdukte.put(produkt, price);
			}
			this.priceDisplayMonitor.writeln(produkt.getProduktName(), price);
		}
	}

	public void druckeKassenzettel(){
		System.out.println("-------------------");
		System.out.println("Vielen Dank fuer Ihren Einkauf");
		System.out.println("Datum des Einkaufs: " + SimpleDateFormat.getDateInstance().format(new Date()));
		System.out.println("-------------------");
		// sieht gut aus
		for(Map.Entry<Produkt,Double> entry : sortProducts(registrierteProdukte)){
			System.out.println("Markenname: "+ entry.getKey().getMarkenName()
							+ " Produktname: "+ entry.getKey().getProduktName()
							+ " Preis " + entry.getValue());
		}
		System.out.println("Summe: "+ calculateSumme()+" Durchschnittspreis: "+ calculateAvgPrice());
		System.out.println("-------------------");
		System.out.println("Beehren sie uns bald wieder");
		System.out.println("-------------------");
	}

	private boolean isListedSortiment(Produkt produkt){
		SortimentEintrag eintrag = new SortimentEintrag(produkt.getMarkenName(), produkt.getProduktName(), "Kaufhaus", produkt.getPreisNetto());
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

	private double calculateSumme(){
		double summe = 0.0;
		for(Map.Entry<Produkt,Double> entry : registrierteProdukte.entrySet()){
			summe += entry.getValue();
		}
		return round(summe,2);
	}

	private double calculateAvgPrice(){
		int count = 0;
		double summe = 0.0;
		for(Map.Entry<Produkt,Double> entry : registrierteProdukte.entrySet()){
			summe += entry.getValue();
			count += 1;
		}
		return round((summe / count),2);
	}

	private List<Map.Entry<Produkt,Double>> sortProducts(Map<Produkt,Double> warenkorb){
		List<Map.Entry<Produkt, Double>> list = new ArrayList<>(warenkorb.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Produkt, Double>>() {
			public int compare(Map.Entry<Produkt, Double> one, Map.Entry<Produkt, Double> two) {
				int nameResult = one.getKey().getMarkenName().compareTo(two.getKey().getMarkenName());
				if (nameResult == 0) {
					return one.getValue().compareTo(two.getValue());
				}
				return nameResult;
			}
		});
		return list;
	}
}