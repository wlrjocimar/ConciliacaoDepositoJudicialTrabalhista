
package br.com.intranet.cenopservicoscwb.bean;

import br.com.intranet.cenopservicoscwb.dao.DesconciliacaoNaoTratadaDAO;
import br.com.intranet.cenopservicoscwb.entity.Desconciliacao;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class DesconciliacaoNaoTratadaBean  extends CrudBean<Desconciliacao, DesconciliacaoNaoTratadaDAO>{
    private DesconciliacaoNaoTratadaDAO desconciliacaoDAO;
    
    
   @PostConstruct
   public void init(){
       
       buscar();
   }
    
  
    
    @Override
    public DesconciliacaoNaoTratadaDAO getDao() {
       if(desconciliacaoDAO == null){
            desconciliacaoDAO = new DesconciliacaoNaoTratadaDAO();
        }
        return desconciliacaoDAO;
    }

    @Override
    public Desconciliacao criarNovaEntidade() {
      return new Desconciliacao();
    }
    
    
   
    
}
