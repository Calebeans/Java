/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio4;

import java.util.Scanner;

/**
 *
 * @author Calebe
 */
public class Distancia {
      public static void main(String[] args) {
          
     Scanner teclado = new Scanner(System.in);
     double x1, y1, x2, y2, z1, z2, distancia;

     System.out.println("Entre com as coordenadas x e y dos pontos nesta ordem:");
     x1 = teclado.nextFloat();
     y1 = teclado.nextFloat();
     z1 = teclado.nextFloat();
     x2 = teclado.nextFloat();
     y2 = teclado.nextFloat();
     z2 = teclado.nextFloat();

     distancia = Math.pow(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2) + Math.pow(z2-z1, 2), 1.0/2);
     System.out.println("A distância é: " + distancia);
     }
}
