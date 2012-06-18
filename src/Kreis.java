import java.awt.*;
import java.awt.geom.*;

//Die Klasse KREIS
public class Kreis{

    //Attribute
    private int radius;
    private int xPosition;
    private int yPosition;
    private String fuellfarbe;
    private boolean istSichtbar;
    
   
    //Konstruktor
    public Kreis(){
        radius = 60;
        xPosition = 40;
        yPosition = 60;
        fuellfarbe = "black";
        istSichtbar = false;
    }

   
    //Weitere Methoden
    public void sichtbarMachen(){
        istSichtbar = true;
        zeichnen();
    }
    
 
    public void unsichtbarMachen(){
        loeschen();
        istSichtbar = false;
    }
    
    public void groesseSetzen(int neuerRadius){
        //loeschen();
        radius = neuerRadius;
        //zeichnen();
    }

    public int groesseGeben(){
        return radius;
    }

    //Ändert die Farbe. Erlaubt sind "red", "yellow", "blue", "green", "magenta" und "black".
    public void fuellfarbeSetzen(String neueFarbe){
        fuellfarbe = neueFarbe;
        zeichnen();
    }

    public void xPositionSetzen(int x){
        xPosition = x;
        //zeichnen();
    }

    public void yPositionSetzen(int y){
        yPosition = y;
        //zeichnen();
    }

    public int xPositionGeben(){
        return xPosition;
    }

    public int yPositionGeben(){
        return yPosition;
    }

    public String fuellfarbeGeben(){
        return fuellfarbe;
    }

    public boolean sichtbarkeitGeben(){
        return istSichtbar;
    }


    //Zeichnet den Kreis auf die Leinwand (Canvas)
    public void zeichnen(){
        if(istSichtbar) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, fuellfarbe, new Ellipse2D.Double(xPosition, yPosition, 
                                                          radius*2, radius*2));
            //canvas.wait(10);
        }
    }

    //Entfernt den Kreis von der Leinwand (Canvas)
    private void loeschen(){
        if(istSichtbar) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
} //Ende der Klasse KREIS
