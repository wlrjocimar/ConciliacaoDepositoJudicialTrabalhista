/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intranet.cenopservicoscwb.dao;

import br.com.intranet.cenopservicoscwb.bean.util.ErroSistema;
import br.com.intranet.cenopservicoscwb.connectionfactory.ConnectionFactory;
import br.com.intranet.cenopservicoscwb.entity.Conexao;
import br.com.intranet.cenopservicoscwb.entity.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author suporte
 */
public class ConexaoDAO implements CrudDAO<Conexao>{

    @Override
    public void salvar(Conexao entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void avocar(Conexao entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean verAvocacao(Conexao entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(Conexao entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    

    @Override
    public List<Conexao> buscar() throws ErroSistema {
       
         FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);

        Funcionario usuario = (Funcionario) session.getAttribute("usuarioLogado");
        
        
        
         Conexao conexao = null;
        try {
            Connection con = ConnectionFactory.conectar("rejud");
            String sql = "SELECT * FROM rejud.tb_conexao where extract(month  FROM DATA) = extract(month FROM curdate()) order by DATA DESC";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Conexao> listaConexao = new ArrayList<>();

            while (rs.next()) {

                conexao = new Conexao();

                conexao.setCodigo(rs.getInt("CODIGO"));
                conexao.setOrcado(rs.getInt("ORCADO"));
                conexao.setRealizado(rs.getInt("REALIZADO"));
                conexao.setIndicador(rs.getDouble("INDICADOR"));
                conexao.setData(rs.getDate("DATA"));
                
                if(rs.getInt("ORCADO_COMPLEMENTAR")>= 0){
                conexao.setOrcadoComplementar(rs.getInt("ORCADO_COMPLEMENTAR"));
                }else{
                 conexao.setOrcadoComplementar(0); 
                }
               
                listaConexao.add(conexao);
                

            }

            
            
            return listaConexao;

        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao listar dados", ex);
        } finally {
            ConnectionFactory.fecharConexao();
        }

        
        
                


    }

    @Override
    public Boolean avaliarParaSalvar(Conexao entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean compararValor(Conexao entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void priorizar(Conexao entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void liberar(Conexao entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public List<Conexao> buscarPorParametro(Conexao entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Conexao> buscarPorParametro(String parametro) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
