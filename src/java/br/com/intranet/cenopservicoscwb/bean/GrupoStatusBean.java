/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intranet.cenopservicoscwb.bean;

import br.com.intranet.cenopservicoscwb.dao.GrupoStatusDAO;
import br.com.intranet.cenopservicoscwb.entity.GrupoStatus;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class GrupoStatusBean extends CrudBean<GrupoStatus, GrupoStatusDAO>{
    
 private GrupoStatusDAO grupoStatusDAO;   


 @PostConstruct

public void init(){
    buscar();
}

 
 
 
 
 
 
 
 
 
    @Override
    public GrupoStatusDAO getDao() {
        
        if(grupoStatusDAO == null){
            grupoStatusDAO = new GrupoStatusDAO();
        }
        return grupoStatusDAO;

    }

    @Override
    public GrupoStatus criarNovaEntidade() {
   
    return new GrupoStatus();
    }
    
    
    
    
}
