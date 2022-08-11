/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pratica1;

/**
 *
 * @author 0048606
 */
public class Animal {
    private String name;
    private double height;
    private int weight;
    private String favoriteFood;
    private double speed;
    protected String sound;
    
    //Name
    public String getName() {
        return name;
    }
    public void setName(String newName) {
        name = newName;
    }
    
    //height
    public double getHeight() {
        return height;
    }
    public void setHeight(double newHeight) {
        if(newHeight>0){
        height = newHeight;
        }else{
            System.out.println("Erro");
        }
    }

    //weight
    public int getWeight() {
        int gram = 1000;
        return weight * gram;
    }
    public void setWeight(int newWeight) {
        if(newWeight>0){
        weight = newWeight;
        }else{
            System.out.println("Erro");
        }
    }
    
    //favoriteFood
    public String getFavoriteFood() {
        return favoriteFood;
    }
    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }
    
    //seed
    public double getSpeed() {
        return speed;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    //sound
    public void setSound(String sound) {
        this.sound = sound;
    }
    public String getSound() {
        return sound;
    }
    
    
    
    public void move(){
        System.out.println("Animal está andando");
    }
    public void eat(){
        System.out.println("Animal está alimentando");
    }
}
