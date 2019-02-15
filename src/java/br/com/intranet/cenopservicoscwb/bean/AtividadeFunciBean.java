/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intranet.cenopservicoscwb.bean;

import br.com.intranet.cenopservicoscwb.dao.AtividadeFunciDAO;
import br.com.intranet.cenopservicoscwb.entity.AtividadeFunci;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class AtividadeFunciBean  extends CrudBean<AtividadeFunci, AtividadeFunciDAO>{
    
    private AtividadeFunciDAO atividadeFunciDAO;
    

    
    
@PostConstruct
 
 public void init(){
    
  
     buscar();
     
     
     
     
 }
 
    
    

    @Override
    public AtividadeFunciDAO getDao() {
    
     if(atividadeFunciDAO == null){
            atividadeFunciDAO = new AtividadeFunciDAO();
        }
        return atividadeFunciDAO;
    
    
    
    }

    @Override
    public AtividadeFunci criarNovaEntidade() {
        
        
        return new AtividadeFunci();
        
        
    }
    
}
