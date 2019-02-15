
package br.com.intranet.cenopservicoscwb.bean;

import br.com.intranet.cenopservicoscwb.dao.DesconciliacaoNovosAcimaQuantidadeDAO;
import br.com.intranet.cenopservicoscwb.dao.DesconciliacaoNovosQuantidadeDAO;
import br.com.intranet.cenopservicoscwb.entity.Desconciliacao;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class DesconciliacaoNovosAcimaQuantidadeBean  extends CrudBean<Desconciliacao, DesconciliacaoNovosAcimaQuantidadeDAO>{
    private DesconciliacaoNovosAcimaQuantidadeDAO desconciliacaoDAO;
    
    
   @PostConstruct
   public void init(){
       
       buscar();
       
       
   }
    
  
    
    @Override
    public DesconciliacaoNovosAcimaQuantidadeDAO getDao() {
       if(desconciliacaoDAO == null){
            desconciliacaoDAO = new DesconciliacaoNovosAcimaQuantidadeDAO();
        }
        return desconciliacaoDAO;
    }

    @Override
    public Desconciliacao criarNovaEntidade() {
      return new Desconciliacao();
    }
    
    
   
    
}
