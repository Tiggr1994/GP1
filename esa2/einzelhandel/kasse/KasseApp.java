package einzelhandel.kasse;

/**
* <p>Die Klasse IsNoApplication begrüßt Sie im Kurs.</p>
* 
* <p>Die Klasse IsNoApplication heißt so, weil sie
* zwar einen Programmablauf darstellt, aber in einer 
* Art und Weise programmiert ist, die für den Anfang
* (Stichwort: erstes Java Programm) geeignet ist,
* jedoch nicht der Art Entspricht, wie eine "normale"
* Java Applikation programmiert ist. </p>
*
* <p>Die normale Programmierungsart für Java-Applikationen
* erfordert Java-Sprachmittel, die wir erst demnächst
* durcharbeiten.</p>
*
* @author Steven Tellekamp, Justus Hardtke
* @version 1.1 24.10.2019
*
*/
public class KasseApp {

  /**
  * <p>Die Main-Methode der Klasse IsNoApplication enthält
  * den Aufruf einer Methode, die das Java-System mitbringt
  * und die die gewünschte Begrüßung ausgibt.</p>
  *
  * <p>Die main-Methode einer Klasse erlaubt der 
  * Java-Laufzeit-Umgebung einen Programmstart auszuführen.
  * Erläuterungen dazu werden im Kursverlauf gegeben.</p>
  *
  * @param args <p>Die Kommandozeilenparameter,falls diese 
                beim Programmstart vom user eingegeben worden sind.</p>
  * @return (nothing) 
  */
  public static void main(String [] args){
    //new KasseController().run();
	new HandelsController().run();
  }
}