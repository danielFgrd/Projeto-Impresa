package br.com.etec.model;

public class Comissionado  extends Empregado{

	private float totalVendas;
	private float taxaComissao;
	
	public float vencimento() {
		return 0;
	}
	
	public float getTotalVendas() {
		return totalVendas;
	}
	public void setTotalVendas(float totalVendas) {
		this.totalVendas = totalVendas;
	}
	public float getTaxaComissao() {
		return taxaComissao;
	}
	public void setTaxaComissao(float totalComissao) {
		this.taxaComissao = taxaComissao;
	}
}
