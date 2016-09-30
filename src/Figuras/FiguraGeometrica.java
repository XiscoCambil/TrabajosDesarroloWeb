package Figuras;
import java.awt.Color;

public abstract class FiguraGeometrica {
   protected int codi=0;
   protected String nom="";
   protected Color color=Color.white;

   public FiguraGeometrica (int ncodi, String nnom, Color ncolor) {
      if (ncodi>0) codi = ncodi;
      nom = nnom;
      color = ncolor;
   }

   public FiguraGeometrica(FiguraGeometrica f)  {
      this (f.codi, f.nom, f.color);
   }

   public FiguraGeometrica () {}

   public void setCodi(int nouCodi)  {
      if (nouCodi>=0) codi = nouCodi;
   }

   public void setNom (String nouNom)  {
      nom = nouNom;
   }

   public void setColor (Color nouColor) {
      color = nouColor;
   }   

   public int getCodi () {
      return codi;
   }

   public String getNom () {
      return nom;
   }
   
   public Color getColor () {
      return color;
   }

   public void visualitzar () {
      System.out.println(toString());
   }

   public abstract double area();

   @Override
   public boolean equals(Object o){
      return  o.equals(getCodi());
   }

   public String toString(){
    return  "Codi..........:" + codi+"\n"+
            "Nom...........:" + nom+"\n"+
            "Color.........:" + color;
   }
   
   /*public static void main(String args[]) {
      FiguraGeometrica f1 = new FiguraGeometrica();
      FiguraGeometrica f2 = new FiguraGeometrica(1,"FiguraGeometrica 1", Color.orange);
      f1.visualitzar();
      f2.visualitzar();
   }
   */
}