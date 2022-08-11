/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicaa;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Usuario
 */
public class Consulta implements Serializable{
    private Integer idConsulta;
    private Integer preco;
    private Cliente idCliente;
    private Dentista idDentista;
    private Funcionario idFuncionario;
    private Exame exame;
    
    public Consulta() {
    }
        
    public Integer getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Integer getPreco() {
        return preco;
    }

    public void setPreco(Integer preco) {
        this.preco = preco;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }
    
    public Dentista getIdDentista() {
        return idDentista;
    }

    public void setIdDentista(Dentista idDentista) {
        this.idDentista = idDentista;
    }
   

    public Funcionario getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionario idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
    
    public Exame getExame() {
        return exame;
    }

    public void setExame(Exame exame) {
        this.exame = exame;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.idConsulta);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Consulta other = (Consulta) obj;
        if (!Objects.equals(this.idConsulta, other.idConsulta)) {
            return false;
        }
        return true;
    }   
        
    @Override
    public String toString() {
        return ""+idConsulta;
    } 

    
}