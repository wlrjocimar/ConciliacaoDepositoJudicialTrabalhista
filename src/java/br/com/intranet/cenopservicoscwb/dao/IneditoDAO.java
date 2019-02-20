/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intranet.cenopservicoscwb.dao;

import br.com.intranet.cenopservicoscwb.bean.util.ErroSistema;
import br.com.intranet.cenopservicoscwb.bean.util.Utils;
import br.com.intranet.cenopservicoscwb.connectionfactory.ConnectionFactory;
import br.com.intranet.cenopservicoscwb.entity.Funcionario;
import br.com.intranet.cenopservicoscwb.entity.Inedito;
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
 * @author jocimar
 */
public class IneditoDAO implements  CrudDAO<Inedito>{

    @Override
    public void salvar(Inedito entidade) throws ErroSistema {
        
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);

        Funcionario usuario = (Funcionario) session.getAttribute("usuarioLogado");
        
        

            try {
            String sql;
            PreparedStatement stmt = null;
            Connection con = ConnectionFactory.conectar("retab");

            if (entidade.getCodigo()== null) {
                sql = "INSERT INTO tb_inedito (NPJ,VARIACAO_NPJ,CONTA_DEPOSITARIA,VL_RSGT,NR_OFICIO,FUNCIONARIO_RESPONSAVEL_SOLICITACAO,DATA_SOLICITACAO,TIPO_DESTINACAO) VALUES (?,?,?,?,?,?,?,?)";
                stmt = con.prepareStatement(sql);
                stmt.setString(6,usuario.getChave() );
                stmt.setDate(7,Utils.getDataAtualFormatoMysql());
                stmt.setString(8,entidade.getTipoDestinacao());
            } else {
                sql = "UPDATE tb_inedito set NPJ=?, VARIACAO_NPJ = ?, CONTA_DEPOSITARIA = ?, VL_RSGT = ?, NR_OFICIO=?, OBS_COMPLEMENTAR = ?, OBS_TRATAR = ?,TIPO_DESTINACAO=?,DEPENDENCIA_DTRA=? WHERE CODIGO=?";
                stmt = con.prepareStatement(sql);
                stmt.setString(6, entidade.getObsComplementar());
                stmt.setString(7, entidade.getObsTratar());
                stmt.setString(8, entidade.getTipoDestinacao());
                stmt.setInt(9, entidade.getDependenciaDtra());
                stmt.setInt(10, entidade.getCodigo());
            }

            stmt.setString(1, entidade.getNpj());
            stmt.setInt(2, entidade.getVariacaoNpj());
            stmt.setString(3, entidade.getContaDepositaria());
            stmt.setDouble(4, (Utils.converterStringParaDouble(entidade.getVlRsgt())));
            stmt.setString(5,entidade.getNrOficio() );
           
            
            stmt.execute();
            ConnectionFactory.fecharConexao();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao tentar salvar", ex);
    
    }   catch (Exception ex) {
             throw new ErroSistema("Erro ao tentar salvar solicitação de inédito", ex);
        } finally{
                ConnectionFactory.fecharConexao();
            }


    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void avocar(Inedito entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean verAvocacao(Inedito entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(Inedito entidade) throws ErroSistema {
                
          try {
            Connection con = ConnectionFactory.conectar("retab");
            String sql = "delete from tb_inedito where CODIGO = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, entidade.getCodigo());
            stmt.execute();

            ConnectionFactory.fecharConexao();
        } catch (SQLException ex) {
             throw new ErroSistema("ERRO ao deletar registro",ex);
        }

        





    }

    @Override
    public List<Inedito> buscar() throws ErroSistema {
        
        
         List<Inedito> ineditos;
        
         try {
            Connection con = ConnectionFactory.conectar("retab");
            String sql = "SELECT * FROM tb_inedito where OBS_TRATAR = '' OR OBS_TRATAR IS NULL OR OBS_TRATAR NOT LIKE '%' 'sucesso' '%' order by TIPO_DESTINACAO DESC,DATA_SOLICITACAO DESC";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ineditos = new ArrayList<>();
            
              
        
            
            
            
            

            while (rs.next()) {

                Inedito inedito = new Inedito();

                inedito.setCodigo(rs.getInt("CODIGO"));
                inedito.setNpj(rs.getString("NPJ"));
                inedito.setContaDepositaria(rs.getString("CONTA_DEPOSITARIA"));
                inedito.setVariacaoNpj(rs.getInt("VARIACAO_NPJ"));
                inedito.setVlRsgt(rs.getString("VL_RSGT"));
                inedito.setNrOficio(rs.getString("NR_OFICIO"));
                inedito.setSituacaoResgateSisbb(rs.getString("SITUACAO_RESGATE_SISBB"));
                inedito.setSituacaoResgatePortal(rs.getString("SITUACAO_RESGATE_PORTAL"));
                inedito.setDependenciaOprd(rs.getInt("DEPENDENCIA_OPRD"));
                inedito.setDependenciaDtra(rs.getInt("DEPENDENCIA_DTRA"));
                inedito.setFuncionarioResponsavelSolicitacao(rs.getString("FUNCIONARIO_RESPONSAVEL_SOLICITACAO"));
                inedito.setTipoDestinacao(rs.getString("TIPO_DESTINACAO"));
                inedito.setDataSolicitacao(rs.getDate("DATA_SOLICITACAO"));
                inedito.setFuncionarioResponsavelInclusao(rs.getString("FUNCIONARIO_RESPONSAVEL_INCLUSAO"));
                inedito.setDataInclusao(rs.getDate("DATA_INCLUSAO"));
                inedito.setObsComplementar(rs.getString("OBS_COMPLEMENTAR"));
                inedito.setObsTratar(rs.getString("OBS_TRATAR"));
                inedito.setSaldoContaDepositaria(rs.getDouble("SALDO_CONTA_DEPOSITARIA"));
                inedito.setDataSaldo(rs.getDate("DATA_SALDO"));
                inedito.setObsColetaDtra(rs.getString("OBS_COLETA_DTRA"));
                inedito.setSaldoPortal(rs.getDouble("SALDO_PORTAL"));
                
                
                
               
                

                ineditos.add(inedito);

            }

            

            return ineditos;

        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao listar inéditos", ex);
        } finally{
          
             ConnectionFactory.fecharConexao();
             
         }

        
        






    }

    @Override
    public Boolean avaliarParaSalvar(Inedito entidade) {
       
        String contaDepositaria = entidade.getContaDepositaria();
        int comprimentoDeposito = contaDepositaria.length();
        String valorResgate = entidade.getVlRsgt();
        if (entidade.getContaDepositaria()== null || entidade.getContaDepositaria().equals("")) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção!!!", "Conta depositária não foi informada"));
            return false;
        }

       
        if(!(valorResgate.contains(".") || valorResgate.contains(","))){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção!!!", "Use  '.' ou ',' para separar casas decimais, se valor inteiro use ,00 "));
            return false; 
        }
        if(comprimentoDeposito>13){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção!!!", "Não é permitido informar conta judicial(DJO) com mais de 13 dígitos"));
            return false; 
        }

        return true;

    
    
    
    
    }

    @Override
    public Boolean compararValor(Inedito entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void priorizar(Inedito entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void liberar(Inedito entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public List<Inedito> buscarPorParametro(Inedito entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inedito> buscarPorParametro(String parametro) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
