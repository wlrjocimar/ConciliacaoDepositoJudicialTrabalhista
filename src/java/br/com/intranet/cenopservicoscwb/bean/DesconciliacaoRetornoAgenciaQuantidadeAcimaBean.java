
package br.com.intranet.cenopservicoscwb.bean;

import br.com.intranet.cenopservicoscwb.dao.DesconciliacaoDAO;
import br.com.intranet.cenopservicoscwb.dao.DesconciliacaoRetornoAcimaQuantidadeDAO;
import br.com.intranet.cenopservicoscwb.dao.DesconciliacaoRetornoAgenciaDAO;
import br.com.intranet.cenopservicoscwb.dao.DesconciliacaoRetornoQuandidade;
import br.com.intranet.cenopservicoscwb.entity.Desconciliacao;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class DesconciliacaoRetornoAgenciaQuantidadeAcimaBean  extends CrudBean<Desconciliacao, DesconciliacaoRetornoAcimaQuantidadeDAO>{
    private DesconciliacaoRetornoAcimaQuantidadeDAO desconciliacaoDAO;
    
    
   @PostConstruct
   public void init(){
       
       buscar();
   }
    
  
    
    @Override
    public DesconciliacaoRetornoAcimaQuantidadeDAO getDao() {
       if(desconciliacaoDAO == null){
            desconciliacaoDAO = new DesconciliacaoRetornoAcimaQuantidadeDAO();
        }
        return desconciliacaoDAO;
    }

    @Override
    public Desconciliacao criarNovaEntidade() {
      return new Desconciliacao();
    }
    
    
   
    
}
