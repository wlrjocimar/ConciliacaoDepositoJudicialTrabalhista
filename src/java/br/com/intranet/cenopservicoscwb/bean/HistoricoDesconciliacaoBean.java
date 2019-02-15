/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intranet.cenopservicoscwb.bean;

import br.com.intranet.cenopservicoscwb.dao.HistoricoDesconciliacaoDAO;
import br.com.intranet.cenopservicoscwb.entity.HistoricoDesconciliacao;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author jocimar
 * 
 */
@ManagedBean
@SessionScoped
public class HistoricoDesconciliacaoBean extends CrudBean<HistoricoDesconciliacao, HistoricoDesconciliacaoDAO>{
     private HistoricoDesconciliacaoDAO historicoDesconciliacaoDAO;
    
     
     
      @PostConstruct

    public void init() {
        buscar();
    }
     
     
    @Override
    public HistoricoDesconciliacaoDAO getDao() {

                if(historicoDesconciliacaoDAO == null){
            historicoDesconciliacaoDAO = new HistoricoDesconciliacaoDAO();
        }
        return historicoDesconciliacaoDAO;

    }

    @Override
    public HistoricoDesconciliacao criarNovaEntidade() {

            return new HistoricoDesconciliacao();

    }
    
}
