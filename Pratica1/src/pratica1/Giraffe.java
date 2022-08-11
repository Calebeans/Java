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
public class Giraffe extends Creature{
    
    @Override
    public void setName(String newName){
        name = newName;
    }
    
    @Override
    public String getName(){
        return name;
    }
}
