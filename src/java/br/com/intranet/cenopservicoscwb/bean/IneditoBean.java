/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intranet.cenopservicoscwb.bean;

import br.com.intranet.cenopservicoscwb.dao.IneditoDAO;
import br.com.intranet.cenopservicoscwb.entity.Inedito;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author jocimar
 */
@ManagedBean
@SessionScoped
public class IneditoBean extends CrudBean<Inedito, IneditoDAO>{
    private IneditoDAO ineditoDAO;
    
    @PostConstruct
    public void init(){
        novo();
    }

    
    
    
    @Override
    public IneditoDAO getDao() {
            if(ineditoDAO == null){
            ineditoDAO = new IneditoDAO();
        }
        return ineditoDAO;


    }

    @Override
    public Inedito criarNovaEntidade() {
        return new Inedito();

    }
    
}
