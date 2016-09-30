package Figuras;

import java.awt.Color;

public class Cercle extends FiguraGeometrica {
   private double radi=0;


   public Cercle (int ncodi, String nnom, Color ncolor, double nradi) {
      super (ncodi, nnom, ncolor);
      if (nradi>0) radi=nradi;
   }
   
   public Cercle (Cercle c) {
      this (c.codi, c.nom, c.color, c.radi);
   }

   public Cercle () {
   }

   public void setRadi (double nouRadi) {
      if (nouRadi>=0) radi = nouRadi;
   }

   public double getRadi () {
      return radi;
   }
   
   public double perimetre () {
      return 2*Math.PI*radi;
   }

   public double area () {
      return Math.PI * radi * radi;
   }
   
   public void visualitzar () {
      System.out.println ("Sóc un cercle");
      System.out.println ("*************");
      super.visualitzar();
      System.out.println ("Radi..........:" + radi);
      System.out.println ("Longitud......:" + perimetre());
      System.out.println ("Àrea..........:" + area());
   }
   
   public static void main (String args[]) {
      Cercle c1 = new Cercle ();
      Cercle c2 = new Cercle (1, "Cercle 1", Color.green, 42.42);
      c1.visualitzar();
      c2.visualitzar();
   }
}