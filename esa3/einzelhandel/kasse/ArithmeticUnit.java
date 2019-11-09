package einzelhandel.kasse;

/**
* <p>Die Klasse ArithmeticUnit ist der mathematische Prozessor
* unserer Kasse.</p>
* 
* @author Steven Tellekamp, Justus Hardtke, Maik Hämpke, Sebastian Naczk, Waqas Daud, Katharina Müller
* @version 1.0 08.11.2019
*
*/
public class ArithmeticUnit {


    // addiere summand1 summand2
    long add(long summand1, long summand2){return summand1 + summand2;}

    // teile ganzzahlig
    long div(long dividend, long divisor){return dividend / divisor;}

    // bestimme den Rest
    long modulo(long dividend, long divisor){return dividend % divisor;}

    // multipliziere
    long multiply(long factor1, long factor2){return factor1 * factor2;}

    // subtrahiere Minuend Subtrahend
    long subtract(long minuend, long subtrahend){return minuend - subtrahend;}



    // Rechnet den einen Nettopreis in den zugehörigen Bruttopreis bei 7% USt. um.
    long netto2Brutto7(long nettopreis){return nettopreis *(1+7/100);}

    // Rechnet den einen Bruttopreis in den zugehörigen Nettopreis bei 7% USt. um.
    long brutto2Netto7(long bruttopreis){return bruttopreis/(1+7/100);}

    // Rechnet den einen Nettopreis in den zugehörigen Bruttopreis bei 19% USt. um.
    long netto2Brutto19(long nettopreis){return nettopreis *(1+19/100);}

    // Rechnet den einen Bruttopreis in den zugehörigen Nettopreis bei 7% USt. um.
    long brutto2Netto19(long bruttopreis){return bruttopreis/(1+19/100);}
}