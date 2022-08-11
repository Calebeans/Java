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
public class Bird extends Animal{
    public void fly(){
        System.out.println("Eating fly");
    }
    @Override
    public void setSound(String newSound){
        sound = newSound;
    }
}
