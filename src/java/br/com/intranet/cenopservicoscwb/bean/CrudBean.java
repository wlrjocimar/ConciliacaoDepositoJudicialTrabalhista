package br.com.intranet.cenopservicoscwb.bean;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import br.com.intranet.cenopservicoscwb.dao.CrudDAO;
import br.com.intranet.cenopservicoscwb.bean.util.ErroSistema;

public abstract class CrudBean<E, D extends CrudDAO> {

    private String estadoTela = "";
    private String tipoCargo = "naoGerencial";
    private String permissaoAcesso ="permitir";
    private String tipoTratamento = "tratamento";
    private String avocado = "nao";
    private String tabelaResgate="";
    private E entidade;
    private List<E> entidades;
    private int numeroRegistro = 0;
    private String parametro;

     public String getParametro() {
        return parametro;
    }

    public String getTabelaResgate() {
        return tabelaResgate;
    }

    public void setTabelaResgate(String tabelaResgate) {
        this.tabelaResgate = tabelaResgate;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }
    
    
    public int getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(int numeroRegistro) {
        this.numeroRegistro = entidades.size();
    }

    public void novo() {

        this.entidade = criarNovaEntidade();
        mudarParaInserir();

    }
    
    public void validarParaSalvar(){
        
            
        if (getDao().avaliarParaSalvar(entidade) == false){
        return;
        } else{
            salvar();
        
    }
            
     
        
    }
    
    public boolean  compararValor(){
        
        return getDao().compararValor(parametro);
        
    }
    
   
    
   
    

    public void salvar() {
        try {
            
            getDao().salvar(entidade);
            entidade = criarNovaEntidade();
            adicionarMensagem("Salvo com sucesso", FacesMessage.SEVERITY_INFO);
            mudarParaBuscar();
            buscar();                                                                                                                                                                                       
           
        } catch (ErroSistema ex) {
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagem(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
        }

    }
    
    
    
    public void verAvocacao(E entidade) throws ErroSistema{
         this.entidade = entidade;
        if(getDao().verAvocacao(entidade)==true){
            mudarParaAvocado();
           FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção!!!", "Registro já está sendo tratado.. selecione o próximo." ));
        }  else{
            setAvocado("nao");
            avocarRegistro(); 
            mudarParaEditar();
        }
        
        
    }
    
     public void avocarRegistro() throws ErroSistema{
         
         
         getDao().avocar(entidade);
         
         
         
     }
    
     
       public void priorizar(E entidade) throws ErroSistema{
         
         
         getDao().priorizar(entidade);
         
         
         
     }
       public void liberar(E entidade) throws ErroSistema{
         
         
        
         
         
          try {
            getDao().liberar(entidade);
            adicionarMensagem("Registro liberado com sucesso!!", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagem(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
         
         
         
         
     }
    

    public void editar(E entidade) throws ErroSistema {
        

        this.entidade = entidade;
        mudarParaEditar();
        

    }

    public String getTipoCargo() {
        return tipoCargo;
    }

    public void setTipoCargo(String tipoCargo) {
        this.tipoCargo = tipoCargo;
    }

    public String getTipoTratamento() {
        return tipoTratamento;
    }

    public void setTipoTratamento(String tipoTratamento) {
        this.tipoTratamento = tipoTratamento;
    }

    public String getAvocado() {
        return avocado;
    }

    public void setAvocado(String avocado) {
        this.avocado = avocado;
    }

    public void deletar(E entidade) {
        try {
            getDao().deletar(entidade);
            entidades.remove(entidade);
            adicionarMensagem("Excluído com sucesso", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagem(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
        }

    }

    public void buscar() {

        if (isBuscar() == false) {

            mudarParaBuscar();
           
           

        }

        try {
            entidades = getDao().buscar();
             setNumeroRegistro(entidades.size());

            if (entidades == null || entidades.size() < 1) {
                adicionarMensagem("Nenhum registro encontrado", FacesMessage.SEVERITY_WARN);

            }

        } catch (ErroSistema ex) {
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagem(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
        }

    }
    
    
    
     public void buscarPorParametro(E entidade) {

        

        try {
            entidades = getDao().buscarPorParametro(entidade);
             setNumeroRegistro(entidades.size());
              adicionarMensagem("Nenhum registro encontrado em busca por parametro", FacesMessage.SEVERITY_WARN);

            if (entidades == null || entidades.size() < 1) {
                adicionarMensagem("Nenhum registro encontrado em busca por parametro", FacesMessage.SEVERITY_WARN);

            }

        } catch (ErroSistema ex) {
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagem(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
        }

    }
     public void buscarPorParametro(String parametro) {
          
          mudarParaTabelaResgateVisivel();
        try {
             entidades = getDao().buscarPorParametro(parametro);
             setNumeroRegistro(entidades.size());
            
            if (entidades == null || entidades.size() < 1) {

            }

        } catch (ErroSistema ex) {
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagem(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
        }

    }


    public void adicionarMensagem(String mensagem, FacesMessage.Severity tipoErro) {
        FacesMessage fm = new FacesMessage(tipoErro, mensagem, null);
        FacesContext.getCurrentInstance().addMessage(null, fm);

    }

    // responsavel por criar os metodos nas classes bean    
    public abstract D getDao();

    public abstract E criarNovaEntidade();

    //métodos de controle de tela
    public Boolean isInserir() {
        return "inserir".equals(estadoTela);

    }
    public Boolean isVerResgate() {
        return "verResgate".equals(estadoTela);

    }
    
    public Boolean isPermitir() {
        return "permitir".equals(permissaoAcesso);

    }
    public Boolean isTabelaResgate() {
        return "visivel".equals(tabelaResgate);

    }
    
    public Boolean isAvocado() {
        return "sim".equals(avocado);

    }
    
    public Boolean isCargoGerencial(){
        return "gerencial".equals(tipoCargo);
    }
    
    public Boolean isNegar() {
        return "negar".equals(permissaoAcesso);

    }

    public void mudarParaPermitir() {
        permissaoAcesso = "permitido";
    }
    public void mudarParaTabelaResgateVisivel() {
        
        tabelaResgate = "visivel";
        
    }
    public void mudarParaVerRegate() {
        estadoTela = "verResgate";
    }
    public void mudarParaAvocado() {
        avocado = "sim";
    }
    public void mudarParaCargoGerencial() {
        tipoCargo = "gerencial";
    }
    
     public void mudarParaTratamento() {
        tipoTratamento = "tratamento";
    }
    
     
     public void mudarParaInconsistencia() {
        tipoTratamento = "inconsistencia";
    }
    
    
    
    public void mudarParaNegar() {
        permissaoAcesso = "negar";
    }

    public Boolean isEditar() {
        return "editar".equals(estadoTela);

    }
    
    
    public Boolean isInconsistencia() {
        buscar();
        return "inconsistencia".equals(tipoTratamento);

    }
    public Boolean isTratamento() {
        buscar();
        return "tratamento".equals(tipoTratamento);

    }

    public Boolean isBuscar() {
        return "buscar".equals(estadoTela);

    }
    public Boolean isPesquisar() {
        return "pesquisar".equals(estadoTela);

    }

    public void mudarParaInserir() {
        estadoTela = "inserir";
    }

    public void mudarParaEditar() {
        estadoTela = "editar";
        
    }

    public void mudarParaBuscar() {
        estadoTela = "buscar";
    }
    
    public void mudarParaInicial() {
        estadoTela = "";
    }
    
    public void mudarParaPesquisar(){
      estadoTela = "pesquisar";  
    }

    // getters e setters
    public String getEstadoTela() {
        return estadoTela;
    }

    public void setEstadoTela(String estadoTela) {
        this.estadoTela = estadoTela;
    }

    public E getEntidade() {
        return entidade;
    }

    public void setEntidade(E entidade) {
        this.entidade = entidade;
    }

    public List<E> getEntidades() {
        return entidades;
    }

    public void setEntidades(List<E> entidades) {
        this.entidades = entidades;
    }

    public String getPermissaoAcesso() {
        return permissaoAcesso;
    }

    public void setPermissaoAcesso(String permissaoAcesso) {
        this.permissaoAcesso = permissaoAcesso;
    }

}
