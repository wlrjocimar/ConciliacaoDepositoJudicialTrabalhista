/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intranet.cenopservicoscwb.dao;

import br.com.intranet.cenopservicoscwb.bean.util.ErroSistema;
import br.com.intranet.cenopservicoscwb.connectionfactory.ConnectionFactory;
import br.com.intranet.cenopservicoscwb.entity.SerieDesconciliacao;
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
public class SerieDesconciliacaoDAO implements CrudDAO<SerieDesconciliacao> {

    @Override
    public void salvar(SerieDesconciliacao entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void avocar(SerieDesconciliacao entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean verAvocacao(SerieDesconciliacao entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(SerieDesconciliacao entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    @Override
    public List<SerieDesconciliacao> buscar() throws ErroSistema {
        List<SerieDesconciliacao> series;
        
         try {
            Connection con = ConnectionFactory.conectar("retab");
            String sql = "SELECT * FROM tb_serie_historica_desconciliacao_dj_paj order by DATA DESC";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            series = new ArrayList<>();
            
              
        
            
            
            
            

            while (rs.next()) {

                SerieDesconciliacao serie = new SerieDesconciliacao();

                serie.setCodigo(rs.getInt("CODIGO"));
                serie.setQuantidade(rs.getInt("QUANTIDADE"));
                serie.setValor(rs.getDouble("VALOR"));
                serie.setData(rs.getDate("DATA"));
               serie.setValorAbsoluto(rs.getDouble("VALOR_ABSOLUTO"));
                      

                series.add(serie);

            }

            ConnectionFactory.fecharConexao();

            return series;

        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao listar serie desconciliação", ex);
        }

    }

    @Override
    public Boolean avaliarParaSalvar(SerieDesconciliacao entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean compararValor(SerieDesconciliacao entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void priorizar(SerieDesconciliacao entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void liberar(SerieDesconciliacao entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public List<SerieDesconciliacao> buscarPorParametro(SerieDesconciliacao entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SerieDesconciliacao> buscarPorParametro(String parametro) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


   
}
