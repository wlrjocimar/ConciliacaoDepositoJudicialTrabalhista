/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intranet.cenopservicoscwb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.intranet.cenopservicoscwb.entity.Usuario;
import br.com.intranet.cenopservicoscwb.connectionfactory.ConnectionFactory;
import br.com.intranet.cenopservicoscwb.bean.util.ErroSistema;


/**
 *
 * @author PC_LENOVO
 */
public class UsuarioDAO implements  CrudDAO<Usuario>{

    @Override
    public void salvar(Usuario entidade) throws ErroSistema {
        
    }

    @Override
    public void deletar(Usuario entidade) throws ErroSistema {
       
    
    }

    @Override
    public List<Usuario> buscar() throws ErroSistema {
     
     
        
        
        
        
        
        
        try {
            Connection con = ConnectionFactory.conectar("retab");
            String sql = "SELECT A.*,B.cd_area,C.Quadro, spf_dados.nm_gerente_funci(A.matriculaF, '4750') AS gerente FROM arh.v_funcionarios A LEFT JOIN gestao_equipes.tb_uor_area B ON A.UOR_Posicao=B.uor LEFT JOIN spf_dados.tb_arh_base C ON A.matriculaF = C.tx_mtc_fun \n" +
"					WHERE B.uor=286409 or B.uor = 287339 or B.uor = 286399 or B.uor = 79771  or B.uor =286369";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Usuario> usuarios = new ArrayList<>();

            while (rs.next()) {

                Usuario  user = new Usuario();

                user.setChave(rs.getString("matriculaF"));
                user.setNome(rs.getString("nome"));
                user.setNomeGuerra(rs.getString("nome_guerra"));
                user.setFuncao(rs.getInt("funcao"));
                user.setNomeFuncao(rs.getString("nfuncao"));
                user.setUORHabitual(rs.getInt("UORHabitual"));
                user.setUORPosicao(rs.getInt("UOR_Posicao"));
                user.setGerente(rs.getString("gerente"));
                user.setSecao(rs.getString("secao"));
                user.setQuadro(rs.getString("Quadro"));

                usuarios.add(user);

            }

            ConnectionFactory.fecharConexao();

            return usuarios;

        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao listar chaves de funcionarios", ex);
        } finally {
            ConnectionFactory.fecharConexao();

        }
        
        
        

     }

    @Override
    public void avocar(Usuario entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean verAvocacao(Usuario entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean avaliarParaSalvar(Usuario entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean compararValor(Usuario entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void priorizar(Usuario entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void liberar(Usuario entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public List<Usuario> buscarPorParametro(Usuario entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> buscarPorParametro(String parametro) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


   


    }