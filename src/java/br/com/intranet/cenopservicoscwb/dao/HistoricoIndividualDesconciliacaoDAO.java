/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intranet.cenopservicoscwb.dao;

import br.com.intranet.cenopservicoscwb.bean.util.ErroSistema;
import br.com.intranet.cenopservicoscwb.connectionfactory.ConnectionFactory;
import br.com.intranet.cenopservicoscwb.entity.Funcionario;
import br.com.intranet.cenopservicoscwb.entity.HistoricoDesconciliacao;
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
 * @author jocimar
 */
public class HistoricoIndividualDesconciliacaoDAO implements  CrudDAO<HistoricoDesconciliacao>{
int qtdReg =  0;
    @Override
    public void salvar(HistoricoDesconciliacao entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void avocar(HistoricoDesconciliacao entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean verAvocacao(HistoricoDesconciliacao entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(HistoricoDesconciliacao entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HistoricoDesconciliacao> buscar() throws ErroSistema {
        
        
        
       FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);

        Funcionario usuario = (Funcionario) session.getAttribute("usuarioLogado");
        try {
            Connection con = ConnectionFactory.conectar("rejud");
            String sql = "SELECT * FROM tb_historico_desconciliacao_djo_paj WHERE FUNCIONARIO_RESPONSAVEL_SITUACAO  LIKE  '%'  '" + usuario.getChave() + "' '%' ";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<HistoricoDesconciliacao> historicoDesconciliacoes = new ArrayList<>();

            while (rs.next()) {

                HistoricoDesconciliacao historicoDesconciiacao = new HistoricoDesconciliacao();

                historicoDesconciiacao.setCodigoDesconciliacao(rs.getInt("CODIGO_DESCONCILIACAO"));
                historicoDesconciiacao.setNpj(rs.getString("NPJ"));
                historicoDesconciiacao.setVariacaoNpj(rs.getInt("VARIACAO_NPJ"));
                historicoDesconciiacao.setContaControle(rs.getString("CONTA_CONTROLE"));
                historicoDesconciiacao.setContaDepositaria(rs.getString("CONTA_DEPOSITARIA"));
                historicoDesconciiacao.setSaldoContaControle(rs.getDouble("SALDO_CONTA_CONTROLE"));
                historicoDesconciiacao.setSaldoDeposito(rs.getDouble("SALDO_DEPOSITO"));
                historicoDesconciiacao.setValorDesconciliacao(rs.getDouble("VALOR_DESCONCILIACAO"));
                historicoDesconciiacao.setSituacao(rs.getString("SITUACAO"));
                historicoDesconciiacao.setDataSituacao(rs.getDate("DATA_SITUACAO"));
                historicoDesconciiacao.setFuncionarioResponsavelSituacao(rs.getString("FUNCIONARIO_RESPONSAVEL_SITUACAO"));
                historicoDesconciiacao.setFuncionarioAtual(rs.getString("FUNCIONARIO_ATUAL"));
                historicoDesconciiacao.setNomeTratamento(rs.getString("NOME_TRATAMENTO"));
                historicoDesconciiacao.setAvocado(rs.getString("AVOCADO"));
                historicoDesconciiacao.setDataAvocacao(rs.getDate("DATA_AVOCACAO"));
                historicoDesconciiacao.setDataDesconciliacao(rs.getDate("DATA_DESCONCILIACAO"));
                historicoDesconciiacao.setDiasDesconciliado(rs.getInt("DIAS_DESCONCILIADO"));
                historicoDesconciiacao.setDataEntradaBd(rs.getDate("DATA_ENTRADA_BD"));

                historicoDesconciliacoes.add(historicoDesconciiacao);

            }

            ConnectionFactory.fecharConexao();

            return historicoDesconciliacoes;

        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao listar tratamento  diário", ex);
        } finally {
            ConnectionFactory.fecharConexao();
        }



    }

    @Override
    public Boolean avaliarParaSalvar(HistoricoDesconciliacao entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean compararValor(HistoricoDesconciliacao entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void priorizar(HistoricoDesconciliacao entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void liberar(HistoricoDesconciliacao entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public List<HistoricoDesconciliacao> buscarPorParametro(HistoricoDesconciliacao entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HistoricoDesconciliacao> buscarPorParametro(String parametro) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
