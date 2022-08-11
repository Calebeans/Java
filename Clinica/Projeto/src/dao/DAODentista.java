/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import clinicaa.Dentista;
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
public class DAODentista {
    public List<Dentista> getLista() {
    String sql = "select * from Dentista";
    List<Dentista>lista = new ArrayList<>();
    try{
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            Dentista obj = new Dentista();
            obj.setIdDentista(rs.getInt("CODDentista"));
            obj.setNome(rs.getString("nome"));
            obj.setCPF(rs.getString("cpf"));
            obj.setContato(rs.getString("contato"));
            lista.add(obj);
        }
    }catch (SQLException e){
        JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
    }
    return lista;

}

    public boolean salvar(Dentista dentista){
        if(dentista.getIdDentista() == null){
            return incluir(dentista);
        }else{
            return alterar(dentista);
        }
    }
    public boolean incluir(Dentista obj){
        String sql = "insert into dentista(nome, cpf, contato) values(?,?,?)";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getCPF());
            pst.setString(3, obj.getContato());
            if(pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Dentista incluído com sucesso");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Dentista não incluído");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: "+ e.getMessage());
            return false;
        }
    }
    public boolean alterar(Dentista obj){
        String sql = 
           "update dentista set nome= ?, cpf = ?, contato = ? where CODDENTISTA = ?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getCPF());
            pst.setString(3, obj.getContato());
            pst.setInt(6, obj.getIdDentista());
            if(pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "dentista alterado com sucesso");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "dentista não alterado");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL:2 "+ e.getMessage());
            return false;
        }
    }
    
    
    public boolean remover(Dentista obj){
        String sql = "delete from Dentista where CODDENTISTA = ?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getIdDentista());
            if(pst.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Dentista excluído com sucesso");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Dentista não excluído");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: "+ e.getMessage());
            return false;
        }    
    }
    public Dentista localizar(Integer id){
        String sql = "select * from Dentista where CODDENTISTA = ?";
        Dentista obj = new Dentista();
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                obj.setIdDentista(rs.getInt("CODDentista"));
                obj.setNome(rs.getString("nome"));
                obj.setCPF(rs.getString("cpf"));
                obj.setContato(rs.getString("contato"));
                return obj;
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
        }
        return null;
    }
}
