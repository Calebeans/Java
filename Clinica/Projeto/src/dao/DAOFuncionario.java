/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import clinicaa.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class DAOFuncionario {
   public List<Funcionario> getLista() {
    String sql = "select * from funcionarios";
    List<Funcionario>lista = new ArrayList<>();
    try{
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            Funcionario obj = new Funcionario();
            obj.setCodigo(rs.getInt("CODFUNC"));
            obj.setNome(rs.getString("nome"));
            obj.setCpf(rs.getString("cpf"));
            obj.setSalario(rs.getDouble("salario"));
            obj.setIdade(rs.getInt("idade"));
            lista.add(obj);
        }
    }catch (SQLException e){
        JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
    }
    return lista;

}

    public boolean salvar(Funcionario funcionario){
        if(funcionario.getCodigo() == null){
            return incluir(funcionario);
        }else{
            return alterar(funcionario);
        }
    }
    public boolean incluir(Funcionario obj){
        String sql = "insert into funcionarios(nome, cpf, salario, idade) values(?,?,?,?)";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getCpf());
            pst.setDouble(3, obj.getSalario());
            pst.setInt(4, obj.getIdade());
            if(pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Funcionario incluído com sucesso");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Funcionario não incluído");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: "+ e.getMessage());
            return false;
        }
    }
    public boolean alterar(Funcionario obj){
        String sql = 
           "update funcionarios set nome= ?, cpf = ?, salario = ?, idade = ? where CODFUNC = ?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getCpf());
            pst.setDouble(3, obj.getSalario());
            pst.setInt(4, obj.getIdade());
            pst.setInt(5, obj.getCodigo());
            if(pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Funcionario alterado com sucesso");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Funcionario não alterado");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL:2 "+ e.getMessage());
            return false;
        }
    }
    
    
    public boolean remover(Funcionario obj){
        String sql = "delete from funcionarios where CODFUNC = ?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getCodigo());
            if(pst.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Funcionario excluído com sucesso");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Funcionario não excluído");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: "+ e.getMessage());
            return false;
        }    
    }
    public Funcionario localizar(Integer id){
        String sql = "select * from Funcionarios where CODFUNC = ?";
        Funcionario obj = new Funcionario();
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                obj.setCodigo(rs.getInt("CODFUNC"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setSalario(rs.getDouble("salario"));
                obj.setIdade(rs.getInt("idade"));
                return obj;
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }
        return null;
    }
}
