
package br.com.intranet.cenopservicoscwb.bean;


import br.com.intranet.cenopservicoscwb.dao.DesconciliacaoTransferenciaDAO;
import br.com.intranet.cenopservicoscwb.entity.Desconciliacao;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class DesconciliacaoTransferenciaBean  extends CrudBean<Desconciliacao, DesconciliacaoTransferenciaDAO>{
    private DesconciliacaoTransferenciaDAO desconciliacaoDAO;
    
    
   @PostConstruct
   public void init(){
       
       buscar();
   }
    
  
    
    @Override
    public DesconciliacaoTransferenciaDAO getDao() {
       if(desconciliacaoDAO == null){
            desconciliacaoDAO = new DesconciliacaoTransferenciaDAO();
        }
        return desconciliacaoDAO;
    }

    @Override
    public Desconciliacao criarNovaEntidade() {
      return new Desconciliacao();
    }
    
    
   
    
}
