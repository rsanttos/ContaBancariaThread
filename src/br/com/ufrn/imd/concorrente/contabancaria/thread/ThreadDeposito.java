package br.com.ufrn.imd.concorrente.contabancaria.thread;

import br.com.ufrn.imd.concorrente.contabancaria.dominio.ContaBancaria;

public class ThreadDeposito extends Thread {
	private ContaBancaria conta;
	private int valor;
	

	public ThreadDeposito(ContaBancaria conta, int valor) {
		super();
		this.conta = conta;
		this.valor = valor;
	}

	public ContaBancaria getConta() {
		return conta;
	}

	public void setConta(ContaBancaria conta) {
		this.conta = conta;
	}
	
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public synchronized void realizaDeposito() throws InterruptedException {
		int novoValor;
		while (conta.getSaldo() < 0) {
			wait();
		}
		while(conta.getSaldo() >= 0){
			novoValor = conta.getSaldo() + valor;
			conta.setSaldo(novoValor);
			System.out.println("Depósito realizado no valor de: " + valor);
			System.out.println("Saldo atual (depois do depósito): " + conta.getSaldo());
			Thread.sleep((long) Math.random() * 1000); 
			notifyAll();
		}
	}

	@Override
	public void run() {
		try {
			realizaDeposito();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
