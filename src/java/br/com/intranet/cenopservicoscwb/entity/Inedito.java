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
 * @author jocimar
 */
@Entity
@Table(name = "tb_inedito")
@NamedQueries({
    @NamedQuery(name = "Inedito.findAll", query = "SELECT i FROM Inedito i")})
public class Inedito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "VL_RSGT")
    private String vlRsgt;
    @Column(name = "NPJ")
    private String npj;
    @Column(name = "VARIACAO_NPJ")
    private Integer variacaoNpj = 0;
    @Column(name = "NR_OFICIO")
    private String nrOficio;
    @Column(name = "CONTA_DEPOSITARIA")
    private String contaDepositaria;
    @Column(name = "SITUACAO_RESGATE_SISBB")
    private String situacaoResgateSisbb;
    @Column(name = "SITUACAO_RESGATE_PORTAL")
    private String situacaoResgatePortal;
    @Column(name = "DEPENDENCIA_OPRD")
    private Integer dependenciaOprd;
    @Column(name = "DEPENDENCIA_DTRA")
    private Integer dependenciaDtra;
    @Column(name = "FUNCIONARIO_RESPONSAVEL_SOLICITACAO")
    private String funcionarioResponsavelSolicitacao;
    @Column(name = "TIPO_DESTINACAO")
    private String tipoDestinacao;
    @Column(name = "DATA_SOLICITACAO")
    @Temporal(TemporalType.DATE)
    private Date dataSolicitacao;
    @Column(name = "FUNCIONARIO_RESPONSAVEL_INCLUSAO")
    private String funcionarioResponsavelInclusao;
    @Column(name = "DATA_INCLUSAO")
    @Temporal(TemporalType.DATE)
    private Date dataInclusao;
    @Column(name = "OBS_COMPLEMENTAR")
    private String obsComplementar;
    @Column(name = "OBS_TRATAR")
    private String obsTratar;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SALDO_CONTA_DEPOSITARIA")
    private Double saldoContaDepositaria;
    @Column(name = "DATA_SALDO")
    @Temporal(TemporalType.DATE)
    private Date dataSaldo;
    @Column(name = "OBS_COLETA_DTRA")
    private String obsColetaDtra;
    @Column(name = "SALDO_PORTAL")
    private Double saldoPortal;

    public Inedito() {
    }

    public Inedito(Integer codigo) {
        this.codigo = codigo;
    }

    public Inedito(Integer codigo, String vlRsgt) {
        this.codigo = codigo;
        this.vlRsgt = vlRsgt;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getVlRsgt() {
        return vlRsgt;
    }

    public void setVlRsgt(String vlRsgt) {
        this.vlRsgt = vlRsgt;
    }

    public String getNpj() {
        return npj;
    }

    public void setNpj(String npj) {
        this.npj = npj;
    }

    public Integer getVariacaoNpj() {
        return variacaoNpj;
    }

    public void setVariacaoNpj(Integer variacaoNpj) {
        this.variacaoNpj = variacaoNpj;
    }

    public String getNrOficio() {
        return nrOficio;
    }

    public void setNrOficio(String nrOficio) {
        this.nrOficio = nrOficio;
    }

    public String getContaDepositaria() {
        return contaDepositaria;
    }

    public void setContaDepositaria(String contaDepositaria) {
        this.contaDepositaria = contaDepositaria;
    }

    public String getSituacaoResgateSisbb() {
        return situacaoResgateSisbb;
    }

    public void setSituacaoResgateSisbb(String situacaoResgateSisbb) {
        this.situacaoResgateSisbb = situacaoResgateSisbb;
    }

    public String getSituacaoResgatePortal() {
        return situacaoResgatePortal;
    }

    public void setSituacaoResgatePortal(String situacaoResgatePortal) {
        this.situacaoResgatePortal = situacaoResgatePortal;
    }

    public Integer getDependenciaOprd() {
        return dependenciaOprd;
    }

    public void setDependenciaOprd(Integer dependenciaOprd) {
        this.dependenciaOprd = dependenciaOprd;
    }

    public Integer getDependenciaDtra() {
        return dependenciaDtra;
    }

    public void setDependenciaDtra(Integer dependenciaDtra) {
        this.dependenciaDtra = dependenciaDtra;
    }

    public String getFuncionarioResponsavelSolicitacao() {
        return funcionarioResponsavelSolicitacao;
    }

    public void setFuncionarioResponsavelSolicitacao(String funcionarioResponsavelSolicitacao) {
        this.funcionarioResponsavelSolicitacao = funcionarioResponsavelSolicitacao;
    }

    public String getTipoDestinacao() {
        return tipoDestinacao;
    }

    public void setTipoDestinacao(String tipoDestinacao) {
        this.tipoDestinacao = tipoDestinacao;
    }

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public String getFuncionarioResponsavelInclusao() {
        return funcionarioResponsavelInclusao;
    }

    public void setFuncionarioResponsavelInclusao(String funcionarioResponsavelInclusao) {
        this.funcionarioResponsavelInclusao = funcionarioResponsavelInclusao;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public String getObsComplementar() {
        return obsComplementar;
    }

    public void setObsComplementar(String obsComplementar) {
        this.obsComplementar = obsComplementar;
    }

    public String getObsTratar() {
        return obsTratar;
    }

    public void setObsTratar(String obsTratar) {
        this.obsTratar = obsTratar;
    }

    public Double getSaldoContaDepositaria() {
        return saldoContaDepositaria;
    }

    public void setSaldoContaDepositaria(Double saldoContaDepositaria) {
        this.saldoContaDepositaria = saldoContaDepositaria;
    }

    public Date getDataSaldo() {
        return dataSaldo;
    }

    public void setDataSaldo(Date dataSaldo) {
        this.dataSaldo = dataSaldo;
    }

    public String getObsColetaDtra() {
        return obsColetaDtra;
    }

    public void setObsColetaDtra(String obsColetaDtra) {
        this.obsColetaDtra = obsColetaDtra;
    }

    public Double getSaldoPortal() {
        return saldoPortal;
    }

    public void setSaldoPortal(Double saldoPortal) {
        this.saldoPortal = saldoPortal;
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
        if (!(object instanceof Inedito)) {
            return false;
        }
        Inedito other = (Inedito) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.intranet.cenopservicoscwb.entity.Inedito[ codigo=" + codigo + " ]";
    }
    
}
