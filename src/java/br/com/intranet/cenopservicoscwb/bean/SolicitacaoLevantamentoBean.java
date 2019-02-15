/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intranet.cenopservicoscwb.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import br.com.intranet.cenopservicoscwb.dao.SolicitacaoLevantamentoDAO;
import br.com.intranet.cenopservicoscwb.entity.SolicitacaoLevantamento;
import java.util.List;

@SessionScoped
@ManagedBean
public class SolicitacaoLevantamentoBean extends CrudBean<SolicitacaoLevantamento, SolicitacaoLevantamentoDAO>{
    
    
      
    
    private List<SolicitacaoLevantamento>  levantamentos;
    


    public List<SolicitacaoLevantamento> getLevantamentos() {
        return levantamentos;
    }

    public void setLevantamentos(List<SolicitacaoLevantamento> levantamentos) {
        this.levantamentos = levantamentos;
    }

    public SolicitacaoLevantamentoDAO getSolicitacaoLevantamentoDAO() {
        return solicitacaoLevantamentoDAO;
    }

    public void setSolicitacaoLevantamentoDAO(SolicitacaoLevantamentoDAO solicitacaoLevantamentoDAO) {
        this.solicitacaoLevantamentoDAO = solicitacaoLevantamentoDAO;
    }
    private SolicitacaoLevantamentoDAO solicitacaoLevantamentoDAO;
    
     
    
    
    
    
    
    
    
    
    
   
    @Override
    public SolicitacaoLevantamento criarNovaEntidade() {
        return new SolicitacaoLevantamento();
    }

  
    
    @Override
    public SolicitacaoLevantamentoDAO getDao() {
       if(solicitacaoLevantamentoDAO == null){
            solicitacaoLevantamentoDAO = new SolicitacaoLevantamentoDAO();
        }
        return solicitacaoLevantamentoDAO;
    }
    
}
