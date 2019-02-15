package br.com.intranet.cenopservicoscwb.entity;


import java.util.Date;
import java.util.Objects;


public class ProtocoloGsv {
    
    private int numeroProtocolo;
    private Date  dataSaidaProtocolo;
    private String  nomeProcesso;
    private String nomeAtividade;
    private String nomeFase;
    private Date dataEntradaProtocolo;
    private int codigoEtapa;
    private String identificador1;
    private String identificador2;
    private String identificador3;
    private int codigoAtividade;
    private int codigoClasse;
    private String nomeEtapa;
    private String nomeTipoProcesso;
    private String nomeClasse;

    public String getNomeEtapa() {
        return nomeEtapa;
    }

    public void setNomeEtapa(String nomeEtapa) {
        this.nomeEtapa = nomeEtapa;
    }

    public String getNomeTipoProcesso() {
        return nomeTipoProcesso;
    }

    public void setNomeTipoProcesso(String nomeTipoProcesso) {
        this.nomeTipoProcesso = nomeTipoProcesso;
    }

    

    public String getNomeClasse() {
        return nomeClasse;
    }

    public void setNomeClasse(String nomeClasse) {
        this.nomeClasse = nomeClasse;
    }

    public String getNomeFase() {
        return nomeFase;
    }

    public void setNomeFase(String nomeFase) {
        this.nomeFase = nomeFase;
    }

    public Date getDataEntradaProtocolo() {
        return dataEntradaProtocolo;
    }

    public void setDataEntradaProtocolo(Date dataEntradaProtocolo) {
        this.dataEntradaProtocolo = dataEntradaProtocolo;
    }

    public int getCodigoEtapa() {
        return codigoEtapa;
    }

    public void setCodigoEtapa(int codigoEtapa) {
        this.codigoEtapa = codigoEtapa;
    }

    public String getIdentificador1() {
        return identificador1;
    }

    public void setIdentificador1(String identificador1) {
        this.identificador1 = identificador1;
    }

    public String getIdentificador2() {
        return identificador2;
    }

    public void setIdentificador2(String identificador2) {
        this.identificador2 = identificador2;
    }

    public String getIdentificador3() {
        return identificador3;
    }

    public void setIdentificador3(String identificador3) {
        this.identificador3 = identificador3;
    }

    public int getCodigoAtividade() {
        return codigoAtividade;
    }

    public void setCodigoAtividade(int codigoAtividade) {
        this.codigoAtividade = codigoAtividade;
    }

    public int getCodigoClasse() {
        return codigoClasse;
    }

    public void setCodigoClasse(int codigoClasse) {
        this.codigoClasse = codigoClasse;
    }
    
    
    private String funcionarioResponsavel;

    public int getNumeroProtocolo() {
        return numeroProtocolo;
    }

    public void setNumeroProtocolo(int numeroProtocolo) {
        this.numeroProtocolo = numeroProtocolo;
    }

    public Date getDataSaidaProtocolo() {
        return dataSaidaProtocolo;
    }

    public void setDataSaidaProtocolo(Date dataSaidaProtocolo) {
        this.dataSaidaProtocolo = dataSaidaProtocolo;
    }

    public String getNomeProcesso() {
        return nomeProcesso;
    }

    public void setNomeProcesso(String nomeProcesso) {
        this.nomeProcesso = nomeProcesso;
    }

    public String getNomeAtividade() {
        return nomeAtividade;
    }

    public void setNomeAtividade(String nomeAtividade) {
        this.nomeAtividade = nomeAtividade;
    }

    public String getFuncionarioResponsavel() {
        return funcionarioResponsavel;
    }

    public void setFuncionarioResponsavel(String funcionarioResponsavel) {
        this.funcionarioResponsavel = funcionarioResponsavel;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.numeroProtocolo;
        hash = 89 * hash + Objects.hashCode(this.dataSaidaProtocolo);
        hash = 89 * hash + Objects.hashCode(this.nomeProcesso);
        hash = 89 * hash + Objects.hashCode(this.nomeAtividade);
        hash = 89 * hash + Objects.hashCode(this.funcionarioResponsavel);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProtocoloGsv other = (ProtocoloGsv) obj;
        if (this.numeroProtocolo != other.numeroProtocolo) {
            return false;
        }
        if (!Objects.equals(this.nomeProcesso, other.nomeProcesso)) {
            return false;
        }
        if (!Objects.equals(this.nomeAtividade, other.nomeAtividade)) {
            return false;
        }
        if (!Objects.equals(this.funcionarioResponsavel, other.funcionarioResponsavel)) {
            return false;
        }
        if (!Objects.equals(this.dataSaidaProtocolo, other.dataSaidaProtocolo)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
