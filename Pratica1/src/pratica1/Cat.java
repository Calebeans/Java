/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pratica1;

/**
 *
 * @author rcale
 */
public class Cat extends Animal{
    public void scratch(){
        System.out.println("Scratching cat");
    }
    @Override
    public void setSound(String newSound){
        sound = newSound;
    }
}
