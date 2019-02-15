/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intranet.cenopservicoscwb.bean;

import br.com.intranet.cenopservicoscwb.dao.ConexaoDAO;
import br.com.intranet.cenopservicoscwb.entity.Conexao;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author suporte
 * 
 * 
 */

@ManagedBean
@SessionScoped
public class ConexaoBean extends CrudBean<Conexao, ConexaoDAO>{
    
    private ConexaoDAO conexaoDAO;
    
    
    @PostConstruct
    public void init(){
        buscar();
    }
    
    
    

    @Override
    public ConexaoDAO getDao() {
     
          if(conexaoDAO == null){
            conexaoDAO = new ConexaoDAO();
        }
        return conexaoDAO;
        
        
    }

    @Override
    public Conexao criarNovaEntidade() {

    return  new Conexao();

    }
    
}
