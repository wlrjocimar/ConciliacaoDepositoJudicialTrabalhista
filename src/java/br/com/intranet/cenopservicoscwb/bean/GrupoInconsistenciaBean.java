package br.com.intranet.cenopservicoscwb.bean;

import br.com.intranet.cenopservicoscwb.dao.GrupoInconsistenciaDAO;
import br.com.intranet.cenopservicoscwb.entity.GrupoInconsistencia;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;






@SessionScoped
@ManagedBean
public class GrupoInconsistenciaBean extends CrudBean<GrupoInconsistencia, GrupoInconsistenciaDAO>{
private GrupoInconsistenciaDAO grupoInconsistenciaDAO;

@PostConstruct

public void init(){
    buscar();
}




    @Override
    public GrupoInconsistenciaDAO getDao() {
      
        if(grupoInconsistenciaDAO == null){
            grupoInconsistenciaDAO = new GrupoInconsistenciaDAO();
        }
        return grupoInconsistenciaDAO;
    }

    @Override
    public GrupoInconsistencia criarNovaEntidade() {
        
        return new GrupoInconsistencia();
        
        
    }
    
    
    
    
    
    
}
