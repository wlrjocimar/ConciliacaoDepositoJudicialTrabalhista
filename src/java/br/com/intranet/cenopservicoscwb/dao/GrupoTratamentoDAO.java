/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intranet.cenopservicoscwb.dao;

import br.com.intranet.cenopservicoscwb.bean.util.ErroSistema;
import br.com.intranet.cenopservicoscwb.connectionfactory.ConnectionFactory;
import br.com.intranet.cenopservicoscwb.entity.GrupoStatus;
import br.com.intranet.cenopservicoscwb.entity.GrupoTratamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author suporte
 */
public class GrupoTratamentoDAO  implements  CrudDAO<GrupoTratamento>{

    @Override
    public void salvar(GrupoTratamento entidade) throws ErroSistema {
        
        try {
            String sql;
            PreparedStatement stmt = null;
            Connection con = ConnectionFactory.conectar("rejud");

            if (entidade.getCodigoTratamento()== null) {
                sql = "INSERT INTO tb_grupo_tratamento (NOME_TRATAMENTO) VALUES (?)";
                stmt = con.prepareStatement(sql);
            } else {
                sql = "UPDATE tb_grupo_tratamento set NOME_TRATAMENTO=? WHERE CODIGO_TRATAMENTO =?";
                stmt = con.prepareStatement(sql);
                stmt.setInt(2, entidade.getCodigoTratamento());
            }

            stmt.setString(1, entidade.getNomeTratamento());
           
            
            stmt.execute();
            ConnectionFactory.fecharConexao();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao tentar salvar", ex);
    
    }
        
        
        
    }

    @Override
    public void deletar(GrupoTratamento entidade) throws ErroSistema {
         try {
            Connection con = ConnectionFactory.conectar("rejud");
            String sql = "delete from tb_grupo_tratamento where CODIGO_TRATAMENTO = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, entidade.getCodigoTratamento());
            stmt.execute();

            ConnectionFactory.fecharConexao();
        } catch (SQLException ex) {
             throw new ErroSistema("ERRO ao deletar registro",ex);
        }

    }

    
   

    
     @Override
    public List<GrupoTratamento> buscar() throws ErroSistema {
        
       
        
        
        
        List<GrupoTratamento> grupoTratamentos;
        
         try {
            Connection con = ConnectionFactory.conectar("rejud");
            String sql = "SELECT * FROM tb_grupo_tratamento order by NOME_TRATAMENTO ASC";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            grupoTratamentos = new ArrayList<>();
            
              
        
            
            
            
            

            while (rs.next()) {

                GrupoTratamento grupoTratamento = new GrupoTratamento();

                grupoTratamento.setCodigoTratamento(rs.getInt("CODIGO_TRATAMENTO"));
                grupoTratamento.setNomeTratamento(rs.getString("NOME_TRATAMENTO"));
               
                

                grupoTratamentos.add(grupoTratamento);

            }

            ConnectionFactory.fecharConexao();

            return grupoTratamentos;

        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao listar dados", ex);
        }

        
        

        
        
        
        
        
        
    }

    @Override
    public void avocar(GrupoTratamento entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean verAvocacao(GrupoTratamento entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean avaliarParaSalvar(GrupoTratamento entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
    
    
    public String buscarTratamento(int codigo) throws ErroSistema {
        List<GrupoTratamento> listaTratamento = new ArrayList<>();
        GrupoTratamentoDAO tratamentoDAO = new GrupoTratamentoDAO();
        listaTratamento = tratamentoDAO.buscar();
        String tratamento = null;
            for (GrupoTratamento nomeTratamento : listaTratamento) {
            
                if(nomeTratamento.getCodigoTratamento()== codigo){
                   tratamento = nomeTratamento.getNomeTratamento();
                    return tratamento;
                }
        }
        
       return null;
        
    }

    @Override
    public Boolean compararValor(GrupoTratamento entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void priorizar(GrupoTratamento entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void liberar(GrupoTratamento entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public List<GrupoTratamento> buscarPorParametro(GrupoTratamento entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GrupoTratamento> buscarPorParametro(String parametro) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    

    
   
    
}
