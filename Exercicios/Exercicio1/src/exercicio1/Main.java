/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio1;

/**
 *
 * @author Calebe
 */
public class Main {
    public static void main(String[] args){
        Pessoa Calebe = new Pessoa();
        Calebe.setNome("Calebe");
        Calebe.setIdade(17);
        Calebe.setPai(new Pessoa());
        Calebe.setMae(new Pessoa());
        System.out.println("Nome Filho "+ Calebe.getNome() + " Idade "+ Calebe.getIdade());
        Calebe.getPai().setPai(new Pessoa());
        Calebe.getPai().setMae(new Pessoa());
        Calebe.getMae().setPai(new Pessoa());
        Calebe.getMae().setMae(new Pessoa());
        //Pais
        Calebe.getPai().setNome("Divino");
        Calebe.getMae().setNome("Maria");
        Calebe.getPai().setIdade(60);
        Calebe.getMae().setIdade(40);
        //Avós Pai
        Calebe.getPai().getPai().setNome("Geraldo");
        Calebe.getPai().getMae().setNome("Zenith");
        Calebe.getPai().getPai().setIdade(90);
        Calebe.getPai().getMae().setIdade(86);
        //Avós Mãe
        Calebe.getMae().getPai().setNome("João");
        Calebe.getMae().getMae().setNome("Jacira");
        Calebe.getMae().getPai().setIdade(79);
        Calebe.getMae().getMae().setIdade(78);
        Calebe.imprimeDados();
        
    }
}
