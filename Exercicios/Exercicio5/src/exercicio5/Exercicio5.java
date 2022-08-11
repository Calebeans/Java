/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio5;

import java.util.Scanner;

/**
 *
 * @author Calebe
 */
public class Exercicio5 {

     /**
      * @param args the command line arguments
      */
     public static void main(String[] args) {
          // TODO code application logic here
          
           Scanner c = new Scanner(System.in);
          Fibonnaci r = new Fibonnaci();
          int n;
          n = c.nextInt();
          int f1 = 1, f = 0, f2;
          
          for(int a = 1; a< n; a++){
               System.out.println(fibonnaci(a));
          }
     
}
     public static int fibonnaci(int i){
          if(i < 2){
               return 1;
          }else{
               return fibonnaci (i-1) + fibonnaci (i-2);
          }
     
     }
     
     
}
