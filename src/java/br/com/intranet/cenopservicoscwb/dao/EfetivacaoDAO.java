/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intranet.cenopservicoscwb.dao;

import br.com.intranet.cenopservicoscwb.bean.util.ErroSistema;
import br.com.intranet.cenopservicoscwb.bean.util.Utils;
import br.com.intranet.cenopservicoscwb.connectionfactory.ConnectionFactory;
import br.com.intranet.cenopservicoscwb.entity.Efetivacao;
import br.com.intranet.cenopservicoscwb.entity.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author f5078775
 */
public class EfetivacaoDAO implements CrudDAO<Efetivacao> {

    @Override
    public void salvar(Efetivacao entidade) throws ErroSistema {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);

        Funcionario usuario = (Funcionario) session.getAttribute("usuarioLogado");

        try {
            String sql;
            PreparedStatement stmt = null;
            Connection con = ConnectionFactory.conectar("rejud");

            if (entidade.getCodigo() == null) {
                sql = "INSERT INTO tb_efetivacao_dep (NPJ,AUTOR,PROCESSO,VALOR_EFETIVACAO,BANCO_DEPOSITARIO,"
                        + "CONTA_DEPOSITARIA,"
                        + "AGENCIA_DEPOSITARIA,SITUACAO_DEPOSITO,"
                        + "DATA_SOLICITACAO,FUNCI_RESPONSAVEL_SOLICITACAO,PROTOCOLO_GSV) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, entidade.getNpj());
                stmt.setString(2, entidade.getAutor());
                stmt.setString(3, entidade.getProcesso());
                stmt.setBigDecimal(4, Utils.converterStringParaBigDecimal(entidade.getValorEfetivacao()));
                stmt.setString(5, entidade.getBancoDepositario());
                stmt.setString(6, entidade.getContaDepositaria());
                
                if(entidade.getAgenciaDepositaria()== null){
                 stmt.setInt(7, 0); 
                } else{
                 stmt.setInt(7, entidade.getAgenciaDepositaria()); 
                }
                
                
                stmt.setString(8, entidade.getSituacaoDeposito());
                

                stmt.setDate(9, Utils.getDataAtualFormatoMysql());
                stmt.setString(10, usuario.getChave());
                stmt.setInt(11, entidade.getProtocoloGsv());

            } else {
                sql = "UPDATE tb_efetivacao_dep set NPJ=?, BANCO_DEPOSITARIO = ?, AGENCIA_DEPOSITARIA=?,"
                        + " CONTA_DEPOSITARIA = ?,  VALOR_EFETIVACAO = ?, PROTOCOLO_GSV=?  WHERE CODIGO=?";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, entidade.getNpj());
                stmt.setString(2, entidade.getBancoDepositario());
                stmt.setInt(3, entidade.getAgenciaDepositaria());
                stmt.setString(4, entidade.getContaDepositaria());
                stmt.setBigDecimal(5, Utils.converterStringParaBigDecimal(entidade.getValorEfetivacao()));
                
                stmt.setInt(6, entidade.getProtocoloGsv());
                stmt.setInt(7, entidade.getCodigo());
      }
            

            stmt.execute();
            ConnectionFactory.fecharConexao();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao tentar salvar", ex);

        } catch (Exception ex) {
            throw new ErroSistema("Erro ao tentar salvar efetivação de depósito", ex);
        } finally {
            ConnectionFactory.fecharConexao();
        }

    }

    @Override
    public void avocar(Efetivacao entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void priorizar(Efetivacao entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void liberar(Efetivacao entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean verAvocacao(Efetivacao entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(Efetivacao entidade) throws ErroSistema {
        try {
            Connection con = ConnectionFactory.conectar("rejud");
            String sql = "delete from tb_efetivacao_dep  where CODIGO = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, entidade.getCodigo());
            stmt.execute();

            ConnectionFactory.fecharConexao();
        } catch (SQLException ex) {
            throw new ErroSistema("ERRO ao deletar registro", ex);
        }

    }

    @Override
    public List<Efetivacao> buscar() throws ErroSistema {

        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);

        Funcionario usuario = (Funcionario) session.getAttribute("usuarioLogado");

        Efetivacao efetivacao = null;
        try {
            Connection con = ConnectionFactory.conectar("rejud");
            String sql = "SELECT * FROM rejud.tb_efetivacao_dep order by CODIGO DESC";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Efetivacao> listaEfetivacao = new ArrayList<>();

            while (rs.next()) {

                efetivacao = new Efetivacao();

                efetivacao.setNpj(rs.getString("NPJ"));
                efetivacao.setCodigo(rs.getInt("CODIGO"));
                efetivacao.setContaDepositaria(rs.getString("CONTA_DEPOSITARIA"));
                efetivacao.setAutor(rs.getString("AUTOR"));
                efetivacao.setProcesso(rs.getString("PROCESSO"));
                efetivacao.setValorEfetivacao(rs.getString("VALOR_EFETIVACAO"));
                efetivacao.setBancoDepositario(rs.getString("BANCO_DEPOSITARIO"));
                efetivacao.setContaDepositaria(rs.getString("CONTA_DEPOSITARIA"));
                efetivacao.setAgenciaDepositaria(rs.getInt("AGENCIA_DEPOSITARIA"));
                efetivacao.setSituacaoDeposito(rs.getString("SITUACAO_DEPOSITO"));
                efetivacao.setFunciResponsavelSolicitacao(rs.getString("FUNCI_RESPONSAVEL_SOLICITACAO"));
                efetivacao.setDataSolicitacao(rs.getDate("DATA_SOLICITACAO"));
                efetivacao.setFunciResponsavelComplementacao(rs.getString("FUNCI_RESPONSAVEL_COMPLEMENTACAO"));
                efetivacao.setDataComplementacao(rs.getDate("DATA_COMPLEMENTACAO"));
                efetivacao.setProtocoloGsv(rs.getInt("PROTOCOLO_GSV"));
                efetivacao.setSituacaoProlocolo(rs.getString("SITUACAO_PROLOCOLO"));
                
                efetivacao.setObs(rs.getString("OBS"));
                efetivacao.setNatureza(rs.getString("NATUREZA"));
                efetivacao.setValorInicial(rs.getBigDecimal("VALOR_INICIAL"));
                efetivacao.setSaldoAtual(rs.getBigDecimal("SALDO_ATUAL"));
                efetivacao.setDataInicial(rs.getDate("DATA_INICIAL"));
                efetivacao.setReu(rs.getString("REU"));
                efetivacao.setNatureza(rs.getString("NATUREZA"));
                efetivacao.setModalidade(rs.getString("MODALIDADE"));
                

                listaEfetivacao.add(efetivacao);

            }

            return listaEfetivacao;

        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao listar dados", ex);
        } finally {
            ConnectionFactory.fecharConexao();
        }

    }

    @Override
    public List<Efetivacao> buscarPorParametro(Efetivacao entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Efetivacao> buscarPorParametro(String parametro) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean avaliarParaSalvar(Efetivacao entidade) {
        String npj = entidade.getNpj();
        String banco = entidade.getBancoDepositario();
        String contaDepositaria = entidade.getContaDepositaria();
        
       
        
        
        
        
        int comprimentoNpj = npj.length();

        if (entidade.getNpj() == null || entidade.getNpj().equals("")) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção!!!", "Npj não foi preenchido"));
            return false;
        }

       
        
        
        
        
        if (npj.contains("/")) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção!!!", "Não utilizar /  para o npj"));
            return false;
        }
        if (comprimentoNpj < 11) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção!!!", "Npj deve ter 11 digitos"));
            return false;
        }
        if (comprimentoNpj > 11) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção!!!", "Npj deve ter 11 digitos"));
            return false;
        }

        if (entidade.getContaDepositaria() == null || entidade.getContaDepositaria().equals("")) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção!!!", "Conta depositária não foi preenchida"));
            return false;
        }
        
        if (entidade.getProtocoloGsv()== null ) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção!!!", "Informe o número do protocolo GSV"));
            return false;
        }
        
         if(!(entidade.getValorEfetivacao().contains(".") || entidade.getValorEfetivacao().contains(","))){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção!!!", "Use  '.' ou ',' para separar casas decimais, se valor inteiro use ,00 "));
            return false; 
        }
        
        

        return true;

    }

    @Override
    public Boolean compararValor(Efetivacao entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
