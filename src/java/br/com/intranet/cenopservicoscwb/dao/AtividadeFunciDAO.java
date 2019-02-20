/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intranet.cenopservicoscwb.dao;

import br.com.intranet.cenopservicoscwb.bean.util.ErroSistema;
import br.com.intranet.cenopservicoscwb.connectionfactory.ConnectionFactory;
import br.com.intranet.cenopservicoscwb.entity.AtividadeFunci;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author suporte
 */
public class AtividadeFunciDAO  implements CrudDAO<AtividadeFunci>{

   
    
    @Override
    public void salvar(AtividadeFunci entidade) throws ErroSistema {

 try {
            String sql;
            PreparedStatement stmt = null;
            Connection con = ConnectionFactory.conectar("retab");

            if (entidade.getCodigo() == null) {
                sql = "INSERT INTO tb_atividade_funci (MATRICULA,CODIGO_ATIVIDADE) VALUES (?,?)";
                        
                stmt = con.prepareStatement(sql);
            } else {
                sql = "UPDATE tb_atividade_funci set MATRICULA=?,  CODIGO_ATIVIDADE=? where CODIGO=?";
                stmt = con.prepareStatement(sql);
                stmt.setInt(3, entidade.getCodigo());
            }

            stmt.setString(1, entidade.getMatricula());
            stmt.setInt(2, entidade.getCodigoAtividade());
            
            
           
            
            
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            
            throw new ErroSistema("Erro ao tentar salvar atividade", ex);
           
    
    }finally{
         ConnectionFactory.fecharConexao();
          
     }
    
    
    






    }

    @Override
    public void deletar(AtividadeFunci entidade) throws ErroSistema {

            try {
            Connection con = ConnectionFactory.conectar("retab");
            String sql = "delete from tb_atividade_funci where CODIGO = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, entidade.getCodigo());
            stmt.execute();

            ConnectionFactory.fecharConexao();
        } catch (SQLException ex) {
             throw new ErroSistema("ERRO ao deletar registro",ex);
        }







    }

    @Override
    public List<AtividadeFunci> buscar() throws ErroSistema {
    
         try {
            Connection con = ConnectionFactory.conectar("retab");
            String sql = "SELECT * FROM tb_atividade_funci";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<AtividadeFunci> atividadesFunci = new ArrayList<>();

            while (rs.next()) {

                AtividadeFunci atividadeFunci = new AtividadeFunci();

                atividadeFunci.setCodigo(rs.getInt("CODIGO"));
                atividadeFunci.setMatricula(rs.getString("MATRICULA"));
                atividadeFunci.setCodigoAtividade(rs.getInt("CODIGO_ATIVIDADE"));
                
                
                

                atividadesFunci.add(atividadeFunci);

            }

            ConnectionFactory.fecharConexao();

            return atividadesFunci;

        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao listar atividade por funci", ex);
        } finally{
           ConnectionFactory.fecharConexao();
       }

        

    
    
    
    }

    @Override
    public void avocar(AtividadeFunci entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean verAvocacao(AtividadeFunci entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean avaliarParaSalvar(AtividadeFunci entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean compararValor(AtividadeFunci entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void priorizar(AtividadeFunci entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void liberar(AtividadeFunci entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public List<AtividadeFunci> buscarPorParametro(AtividadeFunci entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AtividadeFunci> buscarPorParametro(String parametro) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    public AtividadeFunci getAtividadeFunci(String chave) throws ClassNotFoundException, SQLException, ErroSistema {
       
        
        
        
        Connection con = ConnectionFactory.conectar("retab");
        Statement busca = con.createStatement();
        String sql = "SELECT * FROM tb_atividade_funci  where MATRICULA=TRIM('" + chave + "')";

        ResultSet rs = busca.executeQuery(sql);

        AtividadeFunci atividadeFunci = new AtividadeFunci();

        try {
           if(rs.next()) {
                

                atividadeFunci.setCodigo(rs.getInt("CODIGO"));
                atividadeFunci.setMatricula(rs.getString("MATRICULA"));
                atividadeFunci.setCodigoAtividade(rs.getInt("CODIGO_ATIVIDADE"));
                
                
                

               
           } 
            rs.close();
        } catch (SQLException e) {
        } finally{
            try{rs.close();} catch(SQLException e){}
            try{busca.close();} catch(SQLException e){}
            try{con.close();} catch(SQLException e){}
        }
        
        
              
    

//    funci.setChave("F5078775");
//    funci.setNome("JOCIMAR WALTER");
//    funci.setFuncao(4750);
//    funci.setUORHabitual(286409);
//    funci.setUORPosicao(286409);

    return atividadeFunci;
    }
    
    
    
}
