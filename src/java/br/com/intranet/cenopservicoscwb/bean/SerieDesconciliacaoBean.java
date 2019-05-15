
package br.com.intranet.cenopservicoscwb.bean;

import br.com.intranet.cenopservicoscwb.dao.SerieDesconciliacaoDAO;
import br.com.intranet.cenopservicoscwb.entity.SerieDesconciliacao;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean
public class SerieDesconciliacaoBean  extends CrudBean<SerieDesconciliacao, SerieDesconciliacaoDAO>{
    private SerieDesconciliacaoDAO desconciliacaoDAO;
    
    
   @PostConstruct
   public void init(){
       
       mudarParaBuscar();
       buscar();
   }
    
  
    
    @Override
    public SerieDesconciliacaoDAO getDao() {
       if(desconciliacaoDAO == null){
            desconciliacaoDAO = new SerieDesconciliacaoDAO();
        }
        return desconciliacaoDAO;
    }

    @Override
    public SerieDesconciliacao criarNovaEntidade() {
      return new SerieDesconciliacao();
    }
    
    
   
    
}
