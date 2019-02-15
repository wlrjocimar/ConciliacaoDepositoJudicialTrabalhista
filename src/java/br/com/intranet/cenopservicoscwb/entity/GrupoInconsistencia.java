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
 * @author PC_LENOVO
 */
@Entity
@Table(name = "tb_grupo_inconsistencia")
@NamedQueries({
    @NamedQuery(name = "GrupoInconsistencia.findAll", query = "SELECT g FROM GrupoInconsistencia g")})
public class GrupoInconsistencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODIGO_INCONSISTENCIA")
    private Integer codigoInconsistencia;
    @Basic(optional = false)
    @Column(name = "NOME_INCONSISTENCIA")
    private String nomeInconsistencia;

    public GrupoInconsistencia() {
    }

    public GrupoInconsistencia(Integer codigoInconsistencia) {
        this.codigoInconsistencia = codigoInconsistencia;
    }

    public GrupoInconsistencia(Integer codigoInconsistencia, String nomeInconsistencia) {
        this.codigoInconsistencia = codigoInconsistencia;
        this.nomeInconsistencia = nomeInconsistencia;
    }

    public Integer getCodigoInconsistencia() {
        return codigoInconsistencia;
    }

    public void setCodigoInconsistencia(Integer codigoInconsistencia) {
        this.codigoInconsistencia = codigoInconsistencia;
    }

    public String getNomeInconsistencia() {
        return nomeInconsistencia;
    }

    public void setNomeInconsistencia(String nomeInconsistencia) {
        this.nomeInconsistencia = nomeInconsistencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoInconsistencia != null ? codigoInconsistencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoInconsistencia)) {
            return false;
        }
        GrupoInconsistencia other = (GrupoInconsistencia) object;
        if ((this.codigoInconsistencia == null && other.codigoInconsistencia != null) || (this.codigoInconsistencia != null && !this.codigoInconsistencia.equals(other.codigoInconsistencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.intranet.cenopservicoscwb.entity.GrupoInconsistencia[ codigoInconsistencia=" + codigoInconsistencia + " ]";
    }
    
}
