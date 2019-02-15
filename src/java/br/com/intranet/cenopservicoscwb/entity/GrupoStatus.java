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
 * @author jocimar
 */
@Entity
@Table(name = "tb_grupo_status")
@NamedQueries({
    @NamedQuery(name = "GrupoStatus.findAll", query = "SELECT g FROM GrupoStatus g")})
public class GrupoStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODIGO_STATUS")
    private Integer codigoStatus;
    @Basic(optional = false)
    @Column(name = "NOME_STATUS")
    private String nomeStatus;

    public GrupoStatus() {
    }

    public GrupoStatus(Integer codigoStatus) {
        this.codigoStatus = codigoStatus;
    }

    public GrupoStatus(Integer codigoStatus, String nomeStatus) {
        this.codigoStatus = codigoStatus;
        this.nomeStatus = nomeStatus;
    }

    public Integer getCodigoStatus() {
        return codigoStatus;
    }

    public void setCodigoStatus(Integer codigoStatus) {
        this.codigoStatus = codigoStatus;
    }

    public String getNomeStatus() {
        return nomeStatus;
    }

    public void setNomeStatus(String nomeStatus) {
        this.nomeStatus = nomeStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoStatus != null ? codigoStatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoStatus)) {
            return false;
        }
        GrupoStatus other = (GrupoStatus) object;
        if ((this.codigoStatus == null && other.codigoStatus != null) || (this.codigoStatus != null && !this.codigoStatus.equals(other.codigoStatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.intranet.cenopservicoscwb.entity.GrupoStatus[ codigoStatus=" + codigoStatus + " ]";
    }
    
}
