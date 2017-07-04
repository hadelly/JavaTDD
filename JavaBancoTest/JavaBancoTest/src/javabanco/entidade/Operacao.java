package javabanco.entidade;

import java.util.Date;

public class Operacao {
	private float valor;
	private String tipoOperacao;
	private Date dataHora;

	public Date getDataHora() {
		return dataHora;
	}

	public String getTipoOperacao() {
		return tipoOperacao;
	}

	public Operacao(float valor, String tipoOperacao, Date dataHora) {
		this.valor = valor;
		this.tipoOperacao = tipoOperacao;
		this.dataHora = dataHora;
	}

	public float getValor() {		
		return valor;
	}
	
	
	
	@Override
	public String toString() {
		return "[ valor: " + this.getValor() + ", tipoOperacao: " + this.getTipoOperacao() + ", dataHora: " + this.getDataHora() + "]";
	}

}