/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intranet.cenopservicoscwb.dao;

import br.com.intranet.cenopservicoscwb.bean.util.ErroSistema;
import br.com.intranet.cenopservicoscwb.connectionfactory.ConnectionFactory;
import br.com.intranet.cenopservicoscwb.entity.GrupoStatus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jocimar
 */
public class GrupoStatusDAO  implements  CrudDAO<GrupoStatus> {

    @Override
    public void salvar(GrupoStatus entidade) throws ErroSistema {
            try {
            String sql;
            PreparedStatement stmt = null;
            Connection con = ConnectionFactory.conectar("rejud");

            if (entidade.getCodigoStatus()== null) {
                sql = "INSERT INTO tb_grupo_status (NOME_STATUS) VALUES (?)";
                stmt = con.prepareStatement(sql);
            } else {
                sql = "UPDATE tb_grupo_status set NOME_STATUS=? WHERE CODIGO_STATUS =?";
                stmt = con.prepareStatement(sql);
                stmt.setInt(2, entidade.getCodigoStatus());
            }

            stmt.setString(1, entidade.getNomeStatus());
           
            
            stmt.execute();
            ConnectionFactory.fecharConexao();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao tentar salvar", ex);
    
    }
        


    }

    @Override
    public void deletar(GrupoStatus entidade) throws ErroSistema {
    
          try {
            Connection con = ConnectionFactory.conectar("rejud");
            String sql = "delete from tb_grupo_status where CODIGO_STATUS = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, entidade.getCodigoStatus());
            stmt.execute();

            ConnectionFactory.fecharConexao();
        } catch (SQLException ex) {
             throw new ErroSistema("ERRO ao deletar registro",ex);
        }

        
        
        
        
    }

    @Override
    public List<GrupoStatus> buscar() throws ErroSistema {


             List<GrupoStatus> listaStatus;
        
         try {
            Connection con = ConnectionFactory.conectar("rejud");
            String sql = "SELECT * FROM tb_grupo_status";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            listaStatus = new ArrayList<>();
            
              
        
            
            
            
            

            while (rs.next()) {

                GrupoStatus grupoStatus = new GrupoStatus();

                grupoStatus.setCodigoStatus(rs.getInt("CODIGO_STATUS"));
                grupoStatus.setNomeStatus(rs.getString("NOME_STATUS"));
               
                

                listaStatus.add(grupoStatus);

            }

            ConnectionFactory.fecharConexao();

            return listaStatus;

        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao listar dados", ex);
        }

        
        

        
        




    }

    @Override
    public void avocar(GrupoStatus entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean verAvocacao(GrupoStatus entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean avaliarParaSalvar(GrupoStatus entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public String buscarStatus(int codigo) throws ErroSistema {
        List<GrupoStatus> listaStatus = new ArrayList<>();
        GrupoStatusDAO statusDAO = new GrupoStatusDAO();
        listaStatus = statusDAO.buscar();
        String status = null;
            for (GrupoStatus listaStatu : listaStatus) {
            
                if(listaStatu.getCodigoStatus() == codigo){
                   status = listaStatu.getNomeStatus();
                    return status;
                }
        }
        
       return null;
        
    }

    @Override
    public Boolean compararValor(GrupoStatus entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void priorizar(GrupoStatus entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void liberar(GrupoStatus entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public List<GrupoStatus> buscarPorParametro(GrupoStatus entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GrupoStatus> buscarPorParametro(String parametro) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
     
}
