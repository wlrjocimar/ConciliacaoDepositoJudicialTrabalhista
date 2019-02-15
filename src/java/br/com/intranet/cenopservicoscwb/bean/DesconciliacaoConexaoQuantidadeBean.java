
package br.com.intranet.cenopservicoscwb.bean;

import br.com.intranet.cenopservicoscwb.dao.DesconciliacaoConexaoQuantidadeDAO;
import br.com.intranet.cenopservicoscwb.entity.Desconciliacao;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class DesconciliacaoConexaoQuantidadeBean  extends CrudBean<Desconciliacao, DesconciliacaoConexaoQuantidadeDAO>{
    private DesconciliacaoConexaoQuantidadeDAO desconciliacaoDAO;
    
    
   @PostConstruct
   public void init(){
       
       buscar();
       
       
   }
    
  
    
    @Override
    public DesconciliacaoConexaoQuantidadeDAO getDao() {
       if(desconciliacaoDAO == null){
            desconciliacaoDAO = new DesconciliacaoConexaoQuantidadeDAO();
        }
        return desconciliacaoDAO;
    }

    @Override
    public Desconciliacao criarNovaEntidade() {
      return new Desconciliacao();
    }
    
    
   
    
}
