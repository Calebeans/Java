/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio2;

/**
 *
 * @author Calebe
 */
public class Porta {
     private String aberta, cor, dimensaoX, dimensaoY, dimensaoZ;

public String getAberta() {
          return aberta;
     }

     public void setAberta(String aberta) {
          this.aberta = aberta;
     }

     public String getCor() {
          return cor;
     }

     public void setCor(String cor) {
          this.cor = cor;
     }

     public String getDimensaoX() {
          return dimensaoX;
     }

     public void setDimensaoX(String dimensaoX) {
          this.dimensaoX = dimensaoX;
     }

     public String getDimensaoY() {
          return dimensaoY;
     }

     public void setDimensaoY(String dimensaoY) {
          this.dimensaoY = dimensaoY;
     }

     public String getDimensaoZ() {
          return dimensaoZ;
     }

     public void setDimensaoZ(String dimensaoZ) {
          this.dimensaoZ = dimensaoZ;
     }
     
     public void abre(String aberta){
          aberta = "Esta aberta";
          this.setAberta(aberta);
     }
     public void fecha(String fechada){
          fechada= "Esta fechada";
          this.setAberta(fechada);
     }
     public void pinta(String s){
          s = "Vermelha";
          this.setCor(s);;
     }
     public boolean estaAberta(){
          return true;
     }
     
}
