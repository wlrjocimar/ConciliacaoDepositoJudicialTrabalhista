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
@Table(name = "tb_historico_desconciliacao_djo_paj")
@NamedQueries({
    @NamedQuery(name = "HistoricoDesconciliacao.findAll", query = "SELECT h FROM HistoricoDesconciliacao h")})
public class HistoricoDesconciliacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODIGO_HISTORICO")
    private Integer codigoHistorico;
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
    @Column(name = "DATA_ENTRADA_BD")
    @Temporal(TemporalType.DATE)
    private Date dataEntradaBd;
    @Column(name = "MES_TRATAMENTO")
    private String mesTratamento;
    @Column(name = "PREFIXO")
    private Integer prefixo;
    @Column(name = "CODIGO_FUNCAO")
    private Integer codigoFuncao;
    @Column(name = "UOR_LOCALIZACAO")
    private Integer uorLocalizacao;
    @Column(name = "PROCESSO_NO_GSV")
    private Integer processoNoGsv;
    @Column(name = "CODIGO_PROCESSO")
    private Integer codigoProcesso;
    @Column(name = "CODIGO_ATIVIDADE")
    private Integer codigoAtividade;
    @Column(name = "CODIGO_DETALHE_ATIVIDADE")
    private Integer codigoDetalheAtividade;
    @Column(name = "CODIGO_TAREFA")
    private Integer codigoTarefa;
    @Column(name = "CARGO_GERENCIAL")
    private Integer cargoGerencial;
    @Column(name = "TIPO_CHAVE")
    private String tipoChave;
    @Column(name = "QUANTIDADE_PROCESSO_CONCLUIDO")
    private Integer quantidadeProcessoConcluido;
    @Column(name = "QUANTIDADE_PROCESSO_DEVOLVIDO")
    private Integer quantidadeProcessoDevolvido;
    @Column(name = "QUANTIDADE_TAREFA_CONCLUIDA")
    private Integer quantidadeTarefaConcluida;
    @Column(name = "QUANTIDADE_TAREFA_DEVOLVIDA")
    private Integer quantidadeTarefaDevolvida;

    public HistoricoDesconciliacao() {
    }

    public HistoricoDesconciliacao(Integer codigoHistorico) {
        this.codigoHistorico = codigoHistorico;
    }

    public Integer getCodigoHistorico() {
        return codigoHistorico;
    }

    public void setCodigoHistorico(Integer codigoHistorico) {
        this.codigoHistorico = codigoHistorico;
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

    public Date getDataEntradaBd() {
        return dataEntradaBd;
    }

    public void setDataEntradaBd(Date dataEntradaBd) {
        this.dataEntradaBd = dataEntradaBd;
    }

    public String getMesTratamento() {
        return mesTratamento;
    }

    public void setMesTratamento(String mesTratamento) {
        this.mesTratamento = mesTratamento;
    }

    public Integer getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(Integer prefixo) {
        this.prefixo = prefixo;
    }

    public Integer getCodigoFuncao() {
        return codigoFuncao;
    }

    public void setCodigoFuncao(Integer codigoFuncao) {
        this.codigoFuncao = codigoFuncao;
    }

    public Integer getUorLocalizacao() {
        return uorLocalizacao;
    }

    public void setUorLocalizacao(Integer uorLocalizacao) {
        this.uorLocalizacao = uorLocalizacao;
    }

    public Integer getProcessoNoGsv() {
        return processoNoGsv;
    }

    public void setProcessoNoGsv(Integer processoNoGsv) {
        this.processoNoGsv = processoNoGsv;
    }

    public Integer getCodigoProcesso() {
        return codigoProcesso;
    }

    public void setCodigoProcesso(Integer codigoProcesso) {
        this.codigoProcesso = codigoProcesso;
    }

    public Integer getCodigoAtividade() {
        return codigoAtividade;
    }

    public void setCodigoAtividade(Integer codigoAtividade) {
        this.codigoAtividade = codigoAtividade;
    }

    public Integer getCodigoDetalheAtividade() {
        return codigoDetalheAtividade;
    }

    public void setCodigoDetalheAtividade(Integer codigoDetalheAtividade) {
        this.codigoDetalheAtividade = codigoDetalheAtividade;
    }

    public Integer getCodigoTarefa() {
        return codigoTarefa;
    }

    public void setCodigoTarefa(Integer codigoTarefa) {
        this.codigoTarefa = codigoTarefa;
    }

    public Integer getCargoGerencial() {
        return cargoGerencial;
    }

    public void setCargoGerencial(Integer cargoGerencial) {
        this.cargoGerencial = cargoGerencial;
    }

    public String getTipoChave() {
        return tipoChave;
    }

    public void setTipoChave(String tipoChave) {
        this.tipoChave = tipoChave;
    }

    public Integer getQuantidadeProcessoConcluido() {
        return quantidadeProcessoConcluido;
    }

    public void setQuantidadeProcessoConcluido(Integer quantidadeProcessoConcluido) {
        this.quantidadeProcessoConcluido = quantidadeProcessoConcluido;
    }

    public Integer getQuantidadeProcessoDevolvido() {
        return quantidadeProcessoDevolvido;
    }

    public void setQuantidadeProcessoDevolvido(Integer quantidadeProcessoDevolvido) {
        this.quantidadeProcessoDevolvido = quantidadeProcessoDevolvido;
    }

    public Integer getQuantidadeTarefaConcluida() {
        return quantidadeTarefaConcluida;
    }

    public void setQuantidadeTarefaConcluida(Integer quantidadeTarefaConcluida) {
        this.quantidadeTarefaConcluida = quantidadeTarefaConcluida;
    }

    public Integer getQuantidadeTarefaDevolvida() {
        return quantidadeTarefaDevolvida;
    }

    public void setQuantidadeTarefaDevolvida(Integer quantidadeTarefaDevolvida) {
        this.quantidadeTarefaDevolvida = quantidadeTarefaDevolvida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoHistorico != null ? codigoHistorico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoricoDesconciliacao)) {
            return false;
        }
        HistoricoDesconciliacao other = (HistoricoDesconciliacao) object;
        if ((this.codigoHistorico == null && other.codigoHistorico != null) || (this.codigoHistorico != null && !this.codigoHistorico.equals(other.codigoHistorico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.intranet.cenopservicoscwb.entity.HistoricoDesconciliacao[ codigoHistorico=" + codigoHistorico + " ]";
    }
    
}
