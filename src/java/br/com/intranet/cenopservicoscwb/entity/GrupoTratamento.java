/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intranet.cenopservicoscwb.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author suporte
 */
@Entity
@Table(name = "tb_grupo_tratamento")
@NamedQueries({
    @NamedQuery(name = "GrupoTRatamento.findAll", query = "SELECT g FROM GrupoTRatamento g")})
public class GrupoTratamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODIGO_TRATAMENTO")
    private Integer codigoTratamento;
    @Basic(optional = false)
    @Column(name = "NOME_TRATAMENTO")
    private String nomeTratamento;

    public GrupoTratamento() {
    }

    public GrupoTratamento(Integer codigoTratamento) {
        this.codigoTratamento = codigoTratamento;
    }

    public GrupoTratamento(Integer codigoTratamento, String nomeTratamento) {
        this.codigoTratamento = codigoTratamento;
        this.nomeTratamento = nomeTratamento;
    }

    public Integer getCodigoTratamento() {
        return codigoTratamento;
    }

    public void setCodigoTratamento(Integer codigoTratamento) {
        this.codigoTratamento = codigoTratamento;
    }

    public String getNomeTratamento() {
        return nomeTratamento;
    }

    public void setNomeTratamento(String nomeTratamento) {
        this.nomeTratamento = nomeTratamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoTratamento != null ? codigoTratamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoTratamento)) {
            return false;
        }
        GrupoTratamento other = (GrupoTratamento) object;
        if ((this.codigoTratamento == null && other.codigoTratamento != null) || (this.codigoTratamento != null && !this.codigoTratamento.equals(other.codigoTratamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.intranet.cenopservicoscwb.entity.GrupoTRatamento[ codigoTratamento=" + codigoTratamento + " ]";
    }
    
}
