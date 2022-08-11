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
public class Teste {
     public static void main(String[] args){
          Porta p = new Porta();
          p.setAberta("A porta esta aberta");
          p.setCor("Azul");
          p.setDimensaoX("12");
          p.setDimensaoY("21");
          p.setDimensaoZ("13");
          System.out.println(p.getAberta() +"\n A cor é "+ p.getCor() +"\n Dimensões X, Y e Z"+ p.getDimensaoX()+ " "+ p.getDimensaoY()+ " "+ p.getDimensaoZ());
          p.fecha(p.getAberta());
          p.pinta(p.getCor());
          p.setDimensaoX("22");
          p.setDimensaoY("30");
          p.setDimensaoZ("10");
          System.out.println(p.getAberta() +"\n A cor é "+ p.getCor() +"\n Dimensões X, Y e Z"+ p.getDimensaoX()+ " "+ p.getDimensaoY()+ " "+ p.getDimensaoZ());
     }
}
