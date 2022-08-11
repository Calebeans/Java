/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio4.pkg1;

import java.util.Scanner;

/**
 *
 * @author Calebe
 */
public class Exercicio41 {

     /**
      * @param args the command line arguments
      */
     public static void main(String[] args) {
          // TODO code application logic here
          Scanner a = new Scanner(System.in);
          int f1 = 1, f = 0, f2, n;
          n = a.nextInt();
          
          for(int i = 1; i<n; i++){
               f2 = f1+f;
               f = f1;
               f1 = f2;
               System.out.println(f2);
          }
     }
     
}
