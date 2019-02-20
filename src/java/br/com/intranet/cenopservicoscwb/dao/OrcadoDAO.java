/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intranet.cenopservicoscwb.dao;

import br.com.intranet.cenopservicoscwb.bean.util.ErroSistema;
import br.com.intranet.cenopservicoscwb.connectionfactory.ConnectionFactory;
import br.com.intranet.cenopservicoscwb.entity.Desconciliacao;
import br.com.intranet.cenopservicoscwb.entity.Orcado;
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
public class OrcadoDAO implements  CrudDAO<Orcado>{

    @Override
    public void salvar(Orcado entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void avocar(Orcado entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void priorizar(Orcado entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void liberar(Orcado entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean verAvocacao(Orcado entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(Orcado entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Orcado> buscar() throws ErroSistema {
    try {
            Connection con = ConnectionFactory.conectar("retab");
            String sql = "SELECT * FROM tb_orcado_realizado_desconciliacao_djo_paj";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Orcado> desconciliacoes = new ArrayList<>();

            while (rs.next()) {

                Orcado desconciliacao = new Orcado();

                desconciliacao.setCodigoDesconciliacao(rs.getInt("CODIGO_DESCONCILIACAO"));
                desconciliacao.setNpj(rs.getString("NPJ"));
                desconciliacao.setVariacaoNpj(rs.getInt("VARIACAO_NPJ"));
                desconciliacao.setContaControle(rs.getString("CONTA_CONTROLE"));
                desconciliacao.setContaDepositaria(rs.getString("CONTA_DEPOSITARIA"));
                desconciliacao.setSaldoContaControle(rs.getDouble("SALDO_CONTA_CONTROLE"));
                desconciliacao.setSaldoDeposito(rs.getDouble("SALDO_DEPOSITO"));
                desconciliacao.setValorDesconciliacao(rs.getDouble("VALOR_DESCONCILIACAO"));
                desconciliacao.setSituacao(rs.getString("SITUACAO"));
                desconciliacao.setDataSituacao(rs.getDate("DATA_SITUACAO"));
                desconciliacao.setFuncionarioResponsavelSituacao(rs.getString("FUNCIONARIO_RESPONSAVEL_SITUACAO"));
                desconciliacao.setFuncionarioAtual(rs.getString("FUNCIONARIO_ATUAL"));
                desconciliacao.setNomeTratamento(rs.getString("NOME_TRATAMENTO"));
                desconciliacao.setAvocado(rs.getString("AVOCADO"));
                desconciliacao.setDataAvocacao(rs.getDate("DATA_AVOCACAO"));
                desconciliacao.setDataDesconciliacao(rs.getDate("DATA_DESCONCILIACAO"));
                desconciliacao.setDiasDesconciliado(rs.getInt("DIAS_DESCONCILIADO"));
                desconciliacao.setDataEntradaBd(rs.getDate("DATA_ENTRADA_BD"));
                desconciliacao.setObsLivre(rs.getString("OBS_LIVRE"));
                desconciliacao.setAutor(rs.getString("AUTOR"));
                desconciliacao.setMateria(rs.getString("MATERIA"));
                desconciliacao.setAssunto(rs.getString("ASSUNTO"));
                desconciliacao.setDataPrimeiroTratamento(rs.getDate("DATA_PRIMEIRO_TRATAMENTO"));
                desconciliacao.setDiasDesconciliado(rs.getInt("DIAS_DESCONCILIADO"));
                desconciliacao.setTratadoPrazo(rs.getString("TRATADO_PRAZO"));
                desconciliacao.setDataRetornoAgencia(rs.getDate("DATA_RETORNO_AGENCIA"));
                
                desconciliacoes.add(desconciliacao);

            }

            ConnectionFactory.fecharConexao();

            return desconciliacoes;

        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao listar dados", ex);
        } finally {
            ConnectionFactory.fecharConexao();
        }

    
    
    
    }

    @Override
    public List<Orcado> buscarPorParametro(Orcado entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Orcado> buscarPorParametro(String parametro) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean avaliarParaSalvar(Orcado entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean compararValor(Orcado entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
