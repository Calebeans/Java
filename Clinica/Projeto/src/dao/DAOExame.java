/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import clinicaa.*;
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
public class DAOExame {
    DAOCliente daoCliente = new DAOCliente();
    
    public List<Exame> getLista() {
    String sql = "select * from Exame";
    List<Exame>lista = new ArrayList<>();
    try{
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            Exame obj = new Exame();
            obj.setIdExame(rs.getInt("CODEXAME"));
            obj.setCategoria(rs.getString("categoria"));
            obj.setPrescricao(rs.getString("PRESCRICAO"));
            obj.setCliente(daoCliente.localizar(rs.getInt("CODCLIENTE")));
            lista.add(obj);
        }
    }catch (SQLException e){
        JOptionPane.showMessageDialog(null, "Erro de SQL:3 " + e.getMessage());
    }
    return lista;

}

    public boolean salvar(Exame exame){
        if(exame.getIdExame()== null){
            return incluir(exame);
        }else{
            return alterar(exame);
        }
    }
    public boolean incluir(Exame obj){
        String sql = "insert into Exame(Categoria, PRESCRICAO, CODCLIENTE) values(?,?,?)";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getCategoria());
            pst.setString(2, obj.getPrescricao());
            pst.setInt(3, obj.getCliente().getCodigo());
            if(pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Exame incluído com sucesso");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Exame não incluído");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL1: "+ e.getMessage());
            return false;
        }
    }
    public boolean alterar(Exame obj){
        String sql = 
           "update Exame set Categoria= ?, PRESCRICAO = ?, CODCLIENTE = ?, where CODEXAME = ?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getCategoria());
            pst.setString(2, obj.getPrescricao());
            pst.setInt(3, obj.getCliente().getCodigo());
            pst.setInt(4, obj.getIdExame());
            if(pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Exame alterado com sucesso");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Exame não alterado");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL:2 "+ e.getMessage());
            return false;
        }
    }
    
    
    public boolean remover(Exame obj){
        String sql = "delete from Exame where CODEXAME = ?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getIdExame());
            if(pst.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Exame excluído com sucesso");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Exame não excluído");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: "+ e.getMessage());
            return false;
        }
    }
    public Exame localizar(Integer id){
        String sql = "select * from Exame where CODEXAME = ?";
        Exame obj = new Exame();
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                obj.setIdExame(rs.getInt("CODEXAME"));
                obj.setCategoria(rs.getString("categoria"));
                obj.setPrescricao(rs.getString("PRESCRICAO"));
                obj.setCliente(daoCliente.localizar(rs.getInt("CODCLIENTE")));
                return obj;
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }
        return null;
    }
}
