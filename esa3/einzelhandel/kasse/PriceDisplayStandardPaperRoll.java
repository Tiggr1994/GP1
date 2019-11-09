package einzelhandel.kasse;

/**
* <p>Klasse zur Ausgabe auf einer Papierrolle.</p>
* 
* @author Steven Tellekamp, Justus Hardtke, Maik Hämpke, Sebastian Naczk, Waqas Daud, Katharina Müller
* @version 1.0 08.11.2019
*
*/



public class PriceDisplayStandardPaperRoll extends PriceDisplay{

  // Der Text wird bei Bedarf ....
  protected String clipText(String text) {
    if(text.length() > 10) return text.substring(0,10);
    
    return text;
  }

  // price ist in cent gegeben
  protected String formatNumberText(long price) {
    long euro = price;
    long cent = Math.abs(price) % 100;

    String eurotext = "" + euro;
    String centtext = "" + cent;

    if (eurotext.length() > 5)       return "xxxxx,xx" + "   ";
    else if (eurotext.length() == 5) ;
    else if (eurotext.length() == 4) eurotext = " " + eurotext;
    else if (eurotext.length() == 3) eurotext = "  " + eurotext;
    else if (eurotext.length() == 2) eurotext = "   " + eurotext;
    else                             eurotext = "    " + eurotext;
 
    if(centtext.length() == 1) centtext = "0"+ centtext;

    return eurotext + "," + centtext + "   ";
  }

  // Erst wird der Preis ausgegeben, dann nach ein paar
  // der erläuternde Text. Beide Argumente werden vorher
  // formatiert (siehe oben);
  public void writeln(String text, long price){ 
    System.out.println(formatNumberText(price) + clipText(text));
  };
}