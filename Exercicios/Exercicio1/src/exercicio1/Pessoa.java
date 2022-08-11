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
public class Pessoa {
    private String nome;
    private Pessoa pai;
    private Pessoa mae;
    private int idade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade(){
        return idade;
    }
    
    public void setIdade(int idade){
        this.idade = idade;
    }
    
    public Pessoa getPai() {
        return pai;
    }

    public void setPai(Pessoa pai) {
        this.pai = pai;
    }

    public Pessoa getMae() {
        return mae;
    }

    public void setMae(Pessoa mae) {
        this.mae = mae;
    }
    
    public void imprimeDados(){
        if((this.getPai()) != (null)){
             System.out.println("Pai "+this.getPai().getNome() +" idade: "+ this.getPai().getIdade());
          }else if((this.getPai())== (null)){
               System.out.println("Não tem Pai");
               
        }if((this.getPai()) != (null)){
             System.out.println("Mãe "+this.getMae().getNome() +" idade: "+ this.getMae().getIdade());
          }else if((this.getMae())== (null)){
             System.out.println("Não tem Mae");
             
        }if((this.getPai().getPai()) != (null) & (this.getPai()) != (null)){
             System.out.println("Avô Paterno "+this.getPai().getPai().getNome() +" idade: "+ this.getPai().getPai().getIdade());
          }else if((this.getPai())== (null)|| (this.getPai().getPai())== (null)){
               System.out.println("Não tem Avô Paterno");  
               
        }if((this.getPai().getMae()) != (null) & (this.getPai()) != (null)){
             System.out.println("Avó Paterno "+this.getPai().getMae().getNome() +" idade: "+ this.getPai().getMae().getIdade());
          }else if((this.getPai())== (null) || (this.getPai().getMae())== (null)){
               System.out.println("Não tem Avó Paterno"); 
               
        }if((this.getMae().getPai()) != (null) & (this.getMae()) != (null)){
             System.out.println("Avô Materno "+this.getMae().getPai().getNome() +" idade: "+ this.getMae().getPai().getIdade());
          }else if((this.getMae())== (null) || (this.getMae().getPai())== (null)){
               System.out.println("Não tem Avô Materno");
               
        }if((this.getMae().getMae()) != (null)){
             System.out.println("Avó Materno "+this.getMae().getMae().getNome() +" idade: "+ this.getMae().getMae().getIdade());
        }else if((this.getMae())== (null) || (this.getMae().getMae())== (null)){
               System.out.println("Não tem Avó Materno"); 
        }
    }
}
