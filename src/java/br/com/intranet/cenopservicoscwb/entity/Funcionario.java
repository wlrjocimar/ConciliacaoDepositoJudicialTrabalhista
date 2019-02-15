package br.com.intranet.cenopservicoscwb.entity;

import java.io.Serializable;

public class Funcionario  implements  Serializable{

	private String chave;
	private String nome;
	private String nomeGuerra;
	private int UORPosicao;
	private int UORHabitual;
	private int funcao;
	private String nomeFuncao;
        private String gerente;
        private String secao;
        private String quadro;
        

	public String getChave() {
		return chave;
	}

   

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeGuerra() {
		return nomeGuerra;
	}

	public void setNomeGuerra(String nomeGuerra) {
		this.nomeGuerra = nomeGuerra;
	}

	public int getUORPosicao() {
		return UORPosicao;
	}

	public void setUORPosicao(int uORPosicao) {
		UORPosicao = uORPosicao;
	}

	public int getUORHabitual() {
		return UORHabitual;
	}

	public void setUORHabitual(int uORHabitual) {
		UORHabitual = uORHabitual;
	}

	public int getFuncao() {
		return funcao;
	}

	public void setFuncao(int funcao) {
		this.funcao = funcao;
	}

	public String getNomeFuncao() {
		return nomeFuncao;
	}

	public void setNomeFuncao(String nomeFuncao) {
		this.nomeFuncao = nomeFuncao;
	}
        
        public String getGerente() {
            return gerente;
        }

        public void setGerente(String gerente) {
            this.gerente = gerente;
        }

        public String getSecao() {
            return secao;
        }

        public void setSecao(String secao) {
            this.secao = secao;
        }

        public String getQuadro() {
            return quadro;
        }

        public void setQuadro(String quadro) {
            this.quadro = quadro;
        }

        public Funcionario(String chave, String nome, String nomeGuerra, int uORPosicao, int uORHabitual, int funcao,
                            String nomeFuncao, String gerente, String secao, String quadro) {
                    super();
                    this.chave = chave;
                    this.nome = nome;
                    this.nomeGuerra = nomeGuerra;
                    UORPosicao = uORPosicao;
                    UORHabitual = uORHabitual;
                    this.funcao = funcao;
                    this.nomeFuncao = nomeFuncao;
                    this.gerente = gerente;
                    this.secao = secao;
                    this.quadro = quadro;
            }

        public Funcionario() {
                super();
        }

}