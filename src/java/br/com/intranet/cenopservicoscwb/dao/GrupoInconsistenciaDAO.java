/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intranet.cenopservicoscwb.dao;

import br.com.intranet.cenopservicoscwb.bean.util.ErroSistema;
import br.com.intranet.cenopservicoscwb.connectionfactory.ConnectionFactory;
import br.com.intranet.cenopservicoscwb.entity.GrupoInconsistencia;
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
public class GrupoInconsistenciaDAO implements CrudDAO<GrupoInconsistencia>{

    @Override
    public void salvar(GrupoInconsistencia entidade) throws ErroSistema {
       
        try {
            String sql;
            PreparedStatement stmt = null;
            Connection con = ConnectionFactory.conectar("rejud");

            if (entidade.getCodigoInconsistencia() == null) {
                sql = "INSERT INTO tb_grupo_inconsistencia (NOME_INCONSISTENCIA) VALUES (?)";
                stmt = con.prepareStatement(sql);
            } else {
                sql = "UPDATE tb_grupo_inconsistencia set NOME_INCONSISTENCIA=? WHERE CODIGO_INCONSISTENCIA =?";
                stmt = con.prepareStatement(sql);
                stmt.setInt(2, entidade.getCodigoInconsistencia());
            }

            stmt.setString(1, entidade.getNomeInconsistencia());
           
            
            stmt.execute();
            ConnectionFactory.fecharConexao();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao tentar salvar", ex);
    
    }
        
        
        
        
    }

    @Override
    public void deletar(GrupoInconsistencia entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GrupoInconsistencia> buscar() throws ErroSistema {

        
        
         try {
            Connection con = ConnectionFactory.conectar("rejud");
            String sql = "SELECT * FROM tb_grupo_inconsistencia";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<GrupoInconsistencia> grupoInconsistencias = new ArrayList<>();
            
              
        
            
            
            
            

            while (rs.next()) {

                GrupoInconsistencia grupoInconsistencia = new GrupoInconsistencia();

                grupoInconsistencia.setCodigoInconsistencia(rs.getInt("CODIGO_INCONSISTENCIA"));
                grupoInconsistencia.setNomeInconsistencia(rs.getString("NOME_INCONSISTENCIA"));
               
                

                grupoInconsistencias.add(grupoInconsistencia);

            }

            ConnectionFactory.fecharConexao();

            return grupoInconsistencias;

        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao listar dados", ex);
        }

    }

    @Override
    public void avocar(GrupoInconsistencia entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean verAvocacao(GrupoInconsistencia entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean avaliarParaSalvar(GrupoInconsistencia entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean compararValor(GrupoInconsistencia entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void priorizar(GrupoInconsistencia entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void liberar(GrupoInconsistencia entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public List<GrupoInconsistencia> buscarPorParametro(GrupoInconsistencia entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GrupoInconsistencia> buscarPorParametro(String parametro) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
