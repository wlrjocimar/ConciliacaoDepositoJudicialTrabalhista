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
@Table(name = "tb_atividade_funci")
@NamedQueries({
    @NamedQuery(name = "AtividadeFunci.findAll", query = "SELECT a FROM AtividadeFunci a")})
public class AtividadeFunci implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "MATRICULA")
    private String matricula;
    @Basic(optional = false)
    @Column(name = "CODIGO_ATIVIDADE")
    private int codigoAtividade;

    public AtividadeFunci() {
    }

    public AtividadeFunci(Integer codigo) {
        this.codigo = codigo;
    }

    public AtividadeFunci(Integer codigo, String matricula, int codigoAtividade) {
        this.codigo = codigo;
        this.matricula = matricula;
        this.codigoAtividade = codigoAtividade;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getCodigoAtividade() {
        return codigoAtividade;
    }

    public void setCodigoAtividade(int codigoAtividade) {
        this.codigoAtividade = codigoAtividade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AtividadeFunci)) {
            return false;
        }
        AtividadeFunci other = (AtividadeFunci) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.intranet.cenopservicoscwb.entity.AtividadeFunci[ codigo=" + codigo + " ]";
    }
    
}
