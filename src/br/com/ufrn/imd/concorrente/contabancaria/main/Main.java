package br.com.ufrn.imd.concorrente.contabancaria.main;

import br.com.ufrn.imd.concorrente.contabancaria.dominio.ContaBancaria;
import br.com.ufrn.imd.concorrente.contabancaria.thread.ThreadDeposito;
import br.com.ufrn.imd.concorrente.contabancaria.thread.ThreadSaque;

public class Main {

	public static void main(String[] args) {
		
		ContaBancaria conta = new ContaBancaria();
		
		for(int i = 0 ; i < 10 ; i++){
			int valorDeposito = (int) (Math.random() * 10);
			int valorSaque = (int) (Math.random() * 10);
			ThreadDeposito deposito = new ThreadDeposito(conta, valorDeposito);
			ThreadSaque saque = new ThreadSaque(conta, valorSaque);
			deposito.start();
			saque.start();
		}
	}

}
