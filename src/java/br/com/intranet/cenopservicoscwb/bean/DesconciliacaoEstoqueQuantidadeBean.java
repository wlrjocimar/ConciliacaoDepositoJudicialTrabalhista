
package br.com.intranet.cenopservicoscwb.bean;

import br.com.intranet.cenopservicoscwb.dao.DesconciliacaoEstoqueDAO;
import br.com.intranet.cenopservicoscwb.dao.DesconciliacaoEstoqueQuantidadeDAO;
import br.com.intranet.cenopservicoscwb.entity.Desconciliacao;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class DesconciliacaoEstoqueQuantidadeBean  extends CrudBean<Desconciliacao, DesconciliacaoEstoqueQuantidadeDAO>{
    private DesconciliacaoEstoqueQuantidadeDAO desconciliacaoDAO;
    
    
   @PostConstruct
   public void init(){
       
       buscar();
       
       
   }
    
  
    
    @Override
    public DesconciliacaoEstoqueQuantidadeDAO getDao() {
       if(desconciliacaoDAO == null){
            desconciliacaoDAO = new DesconciliacaoEstoqueQuantidadeDAO();
        }
        return desconciliacaoDAO;
    }

    @Override
    public Desconciliacao criarNovaEntidade() {
      return new Desconciliacao();
    }
    
    
   
    
}
