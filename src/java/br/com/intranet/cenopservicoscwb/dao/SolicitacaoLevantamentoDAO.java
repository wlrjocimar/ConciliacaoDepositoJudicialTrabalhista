
package br.com.intranet.cenopservicoscwb.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.intranet.cenopservicoscwb.entity.SolicitacaoLevantamento;
import br.com.intranet.cenopservicoscwb.connectionfactory.ConnectionFactory;
import br.com.intranet.cenopservicoscwb.bean.util.ErroSistema;
import br.com.intranet.cenopservicoscwb.entity.Desconciliacao;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;


public class SolicitacaoLevantamentoDAO implements CrudDAO<SolicitacaoLevantamento>{

   
    
    
    
    @Override
    public void salvar(SolicitacaoLevantamento entidade) throws ErroSistema {
    
    }

    @Override
    public void deletar(SolicitacaoLevantamento entidade) throws ErroSistema {

     JOptionPane.showMessageDialog(null, "Teste");
             

    }

    
    
    
    
    
    
    public List<SolicitacaoLevantamento> buscarPorParametro(Desconciliacao entidade) throws ErroSistema {
       
        
        
        try {
            Connection con = ConnectionFactory.conectar("retab");
            String sql = "SELECT * FROM tb_cpj_cadastro where NPJ like '%' ? '%'";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, entidade.getNpj());
            ResultSet rs = stmt.executeQuery();
            List<SolicitacaoLevantamento> levantamentos = new ArrayList<>();

            while (rs.next()) {

                SolicitacaoLevantamento solicitacaoLevantamento = new SolicitacaoLevantamento();

                solicitacaoLevantamento.setCod(rs.getInt("cod"));
                solicitacaoLevantamento.setIdNpj(rs.getString("NPJ"));
                
                
                
                

                levantamentos.add(solicitacaoLevantamento);

            }

            ConnectionFactory.fecharConexao();

            return levantamentos;

        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao listar resgates", ex);
        } finally{
           ConnectionFactory.fecharConexao();
       }
       
       
       

        
       
   
    }
    public List<SolicitacaoLevantamento> buscarPorParametro(String parametro) throws ErroSistema {
       
        
        try {
            Connection con = ConnectionFactory.conectar("retab");
            String sql = "SELECT * FROM tb_cpj_cadastro where NPJ like '%' ? '%'";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, parametro);
            ResultSet rs = stmt.executeQuery();
            List<SolicitacaoLevantamento> levantamentos = new ArrayList<>();

            while (rs.next()) {

                SolicitacaoLevantamento s = new SolicitacaoLevantamento();

                s.setCod(rs.getInt("cod"));
                s.setNpj(rs.getString("NPJ"));
                s.setContaDepositaria(rs.getString("CONTA_DEPOSITARIA"));
                s.setIDValor(rs.getBigDecimal("ID_Valor"));
                s.setIDSituação(rs.getString("ID_Situação"));
                s.setDjo51F12ParteNome(rs.getString("djo_51_f12_parte_nome"));
                s.setAlvaraEletronico(rs.getString("ALVARA_ELETRONICO"));
                s.setObsContabilizacao(rs.getString("OBS_CONTABILIZACAO"));
                s.setDjo51Finalidade(rs.getString("djo_51_finalidade"));
                s.setDjo51AgenciaResponsavel(rs.getString("djo_51_agencia_responsavel"));
                
                levantamentos.add(s);

            }

            ConnectionFactory.fecharConexao();

            return levantamentos;

        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao listar resgates", ex);
        } finally{
           ConnectionFactory.fecharConexao();
       }
       
       
       

        
       
   
    }

    @Override
    public List<SolicitacaoLevantamento> buscar() throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void avocar(SolicitacaoLevantamento entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean verAvocacao(SolicitacaoLevantamento entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean avaliarParaSalvar(SolicitacaoLevantamento entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean compararValor(SolicitacaoLevantamento entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void priorizar(SolicitacaoLevantamento entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void liberar(SolicitacaoLevantamento entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SolicitacaoLevantamento> buscarPorParametro(SolicitacaoLevantamento entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    

   
    
    
    
}
