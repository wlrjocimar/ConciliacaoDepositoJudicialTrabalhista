
package br.com.intranet.cenopservicoscwb.bean;

import br.com.intranet.cenopservicoscwb.dao.FuncionarioDAO;
import br.com.intranet.cenopservicoscwb.entity.AtividadeFunci;
import br.com.intranet.cenopservicoscwb.entity.Funcionario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@SessionScoped
@ManagedBean
public class FuncionarioBean extends CrudBean<Funcionario, FuncionarioDAO>{
    
    private FuncionarioDAO funcionarioDAO;
    
 
    
    
    
    
    
    
    
    
   
    FacesContext fc = FacesContext.getCurrentInstance();
    HttpSession session = (HttpSession)fc.getExternalContext().getSession(false);
    
    Funcionario usuario = (Funcionario) session.getAttribute("usuarioLogado");
    AtividadeFunci atividadeFunci = (AtividadeFunci) session.getAttribute("funciAtividade");
    
    
    @PostConstruct // teste para executar instrução ao iniciar ete bean
    public void init(){
        
            if(usuario.getFuncao()== 4750 || usuario.getFuncao()== 4438 || usuario.getFuncao()== 4750 || 
                    usuario.getFuncao()== 4665 || usuario.getFuncao()== 4072  || 
                    usuario.getChave().equals("F0423403") || usuario.getChave().equals("F4281065") ||atividadeFunci.getCodigoAtividade()==6 ){
                
                mudarParaCargoGerencial();
                
            }
            
            
            
            if(usuario.getUORPosicao() !=  286409 && usuario.getUORPosicao() !=  287339  && usuario.getUORPosicao() !=  286399 && usuario.getUORPosicao() !=  284646   && usuario.getUORPosicao() !=  454062  && usuario.getUORPosicao() !=  10544 && usuario.getUORPosicao() !=  79771 && usuario.getUORPosicao() != 286369  ){
                
                try {
                   FacesContext.getCurrentInstance().getExternalContext().redirect("sem-acesso.jsf");
                   mudarParaNegar();
               } catch (IOException ex) {
                   Logger.getLogger(FuncionarioBean.class.getName()).log(Level.SEVERE, null, ex);
               }
               
                
            }
         
           
           if(usuario.getChave().equals("")){
               try {
                   FacesContext.getCurrentInstance().getExternalContext().redirect("sem-acesso.jsf");
                   mudarParaNegar();
               } catch (IOException ex) {
                   Logger.getLogger(FuncionarioBean.class.getName()).log(Level.SEVERE, null, ex);
               }
               
           }
           
    }
    
    
    
    
    
    
    
    
    
    
    public String getPermissao(){
      return null;  
    }
    
    
    
    
    
    
    public String getFunciLogado() {
    
    String matricula = usuario.getChave();
    return "http://connections.bb.com.br/profiles/photo.do?uid=" + matricula;
        

 }
    
    public String getNomeInteiro(){
        
         String nome = usuario.getNome();
        return  nome;
    }
    
    
   
    public String getNomeAbreviado(){
        
         String nomeGerra = usuario.getNomeGuerra();
         return  nomeGerra;
    }
    
    
    public String getChave(){
        String chave = usuario.getChave();
        return chave;
    }
    
    
    public String getGerente(){
        String gerente = usuario.getGerente();
        return gerente;
    }

    
    public int getUor(){
        int uor =  usuario.getUORHabitual();
         return uor;
        
    }
    
    
    public String getFuncao(){
        String funcao = usuario.getNomeFuncao();
        
        return funcao;
    }
    
    public int codigoFuncao(){
        int codigoFuncao = usuario.getFuncao();
        return codigoFuncao;
    }
   

    @Override
    public Funcionario criarNovaEntidade() {
       return new Funcionario();
    }

    @Override
    public FuncionarioDAO getDao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    
    
    


    
    
    
    
    
    
    
    
    
}
