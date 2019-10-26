import ostfalia.vfh.gdprog1_al.*;

public class PriceDisplayTest{

  public static void main(String [] args){

    System.out.println();

    PriceDisplay preisdisplay = new PriceDisplayMonitor();

    preisdisplay.writeln("Bad Movie"   ,     1200); 
    preisdisplay.writeln("Good Movie"  ,     1800); 
    preisdisplay.writeln("Nothing"     ,        0);
    preisdisplay.writeln("Too much ???", 65432100);

    System.out.println();

    preisdisplay = new PriceDisplayStandardPaperRoll();

    preisdisplay.writeln("Bad Movie"   ,     1200); 
    preisdisplay.writeln("Good Movie"  ,     1800); 
    preisdisplay.writeln("Nothing"     ,        0);
    preisdisplay.writeln("Too much???" , 65432100);

    System.out.println();
  }
}