
package br.com.intranet.cenopservicoscwb.bean;


import br.com.intranet.cenopservicoscwb.dao.DesconciliacaoPriorizadoDAO;
import br.com.intranet.cenopservicoscwb.entity.Desconciliacao;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class DesconciliacaoPriorizadoBean  extends CrudBean<Desconciliacao, DesconciliacaoPriorizadoDAO>{
    private DesconciliacaoPriorizadoDAO desconciliacaoDAO;
    
    
   @PostConstruct
   public void init(){
       
       buscar();
       
   }
    
  
    
    @Override
    public DesconciliacaoPriorizadoDAO getDao() {
       if(desconciliacaoDAO == null){
            desconciliacaoDAO = new DesconciliacaoPriorizadoDAO();
        }
        return desconciliacaoDAO;
    }

    @Override
    public Desconciliacao criarNovaEntidade() {
      return new Desconciliacao();
    }
 
   
    
}
