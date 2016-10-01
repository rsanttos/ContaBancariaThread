package br.com.ufrn.imd.concorrente.contabancaria.dominio;

public class ContaBancaria {
	public int saldo;

	public ContaBancaria(){
		this.saldo = 0;
	}
	
	public ContaBancaria(int saldo) {
		super();
		this.saldo = saldo;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
}
