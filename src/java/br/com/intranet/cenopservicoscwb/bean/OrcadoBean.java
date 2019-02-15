/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intranet.cenopservicoscwb.bean;

import br.com.intranet.cenopservicoscwb.dao.CrudDAO;
import br.com.intranet.cenopservicoscwb.dao.EfetivacaoDAO;
import br.com.intranet.cenopservicoscwb.dao.OrcadoDAO;
import br.com.intranet.cenopservicoscwb.entity.Orcado;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author jocimar
 */
@ManagedBean
@SessionScoped
public class OrcadoBean extends  CrudBean<Orcado, OrcadoDAO>{
      private OrcadoDAO orcadoDAO; 
    
      
      
   @PostConstruct
   public void init(){
       
       buscar();
   }
      
      
      
    
    @Override
    public OrcadoDAO getDao() {
     if (orcadoDAO == null) {
            orcadoDAO = new OrcadoDAO();
        }
        return orcadoDAO;
    
    
    }

    @Override
    public Orcado criarNovaEntidade() {
     return new Orcado();
    
    }
    
}
