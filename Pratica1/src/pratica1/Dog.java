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
public class Dog extends Animal{
    public void digHole(){
            System.out.println(this.getName() + "HOLE DUG");
    }
    @Override
    public void setSound(String newSound){
        sound = newSound;
    }
}
