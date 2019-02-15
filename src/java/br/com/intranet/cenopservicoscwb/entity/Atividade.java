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
@Table(name = "tb_atividade")
@NamedQueries({
    @NamedQuery(name = "Atividade.findAll", query = "SELECT a FROM Atividade a")})
public class Atividade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODIGO_ATIVIDADE")
    private Integer codigoAtividade;
    @Basic(optional = false)
    @Column(name = "NOME_ATIVIDADE")
    private String nomeAtividade;

    public Atividade() {
    }

    public Atividade(Integer codigoAtividade) {
        this.codigoAtividade = codigoAtividade;
    }

    public Atividade(Integer codigoAtividade, String nomeAtividade) {
        this.codigoAtividade = codigoAtividade;
        this.nomeAtividade = nomeAtividade;
    }

    public Integer getCodigoAtividade() {
        return codigoAtividade;
    }

    public void setCodigoAtividade(Integer codigoAtividade) {
        this.codigoAtividade = codigoAtividade;
    }

    public String getNomeAtividade() {
        return nomeAtividade;
    }

    public void setNomeAtividade(String nomeAtividade) {
        this.nomeAtividade = nomeAtividade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoAtividade != null ? codigoAtividade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Atividade)) {
            return false;
        }
        Atividade other = (Atividade) object;
        if ((this.codigoAtividade == null && other.codigoAtividade != null) || (this.codigoAtividade != null && !this.codigoAtividade.equals(other.codigoAtividade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.intranet.cenopservicoscwb.entity.Atividade[ codigoAtividade=" + codigoAtividade + " ]";
    }
    
}
