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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author f5078775
 */
@Entity
@Table(name = "tb_desconciliacao_djo_paj")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Desconciliacao.findAll", query = "SELECT d FROM Desconciliacao d")
    , @NamedQuery(name = "Desconciliacao.findByCodigoDesconciliacao", query = "SELECT d FROM Desconciliacao d WHERE d.codigoDesconciliacao = :codigoDesconciliacao")
    , @NamedQuery(name = "Desconciliacao.findByNpj", query = "SELECT d FROM Desconciliacao d WHERE d.npj = :npj")
    , @NamedQuery(name = "Desconciliacao.findByVariacaoNpj", query = "SELECT d FROM Desconciliacao d WHERE d.variacaoNpj = :variacaoNpj")
    , @NamedQuery(name = "Desconciliacao.findByContaControle", query = "SELECT d FROM Desconciliacao d WHERE d.contaControle = :contaControle")
    , @NamedQuery(name = "Desconciliacao.findByContaDepositaria", query = "SELECT d FROM Desconciliacao d WHERE d.contaDepositaria = :contaDepositaria")
    , @NamedQuery(name = "Desconciliacao.findBySaldoContaControle", query = "SELECT d FROM Desconciliacao d WHERE d.saldoContaControle = :saldoContaControle")
    , @NamedQuery(name = "Desconciliacao.findBySaldoDeposito", query = "SELECT d FROM Desconciliacao d WHERE d.saldoDeposito = :saldoDeposito")
    , @NamedQuery(name = "Desconciliacao.findByValorDesconciliacao", query = "SELECT d FROM Desconciliacao d WHERE d.valorDesconciliacao = :valorDesconciliacao")
    , @NamedQuery(name = "Desconciliacao.findBySituacao", query = "SELECT d FROM Desconciliacao d WHERE d.situacao = :situacao")
    , @NamedQuery(name = "Desconciliacao.findByDataSituacao", query = "SELECT d FROM Desconciliacao d WHERE d.dataSituacao = :dataSituacao")
    , @NamedQuery(name = "Desconciliacao.findByDataRetorno", query = "SELECT d FROM Desconciliacao d WHERE d.dataRetorno = :dataRetorno")
    , @NamedQuery(name = "Desconciliacao.findByFuncionarioResponsavelSituacao", query = "SELECT d FROM Desconciliacao d WHERE d.funcionarioResponsavelSituacao = :funcionarioResponsavelSituacao")
    , @NamedQuery(name = "Desconciliacao.findByFuncionarioAtual", query = "SELECT d FROM Desconciliacao d WHERE d.funcionarioAtual = :funcionarioAtual")
    , @NamedQuery(name = "Desconciliacao.findByNomeTratamento", query = "SELECT d FROM Desconciliacao d WHERE d.nomeTratamento = :nomeTratamento")
    , @NamedQuery(name = "Desconciliacao.findByAvocado", query = "SELECT d FROM Desconciliacao d WHERE d.avocado = :avocado")
    , @NamedQuery(name = "Desconciliacao.findByDataAvocacao", query = "SELECT d FROM Desconciliacao d WHERE d.dataAvocacao = :dataAvocacao")
    , @NamedQuery(name = "Desconciliacao.findByDataDesconciliacao", query = "SELECT d FROM Desconciliacao d WHERE d.dataDesconciliacao = :dataDesconciliacao")
    , @NamedQuery(name = "Desconciliacao.findByDiasDesconciliado", query = "SELECT d FROM Desconciliacao d WHERE d.diasDesconciliado = :diasDesconciliado")
    , @NamedQuery(name = "Desconciliacao.findByAutor", query = "SELECT d FROM Desconciliacao d WHERE d.autor = :autor")
    , @NamedQuery(name = "Desconciliacao.findByReu", query = "SELECT d FROM Desconciliacao d WHERE d.reu = :reu")
    , @NamedQuery(name = "Desconciliacao.findByDataEntradaBd", query = "SELECT d FROM Desconciliacao d WHERE d.dataEntradaBd = :dataEntradaBd")
    , @NamedQuery(name = "Desconciliacao.findByCodigoSituacao", query = "SELECT d FROM Desconciliacao d WHERE d.codigoSituacao = :codigoSituacao")
    , @NamedQuery(name = "Desconciliacao.findByCodigoTratamento", query = "SELECT d FROM Desconciliacao d WHERE d.codigoTratamento = :codigoTratamento")
    , @NamedQuery(name = "Desconciliacao.findByNaturezaNpj", query = "SELECT d FROM Desconciliacao d WHERE d.naturezaNpj = :naturezaNpj")
    , @NamedQuery(name = "Desconciliacao.findByAssunto", query = "SELECT d FROM Desconciliacao d WHERE d.assunto = :assunto")
    , @NamedQuery(name = "Desconciliacao.findByMateria", query = "SELECT d FROM Desconciliacao d WHERE d.materia = :materia")
    , @NamedQuery(name = "Desconciliacao.findByObsLivre", query = "SELECT d FROM Desconciliacao d WHERE d.obsLivre = :obsLivre")
    , @NamedQuery(name = "Desconciliacao.findByDataPrimeiroTratamento", query = "SELECT d FROM Desconciliacao d WHERE d.dataPrimeiroTratamento = :dataPrimeiroTratamento")
    , @NamedQuery(name = "Desconciliacao.findByTratadoPrazo", query = "SELECT d FROM Desconciliacao d WHERE d.tratadoPrazo = :tratadoPrazo")
    , @NamedQuery(name = "Desconciliacao.findByDataRetornoAgencia", query = "SELECT d FROM Desconciliacao d WHERE d.dataRetornoAgencia = :dataRetornoAgencia")
    , @NamedQuery(name = "Desconciliacao.findByDataRotinaSaldoDjo", query = "SELECT d FROM Desconciliacao d WHERE d.dataRotinaSaldoDjo = :dataRotinaSaldoDjo")
    , @NamedQuery(name = "Desconciliacao.findByIdDesconciliacaoDiris", query = "SELECT d FROM Desconciliacao d WHERE d.idDesconciliacaoDiris = :idDesconciliacaoDiris")})
public class Desconciliacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODIGO_DESCONCILIACAO")
    private Integer codigoDesconciliacao;
    @Column(name = "NPJ")
    private String npj;
    @Column(name = "VARIACAO_NPJ")
    private Integer variacaoNpj;
    @Column(name = "CONTA_CONTROLE")
    private String contaControle;
    @Column(name = "CONTA_DEPOSITARIA")
    private String contaDepositaria;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SALDO_CONTA_CONTROLE")
    private Double saldoContaControle;
    @Column(name = "SALDO_DEPOSITO")
    private Double saldoDeposito;
    @Column(name = "VALOR_DESCONCILIACAO")
    private Double valorDesconciliacao;
    @Column(name = "SITUACAO")
    private String situacao;
    @Column(name = "DATA_SITUACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataSituacao;
    @Column(name = "DATA_RETORNO")
    @Temporal(TemporalType.DATE)
    private Date dataRetorno;
    @Column(name = "FUNCIONARIO_RESPONSAVEL_SITUACAO")
    private String funcionarioResponsavelSituacao;
    @Column(name = "FUNCIONARIO_ATUAL")
    private String funcionarioAtual;
    @Column(name = "NOME_TRATAMENTO")
    private String nomeTratamento;
    @Column(name = "AVOCADO")
    private String avocado;
    @Column(name = "DATA_AVOCACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAvocacao;
    @Column(name = "DATA_DESCONCILIACAO")
    @Temporal(TemporalType.DATE)
    private Date dataDesconciliacao;
    @Column(name = "DIAS_DESCONCILIADO")
    private Integer diasDesconciliado;
    @Column(name = "AUTOR")
    private String autor;
    @Column(name = "REU")
    private String reu;
    @Column(name = "DATA_ENTRADA_BD")
    @Temporal(TemporalType.DATE)
    private Date dataEntradaBd;
    @Column(name = "CODIGO_SITUACAO")
    private Integer codigoSituacao;
    @Column(name = "CODIGO_TRATAMENTO")
    private Integer codigoTratamento;
    @Column(name = "NATUREZA_NPJ")
    private String naturezaNpj;
    @Column(name = "ASSUNTO")
    private String assunto;
    @Column(name = "MATERIA")
    private String materia;
    @Column(name = "OBS_LIVRE")
    private String obsLivre;
    @Column(name = "DATA_PRIMEIRO_TRATAMENTO")
    @Temporal(TemporalType.DATE)
    private Date dataPrimeiroTratamento;
    @Column(name = "TRATADO_PRAZO")
    private String tratadoPrazo;
    @Column(name = "DATA_RETORNO_AGENCIA")
    @Temporal(TemporalType.DATE)
    private Date dataRetornoAgencia;
    @Column(name = "DATA_ROTINA_SALDO_DJO")
    @Temporal(TemporalType.DATE)
    private Date dataRotinaSaldoDjo;
    @Column(name = "ID_DESCONCILIACAO_DIRIS")
    private String idDesconciliacaoDiris;

    public Desconciliacao() {
    }

    public Desconciliacao(Integer codigoDesconciliacao) {
        this.codigoDesconciliacao = codigoDesconciliacao;
    }

    public Integer getCodigoDesconciliacao() {
        return codigoDesconciliacao;
    }

    public void setCodigoDesconciliacao(Integer codigoDesconciliacao) {
        this.codigoDesconciliacao = codigoDesconciliacao;
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

    public String getContaControle() {
        return contaControle;
    }

    public void setContaControle(String contaControle) {
        this.contaControle = contaControle;
    }

    public String getContaDepositaria() {
        return contaDepositaria;
    }

    public void setContaDepositaria(String contaDepositaria) {
        this.contaDepositaria = contaDepositaria;
    }

    public Double getSaldoContaControle() {
        return saldoContaControle;
    }

    public void setSaldoContaControle(Double saldoContaControle) {
        this.saldoContaControle = saldoContaControle;
    }

    public Double getSaldoDeposito() {
        return saldoDeposito;
    }

    public void setSaldoDeposito(Double saldoDeposito) {
        this.saldoDeposito = saldoDeposito;
    }

    public Double getValorDesconciliacao() {
        return valorDesconciliacao;
    }

    public void setValorDesconciliacao(Double valorDesconciliacao) {
        this.valorDesconciliacao = valorDesconciliacao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Date getDataSituacao() {
        return dataSituacao;
    }

    public void setDataSituacao(Date dataSituacao) {
        this.dataSituacao = dataSituacao;
    }

    public Date getDataRetorno() {
        return dataRetorno;
    }

    public void setDataRetorno(Date dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    public String getFuncionarioResponsavelSituacao() {
        return funcionarioResponsavelSituacao;
    }

    public void setFuncionarioResponsavelSituacao(String funcionarioResponsavelSituacao) {
        this.funcionarioResponsavelSituacao = funcionarioResponsavelSituacao;
    }

    public String getFuncionarioAtual() {
        return funcionarioAtual;
    }

    public void setFuncionarioAtual(String funcionarioAtual) {
        this.funcionarioAtual = funcionarioAtual;
    }

    public String getNomeTratamento() {
        return nomeTratamento;
    }

    public void setNomeTratamento(String nomeTratamento) {
        this.nomeTratamento = nomeTratamento;
    }

    public String getAvocado() {
        return avocado;
    }

    public void setAvocado(String avocado) {
        this.avocado = avocado;
    }

    public Date getDataAvocacao() {
        return dataAvocacao;
    }

    public void setDataAvocacao(Date dataAvocacao) {
        this.dataAvocacao = dataAvocacao;
    }

    public Date getDataDesconciliacao() {
        return dataDesconciliacao;
    }

    public void setDataDesconciliacao(Date dataDesconciliacao) {
        this.dataDesconciliacao = dataDesconciliacao;
    }

    public Integer getDiasDesconciliado() {
        return diasDesconciliado;
    }

    public void setDiasDesconciliado(Integer diasDesconciliado) {
        this.diasDesconciliado = diasDesconciliado;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getReu() {
        return reu;
    }

    public void setReu(String reu) {
        this.reu = reu;
    }

    public Date getDataEntradaBd() {
        return dataEntradaBd;
    }

    public void setDataEntradaBd(Date dataEntradaBd) {
        this.dataEntradaBd = dataEntradaBd;
    }

    public Integer getCodigoSituacao() {
        return codigoSituacao;
    }

    public void setCodigoSituacao(Integer codigoSituacao) {
        this.codigoSituacao = codigoSituacao;
    }

    public Integer getCodigoTratamento() {
        return codigoTratamento;
    }

    public void setCodigoTratamento(Integer codigoTratamento) {
        this.codigoTratamento = codigoTratamento;
    }

    public String getNaturezaNpj() {
        return naturezaNpj;
    }

    public void setNaturezaNpj(String naturezaNpj) {
        this.naturezaNpj = naturezaNpj;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getObsLivre() {
        return obsLivre;
    }

    public void setObsLivre(String obsLivre) {
        this.obsLivre = obsLivre;
    }

    public Date getDataPrimeiroTratamento() {
        return dataPrimeiroTratamento;
    }

    public void setDataPrimeiroTratamento(Date dataPrimeiroTratamento) {
        this.dataPrimeiroTratamento = dataPrimeiroTratamento;
    }

    public String getTratadoPrazo() {
        return tratadoPrazo;
    }

    public void setTratadoPrazo(String tratadoPrazo) {
        this.tratadoPrazo = tratadoPrazo;
    }

    public Date getDataRetornoAgencia() {
        return dataRetornoAgencia;
    }

    public void setDataRetornoAgencia(Date dataRetornoAgencia) {
        this.dataRetornoAgencia = dataRetornoAgencia;
    }

    public Date getDataRotinaSaldoDjo() {
        return dataRotinaSaldoDjo;
    }

    public void setDataRotinaSaldoDjo(Date dataRotinaSaldoDjo) {
        this.dataRotinaSaldoDjo = dataRotinaSaldoDjo;
    }

    public String getIdDesconciliacaoDiris() {
        return idDesconciliacaoDiris;
    }

    public void setIdDesconciliacaoDiris(String idDesconciliacaoDiris) {
        this.idDesconciliacaoDiris = idDesconciliacaoDiris;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoDesconciliacao != null ? codigoDesconciliacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Desconciliacao)) {
            return false;
        }
        Desconciliacao other = (Desconciliacao) object;
        if ((this.codigoDesconciliacao == null && other.codigoDesconciliacao != null) || (this.codigoDesconciliacao != null && !this.codigoDesconciliacao.equals(other.codigoDesconciliacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.intranet.cenopservicoscwb.entity.Desconciliacao[ codigoDesconciliacao=" + codigoDesconciliacao + " ]";
    }
    
}
