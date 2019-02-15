/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intranet.cenopservicoscwb.bean;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

@ManagedBean
@SessionScoped
public class UploadBean implements Serializable{
   
    private Part file ; 
    private String fileName;
    
    private Long tamanhoArquivo ;
    
    
    
    public void upload(){
         try(InputStream is = file.getInputStream()){
            
            
           this.fileName = file.getSubmittedFileName();
           this.tamanhoArquivo=file.getSize();
           
            
           Files.copy(is, new File("\\\\172.20.0.33\\jsp$\\docsfiscal\\REJUD",fileName).toPath());

           FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Arquivo enviado com sucesso!!", "");
            FacesContext.getCurrentInstance().addMessage(null, mensagem);
           
        } catch(IOException ex){
          ex.printStackTrace();
        }
    
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public Long getTamanhoArquivo() {
        return tamanhoArquivo;
    }

    public void setTamanhoArquivo(Long tamanhoArquivo) {
        this.tamanhoArquivo = tamanhoArquivo;
    }

   
    
    
    
}
