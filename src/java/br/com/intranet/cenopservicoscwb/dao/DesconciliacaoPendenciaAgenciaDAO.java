/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intranet.cenopservicoscwb.dao;

import br.com.intranet.cenopservicoscwb.bean.util.ErroSistema;
import br.com.intranet.cenopservicoscwb.bean.util.Utils;
import br.com.intranet.cenopservicoscwb.connectionfactory.ConnectionFactory;
import br.com.intranet.cenopservicoscwb.entity.Desconciliacao;
import br.com.intranet.cenopservicoscwb.entity.Funcionario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PC_LENOVO
 */
public class DesconciliacaoPendenciaAgenciaDAO implements CrudDAO<Desconciliacao> {
    
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);

        Funcionario usuario = (Funcionario) session.getAttribute("usuarioLogado");

        
        
    @Override
    public void salvar(Desconciliacao entidade) throws ErroSistema {
         GrupoStatusDAO statusDAO = new GrupoStatusDAO();
        GrupoTratamentoDAO tratamentoDAO = new GrupoTratamentoDAO();
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);

        Funcionario usuario = (Funcionario) session.getAttribute("usuarioLogado");
        
        try {
            String sql;
            PreparedStatement stmt = null;
            Connection con = ConnectionFactory.conectar("retab");
           
             if (entidade.getDataPrimeiroTratamento()== null) {
                 sql = "UPDATE tb_desconciliacao_djo_paj set NPJ=?, CONTA_CONTROLE=? , CONTA_DEPOSITARIA=? , SALDO_CONTA_CONTROLE=? , SALDO_DEPOSITO=?"
                        + " , VALOR_DESCONCILIACAO=? , SITUACAO=? , DATA_SITUACAO=? , FUNCIONARIO_RESPONSAVEL_SITUACAO=?"
                        + " , NOME_TRATAMENTO=? , AVOCADO=?, DATA_AVOCACAO=?, DATA_DESCONCILIACAO=?, OBS_LIVRE = ?, DATA_PRIMEIRO_TRATAMENTO = ?, TRATADO_PRAZO = ?, CODIGO_SITUACAO = ?,CODIGO_TRATAMENTO=?  where CODIGO_DESCONCILIACAO=?";
                stmt = con.prepareStatement(sql);
                try {
                    stmt.setDate(15, Utils.getDataAtualFormatoMysql());
                } catch (Exception ex) {
                  throw new ErroSistema("Erro ao tentar verificar data atual", ex);
                }
                if(entidade.getDiasDesconciliado()<=10){
                stmt.setString(16, "SIM");
                } else{
                 stmt.setString(16, "NAO");   
                }
                stmt.setInt(17, entidade.getCodigoSituacao());
                stmt.setInt(18, entidade.getCodigoTratamento());
                stmt.setInt(19, entidade.getCodigoDesconciliacao());
               
            } else {
                sql = "UPDATE tb_desconciliacao_djo_paj set NPJ=?, CONTA_CONTROLE=? , CONTA_DEPOSITARIA=? , SALDO_CONTA_CONTROLE=? , SALDO_DEPOSITO=?"
                        + " , VALOR_DESCONCILIACAO=? , SITUACAO=? , DATA_SITUACAO=? , FUNCIONARIO_RESPONSAVEL_SITUACAO=?"
                        + " , NOME_TRATAMENTO=? , AVOCADO=?, DATA_AVOCACAO=?, DATA_DESCONCILIACAO=?, OBS_LIVRE = ?,CODIGO_SITUACAO=?,CODIGO_TRATAMENTO=? where CODIGO_DESCONCILIACAO=?";
                stmt = con.prepareStatement(sql);
                stmt.setInt(15, entidade.getCodigoSituacao());
                stmt.setInt(16, entidade.getCodigoTratamento());
                stmt.setInt(17, entidade.getCodigoDesconciliacao());
                
            }

            stmt.setString(1, entidade.getNpj());
            stmt.setString(2, entidade.getContaControle());
            stmt.setString(3, entidade.getContaDepositaria());
            stmt.setDouble(4, entidade.getSaldoContaControle());
            stmt.setDouble(5, entidade.getSaldoDeposito());

            stmt.setDouble(6, entidade.getValorDesconciliacao());

            stmt.setString(7, statusDAO.buscarStatus(entidade.getCodigoSituacao()));
            entidade.setSituacao(statusDAO.buscarStatus(entidade.getCodigoSituacao()));
            try {
                stmt.setString(8, Utils.getDataHoraAtualMysql());
                entidade.setDataSituacao(Utils.getDataAtualFormatoMysql());
            } catch (Exception ex) {
                throw new ErroSistema("Erro ao tentar verificar data atual", ex);
            }
            stmt.setString(9, usuario.getChave());
            stmt.setString(10, tratamentoDAO.buscarTratamento(entidade.getCodigoTratamento()));
             entidade.setNomeTratamento(tratamentoDAO.buscarTratamento(entidade.getCodigoTratamento()));
            stmt.setString(11, "");
            stmt.setDate(12, (Date) entidade.getDataAvocacao());
            stmt.setDate(13, (Date) entidade.getDataDesconciliacao());
            stmt.setString(14,  entidade.getObsLivre());
            
           

            stmt.executeUpdate();
            salvarHistorico(entidade);

        } catch (SQLException ex) {

            throw new ErroSistema("Erro ao tentar salvar", ex);

        } finally {

            
            ConnectionFactory.fecharConexao();

        }

    }

    public void inserirNovaDesconciliacao(Desconciliacao entidade) throws ErroSistema {

        try {
            String sql;
            PreparedStatement stmt = null;
            Connection con = ConnectionFactory.conectar("retab");

            sql = "INSERT INTO tb_desconciliacao_djo_paj (NPJ,VARIACAO_NPJ,AUTOR,CONTA_DEPOSITARIA,VALOR_DESCONCILIACAO,DATA_DESCONCILIACAO) VALUES (?,?,?,?,?,?)";
            stmt = con.prepareStatement(sql);

            stmt.setString(1, entidade.getNpj());
            stmt.setInt(2, entidade.getVariacaoNpj());
            stmt.setString(3, entidade.getAutor());
            stmt.setString(4, entidade.getContaDepositaria());
            stmt.setDouble(5, entidade.getValorDesconciliacao());

            stmt.setString(6, entidade.getDataDesconciliacao().toString());

            stmt.executeUpdate();

        } catch (SQLException ex) {

            throw new ErroSistema("Erro ao tentar salvar", ex);

        } finally {

            ConnectionFactory.fecharConexao();

        }

    }

    public void criarTabelaTemporariaDesconciliacaoDjo(String sql) throws ErroSistema {

        try {

            PreparedStatement stmt = null;
            Connection con = ConnectionFactory.conectar("retab");

            stmt = con.prepareStatement(sql);

            stmt.execute();

        } catch (SQLException ex) {

            throw new ErroSistema("Erro ao tentar salvar", ex);

        } finally {

            ConnectionFactory.fecharConexao();

        }

    }

    public void inserirRegistroNovoTbTemporaria(Desconciliacao entidade) throws ErroSistema {

        

        try {
            String sql;
            PreparedStatement stmt = null;
            Connection con = ConnectionFactory.conectar("retab");

            sql = "INSERT INTO tb_temporaria_desconciliacao_djo_paj (NPJ,VARIACAO_NPJ,AUTOR,CONTA_DEPOSITARIA,VALOR_DESCONCILIACAO,DATA_DESCONCILIACAO) VALUES (?,?,?,?,?,?)";
            stmt = con.prepareStatement(sql);

            stmt.setString(1, entidade.getNpj());
            stmt.setInt(2, entidade.getVariacaoNpj());
            stmt.setString(3, entidade.getAutor());
            stmt.setString(4, entidade.getContaDepositaria());
            stmt.setDouble(5, entidade.getValorDesconciliacao());

            stmt.setString(6, entidade.getDataDesconciliacao().toString());

            stmt.executeUpdate();

        } catch (SQLException ex) {

            throw new ErroSistema("Erro ao tentar salvar", ex);

        } finally {

            ConnectionFactory.fecharConexao();

        }

    }

    @Override
    public void deletar(Desconciliacao entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Desconciliacao> buscar() throws ErroSistema {
         Desconciliacao desconciliacao = null;
        try {
            Connection con = ConnectionFactory.conectar("retab");
            String sql = "SELECT * FROM retab.tb_desconciliacao_djo_paj where ((SITUACAO = 'EM TRATAMENTO' AND NOME_TRATAMENTO LIKE '%' 'AGUARDANDO RETORNO' '%' ) AND (AVOCADO = '' OR AVOCADO IS NULL OR ( AVOCADO = 'SIM' AND FUNCIONARIO_ATUAL =  '" + usuario.getChave() + "' )))  ORDER BY ABS(VALOR_DESCONCILIACAO) DESC";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Desconciliacao> desconciliacoes = new ArrayList<>();

            while (rs.next()) {

                 desconciliacao = new Desconciliacao();

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
     
                desconciliacoes.add(desconciliacao);
                

            }

            
            
            return desconciliacoes;

        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao listar dados", ex);
        } finally {
            ConnectionFactory.fecharConexao();
        }

    }

    private void salvarHistorico(Desconciliacao entidade) throws ErroSistema {

        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);

        Funcionario usuario = (Funcionario) session.getAttribute("usuarioLogado");

        try {
            String sql;
            PreparedStatement stmt = null;
            Connection con = ConnectionFactory.conectar("retab");

            sql = "INSERT INTO tb_historico_desconciliacao_djo_paj (CODIGO_DESCONCILIACAO,NPJ,VARIACAO_NPJ,CONTA_CONTROLE,CONTA_DEPOSITARIA,SALDO_CONTA_CONTROLE,"
                    + "SALDO_DEPOSITO,VALOR_DESCONCILIACAO,SITUACAO,DATA_SITUACAO,FUNCIONARIO_RESPONSAVEL_SITUACAO,NOME_TRATAMENTO,DATA_DESCONCILIACAO,DIAS_DESCONCILIADO,DATA_ENTRADA_BD,MES_TRATAMENTO,CODIGO_FUNCAO,UOR_LOCALIZACAO,CODIGO_TAREFA"
                    + ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            stmt = con.prepareStatement(sql);

            stmt.setInt(1, entidade.getCodigoDesconciliacao());
            stmt.setString(2, entidade.getNpj());
            stmt.setInt(3, entidade.getVariacaoNpj());
            stmt.setString(4, entidade.getContaControle());
            stmt.setString(5, entidade.getContaDepositaria());
            stmt.setDouble(6, entidade.getSaldoContaControle());
            stmt.setDouble(7, entidade.getSaldoDeposito());

            stmt.setDouble(8, entidade.getValorDesconciliacao());

            stmt.setString(9, entidade.getSituacao());

            stmt.setString(10, Utils.getDataHoraAtualMysql());

            stmt.setString(11, usuario.getChave());
            stmt.setString(12, entidade.getNomeTratamento());
//            stmt.setString(12, usuario.getChave());
//            
//            stmt.setString(14, entidade.getAvocado());
            // stmt.setDate(15, (Date) entidade.getDataAvocacao());
            stmt.setDate(13, (Date) entidade.getDataDesconciliacao());
            stmt.setInt(14, entidade.getDiasDesconciliado());
            stmt.setDate(15,(Date) entidade.getDataEntradaBd());
            stmt.setString(16,Utils.getMesAtual());
            stmt.setInt(17,usuario.getFuncao());
            stmt.setInt(18,usuario.getUORPosicao());
            if((entidade.getValorDesconciliacao()<50000)){
                
                stmt.setInt(19,21444);
            } else{
                stmt.setInt(19,21443);
            }

            stmt.executeUpdate();

        } catch (SQLException ex) {

            throw new ErroSistema("Erro ao tentar salvar histórico", ex);

        } finally {

            ConnectionFactory.fecharConexao();

        }


    }

    public void avocar(Desconciliacao entidade) throws ErroSistema {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);

        Funcionario usuario = (Funcionario) session.getAttribute("usuarioLogado");

        try {
            String sql;
            PreparedStatement stmt = null;
            Connection con = ConnectionFactory.conectar("retab");

            sql = "UPDATE tb_desconciliacao_djo_paj set AVOCADO=?, DATA_AVOCACAO=?, FUNCIONARIO_ATUAL=? where CODIGO_DESCONCILIACAO=?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(4, entidade.getCodigoDesconciliacao());

            stmt.setString(1, "SIM");
            try {
                stmt.setString(2, Utils.getDataHoraAtualMysql());
            } catch (Exception ex) {
                throw new ErroSistema("Erro ao tentar verificar data atual", ex);
            }
            stmt.setString(3, usuario.getChave());
            entidade.setFuncionarioAtual(usuario.getChave());

            stmt.executeUpdate();

        } catch (SQLException ex) {

            throw new ErroSistema("Erro ao tentar avocar registro", ex);

        } finally {

            ConnectionFactory.fecharConexao();

        }

    }

    @Override
    public Boolean verAvocacao(Desconciliacao entidade) {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);

        Funcionario usuario = (Funcionario) session.getAttribute("usuarioLogado");
        int numeroRegistro = 0;

        try {
            Connection con = ConnectionFactory.conectar("retab");
            String sql = "SELECT * FROM tb_desconciliacao_djo_paj where (AVOCADO = 'SIM' AND CODIGO_DESCONCILIACAO =? and FUNCIONARIO_ATUAL <> ? )";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, entidade.getCodigoDesconciliacao());
            stmt.setString(2, usuario.getChave());//MUDAR PARA usuario.getChave para produçao
            ResultSet rs = stmt.executeQuery();

            numeroRegistro = contareg(rs);
        } catch (Exception ex) {

            return false;

        }

        if (numeroRegistro > 0) {
            return true;

        } else {
            return false;

        }

    }

    public int contareg(ResultSet rs) throws ErroSistema {

        int numResultados = 0;
        try {
            rs.last();
            numResultados = rs.getRow();
            rs.first();
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally{
            

            ConnectionFactory.fecharConexao();

        
        }
        return numResultados;

    } 

    
    
    public void apagaRegistrosTabela() throws ErroSistema {

        String sql;

        try {

            PreparedStatement stmt = null;
            Connection con = ConnectionFactory.conectar("retab");

            sql = "truncate retab.tb_temporaria_desconciliacao_djo_paj";
            stmt = con.prepareStatement(sql);
            
            stmt.execute();

        } catch (Exception ex) {

        } finally{
            ConnectionFactory.fecharConexao();
        }

    }
    

    @Override
    public Boolean avaliarParaSalvar(Desconciliacao entidade) {
        GrupoStatusDAO statusDAO = new GrupoStatusDAO();
      GrupoTratamentoDAO tratamentoDAO = new GrupoTratamentoDAO();
        
        String status = null;
        String complemento= null;
        try {
            status = statusDAO.buscarStatus(entidade.getCodigoSituacao());
            complemento = tratamentoDAO.buscarTratamento(entidade.getCodigoTratamento());
            
        } catch (ErroSistema ex) {
            Logger.getLogger(DesconciliacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
          
        
        
        
                if (status.contains("EM TRATAMENTO") &&  complemento == null){
                    
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção!!!", "Status EM TRATAMENTO requer tipo de tratamento" ));
                    
                    return false;
                    
                
                
                }else if(status.contains("INCONSISTENCIA") &&  complemento == null){
                    
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção!!!", "Status INCONSISTENCIA requer tipo de tratamento" ));
                
                return false;
                
                }
                
                
                return true;
    



    }

    @Override
    public Boolean compararValor(Desconciliacao entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void priorizar(Desconciliacao entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void liberar(Desconciliacao entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public List<Desconciliacao> buscarPorParametro(Desconciliacao entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Desconciliacao> buscarPorParametro(String parametro) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

}
