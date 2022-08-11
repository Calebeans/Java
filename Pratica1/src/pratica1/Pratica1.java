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
public class Pratica1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Dog bulldog = new Dog();
        bulldog.setName("Marley");
        bulldog.setHeight(5);
        bulldog.setWeight(8);
        bulldog.setSpeed(20);
        bulldog.setFavoriteFood("Osso");
        bulldog.setSound("AU AU AU");
        System.out.println(bulldog.getName() + " says: " + bulldog.getSound());
        bulldog.digHole();
        System.out.println(bulldog.getHeight());
        System.out.println(bulldog.getWeight());
        System.out.println(bulldog.getSpeed());
        System.out.println(bulldog.getFavoriteFood());
        
        System.out.println(" ");
        
        Cat persian = new Cat();
        persian.setName("Kitty");
        persian.setHeight(3);
        persian.setWeight(6);
        persian.setSpeed(20);
        persian.setFavoriteFood("Ração");
        persian.setSound("Miau");
        System.out.println(persian.getName() + " says: " + persian.getSound());
        persian.scratch();
        System.out.println(persian.getHeight());
        System.out.println(persian.getWeight());
        System.out.println(persian.getSpeed());
        System.out.println(persian.getFavoriteFood());
        
        System.out.println(" ");
        
        Bird canary = new Bird();
        canary.setName("Brasil");
        canary.setHeight(4);
        canary.setWeight(7);
        canary.setSpeed(25);
        canary.setFavoriteFood("Ração");
        canary.setSound("Miau");
        System.out.println(canary.getName() + " says: " + canary.getSound());
        canary.fly();
        System.out.println(canary.getHeight());
        System.out.println(canary.getWeight());
        System.out.println(canary.getSpeed());
        System.out.println(canary.getFavoriteFood());
        
        System.out.println(" ");
        
        Giraffe giraffe = new Giraffe();
        giraffe.setName("Frank");
        System.out.println(giraffe.getName());
    }
    
}
