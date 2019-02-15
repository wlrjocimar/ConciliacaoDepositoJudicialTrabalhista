
package br.com.intranet.cenopservicoscwb.bean;

import br.com.intranet.cenopservicoscwb.dao.DesconciliacaoDAO;
import br.com.intranet.cenopservicoscwb.dao.DesconciliacaoRetornoAgenciaDAO;
import br.com.intranet.cenopservicoscwb.dao.DesconciliacaoRetornoQuandidade;
import br.com.intranet.cenopservicoscwb.entity.Desconciliacao;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class DesconciliacaoRetornoAgenciaQuantidadeBean  extends CrudBean<Desconciliacao, DesconciliacaoRetornoQuandidade>{
    private DesconciliacaoRetornoQuandidade desconciliacaoDAO;
    
    
   @PostConstruct
   public void init(){
       
       buscar();
   }
    
  
    
    @Override
    public DesconciliacaoRetornoQuandidade getDao() {
       if(desconciliacaoDAO == null){
            desconciliacaoDAO = new DesconciliacaoRetornoQuandidade();
        }
        return desconciliacaoDAO;
    }

    @Override
    public Desconciliacao criarNovaEntidade() {
      return new Desconciliacao();
    }
    
    
   
    
}
