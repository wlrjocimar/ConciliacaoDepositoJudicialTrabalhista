
package br.com.intranet.cenopservicoscwb.bean;

import br.com.intranet.cenopservicoscwb.dao.DesconciliacaoDAO;
import br.com.intranet.cenopservicoscwb.dao.DesconciliacaoRetornoAgenciaAcimaDAO;
import br.com.intranet.cenopservicoscwb.dao.DesconciliacaoRetornoAgenciaDAO;
import br.com.intranet.cenopservicoscwb.entity.Desconciliacao;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class DesconciliacaoRetornoAgenciaAcimaBean  extends CrudBean<Desconciliacao, DesconciliacaoRetornoAgenciaAcimaDAO>{
    private DesconciliacaoRetornoAgenciaAcimaDAO desconciliacaoDAO;
    
    
   @PostConstruct
   public void init(){
       
       buscar();
   }
    
  
    
    @Override
    public DesconciliacaoRetornoAgenciaAcimaDAO getDao() {
       if(desconciliacaoDAO == null){
            desconciliacaoDAO = new DesconciliacaoRetornoAgenciaAcimaDAO();
        }
        return desconciliacaoDAO;
    }

    @Override
    public Desconciliacao criarNovaEntidade() {
      return new Desconciliacao();
    }
    
    
   
    
}
