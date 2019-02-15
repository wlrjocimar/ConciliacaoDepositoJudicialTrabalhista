/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intranet.cenopservicoscwb.bean;

import br.com.intranet.cenopservicoscwb.dao.AtividadeDAO;
import br.com.intranet.cenopservicoscwb.dao.CrudDAO;
import br.com.intranet.cenopservicoscwb.entity.Atividade;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class AtividadeBean extends CrudBean<Atividade, CrudDAO>{

    private AtividadeDAO atividadeDAO;
    
    
     @PostConstruct
 
 public void init(){
    
  
     buscar();
     
     
     
     
 }
 
    
    
    
    
    
    @Override
    public CrudDAO getDao() {
        if(atividadeDAO == null){
            atividadeDAO = new AtividadeDAO();
        }
        return atividadeDAO;
        
        
        
        
        
         }

    @Override
    public Atividade criarNovaEntidade() {
        return new Atividade();
    }
    
}
