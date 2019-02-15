/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intranet.cenopservicoscwb.dao;

import br.com.intranet.cenopservicoscwb.bean.util.ErroSistema;
import br.com.intranet.cenopservicoscwb.connectionfactory.ConnectionFactory;
import br.com.intranet.cenopservicoscwb.entity.Atividade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC_LENOVO
 */
public class AtividadeDAO implements  CrudDAO<Atividade>{

    @Override
    public void salvar(Atividade entidade) throws ErroSistema {
      
     try {
            String sql;
            PreparedStatement stmt = null;
            Connection con = ConnectionFactory.conectar("rejud");

            if (entidade.getCodigoAtividade()== null) {
                sql = "INSERT INTO tb_atividade (NOME_ATIVIDADE) VALUES (?)";
                        
                stmt = con.prepareStatement(sql);
            } else {
                sql = "UPDATE tb_atividade set NOME_ATIVIDADE=? where CODIGO=?";
                stmt = con.prepareStatement(sql);
                stmt.setInt(2, entidade.getCodigoAtividade());
            }

            stmt.setString(1, entidade.getNomeAtividade());
            
            
           
            
            
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            
            throw new ErroSistema("Erro ao tentar salvar atividade", ex);
           
    
    }finally{
         ConnectionFactory.fecharConexao();
          
     }
    
    
    
    
    
    
    }

    @Override
    public void deletar(Atividade entidade) throws ErroSistema {

                
          try {
            Connection con = ConnectionFactory.conectar("rejud");
            String sql = "delete from tb_atividade where CODIGO_ATIVIDADE = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, entidade.getCodigoAtividade());
            stmt.execute();

            ConnectionFactory.fecharConexao();
        } catch (SQLException ex) {
             throw new ErroSistema("ERRO ao deletar registro",ex);
        }

        




    }

    @Override
    public List<Atividade> buscar() throws ErroSistema {
       
    try {
            Connection con = ConnectionFactory.conectar("rejud");
            String sql = "SELECT * FROM tb_atividade";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Atividade> atividades = new ArrayList<>();

            while (rs.next()) {

                Atividade atividade = new Atividade();

                atividade.setCodigoAtividade(rs.getInt("CODIGO_ATIVIDADE"));
                atividade.setNomeAtividade(rs.getString("NOME_ATIVIDADE"));
                
                
                
                

                atividades.add(atividade);

            }

            ConnectionFactory.fecharConexao();

            return atividades;

        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao listar atividades cadastradas", ex);
        } finally{
           ConnectionFactory.fecharConexao();
       }

        

    
    
    }

    @Override
    public void avocar(Atividade entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean verAvocacao(Atividade entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean avaliarParaSalvar(Atividade entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean compararValor(Atividade entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void priorizar(Atividade entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void liberar(Atividade entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public List<Atividade> buscarPorParametro(Atividade entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Atividade> buscarPorParametro(String parametro) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    

    
    
}
