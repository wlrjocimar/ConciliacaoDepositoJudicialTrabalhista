package br.com.intranet.cenopservicoscwb.dao;

import br.com.intranet.cenopservicoscwb.bean.util.ErroSistema;
import br.com.intranet.cenopservicoscwb.connectionfactory.ConnectionFactory;
import br.com.intranet.cenopservicoscwb.entity.ProtocoloGsv;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProtocoloGsvDAO implements CrudDAO<ProtocoloGsv> {

    @Override
    public void salvar(ProtocoloGsv entidade) throws ErroSistema {
        //nao desenvolver este metodo para rotinas de tbelas externas somente de  connsultar
    }

    @Override
    public void deletar(ProtocoloGsv entidade) throws ErroSistema {
        //nao desenvolver este metodo para rotinas de tbelas externas somente de  connsultar  
    }

    @Override
    public List<ProtocoloGsv> buscar() throws ErroSistema {

        try {
            Connection con = ConnectionFactory.conectar("retab");
            String sql = "(SELECT T1.CD_PRC,T2.NM_AGRUP_PRC,t3.NM_TIP_ATVD,T1.CD_USU_FUN,\n" +
"                    t4.NM_FASE_PRC,T1.DT_ENTD_PRC,T1.DT_SAID_PRC,T1.CD_ETP,T1.IDENTIFIC1,\n" +
"                    T1.IDENTIFIC2,T1.IDENTIFIC3,T1.CD_TIP_ATVD,T1.CD_CLASSE_PRC,t5.NM_ETP,t6.NM_TIP_PRC,t7.NM_CLASSE_PRC\n" +
"                    FROM uso_dados.tb_prc_concl  as T1\n" +
"					left join uso_dados.tb_tip_agrup_prc as T2\n" +
"                       on T1.CD_AGRUP_PRC = T2.CD_AGRUP_PRC\n" +
"                    left join uso_dados.tb_tip_atvd as t3\n" +
"                    on T1.CD_TIP_ATVD =t3.CD_TIP_ATVD\n" +
"                    left join uso_dados.tb_tip_fase as t4\n" +
"                    on T1.CD_FASE_PRC=t4.CD_FASE_PRC\n" +
"                    left join uso_dados.tb_etp as t5\n" +
"                    ON T1.CD_ETP = t5.CD_ETP \n" +
"                    left join uso_dados.tb_tip_prc as t6\n" +
"                    on T1.CD_TIP_PRC = t6.CD_TIP_PRC\n" +
"                    left join uso_dados.tb_classe_prc as t7\n" +
"                    on T1.CD_ClASSE_PRC = t7.CD_CLASSE_PRC\n" +
"\n" +
"                    \n" +
"                     where\n" +
"                    (T1.CD_AGRUP_PRC = 2  or T1.CD_AGRUP_PRC =35) and\n" +
"                    (T1.CD_TIP_ATVD = 3500 or T1.CD_TIP_ATVD = 3501 or T1.CD_TIP_ATVD = 3502\n" +
"                     or T1.CD_TIP_ATVD = 3503 or T1.CD_TIP_ATVD = 3504 or T1.CD_TIP_ATVD = 250 and CD_PRF_UND=1915)) \n" +
"                    union \n" +
"                    (select T1.CD_PRC,T2.NM_AGRUP_PRC,t3.NM_TIP_ATVD,T1.CD_USU_FUN,t4.NM_FASE_PRC,\n" +
"                    T1.DT_ENTD_PRC,T1.DT_SAID_PRC,T1.CD_ETP,T1.IDENTIFIC1,\n" +
"                    T1.IDENTIFIC2,T1.IDENTIFIC3,T1.CD_TIP_ATVD,T1.CD_CLASSE_PRC,t5.NM_ETP,t6.NM_TIP_PRC,t7.NM_CLASSE_PRC\n" +
"                    from uso_dados.tb_prc as T1 \n" +
"                    left join uso_dados.tb_tip_agrup_prc as T2\n" +
"                     on T1.CD_AGRUP_PRC = T2.CD_AGRUP_PRC\n" +
"                      left join uso_dados.tb_tip_atvd as t3\n" +
"                    on T1.CD_TIP_ATVD =t3.CD_TIP_ATVD left join uso_dados.tb_tip_fase as t4\n" +
"                     on T1.CD_FASE_PRC=t4.CD_FASE_PRC\n" +
"                     left join uso_dados.tb_etp as t5\n" +
"                    ON T1.CD_ETP = t5.CD_ETP \n" +
"                    left join uso_dados.tb_tip_prc as t6\n" +
"                    on T1.CD_TIP_PRC = t6.CD_TIP_PRC\n" +
"                    left join uso_dados.tb_classe_prc as t7\n" +
"                    on T1.CD_ClASSE_PRC = t7.CD_CLASSE_PRC\n" +
"                    where\n" +
"                     (T1.CD_AGRUP_PRC = 2 or T1.CD_AGRUP_PRC =35)\n" +
"                     and(T1.CD_TIP_ATVD = 3500 or T1.CD_TIP_ATVD = 3501 or T1.CD_TIP_ATVD = 3502 or\n" +
"                    T1.CD_TIP_ATVD = 3503 or T1.CD_TIP_ATVD = 3504 or T1.CD_TIP_ATVD = 250 and CD_PRF_UND=1915))";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<ProtocoloGsv> protocolos = new ArrayList<>();

            while (rs.next()) {

                ProtocoloGsv protocoloGsv = new ProtocoloGsv();

                protocoloGsv.setNumeroProtocolo(rs.getInt("CD_PRC"));
                protocoloGsv.setNomeProcesso(rs.getString("NM_AGRUP_PRC"));
                protocoloGsv.setNomeAtividade(rs.getString("NM_TIP_ATVD"));
                protocoloGsv.setFuncionarioResponsavel(rs.getString("CD_USU_FUN"));
                protocoloGsv.setDataSaidaProtocolo(rs.getDate("DT_SAID_PRC"));
                protocoloGsv.setNomeFase(rs.getString("NM_FASE_PRC"));
                protocoloGsv.setDataEntradaProtocolo(rs.getDate("DT_ENTD_PRC"));
                protocoloGsv.setCodigoEtapa(rs.getInt("CD_ETP"));
                protocoloGsv.setIdentificador1(rs.getString("IDENTIFIC1"));
                protocoloGsv.setIdentificador2(rs.getString("IDENTIFIC2"));
                protocoloGsv.setIdentificador3(rs.getString("IDENTIFIC3"));
                protocoloGsv.setCodigoAtividade(rs.getInt("CD_TIP_ATVD"));
                protocoloGsv.setCodigoClasse(rs.getInt("CD_CLASSE_PRC"));
                protocoloGsv.setNomeEtapa(rs.getString("NM_ETP"));
                protocoloGsv.setNomeTipoProcesso(rs.getString("NM_TIP_PRC"));
                protocoloGsv.setNomeClasse(rs.getString("NM_CLASSE_PRC"));
                

                protocolos.add(protocoloGsv);

            }

            ConnectionFactory.fecharConexao();

            return protocolos;

        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao listar protocolos GSV", ex);
        } finally {
            ConnectionFactory.fecharConexao();

        }
    }

   

    public List<ProtocoloGsv> consultaPorParametro(int protocolo) throws ErroSistema {
       
        
        try {
            Connection con = ConnectionFactory.conectar("retab");
            String sql = "(SELECT T1.CD_PRC,T2.NM_AGRUP_PRC,t3.NM_TIP_ATVD,T1.CD_USU_FUN,\n" +
"                    t4.NM_FASE_PRC,T1.DT_ENTD_PRC,T1.DT_SAID_PRC,T1.CD_ETP,T1.IDENTIFIC1,\n" +
"                    T1.IDENTIFIC2,T1.IDENTIFIC3,T1.CD_TIP_ATVD,T1.CD_CLASSE_PRC,t5.NM_ETP,t6.NM_TIP_PRC,t7.NM_CLASSE_PRC\n" +
"                    FROM uso_dados.tb_prc_concl  as T1\n" +
"					left join uso_dados.tb_tip_agrup_prc as T2\n" +
"                       on T1.CD_AGRUP_PRC = T2.CD_AGRUP_PRC\n" +
"                    left join uso_dados.tb_tip_atvd as t3\n" +
"                    on T1.CD_TIP_ATVD =t3.CD_TIP_ATVD\n" +
"                    left join uso_dados.tb_tip_fase as t4\n" +
"                    on T1.CD_FASE_PRC=t4.CD_FASE_PRC\n" +
"                    left join uso_dados.tb_etp as t5\n" +
"                    ON T1.CD_ETP = t5.CD_ETP \n" +
"                    left join uso_dados.tb_tip_prc as t6\n" +
"                    on T1.CD_TIP_PRC = t6.CD_TIP_PRC\n" +
"                    left join uso_dados.tb_classe_prc as t7\n" +
"                    on T1.CD_ClASSE_PRC = t7.CD_CLASSE_PRC\n" +
"                     where T1.CD_PRC =? )" +
                    
"                    union \n" +
"                    (select T1.CD_PRC,T2.NM_AGRUP_PRC,t3.NM_TIP_ATVD,T1.CD_USU_FUN,t4.NM_FASE_PRC,\n" +
"                    T1.DT_ENTD_PRC,T1.DT_SAID_PRC,T1.CD_ETP,T1.IDENTIFIC1,\n" +
"                    T1.IDENTIFIC2,T1.IDENTIFIC3,T1.CD_TIP_ATVD,T1.CD_CLASSE_PRC,t5.NM_ETP,t6.NM_TIP_PRC,t7.NM_CLASSE_PRC\n" +
"                    from uso_dados.tb_prc as T1 \n" +
"                    left join uso_dados.tb_tip_agrup_prc as T2\n" +
"                     on T1.CD_AGRUP_PRC = T2.CD_AGRUP_PRC\n" +
"                      left join uso_dados.tb_tip_atvd as t3\n" +
"                    on T1.CD_TIP_ATVD =t3.CD_TIP_ATVD left join uso_dados.tb_tip_fase as t4\n" +
"                     on T1.CD_FASE_PRC=t4.CD_FASE_PRC\n" +
"                     left join uso_dados.tb_etp as t5\n" +
"                    ON T1.CD_ETP = t5.CD_ETP \n" +
"                    left join uso_dados.tb_tip_prc as t6\n" +
"                    on T1.CD_TIP_PRC = t6.CD_TIP_PRC\n" +
"                    left join uso_dados.tb_classe_prc as t7\n" +
"                    on T1.CD_ClASSE_PRC = t7.CD_CLASSE_PRC\n" +
"                    where T1.CD_PRC =?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, protocolo );
            stmt.setInt(2, protocolo);
            ResultSet rs = stmt.executeQuery();
            List<ProtocoloGsv> protocolos = new ArrayList<>();

            while (rs.next()) {

                ProtocoloGsv protocoloGsv = new ProtocoloGsv();

                protocoloGsv.setNumeroProtocolo(rs.getInt("CD_PRC"));
                protocoloGsv.setNomeProcesso(rs.getString("NM_AGRUP_PRC"));
                protocoloGsv.setNomeAtividade(rs.getString("NM_TIP_ATVD"));
                protocoloGsv.setFuncionarioResponsavel(rs.getString("CD_USU_FUN"));
                protocoloGsv.setDataSaidaProtocolo(rs.getDate("DT_SAID_PRC"));
                protocoloGsv.setNomeFase(rs.getString("NM_FASE_PRC"));
                protocoloGsv.setDataEntradaProtocolo(rs.getDate("DT_ENTD_PRC"));
                protocoloGsv.setCodigoEtapa(rs.getInt("CD_ETP"));
                protocoloGsv.setIdentificador1(rs.getString("IDENTIFIC1"));
                protocoloGsv.setIdentificador2(rs.getString("IDENTIFIC2"));
                protocoloGsv.setIdentificador3(rs.getString("IDENTIFIC3"));
                protocoloGsv.setCodigoAtividade(rs.getInt("CD_TIP_ATVD"));
                protocoloGsv.setCodigoClasse(rs.getInt("CD_CLASSE_PRC"));
                protocoloGsv.setNomeEtapa(rs.getString("NM_ETP"));
                protocoloGsv.setNomeTipoProcesso(rs.getString("NM_TIP_PRC"));
                protocoloGsv.setNomeClasse(rs.getString("NM_CLASSE_PRC"));
                
                protocolos.add(protocoloGsv);

            }

            ConnectionFactory.fecharConexao();

            return protocolos;

        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao listar protocolos GSV", ex);
        } finally {
            ConnectionFactory.fecharConexao();

        } 
    
    
    
    
    }

    @Override
    public void avocar(ProtocoloGsv entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean verAvocacao(ProtocoloGsv entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean avaliarParaSalvar(ProtocoloGsv entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean compararValor(ProtocoloGsv entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void priorizar(ProtocoloGsv entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void liberar(ProtocoloGsv entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public List<ProtocoloGsv> buscarPorParametro(ProtocoloGsv entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProtocoloGsv> buscarPorParametro(String parametro) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}