/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intranet.cenopservicoscwb.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author suporte
 */
@Entity
@Table(name = "tb_conexao")
@NamedQueries({
    @NamedQuery(name = "Conexao.findAll", query = "SELECT c FROM Conexao c")})
public class Conexao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private Integer codigo;
    @Column(name = "ORCADO")
    private Integer orcado;
    @Column(name = "REALIZADO")
    private Integer realizado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "INDICADOR")
    private Double indicador;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "ORCADO_COMPLEMENTAR")
    private Integer orcadoComplementar;

    public Conexao() {
    }

    public Conexao(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getOrcado() {
        return orcado;
    }

    public void setOrcado(Integer orcado) {
        this.orcado = orcado;
    }

    public Integer getRealizado() {
        return realizado;
    }

    public void setRealizado(Integer realizado) {
        this.realizado = realizado;
    }

    public Double getIndicador() {
        return indicador;
    }

    public void setIndicador(Double indicador) {
        this.indicador = indicador;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getOrcadoComplementar() {
        return orcadoComplementar;
    }

    public void setOrcadoComplementar(Integer orcadoComplementar) {
        this.orcadoComplementar = orcadoComplementar;
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
        if (!(object instanceof Conexao)) {
            return false;
        }
        Conexao other = (Conexao) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.intranet.cenopservicoscwb.entity.Conexao[ codigo=" + codigo + " ]";
    }
    
}
