/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intranet.cenopservicoscwb.bean;

import br.com.intranet.cenopservicoscwb.dao.HistoricoIndividualDesconciliacaoDAO;
import br.com.intranet.cenopservicoscwb.entity.HistoricoDesconciliacao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author jocimar
 * 
 */
@ManagedBean
@SessionScoped
public class HistoricoIndividualDesconciliacaoBean extends CrudBean<HistoricoDesconciliacao, HistoricoIndividualDesconciliacaoDAO>{
     private HistoricoIndividualDesconciliacaoDAO historicoDesconciliacaoDAO;
    
    @Override
    public HistoricoIndividualDesconciliacaoDAO getDao() {

                if(historicoDesconciliacaoDAO == null){
            historicoDesconciliacaoDAO = new HistoricoIndividualDesconciliacaoDAO();
        }
        return historicoDesconciliacaoDAO;

    }

    @Override
    public HistoricoDesconciliacao criarNovaEntidade() {

            return new HistoricoDesconciliacao();

    }
    
}
