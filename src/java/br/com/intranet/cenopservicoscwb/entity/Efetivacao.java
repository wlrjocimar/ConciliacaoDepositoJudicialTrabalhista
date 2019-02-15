/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intranet.cenopservicoscwb.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author f5078775
 */
@Entity
@Table(name = "tb_efetivacao_dep")
@NamedQueries({
    @NamedQuery(name = "Efetivacao.findAll", query = "SELECT e FROM Efetivacao e")})
public class Efetivacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private Integer codigo;
    @Column(name = "NPJ")
    private String npj;
    @Column(name = "AUTOR")
    private String autor;
    @Column(name = "PROCESSO")
    private String processo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR_EFETIVACAO")
    private String valorEfetivacao;
    @Column(name = "BANCO_DEPOSITARIO")
    private String bancoDepositario;
    @Column(name = "CONTA_DEPOSITARIA")
    private String contaDepositaria;
    @Column(name = "AGENCIA_DEPOSITARIA")
    private Integer agenciaDepositaria;
    @Column(name = "SITUACAO_DEPOSITO")
    private String situacaoDeposito;
    @Column(name = "FUNCI_RESPONSAVEL_SOLICITACAO")
    private String funciResponsavelSolicitacao;
    @Column(name = "DATA_SOLICITACAO")
    @Temporal(TemporalType.DATE)
    private Date dataSolicitacao;
    @Column(name = "FUNCI_RESPONSAVEL_COMPLEMENTACAO")
    private String funciResponsavelComplementacao;
    @Column(name = "DATA_COMPLEMENTACAO")
    @Temporal(TemporalType.DATE)
    private Date dataComplementacao;
    @Column(name = "PROTOCOLO_GSV")
    private Integer protocoloGsv;
    @Column(name = "SITUACAO_PROLOCOLO")
    private String situacaoProlocolo;
    @Column(name = "VARIACAO_NPJ")
    private Integer variacaoNpj;
    @Column(name = "OBS")
    private String obs;
    @Column(name = "MODALIDADE")
    private String modalidade;
    @Column(name = "NATUREZA")
    private String natureza;
    @Column(name = "VALOR_INICIAL")
    private BigDecimal valorInicial;
    @Column(name = "SALDO_ATUAL")
    private BigDecimal saldoAtual;
    @Column(name = "DATA_INICIAL")
    @Temporal(TemporalType.DATE)
    private Date dataInicial;
    @Column(name = "REU")
    private String reu;

    public Efetivacao() {
    }

    public Efetivacao(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNpj() {
        return npj;
    }

    public void setNpj(String npj) {
        this.npj = npj;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getProcesso() {
        return processo;
    }

    public void setProcesso(String processo) {
        this.processo = processo;
    }

    public String getValorEfetivacao() {
        return valorEfetivacao;
    }

    public void setValorEfetivacao(String valorEfetivacao) {
        this.valorEfetivacao = valorEfetivacao;
    }

    public String getBancoDepositario() {
        return bancoDepositario;
    }

    public void setBancoDepositario(String bancoDepositario) {
        this.bancoDepositario = bancoDepositario;
    }

    public String getContaDepositaria() {
        return contaDepositaria;
    }

    public void setContaDepositaria(String contaDepositaria) {
        this.contaDepositaria = contaDepositaria;
    }

    public Integer getAgenciaDepositaria() {
        return agenciaDepositaria;
    }

    public void setAgenciaDepositaria(Integer agenciaDepositaria) {
        this.agenciaDepositaria = agenciaDepositaria;
    }

    public String getSituacaoDeposito() {
        return situacaoDeposito;
    }

    public void setSituacaoDeposito(String situacaoDeposito) {
        this.situacaoDeposito = situacaoDeposito;
    }

    public String getFunciResponsavelSolicitacao() {
        return funciResponsavelSolicitacao;
    }

    public void setFunciResponsavelSolicitacao(String funciResponsavelSolicitacao) {
        this.funciResponsavelSolicitacao = funciResponsavelSolicitacao;
    }

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public String getFunciResponsavelComplementacao() {
        return funciResponsavelComplementacao;
    }

    public void setFunciResponsavelComplementacao(String funciResponsavelComplementacao) {
        this.funciResponsavelComplementacao = funciResponsavelComplementacao;
    }

    public Date getDataComplementacao() {
        return dataComplementacao;
    }

    public void setDataComplementacao(Date dataComplementacao) {
        this.dataComplementacao = dataComplementacao;
    }

    public Integer getProtocoloGsv() {
        return protocoloGsv;
    }

    public void setProtocoloGsv(Integer protocoloGsv) {
        this.protocoloGsv = protocoloGsv;
    }

    public String getSituacaoProlocolo() {
        return situacaoProlocolo;
    }

    public void setSituacaoProlocolo(String situacaoProlocolo) {
        this.situacaoProlocolo = situacaoProlocolo;
    }

    public Integer getVariacaoNpj() {
        return variacaoNpj;
    }

    public void setVariacaoNpj(Integer variacaoNpj) {
        this.variacaoNpj = variacaoNpj;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getNatureza() {
        return natureza;
    }

    public void setNatureza(String natureza) {
        this.natureza = natureza;
    }

    public BigDecimal getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(BigDecimal valorInicial) {
        this.valorInicial = valorInicial;
    }

    public BigDecimal getSaldoAtual() {
        return saldoAtual;
    }

    public void setSaldoAtual(BigDecimal saldoAtual) {
        this.saldoAtual = saldoAtual;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getReu() {
        return reu;
    }

    public void setReu(String reu) {
        this.reu = reu;
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
        if (!(object instanceof Efetivacao)) {
            return false;
        }
        Efetivacao other = (Efetivacao) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.intranet.cenopservicoscwb.entity.Efetivacao[ codigo=" + codigo + " ]";
    }
    
}
