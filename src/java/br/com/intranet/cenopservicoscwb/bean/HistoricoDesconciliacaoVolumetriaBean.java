/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intranet.cenopservicoscwb.bean;

import br.com.intranet.cenopservicoscwb.dao.HistoricoDesconciliacaoVolumetriaDAO;
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
public class HistoricoDesconciliacaoVolumetriaBean extends CrudBean<HistoricoDesconciliacao, HistoricoDesconciliacaoVolumetriaDAO>{
     private HistoricoDesconciliacaoVolumetriaDAO historicoDesconciliacaoDAO;
  
     
     
     
    @Override
    public HistoricoDesconciliacaoVolumetriaDAO getDao() {

                if(historicoDesconciliacaoDAO == null){
            historicoDesconciliacaoDAO = new HistoricoDesconciliacaoVolumetriaDAO();
        }
        return historicoDesconciliacaoDAO;

    }

    @Override
    public HistoricoDesconciliacao criarNovaEntidade() {

            return new HistoricoDesconciliacao();

    }
    
}
