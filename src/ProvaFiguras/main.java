package ProvaFiguras;

import Figuras.*;

import java.awt.*;
import java.awt.Rectangle;

/**
 * Created by blackwidow on 30/09/16.
 */
public class main {
    public static void main(String[] args) {
        //Circulo
        FiguraGeometrica circulo = new Cercle(1,"circulo", Color.white,3.0);
        FiguraGeometrica circulo2 = new Cercle(1,"circulo",Color.white,4.0);
        circulo.visualitzar();
        circulo2.visualitzar();
        System.out.println(circulo.equals(circulo2));

        //Rectangulo
        FiguraGeometrica rectangle = new Figuras.Rectangle(4,"Rectangulo",Color.BLACK,5.0,10.0);
        FiguraGeometrica rectangle2 = new Figuras.Rectangle(5,"Rectangulo",Color.BLACK,5.0,17.0);
        rectangle.visualitzar();
        rectangle2.visualitzar();
        System.out.println(rectangle.equals(rectangle2));

        //Triangulo
        FiguraGeometrica triangulo = new Triangle(7,"Triangulo",Color.BLACK,5.0,10.0);
        FiguraGeometrica triangulo2 = new Triangle(7,"Triangulo",Color.RED,5.8,10.0);
        triangulo.visualitzar();
        triangulo2.visualitzar();
        System.out.println(triangulo.equals(triangulo2));

    }
}
