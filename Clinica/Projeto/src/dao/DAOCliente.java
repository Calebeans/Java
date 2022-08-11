/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import clinicaa.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class DAOCliente {
    
    public List<Cliente> getLista() {
    String sql = "select * from cliente";
    List<Cliente>lista = new ArrayList<>();
    try{
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            Cliente obj = new Cliente();
            obj.setCodigo(rs.getInt("CODCliente"));
            obj.setNome(rs.getString("nome"));
            obj.setCpf(rs.getString("cpf"));
            obj.setCidade(rs.getString("cidade"));
            obj.setTelefone(rs.getString("telefone"));
            obj.setIdade(rs.getInt("idade"));
            lista.add(obj);
        }
    }catch (SQLException e){
        JOptionPane.showMessageDialog(null, "Erro de SQL:3 " + e.getMessage());
    }
    return lista;

}

    public boolean salvar(Cliente cliente){
        if(cliente.getCodigo() == null){
            return incluir(cliente);
        }else{
            return alterar(cliente);
        }
    }
    public boolean incluir(Cliente obj){
        String sql = "insert into cliente(nome, cpf, telefone, cidade, idade) values(?,?,?,?,?)";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getCpf());
            pst.setString(3, obj.getTelefone());
            pst.setString(4, obj.getCidade());
            pst.setInt(5, obj.getIdade());
            if(pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Cliente incluído com sucesso");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Cliente não incluído");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL1: "+ e.getMessage());
            return false;
        }
    }
    public boolean alterar(Cliente obj){
        String sql = 
           "update cliente set nome= ?, cpf = ?, telefone = ?, cidade = ?, idade = ? where codigo = ?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getCpf());
            pst.setString(3, obj.getTelefone());
            pst.setString(4, obj.getCidade());
            pst.setInt(5, obj.getIdade());
            pst.setInt(6, obj.getCodigo());
            if(pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Cliente não alterado");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL:2 "+ e.getMessage());
            return false;
        }
    }
    
    
    public boolean remover(Cliente obj){
        String sql = "delete from cliente where CODCliente = ?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getCodigo());
            if(pst.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Cliente não excluído");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: "+ e.getMessage());
            return false;
        }
    }
    public Cliente localizar(Integer id){
        String sql = "select * from cliente where CODCliente = ?";
        Cliente obj = new Cliente();
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                obj.setCodigo(rs.getInt("CODCliente"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setCidade(rs.getString("cidade"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setIdade(rs.getInt("idade"));
                return obj;
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }
        return null;
    }
}
