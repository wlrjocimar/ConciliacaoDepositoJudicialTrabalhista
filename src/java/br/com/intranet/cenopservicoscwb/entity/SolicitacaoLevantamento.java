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
import javax.persistence.Lob;
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
@Table(name = "tb_cpj_cadastro")
@NamedQueries({
    @NamedQuery(name = "SolicitacaoLevantamento.findAll", query = "SELECT s FROM SolicitacaoLevantamento s")})
public class SolicitacaoLevantamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod")
    private Integer cod;
    @Column(name = "rejud_marca")
    private Short rejudMarca;
    @Column(name = "rejud_acesso")
    private Integer rejudAcesso;
    @Column(name = "plano")
    private String plano;
    @Column(name = "ID_Plano")
    private String iDPlano;
    @Column(name = "ID_Plano_Tipo")
    private String iDPlanoTipo;
    @Column(name = "Rejud_Status")
    private String rejudStatus;
    @Column(name = "Rejud_Qdd_Devolucao")
    private Integer rejudQddDevolucao;
    @Column(name = "Rejud_Grau")
    private String rejudGrau;
    @Column(name = "Rejud_Tipo")
    private String rejudTipo;
    @Column(name = "Rejud_Especial")
    private String rejudEspecial;
    @Column(name = "Rejud_Especial_Motivo")
    private String rejudEspecialMotivo;
    @Column(name = "Rejud_DataIni")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rejudDataIni;
    @Column(name = "Rejud_HoraIni")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rejudHoraIni;
    @Lob
    @Column(name = "Rejud_DataFim")
    private byte[] rejudDataFim;
    @Column(name = "Rejud_HoraFim")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rejudHoraFim;
    @Column(name = "Rejud_Tempo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rejudTempo;
    @Column(name = "Rejud_Funci")
    private String rejudFunci;
    @Column(name = "ID_Historico_Funci")
    private String iDHistoricoFunci;
    @Column(name = "ID_Portal")
    private Integer iDPortal;
    @Column(name = "ID_NPJ")
    private String idNpj;
    @Column(name = "ID_Situa\u00e7\u00e3o")
    private String iDSituação;
    @Column(name = "ID_Situacao_Data")
    @Temporal(TemporalType.DATE)
    private Date iDSituacaoData;
    @Column(name = "ID_Situacao_Hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date iDSituacaoHora;
    @Column(name = "FUNCI_SITUACAO")
    private String funciSituacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ID_Valor")
    private BigDecimal iDValor;
    @Column(name = "ID_Solicitante")
    private String iDSolicitante;
    @Column(name = "ID_Deposito")
    private String iDDeposito;
    @Column(name = "Proces_NPJ")
    private String procesNPJ;
    @Column(name = "Proces_Autor")
    private String procesAutor;
    @Column(name = "Proces_Reu")
    private String procesReu;
    @Column(name = "proces_processo")
    private String procesProcesso;
    @Column(name = "proces_vara")
    private String procesVara;
    @Column(name = "proces_comarca")
    private String procesComarca;
    @Column(name = "proces_tpacao")
    private String procesTpacao;
    @Column(name = "proces_natureza")
    private String procesNatureza;
    @Column(name = "proces_uja")
    private String procesUja;
    @Column(name = "proces_advogadobb")
    private String procesAdvogadobb;
    @Column(name = "contab_dependencia")
    private String contabDependencia;
    @Column(name = "contab_inicio")
    @Temporal(TemporalType.DATE)
    private Date contabInicio;
    @Column(name = "contab_valororigem")
    private BigDecimal contabValororigem;
    @Column(name = "contab_saldo")
    private BigDecimal contabSaldo;
    @Column(name = "depos_situacao")
    private String deposSituacao;
    @Column(name = "depos_banco")
    private String deposBanco;
    @Column(name = "depos_agencia")
    private String deposAgencia;
    @Column(name = "depos_modalidade")
    private String deposModalidade;
    @Column(name = "depos_deposito")
    private String deposDeposito;
    @Column(name = "depos_depositante")
    private String deposDepositante;
    @Column(name = "solic_valor")
    private BigDecimal solicValor;
    @Column(name = "solic_ordem")
    private String solicOrdem;
    @Column(name = "solic_data")
    @Temporal(TemporalType.DATE)
    private Date solicData;
    @Column(name = "solic_validade")
    @Temporal(TemporalType.DATE)
    private Date solicValidade;
    @Column(name = "solic_transferencia")
    private String solicTransferencia;
    @Column(name = "solic_prefixo")
    private Integer solicPrefixo;
    @Column(name = "liber_valor")
    private BigDecimal liberValor;
    @Column(name = "liber_tipo")
    private String liberTipo;
    @Column(name = "liber_operadora")
    private Integer liberOperadora;
    @Column(name = "liber_prefixo")
    private Integer liberPrefixo;
    @Column(name = "liber_observacao")
    private String liberObservacao;
    @Column(name = "relcompletoassunto")
    private String relcompletoassunto;
    @Column(name = "RelCompletoMateria")
    private String relCompletoMateria;
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Column(name = "hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hora;
    @Column(name = "djo_51_f9_agencia_destino")
    private String djo51F9AgenciaDestino;
    @Column(name = "funci")
    private String funci;
    @Lob
    @Column(name = "observacao")
    private String observacao;
    @Column(name = "djo_12_resgate")
    private String djo12Resgate;
    @Column(name = "djo_12_djo")
    private String djo12Djo;
    @Column(name = "djo_12_parcela")
    private String djo12Parcela;
    @Column(name = "djo_12_data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date djo12Data;
    @Column(name = "djo_12_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date djo12Hora;
    @Column(name = "djo_12_funci")
    private String djo12Funci;
    @Column(name = "djo_12_justica")
    private String djo12Justica;
    @Column(name = "djo_12_alvara")
    private String djo12Alvara;
    @Column(name = "djo_12_reu")
    private String djo12Reu;
    @Column(name = "djo_12_autor")
    private String djo12Autor;
    @Column(name = "djo_12_depositante")
    private String djo12Depositante;
    @Column(name = "djo_12_beneficiario")
    private String djo12Beneficiario;
    @Column(name = "djo_12_valor_ir")
    private BigDecimal djo12ValorIr;
    @Column(name = "djo_12_valor_liquido")
    private BigDecimal djo12ValorLiquido;
    @Column(name = "djo_51_seq")
    private String djo51Seq;
    @Column(name = "djo_51")
    private String djo51;
    @Column(name = "djo_51_parcela")
    private String djo51Parcela;
    @Column(name = "djo_51_protocolo")
    private String djo51Protocolo;
    @Column(name = "djo_51_ordem")
    private String djo51Ordem;
    @Column(name = "djo_51_agencia_responsavel")
    private String djo51AgenciaResponsavel;
    @Column(name = "djo_51_finalidade")
    private String djo51Finalidade;
    @Column(name = "djo_51_situacao")
    private String djo51Situacao;
    @Column(name = "djo_51_beneficiario")
    private String djo51Beneficiario;
    @Column(name = "djo_51_beneficiario_tp_mf")
    private String djo51BeneficiarioTpMf;
    @Column(name = "djo_51_beneficiario_mf")
    private String djo51BeneficiarioMf;
    @Column(name = "djo_51_capitalresgatado")
    private BigDecimal djo51Capitalresgatado;
    @Column(name = "djo_51_jurosprojetado")
    private BigDecimal djo51Jurosprojetado;
    @Column(name = "djo_51_CMonetaria")
    private BigDecimal djo51CMonetaria;
    @Column(name = "djo_51_valorbruto")
    private BigDecimal djo51Valorbruto;
    @Column(name = "djo_51_tarifa")
    private BigDecimal djo51Tarifa;
    @Column(name = "djo_51_ir")
    private BigDecimal djo51Ir;
    @Column(name = "djo_51_valor_liquido")
    private BigDecimal djo51ValorLiquido;
    @Column(name = "djo_51_isencaoIR")
    private String djo51isencaoIR;
    @Column(name = "djo_51_x_protocolo")
    private String djo51XProtocolo;
    @Column(name = "djo_51_x_seq")
    private Integer djo51XSeq;
    @Column(name = "djo_51_x")
    private String djo51X;
    @Column(name = "djo_51_x_parcela")
    private String djo51XParcela;
    @Column(name = "djo_51_x_ordem")
    private String djo51XOrdem;
    @Column(name = "djo_51_x_data_deposito")
    @Temporal(TemporalType.TIMESTAMP)
    private Date djo51XDataDeposito;
    @Column(name = "djo_51_x_capital")
    private BigDecimal djo51XCapital;
    @Column(name = "djo_51_x_juros")
    private BigDecimal djo51XJuros;
    @Column(name = "djo_51_x_CMonetaria")
    private BigDecimal djo51xCMonetaria;
    @Column(name = "djo_51_x_ir_total")
    private BigDecimal djo51XIrTotal;
    @Column(name = "djo_51_x_ir_bnc")
    private BigDecimal djo51XIrBnc;
    @Column(name = "djo_51_x_aliquota_ir")
    private BigDecimal djo51XAliquotaIr;
    @Column(name = "djo_51_x_valor_liquido")
    private BigDecimal djo51XValorLiquido;
    @Column(name = "djo_51_x_motivo_ir")
    private String djo51XMotivoIr;
    @Column(name = "djo_51_f12_protocolo")
    private String djo51F12Protocolo;
    @Column(name = "djo_51_f12")
    private String djo51F12;
    @Column(name = "djo_51_f12_parcela")
    private String djo51F12Parcela;
    @Column(name = "djo_51_f12_ordem")
    private String djo51F12Ordem;
    @Column(name = "djo_51_f12_valor_liquido")
    private BigDecimal djo51F12ValorLiquido;
    @Column(name = "djo_51_f12_parte_nome")
    private String djo51F12ParteNome;
    @Column(name = "djo_51_f12_parte_mf")
    private String djo51F12ParteMf;
    @Column(name = "djo_51_f12_parte_tipo")
    private String djo51F12ParteTipo;
    @Column(name = "djo_51_f9")
    private String djo51F9;
    @Column(name = "djo_51_f9_sql_pgto")
    private String djo51F9SqlPgto;
    @Column(name = "djo_51_f9_finalidade")
    private String djo51F9Finalidade;
    @Column(name = "djo_51_f9_banco_nr_destino")
    private String djo51F9BancoNrDestino;
    @Column(name = "djo_51_f9_banco_nm_destino")
    private String djo51F9BancoNmDestino;
    @Column(name = "djo_51_f9_tipo_conta_destino")
    private String djo51F9TipoContaDestino;
    @Column(name = "djo_51_f9_conta_destino")
    private String djo51F9ContaDestino;
    @Column(name = "djo_51_f9_dv_conta_destino")
    private String djo51F9DvContaDestino;
    @Column(name = "djo_responsavel")
    private String djoResponsavel;
    @Column(name = "djo_posicao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date djoPosicao;
    @Lob
    @Column(name = "retag_favoravel")
    private String retagFavoravel;
    @Column(name = "retag_responsavel")
    private String retagResponsavel;
    @Column(name = "retag_posicao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date retagPosicao;
    @Column(name = "baixa_ID")
    private String baixaID;
    @Column(name = "baixa_data_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date baixaDataHora;
    @Column(name = "baixa_result")
    private String baixaResult;
    @Column(name = "baixa_funci")
    private String baixaFunci;
    @Column(name = "CONTA_DEPOSITARIA")
    private String contaDepositaria;
    @Column(name = "NPJ")
    private String npj;
    @Column(name = "FINALIZADO_POR")
    private String finalizadoPor;
    @Column(name = "OBS_CONTABILIZACAO")
    private String obsContabilizacao;
    @Column(name = "OBS_DEVOLUCAO")
    private String obsDevolucao;
    @Column(name = "ALVARA_ELETRONICO")
    private String alvaraEletronico;

    public SolicitacaoLevantamento() {
    }

    public SolicitacaoLevantamento(Integer cod) {
        this.cod = cod;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public Short getRejudMarca() {
        return rejudMarca;
    }

    public void setRejudMarca(Short rejudMarca) {
        this.rejudMarca = rejudMarca;
    }

    public Integer getRejudAcesso() {
        return rejudAcesso;
    }

    public void setRejudAcesso(Integer rejudAcesso) {
        this.rejudAcesso = rejudAcesso;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public String getIDPlano() {
        return iDPlano;
    }

    public void setIDPlano(String iDPlano) {
        this.iDPlano = iDPlano;
    }

    public String getIDPlanoTipo() {
        return iDPlanoTipo;
    }

    public void setIDPlanoTipo(String iDPlanoTipo) {
        this.iDPlanoTipo = iDPlanoTipo;
    }

    public String getRejudStatus() {
        return rejudStatus;
    }

    public void setRejudStatus(String rejudStatus) {
        this.rejudStatus = rejudStatus;
    }

    public Integer getRejudQddDevolucao() {
        return rejudQddDevolucao;
    }

    public void setRejudQddDevolucao(Integer rejudQddDevolucao) {
        this.rejudQddDevolucao = rejudQddDevolucao;
    }

    public String getRejudGrau() {
        return rejudGrau;
    }

    public void setRejudGrau(String rejudGrau) {
        this.rejudGrau = rejudGrau;
    }

    public String getRejudTipo() {
        return rejudTipo;
    }

    public void setRejudTipo(String rejudTipo) {
        this.rejudTipo = rejudTipo;
    }

    public String getRejudEspecial() {
        return rejudEspecial;
    }

    public void setRejudEspecial(String rejudEspecial) {
        this.rejudEspecial = rejudEspecial;
    }

    public String getRejudEspecialMotivo() {
        return rejudEspecialMotivo;
    }

    public void setRejudEspecialMotivo(String rejudEspecialMotivo) {
        this.rejudEspecialMotivo = rejudEspecialMotivo;
    }

    public Date getRejudDataIni() {
        return rejudDataIni;
    }

    public void setRejudDataIni(Date rejudDataIni) {
        this.rejudDataIni = rejudDataIni;
    }

    public Date getRejudHoraIni() {
        return rejudHoraIni;
    }

    public void setRejudHoraIni(Date rejudHoraIni) {
        this.rejudHoraIni = rejudHoraIni;
    }

    public byte[] getRejudDataFim() {
        return rejudDataFim;
    }

    public void setRejudDataFim(byte[] rejudDataFim) {
        this.rejudDataFim = rejudDataFim;
    }

    public Date getRejudHoraFim() {
        return rejudHoraFim;
    }

    public void setRejudHoraFim(Date rejudHoraFim) {
        this.rejudHoraFim = rejudHoraFim;
    }

    public Date getRejudTempo() {
        return rejudTempo;
    }

    public void setRejudTempo(Date rejudTempo) {
        this.rejudTempo = rejudTempo;
    }

    public String getRejudFunci() {
        return rejudFunci;
    }

    public void setRejudFunci(String rejudFunci) {
        this.rejudFunci = rejudFunci;
    }

    public String getIDHistoricoFunci() {
        return iDHistoricoFunci;
    }

    public void setIDHistoricoFunci(String iDHistoricoFunci) {
        this.iDHistoricoFunci = iDHistoricoFunci;
    }

    public Integer getIDPortal() {
        return iDPortal;
    }

    public void setIDPortal(Integer iDPortal) {
        this.iDPortal = iDPortal;
    }

    public String getIdNpj() {
        return idNpj;
    }

    public void setIdNpj(String idNpj) {
        this.idNpj = idNpj;
    }

    public String getIDSituação() {
        return iDSituação;
    }

    public void setIDSituação(String iDSituação) {
        this.iDSituação = iDSituação;
    }

    public Date getIDSituacaoData() {
        return iDSituacaoData;
    }

    public void setIDSituacaoData(Date iDSituacaoData) {
        this.iDSituacaoData = iDSituacaoData;
    }

    public Date getIDSituacaoHora() {
        return iDSituacaoHora;
    }

    public void setIDSituacaoHora(Date iDSituacaoHora) {
        this.iDSituacaoHora = iDSituacaoHora;
    }

    public String getFunciSituacao() {
        return funciSituacao;
    }

    public void setFunciSituacao(String funciSituacao) {
        this.funciSituacao = funciSituacao;
    }

    public BigDecimal getIDValor() {
        return iDValor;
    }

    public void setIDValor(BigDecimal iDValor) {
        this.iDValor = iDValor;
    }

    public String getIDSolicitante() {
        return iDSolicitante;
    }

    public void setIDSolicitante(String iDSolicitante) {
        this.iDSolicitante = iDSolicitante;
    }

    public String getIDDeposito() {
        return iDDeposito;
    }

    public void setIDDeposito(String iDDeposito) {
        this.iDDeposito = iDDeposito;
    }

    public String getProcesNPJ() {
        return procesNPJ;
    }

    public void setProcesNPJ(String procesNPJ) {
        this.procesNPJ = procesNPJ;
    }

    public String getProcesAutor() {
        return procesAutor;
    }

    public void setProcesAutor(String procesAutor) {
        this.procesAutor = procesAutor;
    }

    public String getProcesReu() {
        return procesReu;
    }

    public void setProcesReu(String procesReu) {
        this.procesReu = procesReu;
    }

    public String getProcesProcesso() {
        return procesProcesso;
    }

    public void setProcesProcesso(String procesProcesso) {
        this.procesProcesso = procesProcesso;
    }

    public String getProcesVara() {
        return procesVara;
    }

    public void setProcesVara(String procesVara) {
        this.procesVara = procesVara;
    }

    public String getProcesComarca() {
        return procesComarca;
    }

    public void setProcesComarca(String procesComarca) {
        this.procesComarca = procesComarca;
    }

    public String getProcesTpacao() {
        return procesTpacao;
    }

    public void setProcesTpacao(String procesTpacao) {
        this.procesTpacao = procesTpacao;
    }

    public String getProcesNatureza() {
        return procesNatureza;
    }

    public void setProcesNatureza(String procesNatureza) {
        this.procesNatureza = procesNatureza;
    }

    public String getProcesUja() {
        return procesUja;
    }

    public void setProcesUja(String procesUja) {
        this.procesUja = procesUja;
    }

    public String getProcesAdvogadobb() {
        return procesAdvogadobb;
    }

    public void setProcesAdvogadobb(String procesAdvogadobb) {
        this.procesAdvogadobb = procesAdvogadobb;
    }

    public String getContabDependencia() {
        return contabDependencia;
    }

    public void setContabDependencia(String contabDependencia) {
        this.contabDependencia = contabDependencia;
    }

    public Date getContabInicio() {
        return contabInicio;
    }

    public void setContabInicio(Date contabInicio) {
        this.contabInicio = contabInicio;
    }

    public BigDecimal getContabValororigem() {
        return contabValororigem;
    }

    public void setContabValororigem(BigDecimal contabValororigem) {
        this.contabValororigem = contabValororigem;
    }

    public BigDecimal getContabSaldo() {
        return contabSaldo;
    }

    public void setContabSaldo(BigDecimal contabSaldo) {
        this.contabSaldo = contabSaldo;
    }

    public String getDeposSituacao() {
        return deposSituacao;
    }

    public void setDeposSituacao(String deposSituacao) {
        this.deposSituacao = deposSituacao;
    }

    public String getDeposBanco() {
        return deposBanco;
    }

    public void setDeposBanco(String deposBanco) {
        this.deposBanco = deposBanco;
    }

    public String getDeposAgencia() {
        return deposAgencia;
    }

    public void setDeposAgencia(String deposAgencia) {
        this.deposAgencia = deposAgencia;
    }

    public String getDeposModalidade() {
        return deposModalidade;
    }

    public void setDeposModalidade(String deposModalidade) {
        this.deposModalidade = deposModalidade;
    }

    public String getDeposDeposito() {
        return deposDeposito;
    }

    public void setDeposDeposito(String deposDeposito) {
        this.deposDeposito = deposDeposito;
    }

    public String getDeposDepositante() {
        return deposDepositante;
    }

    public void setDeposDepositante(String deposDepositante) {
        this.deposDepositante = deposDepositante;
    }

    public BigDecimal getSolicValor() {
        return solicValor;
    }

    public void setSolicValor(BigDecimal solicValor) {
        this.solicValor = solicValor;
    }

    public String getSolicOrdem() {
        return solicOrdem;
    }

    public void setSolicOrdem(String solicOrdem) {
        this.solicOrdem = solicOrdem;
    }

    public Date getSolicData() {
        return solicData;
    }

    public void setSolicData(Date solicData) {
        this.solicData = solicData;
    }

    public Date getSolicValidade() {
        return solicValidade;
    }

    public void setSolicValidade(Date solicValidade) {
        this.solicValidade = solicValidade;
    }

    public String getSolicTransferencia() {
        return solicTransferencia;
    }

    public void setSolicTransferencia(String solicTransferencia) {
        this.solicTransferencia = solicTransferencia;
    }

    public Integer getSolicPrefixo() {
        return solicPrefixo;
    }

    public void setSolicPrefixo(Integer solicPrefixo) {
        this.solicPrefixo = solicPrefixo;
    }

    public BigDecimal getLiberValor() {
        return liberValor;
    }

    public void setLiberValor(BigDecimal liberValor) {
        this.liberValor = liberValor;
    }

    public String getLiberTipo() {
        return liberTipo;
    }

    public void setLiberTipo(String liberTipo) {
        this.liberTipo = liberTipo;
    }

    public Integer getLiberOperadora() {
        return liberOperadora;
    }

    public void setLiberOperadora(Integer liberOperadora) {
        this.liberOperadora = liberOperadora;
    }

    public Integer getLiberPrefixo() {
        return liberPrefixo;
    }

    public void setLiberPrefixo(Integer liberPrefixo) {
        this.liberPrefixo = liberPrefixo;
    }

    public String getLiberObservacao() {
        return liberObservacao;
    }

    public void setLiberObservacao(String liberObservacao) {
        this.liberObservacao = liberObservacao;
    }

    public String getRelcompletoassunto() {
        return relcompletoassunto;
    }

    public void setRelcompletoassunto(String relcompletoassunto) {
        this.relcompletoassunto = relcompletoassunto;
    }

    public String getRelCompletoMateria() {
        return relCompletoMateria;
    }

    public void setRelCompletoMateria(String relCompletoMateria) {
        this.relCompletoMateria = relCompletoMateria;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getDjo51F9AgenciaDestino() {
        return djo51F9AgenciaDestino;
    }

    public void setDjo51F9AgenciaDestino(String djo51F9AgenciaDestino) {
        this.djo51F9AgenciaDestino = djo51F9AgenciaDestino;
    }

    public String getFunci() {
        return funci;
    }

    public void setFunci(String funci) {
        this.funci = funci;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getDjo12Resgate() {
        return djo12Resgate;
    }

    public void setDjo12Resgate(String djo12Resgate) {
        this.djo12Resgate = djo12Resgate;
    }

    public String getDjo12Djo() {
        return djo12Djo;
    }

    public void setDjo12Djo(String djo12Djo) {
        this.djo12Djo = djo12Djo;
    }

    public String getDjo12Parcela() {
        return djo12Parcela;
    }

    public void setDjo12Parcela(String djo12Parcela) {
        this.djo12Parcela = djo12Parcela;
    }

    public Date getDjo12Data() {
        return djo12Data;
    }

    public void setDjo12Data(Date djo12Data) {
        this.djo12Data = djo12Data;
    }

    public Date getDjo12Hora() {
        return djo12Hora;
    }

    public void setDjo12Hora(Date djo12Hora) {
        this.djo12Hora = djo12Hora;
    }

    public String getDjo12Funci() {
        return djo12Funci;
    }

    public void setDjo12Funci(String djo12Funci) {
        this.djo12Funci = djo12Funci;
    }

    public String getDjo12Justica() {
        return djo12Justica;
    }

    public void setDjo12Justica(String djo12Justica) {
        this.djo12Justica = djo12Justica;
    }

    public String getDjo12Alvara() {
        return djo12Alvara;
    }

    public void setDjo12Alvara(String djo12Alvara) {
        this.djo12Alvara = djo12Alvara;
    }

    public String getDjo12Reu() {
        return djo12Reu;
    }

    public void setDjo12Reu(String djo12Reu) {
        this.djo12Reu = djo12Reu;
    }

    public String getDjo12Autor() {
        return djo12Autor;
    }

    public void setDjo12Autor(String djo12Autor) {
        this.djo12Autor = djo12Autor;
    }

    public String getDjo12Depositante() {
        return djo12Depositante;
    }

    public void setDjo12Depositante(String djo12Depositante) {
        this.djo12Depositante = djo12Depositante;
    }

    public String getDjo12Beneficiario() {
        return djo12Beneficiario;
    }

    public void setDjo12Beneficiario(String djo12Beneficiario) {
        this.djo12Beneficiario = djo12Beneficiario;
    }

    public BigDecimal getDjo12ValorIr() {
        return djo12ValorIr;
    }

    public void setDjo12ValorIr(BigDecimal djo12ValorIr) {
        this.djo12ValorIr = djo12ValorIr;
    }

    public BigDecimal getDjo12ValorLiquido() {
        return djo12ValorLiquido;
    }

    public void setDjo12ValorLiquido(BigDecimal djo12ValorLiquido) {
        this.djo12ValorLiquido = djo12ValorLiquido;
    }

    public String getDjo51Seq() {
        return djo51Seq;
    }

    public void setDjo51Seq(String djo51Seq) {
        this.djo51Seq = djo51Seq;
    }

    public String getDjo51() {
        return djo51;
    }

    public void setDjo51(String djo51) {
        this.djo51 = djo51;
    }

    public String getDjo51Parcela() {
        return djo51Parcela;
    }

    public void setDjo51Parcela(String djo51Parcela) {
        this.djo51Parcela = djo51Parcela;
    }

    public String getDjo51Protocolo() {
        return djo51Protocolo;
    }

    public void setDjo51Protocolo(String djo51Protocolo) {
        this.djo51Protocolo = djo51Protocolo;
    }

    public String getDjo51Ordem() {
        return djo51Ordem;
    }

    public void setDjo51Ordem(String djo51Ordem) {
        this.djo51Ordem = djo51Ordem;
    }

    public String getDjo51AgenciaResponsavel() {
        return djo51AgenciaResponsavel;
    }

    public void setDjo51AgenciaResponsavel(String djo51AgenciaResponsavel) {
        this.djo51AgenciaResponsavel = djo51AgenciaResponsavel;
    }

    public String getDjo51Finalidade() {
        return djo51Finalidade;
    }

    public void setDjo51Finalidade(String djo51Finalidade) {
        this.djo51Finalidade = djo51Finalidade;
    }

    public String getDjo51Situacao() {
        return djo51Situacao;
    }

    public void setDjo51Situacao(String djo51Situacao) {
        this.djo51Situacao = djo51Situacao;
    }

    public String getDjo51Beneficiario() {
        return djo51Beneficiario;
    }

    public void setDjo51Beneficiario(String djo51Beneficiario) {
        this.djo51Beneficiario = djo51Beneficiario;
    }

    public String getDjo51BeneficiarioTpMf() {
        return djo51BeneficiarioTpMf;
    }

    public void setDjo51BeneficiarioTpMf(String djo51BeneficiarioTpMf) {
        this.djo51BeneficiarioTpMf = djo51BeneficiarioTpMf;
    }

    public String getDjo51BeneficiarioMf() {
        return djo51BeneficiarioMf;
    }

    public void setDjo51BeneficiarioMf(String djo51BeneficiarioMf) {
        this.djo51BeneficiarioMf = djo51BeneficiarioMf;
    }

    public BigDecimal getDjo51Capitalresgatado() {
        return djo51Capitalresgatado;
    }

    public void setDjo51Capitalresgatado(BigDecimal djo51Capitalresgatado) {
        this.djo51Capitalresgatado = djo51Capitalresgatado;
    }

    public BigDecimal getDjo51Jurosprojetado() {
        return djo51Jurosprojetado;
    }

    public void setDjo51Jurosprojetado(BigDecimal djo51Jurosprojetado) {
        this.djo51Jurosprojetado = djo51Jurosprojetado;
    }

    public BigDecimal getDjo51CMonetaria() {
        return djo51CMonetaria;
    }

    public void setDjo51CMonetaria(BigDecimal djo51CMonetaria) {
        this.djo51CMonetaria = djo51CMonetaria;
    }

    public BigDecimal getDjo51Valorbruto() {
        return djo51Valorbruto;
    }

    public void setDjo51Valorbruto(BigDecimal djo51Valorbruto) {
        this.djo51Valorbruto = djo51Valorbruto;
    }

    public BigDecimal getDjo51Tarifa() {
        return djo51Tarifa;
    }

    public void setDjo51Tarifa(BigDecimal djo51Tarifa) {
        this.djo51Tarifa = djo51Tarifa;
    }

    public BigDecimal getDjo51Ir() {
        return djo51Ir;
    }

    public void setDjo51Ir(BigDecimal djo51Ir) {
        this.djo51Ir = djo51Ir;
    }

    public BigDecimal getDjo51ValorLiquido() {
        return djo51ValorLiquido;
    }

    public void setDjo51ValorLiquido(BigDecimal djo51ValorLiquido) {
        this.djo51ValorLiquido = djo51ValorLiquido;
    }

    public String getDjo51isencaoIR() {
        return djo51isencaoIR;
    }

    public void setDjo51isencaoIR(String djo51isencaoIR) {
        this.djo51isencaoIR = djo51isencaoIR;
    }

    public String getDjo51XProtocolo() {
        return djo51XProtocolo;
    }

    public void setDjo51XProtocolo(String djo51XProtocolo) {
        this.djo51XProtocolo = djo51XProtocolo;
    }

    public Integer getDjo51XSeq() {
        return djo51XSeq;
    }

    public void setDjo51XSeq(Integer djo51XSeq) {
        this.djo51XSeq = djo51XSeq;
    }

    public String getDjo51X() {
        return djo51X;
    }

    public void setDjo51X(String djo51X) {
        this.djo51X = djo51X;
    }

    public String getDjo51XParcela() {
        return djo51XParcela;
    }

    public void setDjo51XParcela(String djo51XParcela) {
        this.djo51XParcela = djo51XParcela;
    }

    public String getDjo51XOrdem() {
        return djo51XOrdem;
    }

    public void setDjo51XOrdem(String djo51XOrdem) {
        this.djo51XOrdem = djo51XOrdem;
    }

    public Date getDjo51XDataDeposito() {
        return djo51XDataDeposito;
    }

    public void setDjo51XDataDeposito(Date djo51XDataDeposito) {
        this.djo51XDataDeposito = djo51XDataDeposito;
    }

    public BigDecimal getDjo51XCapital() {
        return djo51XCapital;
    }

    public void setDjo51XCapital(BigDecimal djo51XCapital) {
        this.djo51XCapital = djo51XCapital;
    }

    public BigDecimal getDjo51XJuros() {
        return djo51XJuros;
    }

    public void setDjo51XJuros(BigDecimal djo51XJuros) {
        this.djo51XJuros = djo51XJuros;
    }

    public BigDecimal getDjo51xCMonetaria() {
        return djo51xCMonetaria;
    }

    public void setDjo51xCMonetaria(BigDecimal djo51xCMonetaria) {
        this.djo51xCMonetaria = djo51xCMonetaria;
    }

    public BigDecimal getDjo51XIrTotal() {
        return djo51XIrTotal;
    }

    public void setDjo51XIrTotal(BigDecimal djo51XIrTotal) {
        this.djo51XIrTotal = djo51XIrTotal;
    }

    public BigDecimal getDjo51XIrBnc() {
        return djo51XIrBnc;
    }

    public void setDjo51XIrBnc(BigDecimal djo51XIrBnc) {
        this.djo51XIrBnc = djo51XIrBnc;
    }

    public BigDecimal getDjo51XAliquotaIr() {
        return djo51XAliquotaIr;
    }

    public void setDjo51XAliquotaIr(BigDecimal djo51XAliquotaIr) {
        this.djo51XAliquotaIr = djo51XAliquotaIr;
    }

    public BigDecimal getDjo51XValorLiquido() {
        return djo51XValorLiquido;
    }

    public void setDjo51XValorLiquido(BigDecimal djo51XValorLiquido) {
        this.djo51XValorLiquido = djo51XValorLiquido;
    }

    public String getDjo51XMotivoIr() {
        return djo51XMotivoIr;
    }

    public void setDjo51XMotivoIr(String djo51XMotivoIr) {
        this.djo51XMotivoIr = djo51XMotivoIr;
    }

    public String getDjo51F12Protocolo() {
        return djo51F12Protocolo;
    }

    public void setDjo51F12Protocolo(String djo51F12Protocolo) {
        this.djo51F12Protocolo = djo51F12Protocolo;
    }

    public String getDjo51F12() {
        return djo51F12;
    }

    public void setDjo51F12(String djo51F12) {
        this.djo51F12 = djo51F12;
    }

    public String getDjo51F12Parcela() {
        return djo51F12Parcela;
    }

    public void setDjo51F12Parcela(String djo51F12Parcela) {
        this.djo51F12Parcela = djo51F12Parcela;
    }

    public String getDjo51F12Ordem() {
        return djo51F12Ordem;
    }

    public void setDjo51F12Ordem(String djo51F12Ordem) {
        this.djo51F12Ordem = djo51F12Ordem;
    }

    public BigDecimal getDjo51F12ValorLiquido() {
        return djo51F12ValorLiquido;
    }

    public void setDjo51F12ValorLiquido(BigDecimal djo51F12ValorLiquido) {
        this.djo51F12ValorLiquido = djo51F12ValorLiquido;
    }

    public String getDjo51F12ParteNome() {
        return djo51F12ParteNome;
    }

    public void setDjo51F12ParteNome(String djo51F12ParteNome) {
        this.djo51F12ParteNome = djo51F12ParteNome;
    }

    public String getDjo51F12ParteMf() {
        return djo51F12ParteMf;
    }

    public void setDjo51F12ParteMf(String djo51F12ParteMf) {
        this.djo51F12ParteMf = djo51F12ParteMf;
    }

    public String getDjo51F12ParteTipo() {
        return djo51F12ParteTipo;
    }

    public void setDjo51F12ParteTipo(String djo51F12ParteTipo) {
        this.djo51F12ParteTipo = djo51F12ParteTipo;
    }

    public String getDjo51F9() {
        return djo51F9;
    }

    public void setDjo51F9(String djo51F9) {
        this.djo51F9 = djo51F9;
    }

    public String getDjo51F9SqlPgto() {
        return djo51F9SqlPgto;
    }

    public void setDjo51F9SqlPgto(String djo51F9SqlPgto) {
        this.djo51F9SqlPgto = djo51F9SqlPgto;
    }

    public String getDjo51F9Finalidade() {
        return djo51F9Finalidade;
    }

    public void setDjo51F9Finalidade(String djo51F9Finalidade) {
        this.djo51F9Finalidade = djo51F9Finalidade;
    }

    public String getDjo51F9BancoNrDestino() {
        return djo51F9BancoNrDestino;
    }

    public void setDjo51F9BancoNrDestino(String djo51F9BancoNrDestino) {
        this.djo51F9BancoNrDestino = djo51F9BancoNrDestino;
    }

    public String getDjo51F9BancoNmDestino() {
        return djo51F9BancoNmDestino;
    }

    public void setDjo51F9BancoNmDestino(String djo51F9BancoNmDestino) {
        this.djo51F9BancoNmDestino = djo51F9BancoNmDestino;
    }

    public String getDjo51F9TipoContaDestino() {
        return djo51F9TipoContaDestino;
    }

    public void setDjo51F9TipoContaDestino(String djo51F9TipoContaDestino) {
        this.djo51F9TipoContaDestino = djo51F9TipoContaDestino;
    }

    public String getDjo51F9ContaDestino() {
        return djo51F9ContaDestino;
    }

    public void setDjo51F9ContaDestino(String djo51F9ContaDestino) {
        this.djo51F9ContaDestino = djo51F9ContaDestino;
    }

    public String getDjo51F9DvContaDestino() {
        return djo51F9DvContaDestino;
    }

    public void setDjo51F9DvContaDestino(String djo51F9DvContaDestino) {
        this.djo51F9DvContaDestino = djo51F9DvContaDestino;
    }

    public String getDjoResponsavel() {
        return djoResponsavel;
    }

    public void setDjoResponsavel(String djoResponsavel) {
        this.djoResponsavel = djoResponsavel;
    }

    public Date getDjoPosicao() {
        return djoPosicao;
    }

    public void setDjoPosicao(Date djoPosicao) {
        this.djoPosicao = djoPosicao;
    }

    public String getRetagFavoravel() {
        return retagFavoravel;
    }

    public void setRetagFavoravel(String retagFavoravel) {
        this.retagFavoravel = retagFavoravel;
    }

    public String getRetagResponsavel() {
        return retagResponsavel;
    }

    public void setRetagResponsavel(String retagResponsavel) {
        this.retagResponsavel = retagResponsavel;
    }

    public Date getRetagPosicao() {
        return retagPosicao;
    }

    public void setRetagPosicao(Date retagPosicao) {
        this.retagPosicao = retagPosicao;
    }

    public String getBaixaID() {
        return baixaID;
    }

    public void setBaixaID(String baixaID) {
        this.baixaID = baixaID;
    }

    public Date getBaixaDataHora() {
        return baixaDataHora;
    }

    public void setBaixaDataHora(Date baixaDataHora) {
        this.baixaDataHora = baixaDataHora;
    }

    public String getBaixaResult() {
        return baixaResult;
    }

    public void setBaixaResult(String baixaResult) {
        this.baixaResult = baixaResult;
    }

    public String getBaixaFunci() {
        return baixaFunci;
    }

    public void setBaixaFunci(String baixaFunci) {
        this.baixaFunci = baixaFunci;
    }

    public String getContaDepositaria() {
        return contaDepositaria;
    }

    public void setContaDepositaria(String contaDepositaria) {
        this.contaDepositaria = contaDepositaria;
    }

    public String getNpj() {
        return npj;
    }

    public void setNpj(String npj) {
        this.npj = npj;
    }

    public String getFinalizadoPor() {
        return finalizadoPor;
    }

    public void setFinalizadoPor(String finalizadoPor) {
        this.finalizadoPor = finalizadoPor;
    }

    public String getObsContabilizacao() {
        return obsContabilizacao;
    }

    public void setObsContabilizacao(String obsContabilizacao) {
        this.obsContabilizacao = obsContabilizacao;
    }

    public String getObsDevolucao() {
        return obsDevolucao;
    }

    public void setObsDevolucao(String obsDevolucao) {
        this.obsDevolucao = obsDevolucao;
    }

    public String getAlvaraEletronico() {
        return alvaraEletronico;
    }

    public void setAlvaraEletronico(String alvaraEletronico) {
        this.alvaraEletronico = alvaraEletronico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cod != null ? cod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitacaoLevantamento)) {
            return false;
        }
        SolicitacaoLevantamento other = (SolicitacaoLevantamento) object;
        if ((this.cod == null && other.cod != null) || (this.cod != null && !this.cod.equals(other.cod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.intranet.cenopservicoscwb.entity.SolicitacaoLevantamento[ cod=" + cod + " ]";
    }
    
}
