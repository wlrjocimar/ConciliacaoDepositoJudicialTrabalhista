package br.com.intranet.cenopservicoscwb.bean;




import br.com.intranet.cenopservicoscwb.bean.*;
import br.com.intranet.cenopservicoscwb.dao.VolumetriaDAO;
import br.com.intranet.cenopservicoscwb.entity.Volumetria;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class VolumetriaBean  extends CrudBean<Volumetria, VolumetriaDAO>{
    private VolumetriaDAO volumetriaDAO;
    
    
   @PostConstruct
   public void init(){
       
       buscar();
       
       
   }
    
  
    
    @Override
    public VolumetriaDAO getDao() {
       if(volumetriaDAO == null){
            volumetriaDAO = new VolumetriaDAO();
        }
        return volumetriaDAO;
    }

    @Override
    public Volumetria criarNovaEntidade() {
      return new Volumetria();
    }
    
    
   
    
}
