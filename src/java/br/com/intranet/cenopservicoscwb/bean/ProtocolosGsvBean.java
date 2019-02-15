
package br.com.intranet.cenopservicoscwb.bean;

import br.com.intranet.cenopservicoscwb.bean.util.ErroSistema;
import br.com.intranet.cenopservicoscwb.dao.ProtocoloGsvDAO;
import br.com.intranet.cenopservicoscwb.entity.ProtocoloGsv;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class ProtocolosGsvBean extends CrudBean<ProtocoloGsv, ProtocoloGsvDAO>{
    private int protocolo = 0;
    private List<ProtocoloGsv>  protocolos;
    private ProtocoloGsvDAO protocoloGsvDAO;
    
   
    
    
    @Override
    public ProtocoloGsvDAO getDao() {
        
        if(protocoloGsvDAO == null){
            protocoloGsvDAO = new ProtocoloGsvDAO();
        }
        return protocoloGsvDAO;
      
    }

    @Override
    public ProtocoloGsv criarNovaEntidade() {
     return new ProtocoloGsv();
    }
   
    
    
    
    public void consultarPorParametro() {
        
        if (isPesquisar()== false) {

            mudarParaPesquisar();
            return;

        }

        try {
            protocolos = getDao().consultaPorParametro(protocolo);

            if (protocolos == null || protocolos.size() < 1) {
                adicionarMensagem("Não localizado o protocolo " +  this.protocolo , FacesMessage.SEVERITY_WARN);

            }

        } catch (ErroSistema ex) {
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagem(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
        }

    }

    public int getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(int protocolo) {
        this.protocolo = protocolo;
    }

    public List<ProtocoloGsv> getProtocolos() {
        return protocolos;
    }

    public void setProtocolos(List<ProtocoloGsv> protocolos) {
        this.protocolos = protocolos;
    }

    public ProtocoloGsvDAO getProtocoloGsvDAO() {
        return protocoloGsvDAO;
    }

    public void setProtocoloGsvDAO(ProtocoloGsvDAO protocoloGsvDAO) {
        this.protocoloGsvDAO = protocoloGsvDAO;
    }
    
    
    public void novoProtocolo() {

        
        mudarParaPesquisar();

    }
    
    
    
    
}
