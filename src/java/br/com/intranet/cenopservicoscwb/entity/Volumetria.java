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
@Table(name = "view_volumetria")
@NamedQueries({
    @NamedQuery(name = "Volumetria.findAll", query = "SELECT v FROM Volumetria v")})
public class Volumetria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "MES_TRATAMENTO")
    private String mesTratamento;
    @Column(name = "PREFIXO")
    private Integer prefixo;
    @Column(name = "FUNCIONARIO")
    private String funcionario;
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
    @Basic(optional = false)
    @Column(name = "QUANTIDADE_TAREFA_CONCLUIDA")
    private long quantidadeTarefaConcluida;
    @Column(name = "QUANTIDADE_TAREFA_DEVOLVIDA")
    private Integer quantidadeTarefaDevolvida;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;

    public Volumetria() {
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

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
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

    public long getQuantidadeTarefaConcluida() {
        return quantidadeTarefaConcluida;
    }

    public void setQuantidadeTarefaConcluida(long quantidadeTarefaConcluida) {
        this.quantidadeTarefaConcluida = quantidadeTarefaConcluida;
    }

    public Integer getQuantidadeTarefaDevolvida() {
        return quantidadeTarefaDevolvida;
    }

    public void setQuantidadeTarefaDevolvida(Integer quantidadeTarefaDevolvida) {
        this.quantidadeTarefaDevolvida = quantidadeTarefaDevolvida;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
}
