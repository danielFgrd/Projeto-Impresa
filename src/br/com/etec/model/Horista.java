package br.com.etec.model;

public class Horista extends Empregado{
	
	private float precoHora;
	private float horasTrabalhadas;
	
	public float vencimento() {
		return 0;
	}
	
	public float getPrecoHora() {
		return precoHora;
	}
	public void setPrecoHora(float precoHora) {
		this.precoHora = precoHora;
	}
	public float getHorasTrabalhadas() {
		return horasTrabalhadas;
	}
	public void setHorasTrabalhadas(float horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}

}
