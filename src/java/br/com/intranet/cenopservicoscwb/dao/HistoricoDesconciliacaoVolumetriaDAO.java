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
public class HistoricoDesconciliacaoVolumetriaDAO implements  CrudDAO<HistoricoDesconciliacao>{
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
            String sql = "SELECT * FROM tb_historico_desconciliacao_djo_paj";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<HistoricoDesconciliacao> historicoDesconciliacoes = new ArrayList<>();

            while (rs.next()) {

                HistoricoDesconciliacao historicoDesconciLiacao = new HistoricoDesconciliacao();

                historicoDesconciLiacao.setCodigoDesconciliacao(rs.getInt("CODIGO_DESCONCILIACAO"));
                historicoDesconciLiacao.setNpj(rs.getString("NPJ"));
                historicoDesconciLiacao.setVariacaoNpj(rs.getInt("VARIACAO_NPJ"));
                historicoDesconciLiacao.setContaControle(rs.getString("CONTA_CONTROLE"));
                historicoDesconciLiacao.setContaDepositaria(rs.getString("CONTA_DEPOSITARIA"));
                historicoDesconciLiacao.setSaldoContaControle(rs.getDouble("SALDO_CONTA_CONTROLE"));
                historicoDesconciLiacao.setSaldoDeposito(rs.getDouble("SALDO_DEPOSITO"));
                historicoDesconciLiacao.setValorDesconciliacao(rs.getDouble("VALOR_DESCONCILIACAO"));
                historicoDesconciLiacao.setSituacao(rs.getString("SITUACAO"));
                historicoDesconciLiacao.setDataSituacao(rs.getDate("DATA_SITUACAO"));
                historicoDesconciLiacao.setFuncionarioResponsavelSituacao(rs.getString("FUNCIONARIO_RESPONSAVEL_SITUACAO"));
                historicoDesconciLiacao.setFuncionarioAtual(rs.getString("FUNCIONARIO_ATUAL"));
                historicoDesconciLiacao.setNomeTratamento(rs.getString("NOME_TRATAMENTO"));
                historicoDesconciLiacao.setAvocado(rs.getString("AVOCADO"));
                historicoDesconciLiacao.setDataAvocacao(rs.getDate("DATA_AVOCACAO"));
                historicoDesconciLiacao.setDataDesconciliacao(rs.getDate("DATA_DESCONCILIACAO"));
                historicoDesconciLiacao.setDiasDesconciliado(rs.getInt("DIAS_DESCONCILIADO"));
                historicoDesconciLiacao.setDataEntradaBd(rs.getDate("DATA_ENTRADA_BD"));
                historicoDesconciLiacao.setMesTratamento(rs.getString("MES_TRATAMENTO"));
                historicoDesconciLiacao.setPrefixo(rs.getInt("PREFIXO"));
                historicoDesconciLiacao.setCodigoFuncao(rs.getInt("CODIGO_FUNCAO"));
                historicoDesconciLiacao.setUorLocalizacao(rs.getInt("UOR_LOCALIZACAO"));
                historicoDesconciLiacao.setProcessoNoGsv(rs.getInt("PROCESSO_NO_GSV"));
                historicoDesconciLiacao.setCodigoProcesso(rs.getInt("CODIGO_PROCESSO"));
                historicoDesconciLiacao.setCodigoAtividade(rs.getInt("CODIGO_ATIVIDADE"));
                historicoDesconciLiacao.setCodigoDetalheAtividade(rs.getInt("CODIGO_DETALHE_ATIVIDADE"));
                historicoDesconciLiacao.setCodigoTarefa(rs.getInt("CODIGO_TAREFA"));
                historicoDesconciLiacao.setCargoGerencial(rs.getInt("CARGO_GERENCIAL"));
                historicoDesconciLiacao.setTipoChave(rs.getString("TIPO_CHAVE"));
                historicoDesconciLiacao.setQuantidadeProcessoConcluido(rs.getInt("QUANTIDADE_PROCESSO_CONCLUIDO"));
                historicoDesconciLiacao.setQuantidadeProcessoDevolvido(rs.getInt("QUANTIDADE_PROCESSO_DEVOLVIDO"));
                historicoDesconciLiacao.setQuantidadeTarefaConcluida(rs.getInt("QUANTIDADE_TAREFA_CONCLUIDA"));
                historicoDesconciLiacao.setQuantidadeTarefaDevolvida(rs.getInt("QUANTIDADE_TAREFA_DEVOLVIDA"));
                
                
                

                historicoDesconciliacoes.add(historicoDesconciLiacao);

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
