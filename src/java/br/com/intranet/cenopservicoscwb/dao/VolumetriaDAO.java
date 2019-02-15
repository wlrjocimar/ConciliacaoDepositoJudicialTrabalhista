/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intranet.cenopservicoscwb.dao;

import br.com.intranet.cenopservicoscwb.bean.util.ErroSistema;
import br.com.intranet.cenopservicoscwb.connectionfactory.ConnectionFactory;
import br.com.intranet.cenopservicoscwb.entity.Funcionario;
import br.com.intranet.cenopservicoscwb.entity.Volumetria;
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
 * @author PC_LENOVO
 */
public class VolumetriaDAO implements CrudDAO<Volumetria> {

    @Override
    public void salvar(Volumetria entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void avocar(Volumetria entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean verAvocacao(Volumetria entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(Volumetria entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Volumetria> buscar() throws ErroSistema {

        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);

        Funcionario usuario = (Funcionario) session.getAttribute("usuarioLogado");
        
        
        
         Volumetria volumetria = null;
        try {
            Connection con = ConnectionFactory.conectar("rejud");
            String sql = "SELECT * FROM rejud.view_volumetria";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Volumetria> listaTratadosVolumetria = new ArrayList<>();

            while (rs.next()) {

                 volumetria = new Volumetria();
                 
                 volumetria.setMesTratamento(rs.getString("MES_TRATAMENTO"));
                 volumetria.setPrefixo(rs.getInt("PREFIXO"));
                 volumetria.setFuncionario(rs.getString("FUNCIONARIO"));
                 volumetria.setCodigoFuncao(rs.getInt("CODIGO_FUNCAO"));
                 volumetria.setUorLocalizacao(rs.getInt("UOR_LOCALIZACAO"));
                 volumetria.setProcessoNoGsv(rs.getInt("PROCESSO_NO_GSV"));
                 volumetria.setCodigoProcesso(rs.getInt("CODIGO_PROCESSO"));
                 volumetria.setCodigoAtividade(rs.getInt("CODIGO_ATIVIDADE"));
                 volumetria.setCodigoDetalheAtividade(rs.getInt("CODIGO_DETALHE_ATIVIDADE"));
                 volumetria.setCodigoTarefa(rs.getInt("CODIGO_TAREFA"));
                 volumetria.setCargoGerencial(rs.getInt("CARGO_GERENCIAL"));
                 volumetria.setTipoChave(rs.getString("TIPO_CHAVE"));
                 volumetria.setQuantidadeProcessoConcluido(rs.getInt("QUANTIDADE_PROCESSO_CONCLUIDO"));
                 volumetria.setQuantidadeProcessoDevolvido(rs.getInt("QUANTIDADE_PROCESSO_DEVOLVIDO"));
                 volumetria.setQuantidadeTarefaConcluida(rs.getInt("QUANTIDADE_TAREFA_CONCLUIDA"));
                 volumetria.setQuantidadeTarefaDevolvida(rs.getInt("QUANTIDADE_TAREFA_DEVOLVIDA"));
                
                 

                 listaTratadosVolumetria.add(volumetria);
                

            }

            
           
            return listaTratadosVolumetria;

        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao listar dados", ex);
        } finally {
            ConnectionFactory.fecharConexao();
        }

















    }

    @Override
    public Boolean avaliarParaSalvar(Volumetria entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean compararValor(Volumetria entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void priorizar(Volumetria entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void liberar(Volumetria entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public List<Volumetria> buscarPorParametro(Volumetria entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Volumetria> buscarPorParametro(String parametro) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
      
    
    

    
}
