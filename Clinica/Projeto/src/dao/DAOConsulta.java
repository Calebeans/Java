/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import clinicaa.Consulta;
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
public class DAOConsulta {
    DAOCliente daoCliente = new DAOCliente();
    DAODentista daoDentista = new DAODentista();
    DAOFuncionario daoFuncioanrio = new DAOFuncionario();
    DAOExame daoExame = new DAOExame();
    
    public List<Consulta> getLista() {
    String sql = "select * from Consulta";
    List<Consulta>lista = new ArrayList<>();
    try{
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            Consulta obj = new Consulta();
            obj.setIdConsulta(rs.getInt("CODCONSULTA"));
            obj.setPreco(rs.getInt("PRECO"));
            obj.setIdCliente(daoCliente.localizar(rs.getInt("CODCLIENTE")));
            obj.setIdDentista(daoDentista.localizar(rs.getInt("CODDENTISTA")));
            obj.setIdFuncionario(daoFuncioanrio.localizar(rs.getInt("CODFUNCIONARIO")));
            obj.setExame(daoExame.localizar(rs.getInt("CODEXAME")));
            lista.add(obj);
        }
    }catch (SQLException e){
        JOptionPane.showMessageDialog(null, "Erro de SQL:3 " + e.getMessage());
    }
    return lista;

}

    public boolean salvar(Consulta consulta){
        if(consulta.getIdConsulta()== null){
            return incluir(consulta);
        }else{
            return alterar(consulta);
        }
    }
    public boolean incluir(Consulta obj){
        String sql = "insert into Consulta(preco, CODCLIENTE, CODDENTISTA, CODFUNCIONARIO, CODExame) values(?,?,?,?,?)";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getPreco());
            pst.setInt(2, obj.getIdCliente().getCodigo());
            pst.setInt(3, obj.getIdDentista().getIdDentista());
            pst.setInt(4, obj.getIdFuncionario().getCodigo());
            pst.setInt(5, obj.getExame().getIdExame());
            if(pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Consulta incluído com sucesso");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Consulta não incluído");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL1: "+ e.getMessage());
            return false;
        }
    }
    public boolean alterar(Consulta obj){
        String sql = 
           "update Consulta set PRECO= ?, CODCLIENTE = ?, CODDENTISTA = ?, CODFUNCIONARIO = ?, CODExame = ?  where CODCONSULTA = ?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getPreco());
            pst.setInt(2, obj.getIdCliente().getCodigo());
            pst.setInt(3, obj.getIdDentista().getIdDentista());
            pst.setInt(4, obj.getIdFuncionario().getCodigo());
            pst.setInt(5, obj.getExame().getIdExame());
            pst.setInt(5, obj.getIdConsulta());
            if(pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Consulta alterado com sucesso");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Consulta não alterado");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL:2 "+ e.getMessage());
            return false;
        }
    }
    
    
    public boolean remover(Consulta obj){
        String sql = "delete from Consulta where CODCONSULTA = ?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getIdConsulta());
            if(pst.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Consulta excluído com sucesso");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Consulta não excluído");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: "+ e.getMessage());
            return false;
        }
    }
}
