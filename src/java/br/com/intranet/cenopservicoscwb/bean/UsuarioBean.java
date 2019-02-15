
package br.com.intranet.cenopservicoscwb.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import br.com.intranet.cenopservicoscwb.dao.UsuarioDAO;
import br.com.intranet.cenopservicoscwb.entity.Usuario;
import javax.annotation.PostConstruct;
@SessionScoped
@ManagedBean
public class UsuarioBean  extends CrudBean<Usuario, UsuarioDAO>{
    
    private UsuarioDAO usuarioDAO;

    
    @PostConstruct
 
 public void init(){
    
  
     buscar();
     
     
     
     
 }
 
    
    
    
    
    @Override
    public UsuarioDAO getDao() {
        if(usuarioDAO == null){
            usuarioDAO = new UsuarioDAO();
        }
        return usuarioDAO;
        
    }

    @Override
    public Usuario criarNovaEntidade() {
        return new Usuario();
    
    }
    
}
